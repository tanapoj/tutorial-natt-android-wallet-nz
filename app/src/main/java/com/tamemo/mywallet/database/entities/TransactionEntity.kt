package com.tamemo.mywallet.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamemo.mywallet.model.Category

@Entity(tableName = "wallet_transaction")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "wallet_id") var walletId: Int = 0,
    @ColumnInfo(name = "amount") var amount: Double = .0,
    @Embedded var category: Category,
    @ColumnInfo(name = "issue_at") var issueAt: Int = 0
)