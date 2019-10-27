package com.tamemo.mywallet.ui.dashboard

import android.os.Bundle
import com.tamemo.mywallet.R
import com.tamemo.mywallet.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardActivity : BaseActivity() {

    private val fragment: DashboardFragment by lazy {
        DashboardFragment.newInstance(viewModel)
    }

    private val viewModel: DashboardViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
        }
    }
}