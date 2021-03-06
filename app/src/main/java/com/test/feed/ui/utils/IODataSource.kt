package com.test.feed.ui.utils

interface IODataSource<T> {

    val count: Int

    fun getItemAtPosition(position: Int): T
}