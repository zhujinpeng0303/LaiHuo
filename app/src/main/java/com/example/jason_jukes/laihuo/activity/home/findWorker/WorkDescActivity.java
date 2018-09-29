package com.example.jason_jukes.laihuo.activity.home.findWorker;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/27 0027 09:19
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class WorkDescActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.et_work_desc)
    EditText etWorkDesc;
    @InjectView(R.id.ll_yuyin)
    LinearLayout llYuyin;
    @InjectView(R.id.iv_del)
    ImageView ivDel;
    @InjectView(R.id.iv_play)
    ImageView ivPlay;
    @InjectView(R.id.rl_lunyin)
    RelativeLayout rlLunyin;
    @InjectView(R.id.tv_end_luyin)
    TextView tvEndLuyin;
    @InjectView(R.id.tv_cancel_luyin)
    TextView tvCancelLuyin;
    @InjectView(R.id.rl_luyining)
    RelativeLayout rlLuyining;
    @InjectView(R.id.tv_kehuanjia)
    TextView tvKehuanjia;
    @InjectView(R.id.tv_yikoujia)
    TextView tvYikoujia;
    @InjectView(R.id.et_jiage)
    EditText etJiage;
    @InjectView(R.id.radio_btn)
    RadioButton radioBtn;
    @InjectView(R.id.tv_word)
    TextView tvWord;
    @InjectView(R.id.tv_time)
    TextView tvTime;
    @InjectView(R.id.ll_work_time)
    LinearLayout llWorkTime;
    @InjectView(R.id.rl_kehuanjia)
    RelativeLayout rlKehuanjia;
    @InjectView(R.id.rl_yikoujia)
    RelativeLayout rlYikoujia;
    @InjectView(R.id.rl_rb)
    RelativeLayout rlRb;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    @InjectView(R.id.iv1)
    ImageView iv1;
    @InjectView(R.id.iv2)
    ImageView iv2;

    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_desc);
        ButterKnife.inject(this);
        initView();

    }

    private void initView() {

        tvStatusBarName.setText("发布");

        tvTitle.setText("第二步·请描述您的服务内容");
        iv1.setBackgroundResource(R.mipmap.img_dui);
        iv2.setBackgroundResource(R.mipmap.img_two_choose);

        tvTime.setVisibility(View.GONE);
        radioBtn.setChecked(false);
        llWorkTime.setClickable(true);
        rlRb.setClickable(false);
    }

    @OnClick({R.id.rl_back, R.id.ll_yuyin, R.id.iv_del, R.id.iv_play, R.id.rl_lunyin, R.id.tv_end_luyin, R.id.tv_cancel_luyin, R.id.rl_luyining, R.id.rl_kehuanjia, R.id.rl_yikoujia, R.id.iv_detail, R.id.rl_rb, R.id.tv_time, R.id.ll_work_time, R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_yuyin:
                //开始录音的框
                break;
            case R.id.iv_del:
                break;
            case R.id.iv_play:
                break;
            case R.id.rl_lunyin:

                break;
            case R.id.tv_end_luyin:
                break;
            case R.id.tv_cancel_luyin:
                break;
            case R.id.rl_luyining:
                //录音中的框

                break;
            case R.id.rl_kehuanjia:

                rlKehuanjia.setBackgroundResource(R.drawable.bg_blue_corner);
                tvKehuanjia.setTextColor(getResources().getColor(R.color.white));
                Drawable drawable = getResources().getDrawable(R.mipmap.img_home);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tvKehuanjia.setCompoundDrawables(drawable, null, null, null);

                rlYikoujia.setBackgroundResource(0);
                tvYikoujia.setTextColor(getResources().getColor(R.color.colorBlack));
                tvYikoujia.setCompoundDrawables(null, null, null, null);

                etJiage.setHint("心理预期价格(可不填)");

                break;
            case R.id.rl_yikoujia:

                rlYikoujia.setBackgroundResource(R.drawable.bg_blue_corner);
                tvYikoujia.setTextColor(getResources().getColor(R.color.white));
                Drawable drawable1 = getResources().getDrawable(R.mipmap.img_home);
                drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
                tvYikoujia.setCompoundDrawables(drawable1, null, null, null);


                rlKehuanjia.setBackgroundResource(0);
                tvKehuanjia.setTextColor(getResources().getColor(R.color.colorBlack));
                tvKehuanjia.setCompoundDrawables(null, null, null, null);

                etJiage.setHint("一口价价格(必填)");

                break;
            case R.id.iv_detail:
                break;
            case R.id.rl_rb:

                if (flag) {
                    rlRb.setClickable(false);
                    llWorkTime.setClickable(true);
                    radioBtn.setChecked(false);
                    tvTime.setVisibility(View.GONE);

                    tvWord.setText("未设置要求开工时间");

                    flag = !flag;
                }

                break;
            case R.id.tv_time:


                break;
            case R.id.ll_work_time:

                if (!flag) {
                    tvTime.setVisibility(View.VISIBLE);
                    llWorkTime.setClickable(false);
                    radioBtn.setChecked(true);
                    rlRb.setClickable(true);

                    tvWord.setText("要求开工时间:");

                    flag = !flag;
                }

                break;
            case R.id.tv_commit:

                startIntent(WorkAddressActivity.class);

                break;
        }
    }
}
