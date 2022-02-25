package com.myke.sharecare.feature.user.data.source.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J1\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/myke/sharecare/feature/user/data/source/remote/GithubUsersRemoteDatasource;", "Lcom/myke/sharecare/feature/user/data/source/GithubUserDatasource;", "api", "Lcom/myke/sharecare/feature/user/data/source/remote/GithubUserApi;", "(Lcom/myke/sharecare/feature/user/data/source/remote/GithubUserApi;)V", "getApi", "()Lcom/myke/sharecare/feature/user/data/source/remote/GithubUserApi;", "fetchGithubUsers", "Lcom/myke/sharecare/shared/result/DataState;", "", "Lcom/myke/sharecare/feature/user/data/model/GithubUserRaw;", "position", "", "perPage", "(Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "user_debug"})
public final class GithubUsersRemoteDatasource implements com.myke.sharecare.feature.user.data.source.GithubUserDatasource {
    @org.jetbrains.annotations.NotNull()
    private final com.myke.sharecare.feature.user.data.source.remote.GithubUserApi api = null;
    
    @javax.inject.Inject()
    public GithubUsersRemoteDatasource(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.data.source.remote.GithubUserApi api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.myke.sharecare.feature.user.data.source.remote.GithubUserApi getApi() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object fetchGithubUsers(@org.jetbrains.annotations.Nullable()
    java.lang.Integer position, @org.jetbrains.annotations.Nullable()
    java.lang.Integer perPage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.myke.sharecare.shared.result.DataState<? extends java.util.List<com.myke.sharecare.feature.user.data.model.GithubUserRaw>>> continuation) {
        return null;
    }
}