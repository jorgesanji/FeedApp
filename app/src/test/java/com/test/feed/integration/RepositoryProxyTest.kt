package com.test.feed.integration

import android.app.Application

import com.test.feed.data.repository.LocalRepository
import com.test.feed.data.repository.MockRepository
import com.test.feed.data.repository.RepositoryProxy
import com.test.feed.data.repository.RestRepository

class  RepositoryProxyTest(context: Application, restRepository: RestRepository,
                          localRepository: LocalRepository, mockRepository: MockRepository) : RepositoryProxy(context, restRepository, localRepository, mockRepository) {

    override val isNetworkAvailable: Boolean
        get() = true
}
