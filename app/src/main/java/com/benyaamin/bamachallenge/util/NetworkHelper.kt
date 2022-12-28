package com.benyaamin.bamachallenge.util

import android.net.*

/**
 * singleton class to check the network connection state
 * It"s use the old ConnectivityManager.activeNetworkInfo way for pre LOLLIPOP
 * and the new API named NetworkCallback for the devices with Android API version LOLLIPOP and above
 *
 * required permissions:
 *     <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 *     <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
 */
class NetworkHelper(
    private val connectivityManager: ConnectivityManager
) {
    private var isNetworkAvailable = false;

    /**
     * check the SDK_INT of device and register to the new API for connection callbacks
     * because the new API only support the API 21 and above
     */
    init {
        val networkRequest = NetworkRequest.Builder()
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

        connectivityManager.registerNetworkCallback(networkRequest, networkCallback())
    }

    /**
     * new API callbacks to determine which status we currently in
     * we need the below callbacks:
     * - onAvailable: device connected to a network of course
     * - onLost: when the connection completely lost
     * - onUnavailable: when somehow the connection cannot be reached
     */
    private fun networkCallback() = object: ConnectivityManager.NetworkCallback() {

        override fun onLost(network: Network) {
            super.onLost(network)
            isNetworkAvailable = false
        }

        override fun onUnavailable() {
            super.onUnavailable()
            isNetworkAvailable = false
        }

        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            isNetworkAvailable = true
        }

    }

    /**
     * the function for call from outside the class to check the connection status
     * first check the SDK_INT then provide the status with the right API
     */
    fun isAvailable(): Boolean {
        return isNetworkAvailable
    }

}