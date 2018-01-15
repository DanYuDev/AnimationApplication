package com.example.coderlt.animationapplication;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class TweenAnimationActivity extends AppCompatActivity {
    private final String TAG=getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        final Animation anim= AnimationUtils.loadAnimation(this,R.anim.rotate);
        //AnimationDrawable frameAnim=(AnimationDrawable)getResources().getDrawable(R.drawable.frame);
        // 监听动画地状态
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(TAG,"onAnimationStart , current time is :"+ new Date());
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG,"onAnimationEnd , current time is :"+ new Date());
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Button tweenAnimBtn=findViewById(R.id.tween_rotate_anim);
        //Button frameAnimBtn=findViewById(R.id.frame_rotate_anim);

        tweenAnimBtn.startAnimation(anim);
        //frameAnimBtn.setBackgroundResource(R.drawable.frame);
        //并不能执行两次，要思考一下原因在哪，比如，这个 tv 还是当年那个纯真的 tv么‘
        //tv.startAnimation(anim);

        tweenAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TweenAnimationActivity.this,"old button.",Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
