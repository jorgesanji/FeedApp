package com.test.feed.di.component

import com.test.feed.di.PerFragment
import com.test.feed.di.module.ManagerModule
import com.test.feed.di.module.NavigatorModule
import com.test.feed.di.module.PresenterModule
import com.test.feed.di.module.UseCaseModule
import com.test.feed.ui.view.detail.DetailFragment
import com.test.feed.ui.view.home.HomeFragment
import com.test.feed.ui.view.splash.SplashFragment
import dagger.Component

@PerFragment
@Component(modules = arrayOf(PresenterModule::class, NavigatorModule::class, UseCaseModule::class, ManagerModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface PresenterComponent {

    fun inject(splashFragment: SplashFragment)
    fun inject(homeFragment: HomeFragment)
    fun inject(detailFragment: DetailFragment)

}
