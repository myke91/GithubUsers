// Generated by Dagger (https://dagger.dev).
package com.myke.sharecare.feature.user.di;

import com.myke.sharecare.feature.user.data.source.GithubUserDatasource;
import com.myke.sharecare.feature.user.data.source.remote.GithubUserApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GithubUserModule_GithubUsersDatasourceFactory implements Factory<GithubUserDatasource> {
  private final GithubUserModule module;

  private final Provider<GithubUserApi> apiProvider;

  public GithubUserModule_GithubUsersDatasourceFactory(GithubUserModule module,
      Provider<GithubUserApi> apiProvider) {
    this.module = module;
    this.apiProvider = apiProvider;
  }

  @Override
  public GithubUserDatasource get() {
    return githubUsersDatasource(module, apiProvider.get());
  }

  public static GithubUserModule_GithubUsersDatasourceFactory create(GithubUserModule module,
      Provider<GithubUserApi> apiProvider) {
    return new GithubUserModule_GithubUsersDatasourceFactory(module, apiProvider);
  }

  public static GithubUserDatasource githubUsersDatasource(GithubUserModule instance,
      GithubUserApi api) {
    return Preconditions.checkNotNullFromProvides(instance.githubUsersDatasource(api));
  }
}
