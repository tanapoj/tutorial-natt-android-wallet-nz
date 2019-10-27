package com.tamemo.mywallet.ui.transaction.create

import android.content.Intent
import android.os.Bundle
import com.tamemo.mywallet.R
import com.tamemo.mywallet.ui.BaseActivity
import com.tamemo.mywallet.ui.dashboard.DashboardActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TransactionCreateActivity : BaseActivity() {

    private val fragment: TransactionCreateFragment by lazy {
        TransactionCreateFragment.newInstance(viewModel)
    }

    private val viewModel: TransactionCreateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
        }

        Intent(this, DashboardActivity::class.java).also {
            startActivity(it)
        }
    }
}
