package com.base.jinjiezhiguang

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.LinearLayout
import android.widget.Scroller
import androidx.annotation.RequiresApi

/**
 * @author jia
 * 自定义View
 */
class CustomView : View {
    private var lastX = 0
    private var lastY = 0
    private var mScroller: Scroller? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        mScroller = Scroller(context)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    override fun computeScroll() {
        super.computeScroll()
        if (mScroller!!.computeScrollOffset()) {
            (parent as View).scrollTo(mScroller!!.currX, mScroller!!.currY)
            invalidate()
        }
    }

    fun smoothScrollTo(destX: Int, destY: Int) {
        val scaleX = scaleX.toInt()
        val delta = destX - scaleX
        mScroller!!.startScroll(scaleX, 0, delta, 0, 2000)
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        //获取手指触摸点的横坐标和纵坐标
        val x = event.x.toInt()
        val y = event.y.toInt()
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_MOVE -> {
                //计算移动的距离
                val offsetX = x - lastX
                val offsetY = y - lastY
                //改变View位置的效果几种：
                //1、调用layout方法来重新放置它的位置
                layout(left + offsetX, top + offsetY,
                        right + offsetX, bottom + offsetY
                )
                //2、
//                对left和right进行偏移
                offsetLeftAndRight(offsetX)
                //                //对top和bottom进行偏移
                offsetTopAndBottom(offsetY)
                //3、通过LayoutParams来改变View的布局参数从而达到改变View位置
                //注意：父控件是什么就写什么   ConstraintLayout目前有点问题，只能上下滑动
//                val layoutParams = layoutParams as LinearLayout.LayoutParams
//                layoutParams.leftMargin = left + offsetX
//                layoutParams.topMargin = top + offsetY
//                setLayoutParams(layoutParams)
                //4、使用ViewGroup.MarginLayoutParams
                val layoutParams = layoutParams as MarginLayoutParams
                layoutParams.leftMargin = left + offsetX
                layoutParams.topMargin = top + offsetY
                setLayoutParams(layoutParams)
            }
        }
        return true
    }
}