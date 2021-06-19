package com.base.myapplication

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

/**
 *
 * Android开发艺术探索
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("--->onCreate $", "$")
        if (savedInstanceState != null) {
            val ee = savedInstanceState.getString("ee")
            Log.e("--->onCreate $", "$$ee")
        }
        findViewById<TextView>(R.id.tv_click).setOnClickListener {
            //隐式跳转
//            val intent = Intent("com.baibai.bai.c")
//            intent.setDataAndType(Uri.parse("file://abc"), "text/plain")
//            if (packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
//                //判断是否有Activity能够匹配我们的隐式Intent,if不加判断，没有匹配会报错
//                startActivity(intent)
//            } else {
//                Log.e("---> $", "xxxxxx")
//            }
            //显示跳转
            val intent1 = Intent(this, SecondActivity::class.java)
            UserManager.sUserId = 10
            startActivity(intent1)
            Log.e("--->MainActivity$", "${UserManager.sUserId}")
        }

        //序列号过程
//        val user = User("ss", 0)
//        val out = ObjectOutputStream(FileOutputStream("cache.txt"))
//        out.writeObject(user)
//        out.close()
//        //反序列化过程
//        val inp = ObjectInputStream(FileInputStream("cache.txt"))
//        val readObject:User = inp.readObject() as User
//        inp.close()
//         Log.e("--->readObject$","$readObject")
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.e("--->onNewIntent$", "${intent.getLongExtra("time", 0)}")

    }

    //保存数据
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("---> $", "\$onSaveInstanceState")
        outState.putString("ee", "test")
    }

    //恢复数据
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val ee = savedInstanceState.getString("ee")
        Log.e("---> $", "onRestoreInstanceState$$ee")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.e("---> $", "onConfigurationChanged$" + newConfig.orientation)
    }

    override fun onStart() {
        super.onStart()
        Log.e("--->onStart $", "$")
    }

    override fun onResume() {
        super.onResume()
        Log.e("--->onResume $", "$")
    }

    override fun onPause() {
        super.onPause()
        Log.e("--->onPause $", "$")
    }

    override fun onStop() {
        super.onStop()
        Log.e("--->onStop $", "$")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("--->onRestart $", "$")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("--->onDestroy $", "$")
    }
}