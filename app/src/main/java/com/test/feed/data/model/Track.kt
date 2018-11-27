package com.test.feed.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Track() : Parcelable{

    @SerializedName("wrapperType")
    var wrapperType:String? = null

    @SerializedName("kind")
    var kind:String? = null

    @SerializedName("artistId")
    var artistId:Int? = null

    @SerializedName("collectionId")
    var collectionId: Int? = null

    @SerializedName("trackId")
    var trackId:Int? = null

    @SerializedName("artistName")
    var artistName:String? = null

    @SerializedName("collectionName")
    var collectionName:String? = null

    @SerializedName("trackName")
    var trackName:String? = null

    @SerializedName("collectionCensoredName")
    var collectionCensoredName:String? = null

    @SerializedName("trackCensoredName")
    var trackCensoredName:String? = null

    @SerializedName("collectionArtistName")
    var collectionArtistName:String? = null

    @SerializedName("previewUrl")
    var previewUrl:String? = null

    @SerializedName("artworkUrl30")
    var artworkUrl30:String? = null

    @SerializedName("artworkUrl60")
    var artworkUrl60:String? = null

    @SerializedName("artworkUrl100")
    var artworkUrl100:String? = null

    @SerializedName("primaryGenreName")
    var primaryGenreName:String? = null

    @SerializedName("trackTimeMillis")
    var trackTimeMillis:Long? = null

    @SerializedName("trackPrice")
    var trackPrice:Double? = null

    @SerializedName("currency")
    var currency:String? = null

    constructor(parcel: Parcel) : this() {
        wrapperType = parcel.readString()
        kind = parcel.readString()
        artistId = parcel.readValue(Int::class.java.classLoader) as? Int
        collectionId = parcel.readValue(Int::class.java.classLoader) as? Int
        trackId = parcel.readValue(Int::class.java.classLoader) as? Int
        artistName = parcel.readString()
        collectionName = parcel.readString()
        trackName = parcel.readString()
        collectionCensoredName = parcel.readString()
        trackCensoredName = parcel.readString()
        collectionArtistName = parcel.readString()
        previewUrl = parcel.readString()
        artworkUrl30 = parcel.readString()
        artworkUrl60 = parcel.readString()
        artworkUrl100 = parcel.readString()
        primaryGenreName = parcel.readString()
        trackTimeMillis = parcel.readValue(Long::class.java.classLoader) as? Long
        trackPrice = parcel.readValue(Double::class.java.classLoader) as? Double
        currency = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(wrapperType)
        parcel.writeString(kind)
        parcel.writeValue(artistId)
        parcel.writeValue(collectionId)
        parcel.writeValue(trackId)
        parcel.writeString(artistName)
        parcel.writeString(collectionName)
        parcel.writeString(trackName)
        parcel.writeString(collectionCensoredName)
        parcel.writeString(trackCensoredName)
        parcel.writeString(collectionArtistName)
        parcel.writeString(previewUrl)
        parcel.writeString(artworkUrl30)
        parcel.writeString(artworkUrl60)
        parcel.writeString(artworkUrl100)
        parcel.writeString(primaryGenreName)
        parcel.writeValue(trackTimeMillis)
        parcel.writeValue(trackPrice)
        parcel.writeString(currency)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Track> {
        override fun createFromParcel(parcel: Parcel): Track {
            return Track(parcel)
        }

        override fun newArray(size: Int): Array<Track?> {
            return arrayOfNulls(size)
        }
    }

}