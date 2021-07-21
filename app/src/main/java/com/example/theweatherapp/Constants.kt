package com.example.theweatherapp

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object Constants {

    const val APP_ID: String = "ad07ce61e7f8d631eaaa028826f837f9"
    const val BASE_URL: String = "https://api.openweathermap.org/data/"
    const val METRIC_UNIT: String = "metric"

    fun isNetworkAvailable(context: Context): Boolean {
        // It answers the queries about the state of network connectivity.
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { //if its new versions of android
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetWork = connectivityManager.getNetworkCapabilities(network) ?: return false
            return when {
                activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                //for other device how are able to connect with Ethernet
                activeNetWork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }

        else { //else use this for the old versions of android when it wasn't deprecated
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnectedOrConnecting
        }
    }
}