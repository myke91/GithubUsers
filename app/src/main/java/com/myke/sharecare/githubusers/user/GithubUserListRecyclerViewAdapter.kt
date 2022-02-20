package com.myke.sharecare.githubusers.user

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding
import com.myke.sharecare.githubusers.R
import com.myke.sharecare.githubusers.databinding.UserGridItemBinding
import com.myke.sharecare.githubusers.databinding.UserListItemBinding
import com.myke.sharecare.githubusers.user.data.model.GithubUser
import com.myke.sharecare.githubusers.user.data.model.GithubUserRaw
import com.myke.sharecare.githubusers.user.viewmodel.ViewType
import com.myke.sharecare.shared.utils.loadImageUrl



class GithubUserListRecyclerViewAdapter(
    private val listener: (String) -> Unit
) : PagingDataAdapter<GithubUser, GithubUserListRecyclerViewAdapter.ViewHolder>(DefaultDiffCallback()) {


    private var viewType: ViewType = ViewType.GRID

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == ViewType.LIST.type) {
            return ViewHolder(
                UserListItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ).root
            )
        } else {
            return ViewHolder(
                UserGridItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                ).root
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val githubUser = getItem(position)

        holder.avatar.loadImageUrl(githubUser!!.avatarUrl, R.drawable.default_avatar)
        holder.nickname.text = githubUser.user
        holder.profileUrl.text = githubUser.profileUrl
        holder.root.setOnClickListener {
            listener(githubUser.user)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType.type
    }

    fun setItemViewType(value: String) {
        viewType = ViewType.valueOf(value)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val root: View = view
        val avatar: ImageView = view.findViewById(R.id.avatar)
        val nickname: TextView = view.findViewById(R.id.nickname)
        val profileUrl: TextView = view.findViewById(R.id.url)
    }

    class DefaultDiffCallback : DiffUtil.ItemCallback<GithubUser>() {
        override fun areItemsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
            return oldItem.user == newItem.user
        }

        override fun areContentsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
            return oldItem == newItem
        }
    }
}