package com.test.feed.data.rest.service

import java.net.HttpURLConnection

object RestConstants {

    val BaseUrl = "https://itunes.apple.com/"

    val platform_type = "android"
    val platformKeyName = "x-type"
    val accessTokenKeyName = "x_access_token"
    val refreshTokenKeyName = "language"

    val connect_time_out: Long = 10
    val read_time_out: Long = 10
    val milliseconds = 1000

    val HTTP_OK = HttpURLConnection.HTTP_OK
    val REFRESH_TOKEN_INVALID = 245
}
