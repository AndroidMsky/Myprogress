package com.airy.myprogress;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ImageView contentImageView;
    private ImageView overImageView;
    private float h, w;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


/*
UI事件队列会按顺序处理事件。在setContentView()被调用后
事件队列中会包含一个要求重新layout的message
所以任何你post到队列中的东西都会在Layout发生变化后执行
*/
        contentImageView.post(new Runnable() {
            @Override
            public void run() {
                h = contentImageView.getHeight();
                w = contentImageView.getWidth();
                Toast.makeText(MainActivity.this, "h:" + h + "w:" + w, Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void init() {
        contentImageView = (ImageView) findViewById(R.id.content);
        overImageView = (ImageView) findViewById(R.id.over);


    }

    public void c0(View v) {

        ObjectAnimator
                .ofFloat(overImageView, "translationX", 0).
                setDuration(500).start();

    }

    public void c5(View v) {
        ObjectAnimator
                .ofFloat(overImageView, "translationX", w).
                setDuration(500).start();


    }

    public void c2(View v) {

        ObjectAnimator
                .ofFloat(overImageView, "translationX", w * 0.289f).
                setDuration(500).start();

    }

    public void c4(View v) {

        ObjectAnimator
                .ofFloat(overImageView, "translationX", w * 0.736f).
                setDuration(500).start();

    }


}
