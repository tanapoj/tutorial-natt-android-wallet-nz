package com.tamemo.mywallet.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamemo.mywallet.R
import com.tamemo.mywallet.ui.BaseFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment(private val viewModel: DashboardViewModel) : BaseFragment() {

    private lateinit var rootView: View

    private val mAdapter: DashboardAdapter by lazy {
        DashboardAdapter()
    }

    companion object {
        fun newInstance(viewModel: DashboardViewModel): DashboardFragment = DashboardFragment(viewModel).apply {
            arguments = Bundle()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()
        initBindEvent()
        initObserver()
        viewModel.init()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_dashboard, container, false)
        return rootView
    }

    private fun initRecyclerView() {
        rvWallet.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = mAdapter
        }
    }

    private fun initBindEvent() {

    }

    private fun initObserver() {
        viewModel.totalBalance.observe(this, Observer {
            tvTotalBalance.text = "$it ฿"
        })
        viewModel.totalSpend.observe(this, Observer {
            tvTotalSpend.text = "- $it ฿"
        })
        viewModel.totalIncome.observe(this, Observer {
            tvTotalIncome.text = "+ $it ฿"
        })
        viewModel.walletList.observe(this, Observer {
            mAdapter.walletList = it
            mAdapter.notifyDataSetChanged()
        })
    }
}