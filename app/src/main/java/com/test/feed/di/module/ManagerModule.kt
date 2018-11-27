package com.test.feed.di.module

import android.app.Activity
import com.test.feed.di.PerFragment
import com.test.feed.ui.utils.AppPermissionManager
import com.test.feed.ui.utils.AppPermissionsManagerImpl
import dagger.Module
import dagger.Provides

@Module
class ManagerModule(private val activity: Activity) {

    @Provides
    @PerFragment
    internal fun providePermissionManager(): AppPermissionManager {
        return AppPermissionsManagerImpl(activity)
    }
}
