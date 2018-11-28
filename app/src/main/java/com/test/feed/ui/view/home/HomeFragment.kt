package com.test.feed.ui.view.home

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import com.test.feed.R
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
        setHasOptionsMenu(true);
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {
       if (item.getItemId() == R.id.no_sort_action) {
           presenter.removeSort()
       }else if (item.getItemId() == R.id.duration_action) {
            presenter.sortByDuration()
       }else if (item.getItemId() == R.id.genre_action) {
            presenter.sortByGenre()
       }else if (item.getItemId() == R.id.price_action) {
            presenter.sortByPrice()
       }
       return super.onOptionsItemSelected(item)
   }

    fun queryText(query: String) {
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