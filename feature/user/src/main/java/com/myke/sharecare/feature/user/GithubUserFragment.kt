package com.myke.sharecare.feature.user

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.myke.sharecare.feature.user.databinding.FragmentUsersListBinding
import com.myke.sharecare.feature.user.viewmodel.GithubUserViewModel
import com.myke.sharecare.feature.user.viewmodel.GithubUserViewModelFactory
import com.myke.sharecare.feature.user.viewmodel.ViewType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class GithubUserFragment : Fragment() {

    lateinit var viewModel: GithubUserViewModel
    lateinit var binding: FragmentUsersListBinding

    private var currentView: ViewType = ViewType.GRID
    lateinit var adapter: GithubUserListRecyclerViewAdapter

    @Inject
    lateinit var viewModelFactory: GithubUserViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUsersListBinding.inflate(layoutInflater)

        setupViewModel()
        observeLoader()
        observeError()
        observeDataState()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapterUI()
        setupRecyclerViewSwitcher()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.pagedUserList.collectLatest {
                adapter.submitData(it)
            }
        }
    }


    private fun setupAdapterUI() {
        val layoutManager = GridLayoutManager(context, 2)

        binding.usersList.layoutManager = layoutManager

        adapter = GithubUserListRecyclerViewAdapter { user ->
            val action =
                GithubUserFragmentDirections.actionGithubUserFragmentToGithubUserDetailFragment(
                    user
                )

            binding.usersList.findNavController().navigate(action)
        }

        binding.usersList.adapter = adapter

    }


    private fun setupRecyclerViewSwitcher() {
        binding.usersListToolbar.inflateMenu(R.menu.menu)
        binding.usersListToolbar.menu.findItem(R.id.action_grid).setVisible(false)
        binding.usersListToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_grid -> {
                    viewModel.switchView(ViewType.GRID)
                    showMenuItem(currentView)
                    true
                }
                R.id.action_list -> {
                    viewModel.switchView(ViewType.LIST)
                    showMenuItem(currentView)
                    true
                }
                else -> false
            }
        }
    }


    fun showMenuItem(viewType: ViewType) {
        if (viewType == ViewType.GRID) {
            binding.usersListToolbar.menu.findItem(R.id.action_grid).isVisible = false
            binding.usersListToolbar.menu.findItem(R.id.action_list).isVisible = true
        } else {
            binding.usersListToolbar.menu.findItem(R.id.action_grid).isVisible = true
            binding.usersListToolbar.menu.findItem(R.id.action_list).isVisible = false
        }

    }


    private fun observeError() {
        viewModel.errorMessage.observe(viewLifecycleOwner, {
            Snackbar.make(binding.usersList, it, Snackbar.LENGTH_LONG).show()
        })
    }

    private fun observeLoader() {
        viewModel.loader.observe(this as LifecycleOwner, { loading ->
            when (loading) {
                true -> binding.loader.visibility = View.VISIBLE
                else -> binding.loader.visibility = View.GONE
            }

        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(GithubUserViewModel::class.java)
        viewModel.getUsers()
    }


    private fun observeDataState() {
        viewModel.currentView.observe(this as LifecycleOwner) {
            if (it == ViewType.LIST) {
                adapter.setItemViewType(ViewType.LIST.name)
                binding.usersList.layoutManager = LinearLayoutManager(context)
                currentView = ViewType.LIST
            } else {
                adapter.setItemViewType(ViewType.GRID.name)
                binding.usersList.layoutManager = GridLayoutManager(context, 2)
                currentView = ViewType.GRID
            }
        }
    }
}