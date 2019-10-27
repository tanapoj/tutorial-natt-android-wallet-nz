package com.tamemo.mywallet.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tamemo.mywallet.R
import com.tamemo.mywallet.model.WalletInfo
import kotlinx.android.synthetic.main.item_wallet_card.view.*

class DashboardAdapter : RecyclerView.Adapter<DashboardAdapter.Holder>() {

    var walletList: List<WalletInfo> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wallet_card, parent, false)
        return Holder(view)
    }

    override fun getItemCount() = walletList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(walletList[position]){
            holder.bind(totalBalance, spend, income)
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(totalBalance: Double, spend: Double, income: Double) = with(itemView) {
            tvWalletTotalBalance.text = "$totalBalance"
            tvWalletSpend.text = "$spend"
            tvWalletIncome.text = "$income"
        }
    }

}