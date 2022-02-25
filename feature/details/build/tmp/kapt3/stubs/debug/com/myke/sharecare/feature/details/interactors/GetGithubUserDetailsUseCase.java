package com.myke.sharecare.feature.details.interactors;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/myke/sharecare/feature/details/interactors/GetGithubUserDetailsUseCase;", "Lcom/myke/sharecare/shared/usecasetypes/BaseUseCaseWithParams;", "", "Lcom/myke/sharecare/shared/result/DataState;", "Lcom/myke/sharecare/feature/details/data/model/GithubUserDetails;", "repository", "Lcom/myke/sharecare/feature/details/data/GithubUserDetailsRepository;", "(Lcom/myke/sharecare/feature/details/data/GithubUserDetailsRepository;)V", "run", "params", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "details_debug"})
public final class GetGithubUserDetailsUseCase implements com.myke.sharecare.shared.usecasetypes.BaseUseCaseWithParams<java.lang.String, com.myke.sharecare.shared.result.DataState<? extends com.myke.sharecare.feature.details.data.model.GithubUserDetails>> {
    private final com.myke.sharecare.feature.details.data.GithubUserDetailsRepository repository = null;
    
    @javax.inject.Inject()
    public GetGithubUserDetailsUseCase(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.details.data.GithubUserDetailsRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object run(@org.jetbrains.annotations.NotNull()
    java.lang.String params, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.myke.sharecare.shared.result.DataState<com.myke.sharecare.feature.details.data.model.GithubUserDetails>> continuation) {
        return null;
    }
}