package com.test.feed.di.module

import android.content.Context
import com.test.feed.business.usecase.feed.GetFeed
import com.test.feed.business.usecase.feed.GetFeedUseCase
import com.test.feed.data.repository.RepositoryProxy
import com.test.feed.di.PerFragment
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule(private val activity: Context) {

    @Provides
    @PerFragment
    internal fun provideGetFeed(repositoryFactory: RepositoryProxy): GetFeedUseCase {
        return GetFeed(repositoryFactory)
    }
}
