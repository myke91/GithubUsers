package com.myke.sharecare.feature.details.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/myke/sharecare/feature/details/data/GithubUserDetailsRepository;", "", "datasource", "Lcom/myke/sharecare/feature/details/data/source/GithubUserDetailsDatasource;", "(Lcom/myke/sharecare/feature/details/data/source/GithubUserDetailsDatasource;)V", "getUserDetails", "Lcom/myke/sharecare/shared/result/DataState;", "Lcom/myke/sharecare/feature/details/data/model/GithubUserDetailsRaw;", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "details_debug"})
public final class GithubUserDetailsRepository {
    private final com.myke.sharecare.feature.details.data.source.GithubUserDetailsDatasource datasource = null;
    
    @javax.inject.Inject()
    public GithubUserDetailsRepository(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.details.data.source.GithubUserDetailsDatasource datasource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.myke.sharecare.shared.result.DataState<com.myke.sharecare.feature.details.data.model.GithubUserDetailsRaw>> continuation) {
        return null;
    }
}