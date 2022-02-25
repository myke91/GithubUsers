package com.myke.sharecare.feature.user.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/myke/sharecare/feature/user/viewmodel/GithubUserViewModel;", "Landroidx/lifecycle/ViewModel;", "useCase", "Lcom/myke/sharecare/feature/user/interactors/GetGithubUsersUseCase;", "(Lcom/myke/sharecare/feature/user/interactors/GetGithubUsersUseCase;)V", "currentView", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myke/sharecare/feature/user/viewmodel/ViewType;", "getCurrentView", "()Landroidx/lifecycle/MutableLiveData;", "errorMessage", "", "getErrorMessage", "loader", "", "getLoader", "pagedUserList", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/myke/sharecare/feature/user/data/model/GithubUser;", "getPagedUserList", "()Lkotlinx/coroutines/flow/Flow;", "setPagedUserList", "(Lkotlinx/coroutines/flow/Flow;)V", "getUsers", "", "switchView", "viewType", "user_debug"})
public final class GithubUserViewModel extends androidx.lifecycle.ViewModel {
    private final com.myke.sharecare.feature.user.interactors.GetGithubUsersUseCase useCase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> loader = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.myke.sharecare.feature.user.viewmodel.ViewType> currentView = null;
    public kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.myke.sharecare.feature.user.data.model.GithubUser>> pagedUserList;
    
    @javax.inject.Inject()
    public GithubUserViewModel(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.interactors.GetGithubUsersUseCase useCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> getLoader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.myke.sharecare.feature.user.viewmodel.ViewType> getCurrentView() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.myke.sharecare.feature.user.data.model.GithubUser>> getPagedUserList() {
        return null;
    }
    
    public final void setPagedUserList(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.myke.sharecare.feature.user.data.model.GithubUser>> p0) {
    }
    
    public final void getUsers() {
    }
    
    public final void switchView(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.viewmodel.ViewType viewType) {
    }
}