package com.test.feed.data.repository

import com.test.feed.data.model.SearchResult
import com.test.feed.data.utils.RetrofitException
import rx.Observable
import javax.inject.Inject

class LocalRepository @Inject
constructor() : Repository {

    override fun getFeed(query: String?): Observable<SearchResult> {
        return Observable.fromCallable { throw RetrofitException.unexpectedError(null) }
    }
}
