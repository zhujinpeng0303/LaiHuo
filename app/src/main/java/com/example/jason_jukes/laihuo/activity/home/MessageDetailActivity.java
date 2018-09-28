package com.example.jason_jukes.laihuo.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.ViewPagerActivity;
import com.example.jason_jukes.laihuo.adapter.MessageCommentLVAdapter;
import com.example.jason_jukes.laihuo.view.nineImage.NineGridlayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/9/24 0024.
 */

public class MessageDetailActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.lv)
    ListView lv;
    private View headerView;
    private TextView date, content, focus_count, comment_count, focus;
    private ImageView avatar;
    private LinearLayout ll;
    private NineGridlayout nineGridlayout;
    private TextView new_comment;

    private MessageCommentLVAdapter adapter;
    private List<String> been;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {
        tvStatusBarName.setText("信息市场");

        headerView = LayoutInflater.from(context).inflate(R.layout.header_lv_message_comment, null);
        date = (TextView) headerView.findViewById(R.id.tv_date);
        content = (TextView) headerView.findViewById(R.id.tv_content);
        focus_count = (TextView) headerView.findViewById(R.id.tv_focus_count);
        comment_count = (TextView) headerView.findViewById(R.id.tv_comment_count);
        avatar = (ImageView) headerView.findViewById(R.id.iv_avatar);
        ll = (LinearLayout) headerView.findViewById(R.id.ll_img);
        nineGridlayout = (NineGridlayout) headerView.findViewById(R.id.iv_img_list);
        new_comment = (TextView) headerView.findViewById(R.id.tv_new_comment);
        focus = (TextView) headerView.findViewById(R.id.tv_focus);

        focus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("关注");
            }
        });

        lv.addHeaderView(headerView);

        been = new ArrayList<>();
        been.add("真好啊");
        been.add("长假结束 奇偶去我家就kdj看得见");
        been.add("kjipoj克氏棘豆我就卢卡斯的既往地来看是看了都会哦IQ好多了卡还是懂你抢我红欧莱德哈史莱克的环球网和哦豁拉烧开后吊无情和");
        been.add("科技司机会");
        been.add("是");

        adapter = new MessageCommentLVAdapter(this, been);

        lv.setAdapter(adapter);
        lv.setDividerHeight(0);
        lv.setVerticalScrollBarEnabled(false);

        nineGridlayout.setImagesData(getIntent().getStringArrayListExtra("list"));

        nineGridlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MessageDetailActivity.this, ViewPagerActivity.class)
                        .putStringArrayListExtra("list", getIntent().getStringArrayListExtra("list")));
            }
        });

    }

    private void initData() {


    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @OnClick({R.id.rl_back, R.id.tv_mine_speak})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_mine_speak:
                showToast("我也说两句");
                startIntent(SendCommentActivity.class);
                break;
        }
    }
}
