package com.myke.sharecare.feature.user;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0015\u0016B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\n\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u0010\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\fH\u0016J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/myke/sharecare/feature/user/GithubUserListRecyclerViewAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lcom/myke/sharecare/feature/user/data/model/GithubUser;", "Lcom/myke/sharecare/feature/user/GithubUserListRecyclerViewAdapter$ViewHolder;", "listener", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "viewType", "Lcom/myke/sharecare/feature/user/viewmodel/ViewType;", "getItemViewType", "", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "setItemViewType", "value", "DefaultDiffCallback", "ViewHolder", "user_debug"})
public final class GithubUserListRecyclerViewAdapter extends androidx.paging.PagingDataAdapter<com.myke.sharecare.feature.user.data.model.GithubUser, com.myke.sharecare.feature.user.GithubUserListRecyclerViewAdapter.ViewHolder> {
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> listener = null;
    private com.myke.sharecare.feature.user.viewmodel.ViewType viewType = com.myke.sharecare.feature.user.viewmodel.ViewType.GRID;
    
    public GithubUserListRecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> listener) {
        super(null, null, null);
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.myke.sharecare.feature.user.GithubUserListRecyclerViewAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.GithubUserListRecyclerViewAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemViewType(int position) {
        return 0;
    }
    
    public final void setItemViewType(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/myke/sharecare/feature/user/GithubUserListRecyclerViewAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/myke/sharecare/feature/user/GithubUserListRecyclerViewAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "nickname", "Landroid/widget/TextView;", "getNickname", "()Landroid/widget/TextView;", "profileUrl", "getProfileUrl", "root", "getRoot", "()Landroid/view/View;", "user_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.view.View root = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView avatar = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView nickname = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView profileUrl = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getRoot() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getAvatar() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getNickname() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getProfileUrl() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/myke/sharecare/feature/user/GithubUserListRecyclerViewAdapter$DefaultDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/myke/sharecare/feature/user/data/model/GithubUser;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "user_debug"})
    public static final class DefaultDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.myke.sharecare.feature.user.data.model.GithubUser> {
        
        public DefaultDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.myke.sharecare.feature.user.data.model.GithubUser oldItem, @org.jetbrains.annotations.NotNull()
        com.myke.sharecare.feature.user.data.model.GithubUser newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.myke.sharecare.feature.user.data.model.GithubUser oldItem, @org.jetbrains.annotations.NotNull()
        com.myke.sharecare.feature.user.data.model.GithubUser newItem) {
            return false;
        }
    }
}