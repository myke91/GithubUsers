package com.myke.sharecare.feature.user.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.FragmentComponent.class})
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/myke/sharecare/feature/user/di/GithubUserModule;", "", "()V", "getGithubUsersUseCase", "Lcom/myke/sharecare/feature/user/interactors/GetGithubUsersUseCase;", "repository", "Lcom/myke/sharecare/feature/user/data/GithubUserRepository;", "githubUserAPI", "Lcom/myke/sharecare/feature/user/data/source/remote/GithubUserApi;", "retrofit", "Lretrofit2/Retrofit;", "githubUserMapper", "Lcom/myke/sharecare/feature/user/business/GithubUserMapper;", "githubUsersDatasource", "Lcom/myke/sharecare/feature/user/data/source/GithubUserDatasource;", "api", "githubUsersRepository", "datasource", "httpLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "moshi", "Lcom/squareup/moshi/Moshi;", "okHttpClient", "Lokhttp3/OkHttpClient;", "client", "user_debug"})
@dagger.Module()
public final class GithubUserModule {
    
    public GithubUserModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.myke.sharecare.feature.user.data.source.remote.GithubUserApi githubUserAPI(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final retrofit2.Retrofit retrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client, @org.jetbrains.annotations.NotNull()
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.squareup.moshi.Moshi moshi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final okhttp3.OkHttpClient okHttpClient(@org.jetbrains.annotations.NotNull()
    okhttp3.logging.HttpLoggingInterceptor httpLoggingInterceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.myke.sharecare.feature.user.business.GithubUserMapper githubUserMapper() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.myke.sharecare.feature.user.interactors.GetGithubUsersUseCase getGithubUsersUseCase(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.data.GithubUserRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.myke.sharecare.feature.user.data.GithubUserRepository githubUsersRepository(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.data.source.GithubUserDatasource datasource) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.myke.sharecare.feature.user.data.source.GithubUserDatasource githubUsersDatasource(@org.jetbrains.annotations.NotNull()
    com.myke.sharecare.feature.user.data.source.remote.GithubUserApi api) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final okhttp3.logging.HttpLoggingInterceptor httpLoggingInterceptor() {
        return null;
    }
}