package com.myke.sharecare.feature.user.data.source.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/myke/sharecare/feature/user/data/source/remote/GithubUserApi;", "", "fetchAllUsers", "Lretrofit2/Response;", "", "Lcom/myke/sharecare/feature/user/data/model/GithubUserRaw;", "page", "", "perPage", "(Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "user_debug"})
public abstract interface GithubUserApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "users")
    public abstract java.lang.Object fetchAllUsers(@org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "since")
    java.lang.Integer page, @org.jetbrains.annotations.Nullable()
    @retrofit2.http.Query(value = "per_page")
    java.lang.Integer perPage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.myke.sharecare.feature.user.data.model.GithubUserRaw>>> continuation);
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public final class DefaultImpls {
    }
}