package com.base.jinjiezhiguang


import android.animation.*
import android.animation.Animator.AnimatorListener
import android.app.NotificationManager
import android.content.Context
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


/**
 * Android进阶之光
 */
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    var nm: NotificationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val mCustomView = findViewById<CustomView>(R.id.customview)
        //用View动画来移动
//        mCustomView.animation = AnimationUtils.loadAnimation(this, R.anim.translate)
        //使用属性动画
//        ObjectAnimator.ofFloat(mCustomView, "translationX", 0f, 300f).setDuration(1000).start()
//        Scroller 来实现有过渡效果的滑动
//        mCustomView.smoothScrollTo(-400, 0)

        //属性动画
        // 1.ObjectAnimator
//        val myView = MyView(mCustomView)
//        val animator = ObjectAnimator.ofInt(myView, "width", 1000)
////                .setDuration(1000).start()
//        animator.addListener(object : AnimatorListenerAdapter() {})
//        animator.addListener(object:AnimatorListener{
//            override fun onAnimationRepeat(animation: Animator?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onAnimationEnd(animation: Animator?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onAnimationCancel(animation: Animator?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onAnimationStart(animation: Animator?) {
//                TODO("Not yet implemented")
//            }
//
//        })

        //2、ValueAnimator   不提供任何动画效果，更像一个数值发生器，
        // 用来产生有一定规律的数字，从而让调用者控制动画的实现过程
//        val mValueAnimator = ValueAnimator.ofFloat(0f, 100f)
//        mValueAnimator.setTarget(mCustomView)
//        mValueAnimator.setDuration(1000).start()
//        mValueAnimator.addUpdateListener {
//            val mFloat = it.animatedValue as Float
//             Log.e("--->mFloat $","$mFloat")
//        }
       //组合动画
    /*    val valuesHolder1 = PropertyValuesHolder.ofFloat("scaleX", 1.0f, 1.5f)
        val valuesHolder2 = PropertyValuesHolder.ofFloat("rotationX", 0.0f, 90.0f, 0.0F)
        val valuesHolder3 = PropertyValuesHolder.ofFloat("alpha", 1.0f, 0.3f, 1.0F)
        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(mCustomView, valuesHolder1, valuesHolder2, valuesHolder3)
        objectAnimator.setDuration(2000).start()*/
     //在XML中使用属性动画
        val loadAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)
        loadAnimator.setTarget(mCustomView)
        loadAnimator.start()
        findViewById<TextView>(R.id.tv_putong).setOnClickListener {
            //普通通知
//            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.csdn.net/qq_40716430/article/details/105690486"))
//            val pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0)
//            val builder = NotificationCompat.Builder(this, "AppTestNotificationId")
//                    .setContentIntent(pendingIntent)
//                    .setSmallIcon(R.mipmap.ic_launcher)
//                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
//                    .setAutoCancel(true)
//                    .setContentTitle("普通通知")
//                    .build()
////            //添加如下代码，android版本需要手动添加NotificationChannel实现
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                val notificationChannel = NotificationChannel("AppTestNotificationId", "AppTestNotificationName", NotificationManager.IMPORTANCE_DEFAULT)
//                nm!!.createNotificationChannel(notificationChannel)
//            }
//            nm!!.notify(1, builder)
//            /**
//            *
//            *折叠式通知
//            */
//            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.csdn.net/qq_40716430/article/details/105690486"))
//            val pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0)
//            val remoteViews = RemoteViews(packageName, R.layout.view_fold)
//            val builder = NotificationCompat.Builder(this, "AppTestNotificationId")
//                    .setContentIntent(pendingIntent)
//                    .setSmallIcon(R.mipmap.ic_launcher)
//                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
//                    .setAutoCancel(true)
//                    .setContentTitle("折叠式通知")
//
//            val notification = builder.build()
//            //指定展开时的视图
//            notification.bigContentView=remoteViews
//            //添加如下代码，android版本需要手动添加NotificationChannel实现
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                val notificationChannel = NotificationChannel("AppTestNotificationId", "AppTestNotificationName", NotificationManager.IMPORTANCE_DEFAULT)
//                nm!!.createNotificationChannel(notificationChannel)
//            }
//            nm!!.notify(1, notification)
            /**
             *
             *悬挂式通知
             * 如果不显示，看看App悬浮通知选项是否打开
             */
//            val mIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.csdn.net/qq_40716430/article/details/105690486"))
//            val pendingIntent = PendingIntent.getActivity(this, 0, mIntent, 0)
//            val builder = NotificationCompat.Builder(this, "AppTestNotificationId")
//                    .setContentIntent(pendingIntent)
//                    .setSmallIcon(R.mipmap.ic_launcher)
//                    .setLargeIcon(BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher))
//                    .setAutoCancel(true)
//                    .setContentTitle("悬挂式通知")
//
//            //设置点击跳转
//            val hangIntent = Intent()
//            hangIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            hangIntent.setClass(this@MainActivity, MainActivity2::class.java)
//            val activity = PendingIntent.getActivity(this@MainActivity, 0, hangIntent, PendingIntent.FLAG_CANCEL_CURRENT)
//            builder.setFullScreenIntent(activity, true)
//            val notification = builder.build()
//            nm!!.notify(2, notification)


        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        if (!ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.CALL_PHONE))
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}