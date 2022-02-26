package com.myke.sharecare.feature.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.myke.sharecare.shared.data.entities.GithubUserDetails
import com.myke.sharecare.feature.details.databinding.FragmentUserDetailBinding
import com.myke.sharecare.feature.details.viewmodel.GithubUserDetailsViewModel
import com.myke.sharecare.feature.details.viewmodel.GithubUserDetailsViewModelFactory
import com.myke.sharecare.shared.data.result.DataState
import com.myke.sharecare.shared.utils.loadImageUrl
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class GithubUserDetailsFragment : Fragment() {

    private val args: GithubUserDetailsFragmentArgs by navArgs()
    lateinit var viewModel: GithubUserDetailsViewModel
    private lateinit var binding: FragmentUserDetailBinding

    @Inject
    lateinit var viewModelFactory: GithubUserDetailsViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserDetailBinding.inflate(layoutInflater)

        val user = args.user

        setupViewModel()

        viewModel.getUserDetails(user)


        observeLoader()
        setupObserver()
        return binding.root
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(GithubUserDetailsViewModel::class.java)
    }

    private fun setupObserver() {
        viewModel.userDetails.observe(this as LifecycleOwner, {
            when (it) {
                is DataState.Success -> {
                    binding.detailsLoader.visibility = View.GONE
                    it.data.let { details -> setupUI(details) }
                }
                is DataState.Loading -> {
                    binding.detailsLoader.visibility = View.VISIBLE
                }
                is DataState.Error -> {
                    Timber.tag("SHARECARE - GITHUB USER").d("Error retrieving online records")
                    binding.detailsLoader.visibility = View.GONE
                    Snackbar.make(binding.root,"An error occurred", Snackbar.LENGTH_LONG).show()
                }
            }
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
        })
    }


    private fun observeLoader() {
        viewModel.loader.observe(this as LifecycleOwner, { loading ->
            when (loading) {
                true -> binding.detailsLoader.visibility = View.VISIBLE
                else -> binding.detailsLoader.visibility = View.GONE
            }

        })
    }

    private fun setupUI(details: GithubUserDetails) {
        binding.username.text = details.username
        binding.profileUrl.text = details.profileUrl
        binding.name.text = details.name
        binding.twitterUsername.text = details.twitterUsername
        binding.company.text = details.company
        binding.location.text = details.location
        binding.blog.text = details.blog
        binding.email.text = details.email

        binding.userImage.loadImageUrl(details.avatarUrl, R.drawable.default_avatar)
    }

    companion object {
        @JvmStatic
        fun newInstance() = GithubUserDetailsFragment()
    }
}