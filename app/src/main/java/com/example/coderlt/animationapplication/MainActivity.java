package com.example.coderlt.animationapplication;

import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button skipTweenAnimation;
    private Button moveButton;
    private Button scrollToBtn;
    private Button scrollByBtn;
    private Button propertyBtn;
    int i=0;
    int buttonWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skipTweenAnimation=findViewById(R.id.skip_tween_animation);
        moveButton=findViewById(R.id.move_btn);
        scrollToBtn=findViewById(R.id.scroll_to);
        scrollByBtn=findViewById(R.id.scroll_by);
        propertyBtn=findViewById(R.id.property_animation);

        // TODO 注意，这里的width将会是0！！！！，应该在onCLick里面获取宽度
        //buttonWidth=propertyBtn.getWidth();


        skipTweenAnimation.setOnClickListener(this);
        moveButton.setOnClickListener(this);
        scrollToBtn.setOnClickListener(this);
        scrollByBtn.setOnClickListener(this);
        propertyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        // TODO  getWidth 和 getLayoutParams.width 有区别么？好像运行起来都可以
        buttonWidth=propertyBtn.getWidth();

        switch(v.getId()){
            case R.id.skip_tween_animation:
                startActivity(new Intent(this,TweenAnimationActivity.class));
                break;
            case  R.id.move_btn:
                Toast.makeText(this,"move btn",Toast.LENGTH_SHORT)
                        .show();

                moveButton.setTranslationX(100+50);
                moveButton.setTranslationY(100+50*i);
                i++;
                break;
            case R.id.scroll_to:
                Toast.makeText(this,"scroll to",Toast.LENGTH_SHORT)
                        .show();
                scrollToBtn.scrollTo(-20,-20);
                break;
            case R.id.scroll_by:
                Toast.makeText(this,"scroll by",Toast.LENGTH_SHORT)
                        .show();
                scrollByBtn.scrollBy(-20,-20);
                break;
            case R.id.property_animation:
                ValueAnimator valueAnimator=ValueAnimator.ofInt(1,100);
                valueAnimator.setDuration(5000);

                //widthAnim.setRepeatCount(5);
                //widthAnim.setRepeatMode(ValueAnimator.REVERSE);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    private IntEvaluator mEvaluator =new IntEvaluator();
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int currentValue=(Integer)animation.getAnimatedValue();
                        float fraction=animation.getAnimatedFraction();
                        propertyBtn.getLayoutParams().width=mEvaluator.evaluate(fraction,
                                buttonWidth,800);
                        propertyBtn.requestLayout();
                    }
                });
                valueAnimator.start();
                break;
            default:
                break;
        }
    }
}
