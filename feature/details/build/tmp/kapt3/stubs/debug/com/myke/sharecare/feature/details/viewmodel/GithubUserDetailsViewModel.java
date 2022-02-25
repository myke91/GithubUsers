package com.myke.sharecare.feature.details.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/myke/sharecare/feature/details/viewmodel/GithubUserDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "usecase", "Lcom/myke/sharecare/feature/details/interactors/GetGithubUserDetailsUseCase;", "(Lcom/myke/sharecare/feature/details/interactors/GetGithubUserDetailsUseCase;)V", "_userDetails", "Landroidx/lifecycle/MutableLiveData;", "Lcom/myke/sharecare/shared/result/DataState;", "Lcom/myke/sharecare/feature/details/data/model/GithubUserDetails;", "errorMessage", "", "getErrorMessage", "()Landroidx/lifecycle/MutableLiveData;", "loader", "", "getLoader", "userDetails", "Landroidx/lifecycle/LiveData;", "getUserDetails", "()Landroidx/lifecycle/LiveData;", "", "username", "details_debug"})
public final class GithubUserDetailsViewModel extends androidx.lifecycle.ViewModel {
    private final com.myke.sharecare.feature.details.interactors.GetGithubUserDetailsUseCase usecase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> loader = null;
    private final androidx.lifecycle.MutableLiveData<com.myke.sharecare.shared.result.DataState<com.myke.sharecare.feature.details.data.model.GithubUserDetails>> _userDetails = null;
    
    @javax.inject.Inject()
    public GithubUserDetailsViewModel(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.details.interactors.GetGithubUserDetailsUseCase usecase) {
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
    public final androidx.lifecycle.LiveData<com.myke.sharecare.shared.result.DataState<com.myke.sharecare.feature.details.data.model.GithubUserDetails>> getUserDetails() {
        return null;
    }
    
    public final void getUserDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String username) {
    }
}