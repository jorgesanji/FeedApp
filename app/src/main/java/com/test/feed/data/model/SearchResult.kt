package com.test.feed.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class SearchResult() : Parcelable{

    @SerializedName("resultCount")
    var resultCount:Int? =  0

    @SerializedName("results")
    var results:List<Track>? = null

    constructor(parcel: Parcel) : this() {
        resultCount = parcel.readValue(Int::class.java.classLoader) as? Int
        results = parcel.createTypedArrayList(Track)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(resultCount)
        parcel.writeTypedList(results)
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