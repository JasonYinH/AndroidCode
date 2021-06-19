package com.base.third_library_source_analysis

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //创建一个OkHttpClient
        val client = OkHttpClient.Builder().build()
        //创建请求
        val request = Request.Builder().url("").build()
        //同步任务开启新线程执行
        Thread{
            //发起网络请求
            val response = client.newCall(request).execute()
          if (!response.isSuccessful) throw IOException("dddd$response")
            Log.e("okhttp_test","response${response.body?.string()}")
        }.start()
    }
}