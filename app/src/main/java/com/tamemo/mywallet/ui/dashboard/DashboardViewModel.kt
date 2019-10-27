package com.tamemo.mywallet.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tamemo.mywallet.model.WalletInfo
import com.tamemo.mywallet.repository.WalletRepository
import com.tamemo.mywallet.ui.BaseViewModel

class DashboardViewModel(
        private val walletRepository: WalletRepository
) : BaseViewModel() {

    private val _totalBalance: MutableLiveData<Double> = MutableLiveData<Double>().apply { postValue(100.0) }
    val totalBalance: LiveData<Double>
        get() = _totalBalance

    private val _totalSpend: MutableLiveData<Double> = MutableLiveData<Double>().apply { postValue(50.0) }
    val totalSpend: LiveData<Double>
        get() = _totalSpend

    private val _totalIncome: MutableLiveData<Double> = MutableLiveData<Double>().apply { postValue(12.0) }
    val totalIncome: LiveData<Double>
        get() = _totalIncome

    private val _walletList: MutableLiveData<List<WalletInfo>> = MutableLiveData()
    val walletList: LiveData<List<WalletInfo>>
        get() = _walletList

    fun init() {
        walletRepository.getWalletList().subscribe({ list ->
            Log.i("aaa", "wallet list = $list")
            _walletList.value = list
        }, {
            it.printStackTrace()
        }).also {
            addDisposable(it)
        }
    }

}