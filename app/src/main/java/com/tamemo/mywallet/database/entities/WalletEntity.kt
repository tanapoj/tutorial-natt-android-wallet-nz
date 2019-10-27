package com.tamemo.mywallet.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallet")
data class WalletEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "user_id") var userId: Int = 0,
    @ColumnInfo(name = "wallet_name") var name: String = "",
    @ColumnInfo(name = "balance") var balance: Double = .0
)