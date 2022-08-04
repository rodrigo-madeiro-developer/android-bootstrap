package com.rodrigomadeiro.bootstrap.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.gson.Gson
import com.rodrigomadeiro.bootstrap.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: FragmentActivity() {

    @Inject
    lateinit var gson: Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)
    }
}