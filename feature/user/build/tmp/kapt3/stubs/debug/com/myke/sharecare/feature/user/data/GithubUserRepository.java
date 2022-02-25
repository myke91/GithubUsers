package com.myke.sharecare.feature.user.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/myke/sharecare/feature/user/data/GithubUserRepository;", "", "datasource", "Lcom/myke/sharecare/feature/user/data/source/GithubUserDatasource;", "(Lcom/myke/sharecare/feature/user/data/source/GithubUserDatasource;)V", "getGithubUsers", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/myke/sharecare/feature/user/data/model/GithubUserRaw;", "Companion", "user_debug"})
public final class GithubUserRepository {
    private final com.myke.sharecare.feature.user.data.source.GithubUserDatasource datasource = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.myke.sharecare.feature.user.data.GithubUserRepository.Companion Companion = null;
    public static final int NETWORK_PAGE_SIZE = 20;
    
    @javax.inject.Inject()
    public GithubUserRepository(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.data.source.GithubUserDatasource datasource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<com.myke.sharecare.feature.user.data.model.GithubUserRaw>> getGithubUsers() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/myke/sharecare/feature/user/data/GithubUserRepository$Companion;", "", "()V", "NETWORK_PAGE_SIZE", "", "user_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}