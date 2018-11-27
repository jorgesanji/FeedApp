package com.test.feed.business

import com.test.feed.business.usecase.base.BaseSubscriber
import com.test.feed.business.usecase.base.BaseUseCaseImpl
import com.test.feed.business.usecase.books.GetBooksUseCase
import com.test.feed.integration.RepositoryProxyTest
import rx.Observable

interface GetBooksTestUseCase :GetBooksUseCase

class GetBooksTest(repositoryFactory: RepositoryProxyTest) : BaseUseCaseImpl<Array<Book>>(repositoryFactory), GetBooksUseCase{

    override var count: Int = 0
    override var offset: Int = 0

    override fun subscribe(subscriber: BaseSubscriber<Array<Book>>?) {
        super.subscribeTest(subscriber)
    }

    override fun buildUseCaseObservable(): Observable<Array<Book>> {
        return repositoryFactory.repository.getBookList(offset, count)
    }
}