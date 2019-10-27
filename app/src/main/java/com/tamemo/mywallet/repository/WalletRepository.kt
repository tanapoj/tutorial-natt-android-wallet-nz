package com.tamemo.mywallet.repository

import com.tamemo.mywallet.common.Scheduler
import com.tamemo.mywallet.common.scheduleBy
import com.tamemo.mywallet.database.dao.TransactionDao
import com.tamemo.mywallet.database.dao.WalletDao
import com.tamemo.mywallet.model.WalletInfo
import com.tamemo.mywallet.preference.UserPreference
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WalletRepository(
        private val walletDao: WalletDao,
        private val transactionDao: TransactionDao,
        private val scheduler: Scheduler,
        private val userRepo: UserRepository,
        private val userPref: UserPreference
) {

    fun getWalletList(): Single<List<WalletInfo>> {
        return Single.fromCallable {
            val wallets = walletDao.getWalletsOf(userPref.userId ?: 0).map {
                WalletInfo(it.id, it.balance, .0, .0)
            }
            val transactions =
                    transactionDao.getTransactions(wallets.map { it.id }).groupBy { it.walletId }
            for (wallet in wallets) {
                transactions[wallet.id]?.let { list ->
                    wallet.spend = list.filter { it.amount < 0 }.sumByDouble { it.amount }
                    wallet.income = list.filter { it.amount > 0 }.sumByDouble { it.amount }
                }
            }
            wallets
        }.scheduleBy(scheduler)
    }

}