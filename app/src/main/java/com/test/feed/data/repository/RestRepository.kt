package com.test.feed.data.repository

import com.test.feed.data.model.SearchResult
import com.test.feed.data.rest.service.RestAdapter
import rx.Observable


class RestRepository(internal var restAdapter: RestAdapter) : Repository {

    override fun getFeed(query: String?): Observable<SearchResult> {
        return restAdapter.service.getFeed(query)
    }
}

