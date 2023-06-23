package com.ahmed.m.hassaan.core.activity

import android.os.Bundle

open class BaseActivity : CoreActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun showAlertDialog(title:String,msg:String){

    }





    override fun onDestroy() {
        super.onDestroy()
    }


}