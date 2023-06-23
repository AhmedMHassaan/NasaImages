package com.ahmed.m.hassaan.nasaimages.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ahmed.m.hassaan.core.activity.BaseActivityBinding
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.nasaimages.R
import com.ahmed.m.hassaan.nasaimages.app.App
import com.ahmed.m.hassaan.nasaimages.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


@AndroidEntryPoint
class MainActivity : BaseActivityBinding<ActivityMainBinding>() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(viewModel) {
            images.onEach { onEachResult(it) }.launchIn(this@MainActivity.lifecycleScope)
        }


    }


    private fun onEachResult(photos: List<DomainNasaImage>) {
        Log.d(App.APP_TAG, "MainActivity - onEachResult:  data emiited to Flow ${photos} ")
    }

    override fun getLayoutId() = R.layout.activity_main
}