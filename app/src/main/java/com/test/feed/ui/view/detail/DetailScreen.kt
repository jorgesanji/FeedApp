package com.test.feed.ui.view.detail

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.OnClick
import butterknife.Optional
import com.test.feed.R
import com.test.feed.ui.utils.ImageLoader
import com.test.feed.ui.view.base.BaseConstraintLayout

class DetailScreen(context: Context) : BaseConstraintLayout(context) {

    interface Listener {
        fun trackPreviewPressed()
    }

    lateinit var listener: Listener

    @BindView(R.id.coverIv)
    protected lateinit var cover_iv: ImageView

    @BindView(R.id.nameArtistTv)
    protected lateinit var name_artist_Tv: TextView

    @BindView(R.id.songtitleTv)
    protected lateinit var song_title_tv: TextView

    @BindView(R.id.albumTitleTv)
    protected lateinit var album_title_tv: TextView

    @BindView(R.id.releaseDateTv)
    protected lateinit var release_date_tv: TextView

    @BindView(R.id.genreTv)
    protected lateinit var genre_tv: TextView

    @BindView(R.id.durationTv)
    protected lateinit var duration_tv: TextView

    @BindView(R.id.priceTv)
    protected lateinit var price_tv: TextView

    override val layout: Int get() = R.layout.lay_track_detail

    override fun initUI(attributeSet: AttributeSet?) {}

    private fun validate(textView: TextView){
        if (textView.text == null || textView.text.isEmpty()){
            textView.visibility = View.GONE
        }else{
            textView.visibility = View.VISIBLE
        }
    }

    fun setDetailInfo(coverUrl:String?, artistName:String?, trackName:String?, collectionName:String?,
                      releaseDate:String?, genre:String?, duration:String?, price:String?){
        ImageLoader.loadBackground(cover_iv, coverUrl)
        name_artist_Tv.text = artistName
        validate(name_artist_Tv)
        song_title_tv.text = trackName
        validate(song_title_tv)
        album_title_tv.text = collectionName
        validate(album_title_tv)
        release_date_tv.text = releaseDate
        validate(release_date_tv)
        genre_tv.text = genre
        validate(genre_tv)
        duration_tv.text = duration
        validate(duration_tv)
        price_tv.text = price
        validate(price_tv)
    }

    @Optional
    @OnClick(R.id.previewBt)
    protected fun previewPressed(){
        listener.trackPreviewPressed()
    }
}
