package com.test.feed.ui.view.detail

import android.view.View
import com.test.feed.di.InjectorHelper
import com.test.feed.ui.presenter.detail.DetailPresenter
import com.test.feed.ui.view.base.MVPFragment

class DetailFragment : MVPFragment<DetailPresenter, DetailPresenter.View>(), DetailPresenter.View, DetailScreen.Listener {

    private lateinit var detailScreen: DetailScreen

    override val rootView: View
        get() {
            detailScreen = DetailScreen(activity)
            detailScreen.listener = this
            return detailScreen
        }

    override fun injectDependencies() {
        InjectorHelper.getPresenterComponent(activity).inject(this)
    }

    override fun onDidAppear() {
        presenter.getTrackDetail()
    }

    /*
    DetailPresenter View
    */

    override  fun setDetailInfo(coverUrl: String?, artistName: String?, trackName: String?, collectionName: String?,
                                releaseDate: String?, genre: String?, duration: String?, price: String?){
        detailScreen.setDetailInfo(coverUrl, artistName, trackName, collectionName, releaseDate, genre, duration, price)
    }

    override fun trackPreviewPressed() {
        presenter.trackPreview()
    }
}