package com.test.feed.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class SearchResult() : Parcelable{

    @SerializedName("resultCount")
    var resultCount:Int? =  0

    @SerializedName("results")
    var results:Array<Track>? = null

    constructor(parcel: Parcel) : this() {
        resultCount = parcel.readValue(Int::class.java.classLoader) as? Int
        results = parcel.createTypedArray(Track)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(resultCount)
        parcel.writeTypedArray(results, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchResult> {
        override fun createFromParcel(parcel: Parcel): SearchResult {
            return SearchResult(parcel)
        }

        override fun newArray(size: Int): Array<SearchResult?> {
            return arrayOfNulls(size)
        }
    }
}