package com.tamemo.mywallet.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tamemo.mywallet.database.dao.UserDao

class MainViewModel : ViewModel() {

    private val _test: MutableLiveData<String> = MutableLiveData<String>().apply { postValue("this is view-model") }
    val test: LiveData<String>
        get() = _test

}