package com.test.feed.di.module

import android.app.Application
import com.test.feed.data.local.AccountManager
import com.test.feed.data.local.AccountManagerImpl
import com.test.feed.data.local.AppSession
import com.test.feed.data.local.SessionManager
import com.test.feed.data.repository.LocalRepository
import com.test.feed.data.repository.MockRepository
import com.test.feed.data.repository.RestRepository
import com.test.feed.data.rest.service.RestAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Application {
        return this.application
    }

    @Provides
    @Singleton
    fun provideRestRepository(restAdapter: RestAdapter): RestRepository {
        return RestRepository(restAdapter)
    }

    @Provides
    @Singleton
    fun provideLocalRepository(): LocalRepository {
        return LocalRepository()
    }

    @Provides
    @Singleton
    fun provideMockRepository(): MockRepository {
        return MockRepository()
    }

    @Provides
    @Singleton
    fun provideRestAdapter(): RestAdapter {
        return RestAdapter()
    }

    @Provides
    @Singleton
    fun provideAccountManager(): AccountManager{
        return AccountManagerImpl()
    }

    @Provides
    @Singleton
    fun provideSessionManager(accountManager: AccountManager, restAdapter: RestAdapter): AppSession {
        return SessionManager(accountManager, restAdapter, application)
    }
}
