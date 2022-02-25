package com.myke.sharecare.feature.details.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.FragmentComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/myke/sharecare/feature/details/di/GithubUserDetailsModule;", "", "()V", "getGithubUserDetailsUseCase", "Lcom/myke/sharecare/feature/details/interactors/GetGithubUserDetailsUseCase;", "repository", "Lcom/myke/sharecare/feature/details/data/GithubUserDetailsRepository;", "githubUserDetailsAPI", "Lcom/myke/sharecare/feature/details/data/source/remote/GithubUserDetailsApi;", "retrofit", "Lretrofit2/Retrofit;", "githubUserDetailsDatasource", "Lcom/myke/sharecare/feature/details/data/source/GithubUserDetailsDatasource;", "api", "githubUserDetailsRepository", "datasource", "details_debug"})
@dagger.Module()
public final class GithubUserDetailsModule {
    
    public GithubUserDetailsModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.myke.sharecare.feature.details.data.source.remote.GithubUserDetailsApi githubUserDetailsAPI(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.myke.sharecare.feature.details.interactors.GetGithubUserDetailsUseCase getGithubUserDetailsUseCase(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.details.data.GithubUserDetailsRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.myke.sharecare.feature.details.data.GithubUserDetailsRepository githubUserDetailsRepository(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.details.data.source.GithubUserDetailsDatasource datasource) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.myke.sharecare.feature.details.data.source.GithubUserDetailsDatasource githubUserDetailsDatasource(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.details.data.source.remote.GithubUserDetailsApi api) {
        return null;
    }
}