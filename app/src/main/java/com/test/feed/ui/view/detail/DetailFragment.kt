package com.test.feed.ui.view.detail

import android.view.View
import com.test.feed.di.InjectorHelper
import com.test.feed.ui.presenter.detail.DetailPresenter
import com.test.feed.ui.view.base.MVPFragment

class DetailFragment : MVPFragment<DetailPresenter, DetailPresenter.View>(), DetailPresenter.View {

    private lateinit var detailScreen: DetailScreen

    override val rootView: View
        get() {
            detailScreen = DetailScreen(activity)
            return detailScreen
        }

    override fun injectDependencies() {
        InjectorHelper.getPresenterComponent(activity).inject(this)
    }

    override fun onDidAppear() {
        presenter.getBookDetail()
    }

    override fun showLoading() {
        detailScreen.showLoading()
    }

    override fun hideLoading() {
        detailScreen.hideLoading()
    }

    /*
    DetailPresenter View
    */

    override fun setInfo(title: String?, author: String?, price: String?, image: String?) {
        detailScreen.setInfo(title, author, price, image)
    }
}