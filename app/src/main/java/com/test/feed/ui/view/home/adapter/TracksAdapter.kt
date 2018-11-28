package com.test.feed.ui.view.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.test.feed.R
import com.test.feed.data.model.Track
import com.test.feed.ui.utils.FormatUtils
import com.test.feed.ui.utils.IODataSource
import com.test.feed.ui.utils.ImageLoader

class TracksAdapter(dataSource: IODataSource<Track>) : RecyclerView.Adapter<TracksAdapter.TrackViewHolder>() {

    private val dataSource: IODataSource<Track>?

    init {
        this.dataSource = dataSource
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.lay_track_item, parent, false)
        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(dataSource!!.getItemAtPosition(position))
    }

    override fun getItemCount(): Int {
        return dataSource?.count ?: 0
    }

    inner class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

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

        init {
            ButterKnife.bind(this, itemView)
        }

       private fun validate(textView: TextView){
            if (textView.text == null || textView.text.isEmpty()){
                textView.visibility = View.GONE
            }else{
                textView.visibility = View.VISIBLE
            }
        }

        fun bind(track: Track) {
            ImageLoader.loadCircularImage(cover_iv, track.artworkUrl60)
            name_artist_Tv.text = track.artistName
            validate(name_artist_Tv)
            song_title_tv.text = track.trackName
            validate(song_title_tv)
            album_title_tv.text = track.collectionName
            validate(album_title_tv)
            release_date_tv.text = FormatUtils.dateToString(track.releaseDate, itemView.context)
            validate(release_date_tv)
            genre_tv.text = track.primaryGenreName
            validate(genre_tv)
            duration_tv.text = FormatUtils.millisToMinutes(track.trackTimeMillis, itemView.context)
            validate(duration_tv)
            price_tv.text = null
            var price = track.trackPrice
            if (price != null){
                price_tv.visibility = View.VISIBLE
                price_tv.text = price.toString()+" "+track.currency
            }else{
                price_tv.visibility = View.GONE
            }
        }
    }
}
