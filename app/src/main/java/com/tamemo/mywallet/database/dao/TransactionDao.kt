package com.tamemo.mywallet.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tamemo.mywallet.database.entities.TransactionEntity

@Dao
interface TransactionDao {

    @Insert
    fun create(transaction: TransactionEntity)

    @Query("SELECT * FROM wallet_transaction WHERE wallet_id = :walletId")
    fun getTransactions(walletId: Int): List<TransactionEntity>

    @Query("SELECT * FROM wallet_transaction WHERE wallet_id = :walletId AND (:from <= issue_at AND issue_at <= :to)")
    fun getTransactions(walletId: Int, from: Int, to: Int): List<TransactionEntity>

    @Query("SELECT * FROM wallet_transaction WHERE id = :id")
    fun getTransaction(id: Int): TransactionEntity

}