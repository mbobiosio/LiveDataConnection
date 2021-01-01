package com.mbobiosio.lifecycleconnectivity

import android.annotation.TargetApi
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.content.IntentFilter
import android.net.*
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData

@Suppress("DEPRECATION")
class LifecycleService(private val context: Context) : LiveData<Boolean>() {

    private val connManager: ConnectivityManager =
        context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    private lateinit var connCallback: ConnectivityManager.NetworkCallback

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private val requestBuilder: NetworkRequest.Builder = NetworkRequest.Builder()
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)

    private val networkStatusReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            notifyStatus()
        }
    }

    override fun onInactive() {
        super.onInactive()
        when {
            isLollipopUp() -> {
                connManager.unregisterNetworkCallback(connCallback)
            }
            else -> {
                context.unregisterReceiver(networkStatusReceiver)
            }
        }
    }

    override fun onActive() {
        super.onActive()

        notifyStatus()

        when {
            isNougatUp() -> connManager.registerDefaultNetworkCallback(marshMallowCallback())
            isMarshMallowUp() -> marshMallowStatusRequest()
            isLollipopUp() -> lollipopStatusRequest()
            else -> {
                when {
                    isLollipopUp() -> {
                        context.registerReceiver(networkStatusReceiver,
                            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
                    }
                }
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private fun lollipopStatusRequest() {
        connManager.registerNetworkCallback(requestBuilder.build(), lollipopCallback())
    }

    @TargetApi(Build.VERSION_CODES.M)
    private fun marshMallowStatusRequest() {
        connManager.registerNetworkCallback(requestBuilder.build(), marshMallowCallback())
    }

    private fun lollipopCallback(): ConnectivityManager.NetworkCallback {
        if (isLollipopUp()) {
            connCallback = object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    postValue(true)
                }

                override fun onLost(network: Network) {
                    postValue(false)
                }
            }
            return connCallback
        } else {
            throw IllegalAccessError("Accessing wrong API version")
        }
    }

    private fun marshMallowCallback(): ConnectivityManager.NetworkCallback {
        if (isMarshMallowUp()) {
            connCallback = object : ConnectivityManager.NetworkCallback() {
                override fun onCapabilitiesChanged(
                    network: Network,
                    netCapabilities: NetworkCapabilities
                ) {
                    netCapabilities.let { capabilities ->
                        when {
                            capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                                    && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED) -> {
                                postValue(true)
                            }
                        }
                    }
                }

                override fun onLost(network: Network) {
                    postValue(false)
                }
            }
            return connCallback
        } else {
            throw IllegalAccessError("Accessing wrong API version")
        }
    }

    private fun notifyStatus() {
        val activeNetwork: NetworkInfo? = connManager.activeNetworkInfo
        postValue(activeNetwork?.isConnected == true)
    }
}