package com.test.feed.ui.presenter.detail

import android.content.Intent
import android.net.Uri
import com.test.feed.data.model.Track
import com.test.feed.ui.presenter.base.PrensenterImpl
import com.test.feed.ui.presenter.base.Presenter
import com.test.feed.ui.utils.BundleConstants.trackKey
import com.test.feed.ui.utils.FormatUtils
import com.test.feed.ui.view.IONavigation


class DetailPresenter(appNavigation: IONavigation) : PrensenterImpl<DetailPresenter.View>(appNavigation) {

    interface View : Presenter.View {
        fun setDetailInfo(coverUrl: String?, artistName: String?, trackName: String?, collectionName: String?,
                          releaseDate: String?, genre: String?, duration: String?, price: String?)
    }

    lateinit var track:Track

    fun getTrackDetail(){
        track = view.fragment.activity!!.intent.getParcelableExtra<Track>(trackKey)
        var price:String? = null
        if (track.trackPrice != null){
            price = track.trackPrice.toString()+" "+track.currency
        }
        view.setDetailInfo(track.artworkUrl100, track.artistName, track.trackName, track.collectionName,
                FormatUtils.dateToString(track.releaseDate, view.activity), track.primaryGenreName,
                FormatUtils.millisToMinutes(track.trackTimeMillis, view.activity), price)
    }

    fun trackPreview(){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(track.previewUrl))
        view.activity.startActivity(browserIntent)
    }
}
