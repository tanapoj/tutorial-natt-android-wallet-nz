package com.tamemo.mywallet.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.tamemo.mywallet.R
import com.tamemo.mywallet.ui.BaseFragment
import kotlinx.android.synthetic.main.fragement_main.*

class MainFragment(private val viewModel: MainViewModel) : BaseFragment() {

    private lateinit var rootView: View

    companion object {
        fun newInstance(viewModel: MainViewModel): MainFragment = MainFragment(viewModel).apply {
            arguments = Bundle()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initBindEvent()
        initObserver()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragement_main, container, false)
        return rootView
    }

    private fun initBindEvent(){

    }

    private fun initObserver(){
        viewModel.test.observe(this, Observer {
            tvTest.text = it
        })
    }

}