package com.test.feed.business

import com.test.feed.business.usecase.base.BaseSubscriber
import com.test.feed.business.usecase.base.BaseUseCaseImpl
import com.test.feed.business.usecase.feed.GetFeedUseCase
import com.test.feed.data.model.SearchResult
import com.test.feed.integration.RepositoryProxyTest
import rx.Observable

interface GetFeedTestUseCase :GetFeedUseCase

class GetFeedTest(repositoryFactory: RepositoryProxyTest) : BaseUseCaseImpl<SearchResult>(repositoryFactory), GetFeedUseCase{

    override var query: String? = null

    override fun subscribe(subscriber: BaseSubscriber<SearchResult>?) {
        super.subscribeTest(subscriber)
    }

    override fun buildUseCaseObservable(): Observable<SearchResult> {
        return repositoryFactory.repository.getFeed(query)
    }
}