package com.tamemo.mywallet.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tamemo.mywallet.database.entities.WalletEntity

@Dao
interface WalletDao {

    @Insert
    fun create(wallet: WalletEntity)

    @Query("SELECT * FROM wallet WHERE user_id = :userId")
    fun getWalletsOf(userId: Int): List<WalletEntity>

    @Query("SELECT * FROM wallet WHERE id = :id")
    fun getWallet(id: Int): WalletEntity

    @Query("UPDATE wallet SET wallet_name = :name WHERE id = :id")
    fun setName(id: Int, name: String): Int

    @Query("UPDATE wallet SET balance = :balance WHERE id = :id")
    fun setBalance(id: Int, balance: Double): Int
}