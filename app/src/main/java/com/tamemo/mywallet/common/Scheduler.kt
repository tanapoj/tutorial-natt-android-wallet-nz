package com.tamemo.mywallet.common

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Scheduler {
    fun compute() = Schedulers.computation()
    fun io() = Schedulers.io()
    fun ui() = AndroidSchedulers.mainThread()
}