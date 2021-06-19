package com.base.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.base.myapplication.UserManager.sUserId

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
         Log.e("---> $","xxxxxxxx")
         Log.e("--->SecondActivity $","$sUserId")
    }
}