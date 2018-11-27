package com.test.feed.data.repository

import com.test.feed.data.model.SearchResult
import rx.Observable

interface Repository {
    fun getFeed(query:String?) :  Observable<SearchResult>
}
