package com.test.feed.ui.view.presenter.home

import android.app.Activity
import com.test.feed.business.GetFeedTestUseCase
import com.test.feed.ui.presenter.home.HomePresenter
import com.test.feed.ui.view.IONavigation
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(HomePresenter::class)
class HomePresenterTest {

    val query = "Michael Jackson"

    lateinit private var homePresenter: HomePresenter
    @Mock
    lateinit private var mockAppNavigation: IONavigation
    @Mock
    lateinit private var mockGetFeed: GetFeedTestUseCase
    @Mock
    lateinit private var mockView: HomePresenter.View
    @Mock
    lateinit private var mockActivity: Activity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        given(mockView.activity).willReturn(mockActivity)
        homePresenter = HomePresenter(mockAppNavigation, mockGetFeed)
        homePresenter.attachView(mockView)
    }

    @After
    fun validate() {
        validateMockitoUsage()
    }

    @Test
    fun testPresenterGetFeedQuery() {
        assert(homePresenter.count == 0){"Error size movie array"}
        homePresenter.getTracks(query)
        verify(mockView, atLeastOnce()).showLoading()
    }

    @Test
    fun testGetFeedQuery() {
        mockGetFeed.query = query
        mockGetFeed.subscribe(null)
        verify(mockGetFeed, atLeastOnce()).subscribe(null)
    }
}