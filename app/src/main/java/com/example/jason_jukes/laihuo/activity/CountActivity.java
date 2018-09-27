package com.example.jason_jukes.laihuo.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 作者：Jason_Jukes on 2018/9/27 0027 15:50
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class CountActivity extends BaseActivity {

    @InjectView(R.id.tv1)
    TextView tv1;
    @InjectView(R.id.tv2)
    TextView tv2;
    @InjectView(R.id.tv3)
    TextView tv3;
    @InjectView(R.id.tv4)
    TextView tv4;

    private String num = "0019";

    private Animation tra1, tra2;
    int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        ButterKnife.inject(this);


        tv4.startAnimation(showA1(2000 - Integer.valueOf(String.valueOf(num.charAt(3))) * 100));

        tra2 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.7f, Animation.RELATIVE_TO_SELF, 0.0f);
        tra2.setInterpolator(new DecelerateInterpolator());
        tra2.setDuration(1100);
        tra2.setFillAfter(true);

    }

    public Animation showA1(int duration) {

        Animation tra1 = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.7f, Animation.RELATIVE_TO_SELF, -0.7f);
        tra1.setDuration(duration);
        tra1.setFillAfter(true);

        tra1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


            }

            @Override
            public void onAnimationEnd(Animation animation) {

                tv4.setText(a + "");
                if (a != Integer.valueOf(String.valueOf(num.charAt(3)))) {
                    tv4.startAnimation(showA1(2000 - Integer.valueOf(String.valueOf(num.charAt(3))) * 100));
                    a++;
                } else {
                    tv4.startAnimation(tra2);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });


        return tra1;

    }

    public void showA2(int duration) {


    }


}
