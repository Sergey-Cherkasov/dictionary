package pt.svcdev.utils.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.util.Log
import androidx.lifecycle.LiveData

class OnlineLiveData(context: Context) : LiveData<Boolean>() {
    private val availableNetworks = mutableSetOf<Network>()

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val request: NetworkRequest = NetworkRequest.Builder().build()

    private val callback = object : ConnectivityManager.NetworkCallback() {

        override fun onLost(network: Network) {
            availableNetworks.remove(network)
            Log.d("DICTIONARY_APP", availableNetworks.toString())
            update(availableNetworks.isNotEmpty())
        }

        override fun onAvailable(network: Network) {
            availableNetworks.add(network)
            Log.d("DICTIONARY_APP", availableNetworks.toString())
            update(availableNetworks.isNotEmpty())
        }

    }

    override fun onActive() {
        connectivityManager.registerNetworkCallback(request, callback)
    }

    override fun onInactive() {
        connectivityManager.unregisterNetworkCallback(callback)
    }

    fun update(online: Boolean) {
        if (online != value) {
            Log.d("DICTIONARY_APP", "Network available = $online")
            postValue(online)
        }
    }

}