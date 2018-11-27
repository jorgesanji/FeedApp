package com.test.feed.di.module

import com.test.feed.business.usecase.feed.GetFeedUseCase
import com.test.feed.data.local.AppSession
import com.test.feed.di.PerFragment
import com.test.feed.ui.presenter.detail.DetailPresenter
import com.test.feed.ui.presenter.home.HomePresenter
import com.test.feed.ui.presenter.splash.SplashPresenter
import com.test.feed.ui.view.IONavigation
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    @PerFragment
    internal fun providSplashPresenter(appNavigation: IONavigation, appSession: AppSession): SplashPresenter {
        return SplashPresenter(appNavigation, appSession)
    }

    @Provides
    @PerFragment
    internal fun provideHomePresenter(appNavigation: IONavigation, getFeedUseCase: GetFeedUseCase): HomePresenter {
        return HomePresenter(appNavigation, getFeedUseCase)
    }

    @Provides
    @PerFragment
    internal fun provideDetailPresenter(appNavigation: IONavigation): DetailPresenter {
        return DetailPresenter(appNavigation)
    }
}
