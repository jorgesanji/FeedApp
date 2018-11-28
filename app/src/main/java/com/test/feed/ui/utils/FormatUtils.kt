package com.test.feed.ui.utils

import android.content.Context
import java.util.*
import java.util.concurrent.TimeUnit

object FormatUtils {

    fun dateToString(date: Date?, context: Context): String {
        val dateFormat = android.text.format.DateFormat.getDateFormat(context)
        if(dateFormat == null || date == null){
            return ""
        }
        return dateFormat.format(date)
    }

    fun millisToMinutes(millis:Long?) : String{
        if (millis != null){
            return  TimeUnit.MILLISECONDS.toMinutes(millis).toString()
        }
        return ""
    }
}