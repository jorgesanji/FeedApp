package com.test.feed.ui.view.home

import android.view.View
import com.test.feed.di.InjectorHelper
import com.test.feed.ui.presenter.home.HomePresenter
import com.test.feed.ui.view.base.MVPFragment
import com.test.feed.ui.view.home.adapter.TracksAdapter

class HomeFragment : MVPFragment<HomePresenter, HomePresenter.View>(), HomePresenter.View, HomeScreen.Listener {

    private lateinit var homeScreen: HomeScreen

    override val rootView: View
        get() {
            homeScreen = HomeScreen(activity)
            homeScreen.listener = this
            return homeScreen
        }

    override fun injectDependencies() {
        InjectorHelper.getPresenterComponent(activity).inject(this)
    }

    override fun onDidAppear() {
        homeScreen.setAdapter(TracksAdapter(presenter))
    }

    fun searchText(query: String) {
        presenter.getTracks(query)
    }

    /*
       HomePresenter View
    */

    override fun reloadData() {
        homeScreen.reloadData()
    }

    /*
     HomeScreen Listener
     */

    override fun onItemClick(view: View, position: Int) {
        presenter.launchDetail(position)
    }
}