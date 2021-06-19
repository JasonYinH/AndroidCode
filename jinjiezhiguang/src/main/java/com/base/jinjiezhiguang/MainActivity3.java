package com.base.jinjiezhiguang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    private PwdEditText p;

    @SuppressLint("ObjectAnimatorBinding")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        p = findViewById(R.id.p);
        p.setOnTextChangeListener(new PwdEditText.OnTextChangeListener() {
            @Override
            public void onTextChange(String pwd) {
                if (pwd.length() == p.getTextLength()) {
                    //输入监听
                    Toast.makeText(MainActivity3.this, pwd, Toast.LENGTH_SHORT).show();
                }
            }
        });
//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                p.clearText(); //清空输入内容
//            }
//        });

//        ConstraintLayout cl = findViewById(R.id.cl);
//        MyView myView = new MyView(cl);
//        ObjectAnimator animation = ObjectAnimator.ofFloat(myView, "translationX", 0, 500);
//        animation.addListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
//        animation.addListener(new AnimatorListenerAdapter() {
//
//        });

    }
}