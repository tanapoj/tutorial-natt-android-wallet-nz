package com.tamemo.mywallet.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tamemo.mywallet.database.dao.TransactionDao
import com.tamemo.mywallet.database.dao.UserDao
import com.tamemo.mywallet.database.dao.WalletDao
import com.tamemo.mywallet.database.entities.TransactionEntity
import com.tamemo.mywallet.database.entities.UserEntity
import com.tamemo.mywallet.database.entities.WalletEntity

@Database(
    entities = [
        UserEntity::class,
        WalletEntity::class,
        TransactionEntity::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME = "my_wallet"

        fun newInstance(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }

    abstract fun getUserDao(): UserDao

    abstract fun getWalletDao(): WalletDao

    abstract fun getTransactionDao(): TransactionDao

}