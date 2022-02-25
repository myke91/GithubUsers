package com.myke.sharecare.feature.user.interactors;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/myke/sharecare/feature/user/interactors/GetGithubUsersUseCase;", "Lcom/myke/sharecare/browsr/base/usecasetypes/BaseUseCaseWithOutParams;", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/myke/sharecare/feature/user/data/model/GithubUser;", "repository", "Lcom/myke/sharecare/feature/user/data/GithubUserRepository;", "(Lcom/myke/sharecare/feature/user/data/GithubUserRepository;)V", "run", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "user_debug"})
public final class GetGithubUsersUseCase implements com.myke.sharecare.browsr.base.usecasetypes.BaseUseCaseWithOutParams<kotlinx.coroutines.flow.Flow<? extends androidx.paging.PagingData<com.myke.sharecare.feature.user.data.model.GithubUser>>> {
    private final com.myke.sharecare.feature.user.data.GithubUserRepository repository = null;
    
    @javax.inject.Inject()
    public GetGithubUsersUseCase(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.data.GithubUserRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object run(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.myke.sharecare.feature.user.data.model.GithubUser>>> continuation) {
        return null;
    }
}