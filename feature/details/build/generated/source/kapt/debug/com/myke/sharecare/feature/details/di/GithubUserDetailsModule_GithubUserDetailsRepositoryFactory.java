// Generated by Dagger (https://dagger.dev).
package com.myke.sharecare.feature.details.di;

import com.myke.sharecare.feature.details.data.GithubUserDetailsRepository;
import com.myke.sharecare.feature.details.data.source.GithubUserDetailsDatasource;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class GithubUserDetailsModule_GithubUserDetailsRepositoryFactory implements Factory<GithubUserDetailsRepository> {
  private final GithubUserDetailsModule module;

  private final Provider<GithubUserDetailsDatasource> datasourceProvider;

  public GithubUserDetailsModule_GithubUserDetailsRepositoryFactory(GithubUserDetailsModule module,
      Provider<GithubUserDetailsDatasource> datasourceProvider) {
    this.module = module;
    this.datasourceProvider = datasourceProvider;
  }

  @Override
  public GithubUserDetailsRepository get() {
    return githubUserDetailsRepository(module, datasourceProvider.get());
  }

  public static GithubUserDetailsModule_GithubUserDetailsRepositoryFactory create(
      GithubUserDetailsModule module, Provider<GithubUserDetailsDatasource> datasourceProvider) {
    return new GithubUserDetailsModule_GithubUserDetailsRepositoryFactory(module, datasourceProvider);
  }

  public static GithubUserDetailsRepository githubUserDetailsRepository(
      GithubUserDetailsModule instance, GithubUserDetailsDatasource datasource) {
    return Preconditions.checkNotNullFromProvides(instance.githubUserDetailsRepository(datasource));
  }
}