package com.tamemo.mywallet.common

import io.reactivex.Completable
import io.reactivex.Single

fun <T> Single<T>.scheduleBy(scheduler: Scheduler): Single<T> {
    return subscribeOn(scheduler.io()).observeOn(scheduler.ui())
}

fun Completable.scheduleBy(scheduler: Scheduler): Completable {
    return subscribeOn(scheduler.io()).observeOn(scheduler.ui())
}