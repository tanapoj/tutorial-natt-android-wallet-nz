package com.tamemo.mywallet.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
        @PrimaryKey(autoGenerate = true) var id: Int = 0,
        @ColumnInfo(name = "email") var email: String = "",
        @ColumnInfo(name = "password") var password: String = "",
        @ColumnInfo(name = "firstname") var firstname: String = "",
        @ColumnInfo(name = "lastname") var lastname: String = "",
        @ColumnInfo(name = "birth_at") var birthAt: Long = 0,
        @ColumnInfo(name = "create_at") var createAt: Long = 0
)