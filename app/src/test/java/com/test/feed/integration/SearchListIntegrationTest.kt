package com.test.feed.integration

import android.app.Application
import com.test.feed.business.usecase.base.BaseSubscriber
import com.test.feed.business.usecase.feed.GetFeed
import com.test.feed.data.model.SearchResult
import com.test.feed.data.repository.LocalRepository
import com.test.feed.data.repository.MockRepository
import com.test.feed.data.repository.RestRepository
import com.test.feed.data.rest.service.ApiError
import com.test.feed.data.rest.service.RestAdapter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchListIntegrationTest {

    val query = "Michael Jackson"
    val accessToken = "accessToken"
    @Mock
    lateinit var mMockContext: Application

    lateinit var repositoryProxy: RepositoryProxyTest
    lateinit var getFeed: GetFeed

    @Before
    fun initUseCases() {
        val restAdapter = RestAdapter()
        restAdapter.accessToken = accessToken
        val restRepository = RestRepository(restAdapter)
        val localRepository = LocalRepository()
        val mockRepository = MockRepository()
        this.repositoryProxy = RepositoryProxyTest(mMockContext, restRepository,
                localRepository, mockRepository)
        this.getFeed = GetFeed(repositoryProxy)
    }

    @Test
    fun getFeedTest() {
        getFeed.query = query
        getFeed.subscribeTest(object : BaseSubscriber<SearchResult>() {
            override fun onError(apiError: ApiError) {
                super.onError(apiError)
                assert(apiError != null)
            }

            override fun onNext(response:SearchResult) {
                super.onNext(response)
                assert(!response!!.results!!.isEmpty()){"No items retrieved"}
            }
        })
    }
}

