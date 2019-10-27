package com.tamemo.mywallet.ui.transaction.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tamemo.mywallet.database.dao.UserDao
import com.tamemo.mywallet.database.entities.UserEntity
import com.tamemo.mywallet.ui.BaseViewModel
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TransactionCreateViewModel(
        private val userDao: UserDao
) : BaseViewModel() {

    private val _test: MutableLiveData<String> = MutableLiveData<String>().apply { postValue("this is view-model") }
    val test: LiveData<String>
        get() = _test

}