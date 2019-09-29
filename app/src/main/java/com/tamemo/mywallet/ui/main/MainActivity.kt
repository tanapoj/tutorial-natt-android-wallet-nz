package com.tamemo.mywallet.ui.main

import android.os.Bundle
import com.tamemo.mywallet.R
import com.tamemo.mywallet.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val fragment: MainFragment by lazy {
        MainFragment.newInstance(viewModel)
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
        }
    }
}
