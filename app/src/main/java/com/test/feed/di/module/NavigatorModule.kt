package com.test.feed.di.module

import android.app.Activity

import com.test.feed.di.PerFragment
import com.test.feed.ui.view.AppNavigation
import com.test.feed.ui.view.IONavigation

import dagger.Module
import dagger.Provides

@Module
class NavigatorModule(private val activity: Activity) {

    @Provides
    @PerFragment
    internal fun provideNavigator(): IONavigation {
        return AppNavigation(activity)
    }
}
