package com.companytest.jsonplaceholderintegration.proxy

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import com.companytest.jsonplaceholderintegration.exception.InternetException
import com.companytest.jsonplaceholderintegration.repository.RemoteRepository

class ProxyRepository<T>(var context: Context, private var repository: RemoteRepository<T>) :
    RemoteRepository<T> {

    override suspend fun getAll(): ArrayList<T> {
        Log.i("proxyRepository","Request getAll $repository")
        if (!isOnline(context)) {
            throw InternetException("No posees conexión a internet")
        }
        return repository.getAll()
    }

    override suspend fun getById(id: String): T {
        Log.i("proxyRepository","Request getById $repository")
        if (!isOnline(context)) {
            throw InternetException("No posees conexión a internet")
        }

        return repository.getById(id)
    }

    private fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                }
            }
        }
        return false
    }
}