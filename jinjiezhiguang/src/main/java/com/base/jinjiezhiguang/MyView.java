package com.base.jinjiezhiguang;

import android.view.View;

/**
 * @author jia
 * 包装类的方法给一个属性增加get和set方法
 */
public  class MyView {
    public View mTarget;

    public MyView(View mTarget) {
        this.mTarget = mTarget;
    }
    public int getWidth() {
        return mTarget.getLayoutParams().width;
    }
    public void setWidth(int width) {
        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }
}