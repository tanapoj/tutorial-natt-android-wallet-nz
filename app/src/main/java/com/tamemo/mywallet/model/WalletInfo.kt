package com.tamemo.mywallet.model

data class WalletInfo(
    val id: Int,
    var totalBalance: Double,
    var spend: Double,
    var income: Double
)