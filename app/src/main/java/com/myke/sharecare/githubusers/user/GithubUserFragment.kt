package com.myke.sharecare.githubusers.user

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
import com.myke.sharecare.githubusers.R
import com.myke.sharecare.githubusers.user.viewmodel.GithubUserViewModel
import com.myke.sharecare.githubusers.user.viewmodel.GithubUserViewModelFactory
import com.myke.sharecare.githubusers.user.viewmodel.ViewType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_users_list.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class GithubUserFragment : Fragment() {

    lateinit var viewModel: GithubUserViewModel

    private var currentView: ViewType = ViewType.GRID
    lateinit var adapter: GithubUserListRecyclerViewAdapter

    @Inject
    lateinit var viewModelFactory: GithubUserViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_users_list, container, false)

        setupViewModel()
        observeLoader()
        observeError()
        observeDataViewState()

        return view
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

        users_list.layoutManager = layoutManager

        adapter = GithubUserListRecyclerViewAdapter { user ->
            val action =
                GithubUserFragmentDirections.actionGithubUserFragmentToGithubUserDetailFragment(
                    user
                )

            users_list.findNavController().navigate(action)
        }

        users_list.adapter = adapter

    }


    private fun setupRecyclerViewSwitcher() {
        myToolbar.inflateMenu(R.menu.menu)
        myToolbar.menu.findItem(R.id.action_grid).setVisible(false)
        myToolbar.setOnMenuItemClickListener {
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
            myToolbar.menu.findItem(R.id.action_grid).setVisible(false)
            myToolbar.menu.findItem(R.id.action_list).setVisible(true)
        } else {
            myToolbar.menu.findItem(R.id.action_grid).setVisible(true)
            myToolbar.menu.findItem(R.id.action_list).setVisible(false)
        }

    }


    private fun observeError() {
        viewModel.errorMessage.observe(this, {
            Snackbar.make(users_list, it, Snackbar.LENGTH_LONG).show()
        })
    }

    private fun observeLoader() {
        viewModel.loader.observe(this as LifecycleOwner, { loading ->
            when (loading) {
                true -> loader.visibility = View.VISIBLE
                else -> loader.visibility = View.GONE
            }

        })
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(GithubUserViewModel::class.java)
        viewModel.getUsers()
    }


    private fun observeDataViewState() {
        viewModel.currentView.observe(this as LifecycleOwner) {
            if (it == ViewType.LIST) {
                adapter.setItemViewType(ViewType.LIST.name)
                users_list.layoutManager = LinearLayoutManager(context)
                currentView = ViewType.LIST
            } else {
                adapter.setItemViewType(ViewType.GRID.name)
                users_list.layoutManager = GridLayoutManager(context, 2)
                currentView = ViewType.GRID
            }
        }
    }


    companion object {
        @JvmStatic
        fun newInstance() = GithubUserFragment()
    }
}