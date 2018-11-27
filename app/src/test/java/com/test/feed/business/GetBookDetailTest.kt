package com.test.feed.business

import com.test.feed.business.usecase.base.BaseSubscriber
import com.test.feed.business.usecase.base.BaseUseCaseImpl
import com.test.feed.business.usecase.books.GetBookDetailUseCase
import com.test.feed.integration.RepositoryProxyTest
import rx.Observable

interface GetBookDetailTestUseCase :GetBookDetailUseCase

class GetBookDetailTest(repositoryFactory: RepositoryProxyTest) : BaseUseCaseImpl<Book>(repositoryFactory), GetBookDetailTestUseCase{

    override var id: Int = 0

    override fun subscribe(subscriber: BaseSubscriber<Book>?) {
        super.subscribeTest(subscriber)
    }

    override fun buildUseCaseObservable(): Observable<Book> {
        return repositoryFactory.repository.getBookDetail(id)
    }
}