package com.tamemo.mywallet.ui

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
    }

    private val mCompositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        mCompositeDisposable.add(disposable)
    }
}