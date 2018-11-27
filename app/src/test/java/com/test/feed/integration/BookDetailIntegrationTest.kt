package com.test.feed.integration

import android.app.Application
import com.test.feed.business.usecase.base.BaseSubscriber
import com.test.feed.business.usecase.books.GetBookDetail
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
class BookDetailIntegrationTest {

    val accessToken = "accessToken"
    @Mock
    lateinit var mMockContext: Application

    lateinit var repositoryProxy: RepositoryProxyTest
    lateinit var getBookDetail: GetBookDetail

    @Before
    fun initUseCases() {
        val restAdapter = RestAdapter()
        restAdapter.accessToken = accessToken
        val restRepository = RestRepository(restAdapter)
        val localRepository = LocalRepository()
        val mockRepository = MockRepository()
        this.repositoryProxy = RepositoryProxyTest(mMockContext, restRepository,
                localRepository, mockRepository)
        this.getBookDetail = GetBookDetail(repositoryProxy)
    }

    @Test
    fun getBooksDetailwithValidIdTest() {
        getBookDetail.id = 8
        getBookDetail.subscribeTest(object : BaseSubscriber<Book>() {
            override fun onError(apiError: ApiError) {
                super.onError(apiError)
                assert(apiError != null)
            }

            override fun onNext(response:Book) {
                super.onNext(response)
                assert(response!!.id != null){"book no valid"}
            }
        })
    }

    @Test
    fun getBookIdNoValidTest() {
        getBookDetail.id = 0
        getBookDetail.subscribeTest(object : BaseSubscriber<Book>() {
            override fun onError(apiError: ApiError) {
                super.onError(apiError)
                assert(apiError != null)
            }
        })
    }
}

