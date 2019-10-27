package com.tamemo.mywallet.model

import androidx.room.ColumnInfo

data class Category(
        @ColumnInfo(name = "category_id") val id: Int,
        @ColumnInfo(name = "category_main") val main: String,
        @ColumnInfo(name = "category_sub") val sub: String
)