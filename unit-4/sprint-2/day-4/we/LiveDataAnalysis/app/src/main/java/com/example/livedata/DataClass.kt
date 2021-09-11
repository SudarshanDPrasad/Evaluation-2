package com.example.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class DataClass {

    private var apiDataVersion = 0
    private var dbDataVersion = 0
    private val apiMutableLiveData = MutableLiveData<String>()
    private val dbMutableLiveData = MutableLiveData<String>()

    private val mediatorLiveData = MediatorLiveData<String>()


    fun getAPINewData() {
        apiDataVersion++
        apiMutableLiveData.value = "Api data $apiDataVersion"
    }

    fun getDBNewData() {
        dbDataVersion++
        dbMutableLiveData.value = "DB data $dbDataVersion"
    }

//
//    fun getApiData(): LiveData<String> {
//        apiMutableLiveData
//        return apiMutableLiveData
//    }
//
//    fun getDBData(): LiveData<String> {
//        dbMutableLiveData
//        return dbMutableLiveData
//    }

    fun getMeditatorLiveData(): LiveData<String> {
        mediatorLiveData.addSource(dbMutableLiveData, Observer {
            mediatorLiveData.value = "DB data $dbDataVersion"
        })

        mediatorLiveData.addSource(apiMutableLiveData, Observer {
            mediatorLiveData.value = "Api data $apiDataVersion"
        })

        return mediatorLiveData
    }
}