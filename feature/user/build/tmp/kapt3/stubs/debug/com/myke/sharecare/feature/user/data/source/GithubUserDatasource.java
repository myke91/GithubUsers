package com.myke.sharecare.feature.user.data.source;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/myke/sharecare/feature/user/data/source/GithubUserDatasource;", "", "fetchGithubUsers", "Lcom/myke/sharecare/shared/result/DataState;", "", "Lcom/myke/sharecare/feature/user/data/model/GithubUserRaw;", "position", "", "perPage", "(Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "user_debug"})
public abstract interface GithubUserDatasource {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object fetchGithubUsers(@org.jetbrains.annotations.Nullable()
    java.lang.Integer position, @org.jetbrains.annotations.Nullable()
    java.lang.Integer perPage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.myke.sharecare.shared.result.DataState<? extends java.util.List<com.myke.sharecare.feature.user.data.model.GithubUserRaw>>> continuation);
}