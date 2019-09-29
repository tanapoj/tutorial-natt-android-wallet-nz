package com.tamemo.mywallet.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tamemo.mywallet.database.dao.UserDao
import com.tamemo.mywallet.database.entities.UserEntity

@Database(entities = [
    UserEntity::class
], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        val DATABASE_NAME = "my_wallet"

        fun newInstance(context: Context) =
                Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }

    abstract fun getUserDao(): UserDao

}