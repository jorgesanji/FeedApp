package com.test.feed.ui.view.presenter.detail

import android.app.Activity
import com.test.feed.data.model.Track
import com.test.feed.ui.presenter.detail.DetailPresenter
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
class DetailPresenterTest {

    lateinit private var detailPresenter: DetailPresenter
    @Mock
    lateinit private var mockAppNavigation: IONavigation
    @Mock
    lateinit private var mockView: DetailPresenter.View
    @Mock
    lateinit private var mockActivity: Activity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this);
        given(mockView.activity).willReturn(mockActivity)
        detailPresenter = DetailPresenter(mockAppNavigation)
        detailPresenter.attachView(mockView)
    }

    @After
    fun validate() {
        validateMockitoUsage()
    }

    @Test
    fun testPresenterView() {
        detailPresenter.track = Track()
        detailPresenter.getTrackDetail()
        verify(mockView, atLeastOnce()).setDetailInfo(null,null,null,null,null,null,null,null)
    }
}