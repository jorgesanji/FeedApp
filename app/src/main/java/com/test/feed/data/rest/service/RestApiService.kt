package com.test.feed.data.rest.service

import com.test.feed.data.model.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface RestApiService {

    @GET("search")
    fun getFeed(@Query("term")query:String?) : Observable<SearchResult>
}
