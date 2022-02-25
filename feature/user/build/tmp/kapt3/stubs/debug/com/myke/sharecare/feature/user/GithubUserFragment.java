package com.myke.sharecare.feature.user;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\"2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\u000e\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u00061"}, d2 = {"Lcom/myke/sharecare/feature/user/GithubUserFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/myke/sharecare/feature/user/GithubUserListRecyclerViewAdapter;", "getAdapter", "()Lcom/myke/sharecare/feature/user/GithubUserListRecyclerViewAdapter;", "setAdapter", "(Lcom/myke/sharecare/feature/user/GithubUserListRecyclerViewAdapter;)V", "binding", "Lcom/myke/sharecare/feature/user/databinding/FragmentUsersListBinding;", "getBinding", "()Lcom/myke/sharecare/feature/user/databinding/FragmentUsersListBinding;", "setBinding", "(Lcom/myke/sharecare/feature/user/databinding/FragmentUsersListBinding;)V", "currentView", "Lcom/myke/sharecare/feature/user/viewmodel/ViewType;", "viewModel", "Lcom/myke/sharecare/feature/user/viewmodel/GithubUserViewModel;", "getViewModel", "()Lcom/myke/sharecare/feature/user/viewmodel/GithubUserViewModel;", "setViewModel", "(Lcom/myke/sharecare/feature/user/viewmodel/GithubUserViewModel;)V", "viewModelFactory", "Lcom/myke/sharecare/feature/user/viewmodel/GithubUserViewModelFactory;", "getViewModelFactory", "()Lcom/myke/sharecare/feature/user/viewmodel/GithubUserViewModelFactory;", "setViewModelFactory", "(Lcom/myke/sharecare/feature/user/viewmodel/GithubUserViewModelFactory;)V", "observeDataState", "", "observeError", "observeLoader", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupAdapterUI", "setupRecyclerViewSwitcher", "setupViewModel", "showMenuItem", "viewType", "Companion", "user_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class GithubUserFragment extends androidx.fragment.app.Fragment {
    public com.myke.sharecare.feature.user.viewmodel.GithubUserViewModel viewModel;
    public com.myke.sharecare.feature.user.databinding.FragmentUsersListBinding binding;
    private com.myke.sharecare.feature.user.viewmodel.ViewType currentView = com.myke.sharecare.feature.user.viewmodel.ViewType.GRID;
    public com.myke.sharecare.feature.user.GithubUserListRecyclerViewAdapter adapter;
    @javax.inject.Inject()
    public com.myke.sharecare.feature.user.viewmodel.GithubUserViewModelFactory viewModelFactory;
    @org.jetbrains.annotations.NotNull()
    public static final com.myke.sharecare.feature.user.GithubUserFragment.Companion Companion = null;
    
    public GithubUserFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.myke.sharecare.feature.user.viewmodel.GithubUserViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.viewmodel.GithubUserViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.myke.sharecare.feature.user.databinding.FragmentUsersListBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.databinding.FragmentUsersListBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.myke.sharecare.feature.user.GithubUserListRecyclerViewAdapter getAdapter() {
        return null;
    }
    
    public final void setAdapter(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.GithubUserListRecyclerViewAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.myke.sharecare.feature.user.viewmodel.GithubUserViewModelFactory getViewModelFactory() {
        return null;
    }
    
    public final void setViewModelFactory(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.viewmodel.GithubUserViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupAdapterUI() {
    }
    
    private final void setupRecyclerViewSwitcher() {
    }
    
    public final void showMenuItem(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.viewmodel.ViewType viewType) {
    }
    
    private final void observeError() {
    }
    
    private final void observeLoader() {
    }
    
    private final void setupViewModel() {
    }
    
    private final void observeDataState() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.myke.sharecare.feature.user.GithubUserFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/myke/sharecare/feature/user/GithubUserFragment$Companion;", "", "()V", "newInstance", "Lcom/myke/sharecare/feature/user/GithubUserFragment;", "user_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.myke.sharecare.feature.user.GithubUserFragment newInstance() {
            return null;
        }
    }
}