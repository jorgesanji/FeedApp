package com.test.feed.business.usecase.feed

import com.test.feed.business.usecase.base.BaseUseCase
import com.test.feed.business.usecase.base.BaseUseCaseImpl
import com.test.feed.data.model.SearchResult
import com.test.feed.data.repository.RepositoryProxy
import rx.Observable
import javax.inject.Inject

interface GetFeedUseCase : BaseUseCase<SearchResult> {
    var query: String?
}

class GetFeed @Inject constructor(repositoryFactory: RepositoryProxy) : BaseUseCaseImpl<SearchResult>(repositoryFactory), GetFeedUseCase {

    override var query: String?  = null

    override fun buildUseCaseObservable(): Observable<SearchResult> {
        return repositoryFactory.repository.getFeed(query)
    }
}
