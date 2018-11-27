package com.test.feed.data.local

interface AppSession{
    var listener:SessionListener?
    fun initSession()
}