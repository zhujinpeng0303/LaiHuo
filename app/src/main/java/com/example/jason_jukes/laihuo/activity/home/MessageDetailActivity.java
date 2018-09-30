package com.example.jason_jukes.laihuo.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.ViewPagerActivity;
import com.example.jason_jukes.laihuo.adapter.MessageCommentLVAdapter;
import com.example.jason_jukes.laihuo.bean.MessageDetailBean;
import com.example.jason_jukes.laihuo.bean.MessageMarketBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;
import com.example.jason_jukes.laihuo.view.nineImage.NineGridlayout;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private TextView name, date, content, focus_count, comment_count, focus;
    private ImageView avatar;
    private LinearLayout ll;
    private NineGridlayout nineGridlayout;
    private TextView new_comment;

    private MessageCommentLVAdapter adapter;
    private List<MessageDetailBean.DataObjBean.SreplyListBean> been;
    private MessageDetailBean bean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        ButterKnife.inject(this);
        initView();
//        initData();
    }

    private void initView() {
        tvStatusBarName.setText("信息市场");

        headerView = LayoutInflater.from(context).inflate(R.layout.header_lv_message_comment, null);
        date = (TextView) headerView.findViewById(R.id.tv_date);
        name = (TextView) headerView.findViewById(R.id.tv_name);
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

        adapter = new MessageCommentLVAdapter(this, been);

        lv.setAdapter(adapter);
        lv.setDividerHeight(0);
        lv.setVerticalScrollBarEnabled(false);


    }

    private void initData() {

        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            getData();
        } else {
            showToast("请检查网络设置");

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        been.clear();
        ll.removeAllViews();
        initData();
    }

    private void getData() {

        Map<String, Object> map = new HashMap<>();
//        map.put("user_id", SPTool.getInstance().getShareDataStr(Contants.USER_ID));
        map.put("token", "gggg");
        map.put("id", getIntent().getStringExtra("id"));
        XUtil.Post(Contants.MESSAGE_MARKET_DETAIL, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                bean = new Gson().fromJson(result, MessageDetailBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    for (int i = 0; i < bean.getDataObj().getSreplyList().size(); i++) {

                        been.add(bean.getDataObj().getSreplyList().get(i));

                    }

                    adapter.notifyDataSetChanged();

                    final List<String> imgs = new ArrayList<>();
                    String str = bean.getDataObj().getPics();
                    String[] arr = str.split(",");//分割字符串得到数组
                    List<String> list = java.util.Arrays.asList(arr);//字符数组转list

                    for (int i1 = 0; i1 < list.size(); i1++) {
                        imgs.add(Contants.URL_IMG_BASE + list.get(i1));
                    }

                    nineGridlayout.setImagesData(imgs);
                    nineGridlayout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MessageDetailActivity.this, ViewPagerActivity.class)
                                    .putStringArrayListExtra("list", (ArrayList<String>) imgs));
                        }
                    });

                    name.setText(bean.getDataObj().getUsername());
                    date.setText(bean.getDataObj().getCreate_time());
                    content.setText(bean.getDataObj().getContents());
                    focus_count.setText(bean.getDataObj().getClick_count() + "");
                    comment_count.setText(bean.getDataObj().getSreplyList().size() + "");
                    new_comment.setText("最新评论(" + bean.getDataObj().getSreplyList().size() + ")");
                    Glide.with(context).load(bean.getDataObj().getHead_url()).transform(new GlideCircleTransform(context)).into(avatar);

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) context.getResources().getDimension(R.dimen.y80), ViewGroup.LayoutParams.MATCH_PARENT);

                    for (int i = 0; i < bean.getDataObj().getTopicLogList().size(); i++) {
                        ImageView imageView = new ImageView(context);
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        imageView.setPadding(0, 0, 0, 0);
                        imageView.setLayoutParams(params);
                        Glide.with(context).load(bean.getDataObj().getTopicLogList().get(i).getHead_url()).transform(new GlideCircleTransform(context)).into(imageView);
                        ll.addView(imageView);
                    }


                } else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hideProgressDialog();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    @OnClick({R.id.rl_back, R.id.tv_mine_speak})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_mine_speak:
//                showToast("我也说两句");
                startActivity(new Intent(this, SendCommentActivity.class)
                        .putExtra("id", bean.getDataObj().getId() + ""));
                break;
        }
    }

}
