package com.test.feed.ui.presenter.home

import android.os.Bundle
import android.widget.Toast
import com.test.feed.R
import com.test.feed.business.usecase.base.BaseSubscriber
import com.test.feed.business.usecase.feed.GetFeedUseCase
import com.test.feed.data.model.SearchResult
import com.test.feed.data.model.Track
import com.test.feed.data.rest.service.ApiError
import com.test.feed.ui.presenter.base.PrensenterImpl
import com.test.feed.ui.presenter.base.Presenter
import com.test.feed.ui.utils.BundleConstants.trackKey
import com.test.feed.ui.utils.IODataSource
import com.test.feed.ui.view.IONavigation

class HomePresenter(appNavigation: IONavigation, private var getFeedUseCase: GetFeedUseCase) : PrensenterImpl<HomePresenter.View>(appNavigation), IODataSource<Track> {

    private var tracks: List<Track> = ArrayList()
    private var tracksPresented: List<Track> = ArrayList()
    private var loading: Boolean = false
    private var total:Int? = 0
    private var isTracksValid:Boolean  = false
        get() { return tracks != null && !tracks.isEmpty()}

    interface View : Presenter.View {
        fun reloadData()
    }

    fun getTracks(query:String) {
        tracks = ArrayList()
        tracksPresented = ArrayList()
        view.reloadData()
        if (query.isEmpty()){
            return
        }
        view.showLoading()
        getFeedUseCase.query = query
        getFeedUseCase.unsubscribe()
        getFeedUseCase.subscribe(object : BaseSubscriber<SearchResult>() {

            override fun onError(apiError: ApiError) {
                super.onError(apiError)
                this@HomePresenter.view.hideLoading()
                this@HomePresenter.view.showInternetConnectionError()
                this@HomePresenter.loading = false
            }

            override fun onNext(response: SearchResult) {
                super.onNext(response)
                this@HomePresenter.view.hideLoading()
                this@HomePresenter.loading = false
                if (response.resultCount == 0){
                    Toast.makeText( this@HomePresenter.view.activity, view.activity.getString(R.string.error_search_empty), Toast.LENGTH_LONG).show()
                    return
                }
                this@HomePresenter.tracks = response.results!!.toList()
                this@HomePresenter.tracksPresented = response.results!!.toList()
                this@HomePresenter.total = response.resultCount
                this@HomePresenter.view.reloadData()
            }
        })
    }

    fun launchDetail(position: Int){
        val track = tracksPresented[position]
        var bundle = Bundle()
        bundle.putParcelable(trackKey, track)
        appNavigation.launchDetail(bundle)
    }

    fun removeSort(){
        tracksPresented = tracks
        view.reloadData()
    }

    fun sortByDuration(){
        if (isTracksValid){
            val tracksSortedByDuration = tracks.filter { track -> track.trackTimeMillis != null}.sortedWith(compareBy { it.trackTimeMillis })
            tracksPresented = tracksSortedByDuration
            view.reloadData()
        }
    }

    fun sortByGenre(){
        if (isTracksValid){
            val tracksSortedByGenre = tracks.filter { track -> track.primaryGenreName != null}.sortedWith(compareBy { it.primaryGenreName })
            tracksPresented = tracksSortedByGenre
            view.reloadData()
        }
    }

    fun sortByPrice(){
        if (isTracksValid){
            val tracksSortedByPrice = tracks.filter { track -> track.trackPrice != null}.sortedWith(compareBy { it.trackPrice })
            tracksPresented = tracksSortedByPrice
            view.reloadData()
        }
    }

    /**
     * Datasource
     */

    override val count: Int
        get() = tracksPresented.size

    override fun getItemAtPosition(position: Int): Track {
        return tracksPresented[position]
    }
}
