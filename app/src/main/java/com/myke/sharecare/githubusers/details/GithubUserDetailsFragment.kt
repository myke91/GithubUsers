package com.myke.sharecare.githubusers.details

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.myke.sharecare.githubusers.R
import com.myke.sharecare.githubusers.details.data.model.GithubUserDetails
import com.myke.sharecare.githubusers.details.data.model.GithubUserDetailsRaw
import com.myke.sharecare.githubusers.details.viewmodel.GithubUserDetailsViewModel
import com.myke.sharecare.githubusers.details.viewmodel.GithubUserDetailsViewModelFactory
import com.myke.sharecare.shared.utils.Status
import com.myke.sharecare.shared.utils.loadImageUrl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_user_detail.*
import kotlinx.android.synthetic.main.fragment_users_list.*
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class GithubUserDetailsFragment : Fragment() {

    private val args: GithubUserDetailsFragmentArgs by navArgs()
    lateinit var viewModel: GithubUserDetailsViewModel

    @Inject
    lateinit var viewModelFactory: GithubUserDetailsViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_detail, container, false)

        val user = args.user

        setupViewModel()

        viewModel.getUserDetails(user)


        observeLoader()
        setupObserver()
        return view
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(GithubUserDetailsViewModel::class.java)
    }

    private fun setupObserver() {
        viewModel.userDetails.observe(this as LifecycleOwner, {
            when (it.status) {
                Status.SUCCESS -> {
                    details_loader.visibility = View.GONE
                    it.data?.let { details -> setupUI(details) }
                }
                Status.LOADING -> {
                    details_loader.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    Timber.tag("SHARECARE - GITHUB USER").d("Error retrieving online records")
                    details_loader.visibility = View.GONE
                    Snackbar.make(user_details_root, R.string.generic_error, Snackbar.LENGTH_LONG).show()
                }
            }
        })

        viewModel.errorMessage.observe(this, {
            Snackbar.make(user_details_root, it, Snackbar.LENGTH_LONG).show()
        })
    }


    private fun observeLoader() {
        viewModel.loader.observe(this as LifecycleOwner, { loading ->
            when (loading) {
                true -> details_loader.visibility = View.VISIBLE
                else -> details_loader.visibility = View.GONE
            }

        })
    }

    private fun setupUI(details: GithubUserDetails) {
        username.text = details.username
        profile_url.text = details.profileUrl
        name.text = details.name
        twitter_username.text = details.twitterUsername
        company.text = details.company
        location.text = details.location
        blog.text = details.blog
        email.text = details.email

        user_image.loadImageUrl(details.avatarUrl, R.drawable.default_avatar)
    }

    companion object {
        @JvmStatic
        fun newInstance() = GithubUserDetailsFragment()
    }
}