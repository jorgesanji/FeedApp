package com.test.feed.ui.view.home

import android.app.Application
import android.support.test.InstrumentationRegistry.getInstrumentation
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.test.feed.data.model.SearchResult
import com.test.feed.data.repository.RestRepository
import com.test.feed.di.component.ApplicationComponent
import com.test.feed.di.module.ApplicationModule
import com.test.feed.ui.application.SampleApplication
import com.test.feed.ui.presenter.home.HomePresenter
import it.cosenonjaviste.daggermock.DaggerMockRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import rx.Observable
import java.util.*

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeViewTest {

    val query = "Michael Jackson"

    @Rule
    var daggerRule: DaggerMockRule<ApplicationComponent> = DaggerMockRule(
            ApplicationComponent::class.java,
            ApplicationModule(getInstrumentation().getTargetContext().getApplicationContext() as Application))
            .set({ component ->
                val app = getInstrumentation().getTargetContext().getApplicationContext() as SampleApplication
                app.applicationComponent = component
            })

    @Mock
    lateinit var homePresenter: HomePresenter

    @Mock
    lateinit var repository: RestRepository

    lateinit var homeFragment: HomeFragment

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        homeFragment = HomeFragment()
        homeFragment.presenter = homePresenter
    }

    @Test
    @Throws(Exception::class)
    fun testAttachView() {
        verify(homePresenter).attachView(homeFragment)
    }

    @Test
    @Throws(Exception::class)
    fun testGetFeed() {
        val response = SearchResult()
        response.resultCount = 0
        response.results = ArrayList()
        `when`(repository.getFeed(query))
                .thenReturn(Observable.just<SearchResult>(response))
    }
}