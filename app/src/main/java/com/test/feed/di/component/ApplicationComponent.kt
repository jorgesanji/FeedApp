package com.test.feed.di.component

import android.app.Application
import com.test.feed.data.local.AccountManager
import com.test.feed.data.local.AppSession
import com.test.feed.data.repository.LocalRepository
import com.test.feed.data.repository.MockRepository
import com.test.feed.data.repository.RestRepository
import com.test.feed.data.rest.service.RestAdapter
import com.test.feed.di.module.ApplicationModule
import com.test.feed.ui.application.SampleApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun provideApplication(): Application

    fun provideRestRepository(): RestRepository

    fun provideLocalRepository(): LocalRepository

    fun provideMockRepository(): MockRepository

    fun provideRestAdapter(): RestAdapter

    fun provideAccountManager(): AccountManager

    fun provideSessionManager(): AppSession

    fun inject(application: SampleApplication)
}
