package com.test.feed.ui.view.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.test.feed.R
import com.test.feed.data.model.Track
import com.test.feed.ui.utils.IODataSource

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

        @BindView(R.id.titleTv)
        protected lateinit var title_tv: TextView

        init {
            ButterKnife.bind(this, itemView)
        }

        fun bind(track: Track) {
            title_tv.text = track.artistName
        }
    }
}
