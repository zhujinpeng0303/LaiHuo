package com.example.jason_jukes.laihuo.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.mine.AddressManageActivity;
import com.example.jason_jukes.laihuo.activity.mine.BindCardActivity;
import com.example.jason_jukes.laihuo.activity.mine.ChangeUserNameActivity;
import com.example.jason_jukes.laihuo.activity.mine.FeedbackActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineFocusListActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineInvistWorkActivity;
import com.example.jason_jukes.laihuo.activity.mine.MinePartWorkActivity;
import com.example.jason_jukes.laihuo.activity.mine.MinePostWorkActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineQualificationActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineScoreActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineWalletActivity;
import com.example.jason_jukes.laihuo.activity.mine.PhoneCertificationActivity;
import com.example.jason_jukes.laihuo.activity.mine.PhoneLoginActivity;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.bean.MineInfoBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.CommonDialog;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;
import com.google.gson.Gson;
import com.jph.takephoto.model.TImage;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import org.xutils.common.Callback;
import org.xutils.common.util.KeyValue;
import org.xutils.http.RequestParams;
import org.xutils.http.body.MultipartBody;
import org.xutils.x;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * 作者：Jason_Jukes on 2018/9/21 0021 16:36
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MineFragment extends BaseFragment {

    @InjectView(R.id.iv_back)
    ImageView ivBack;
    @InjectView(R.id.iv_avatar)
    ImageView ivAvatar;
    @InjectView(R.id.tv_name)
    TextView tvName;
    @InjectView(R.id.tv_shangban)
    TextView tvShangban;
    @InjectView(R.id.tv_guanzhu)
    TextView tvGuanzhu;
    @InjectView(R.id.rl_guanzhu)
    RelativeLayout rlGuanzhu;
    @InjectView(R.id.tv_money)
    TextView tvMoney;
    @InjectView(R.id.rl_qianbao)
    RelativeLayout rlQianbao;
    @InjectView(R.id.tv_fans)
    TextView tvFans;
    @InjectView(R.id.rl_fans)
    RelativeLayout rlFans;
    @InjectView(R.id.tv_wallet_count)
    TextView tvWalletCount;
    @InjectView(R.id.tv_card_status)
    TextView tvCardStatus;
    @InjectView(R.id.tv_phone_status)
    TextView tvPhoneStatus;
    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.tv_top_card_status)
    TextView tvTopCardStatus;
    @InjectView(R.id.tv_top_phone_status)
    TextView tvTopPhoneStatus;
    @InjectView(R.id.ref)
    SwipeRefreshLayout ref;
    private View view;

    private String pathImg = "";

    private String shangbanStatus = "0";

    private String phoneStatus = "0", cardStatus = "0";

    private String score = "", yue = "0";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.inject(this, view);
        ivBack.setVisibility(View.GONE);
        tvStatusBarName.setText("我的");

        initData();

        ref.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initData();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onResume() {
        super.onResume();
//        initData();
    }

    private void initData() {

        if (IsNetWork.isNetWork(context)) {
            showPro();
            ref.setRefreshing(true);
            getInfo();
        } else {
            showToast("请检查网络设置");

        }

    }

    private void getInfo() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
//        map.put("city_id", "236");

        XUtil.Post(Contants.USER_INFO, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MineInfoBean bean = new Gson().fromJson(result, MineInfoBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    Glide.with(context).load(bean.getDataObj().getHead_url()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context))).into(ivAvatar);
                    tvName.setText(bean.getDataObj().getUsername());
                    if (bean.getDataObj().getIs_worker().equals("0")) {
                        tvShangban.setText("我要上班");
                        Drawable img = context.getResources().getDrawable(R.mipmap.img_mine_work_status_no);
                        img.setBounds(0, 0, img.getMinimumWidth(), img.getMinimumHeight());
                        tvShangban.setCompoundDrawables(img, null, null, null);
                        shangbanStatus = "0";
                        SPTool.getInstance().setShareData(Contants.SHANGBAN, shangbanStatus);
                    } else {
                        tvShangban.setText("我要下班");
                        Drawable img = context.getResources().getDrawable(R.mipmap.img_mine_work_status_yes);
                        img.setBounds(0, 0, img.getMinimumWidth(), img.getMinimumHeight());
                        tvShangban.setCompoundDrawables(img, null, null, null);
                        shangbanStatus = "1";
                        SPTool.getInstance().setShareData(Contants.SHANGBAN, shangbanStatus);
                    }

                    tvGuanzhu.setText(bean.getDataObj().getNum_subscribe() + "");
                    tvMoney.setText("¥" + bean.getDataObj().getMoney_yue());
                    tvWalletCount.setText("¥" + bean.getDataObj().getMoney_yue());
                    yue = bean.getDataObj().getMoney_yue() + "";
                    tvFans.setText(bean.getDataObj().getNum_funs() + "");

                    SPTool.getInstance().setShareData(Contants.ID_STATUS, bean.getDataObj().getBind_idcard() + "");

                    if (bean.getDataObj().getMerid() == null) {
                        tvCardStatus.setText("未开户");
                        tvTopCardStatus.setText("未开户");
                        tvTopCardStatus.setBackgroundResource(R.drawable.bg_dark_yellow_corner);
                        cardStatus = "0";
                        SPTool.getInstance().setShareData(Contants.CARD_STATUS, cardStatus);
                    } else {
                        tvCardStatus.setText("已开户");
                        tvTopCardStatus.setText("已开户");
                        tvTopCardStatus.setBackgroundResource(R.drawable.bg_grey_alpha_corner);
                        cardStatus = "1";
                        SPTool.getInstance().setShareData(Contants.CARD_STATUS, cardStatus);
                    }

                    if (bean.getDataObj().getPhoneno() == null) {
                        tvPhoneStatus.setText("未认证");
                        tvTopPhoneStatus.setText("未认证");
                        tvTopPhoneStatus.setBackgroundResource(R.drawable.bg_dark_yellow_corner);
                        phoneStatus = "0";
                        SPTool.getInstance().setShareData(Contants.PHONE_STATUS, phoneStatus);
                    } else {
                        tvPhoneStatus.setText("已认证");
                        tvTopPhoneStatus.setText("已认证");
                        tvTopPhoneStatus.setBackgroundResource(R.drawable.bg_grey_alpha_corner);
                        phoneStatus = "1";
                        SPTool.getInstance().setShareData(Contants.PHONE_STATUS, phoneStatus);
                    }

                    score = bean.getDataObj().getRanking_text();

                } else {
                    showToast(bean.getErrorMsg());
                }
                ref.setRefreshing(false);
                hidePro();

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hidePro();
                ref.setRefreshing(false);

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    @OnClick({R.id.iv_avatar, R.id.rl_name, R.id.tv_shangban, R.id.rl_guanzhu, R.id.rl_qianbao, R.id.rl_fans, R.id.rl_mine_post_work, R.id.rl_mine_join_work, R.id.rl_mine_invist_work, R.id.rl_mine_money, R.id.rl_mine_score, R.id.rl_mine_code, R.id.rl_mine_card, R.id.rl_mine_phone, R.id.rl_mine_zili, R.id.rl_mine_address, R.id.rl_yijian, R.id.rl_tousu, R.id.tv_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_avatar:
                showToast("头像");

                PictureSelector.create(MineFragment.this)
                        .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
//                .theme()//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                        .maxSelectNum(2)// 最大图片选择数量 int
//                .minSelectNum()// 最小选择数量 int
                        .imageSpanCount(4)// 每行显示个数 int
                        .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                        .previewImage(false)// 是否可预览图片 true or false
//                        .previewVideo(false)// 是否可预览视频 true or false
//                        .enablePreviewAudio(false) // 是否可播放音频 true or false
                        .isCamera(true)// 是否显示拍照按钮 true or false
                        .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                        .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                        .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                        .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                        .enableCrop(false)// 是否裁剪 true or false
                        .compress(true)// 是否压缩 true or false
//                .glideOverride()// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                .withAspectRatio()// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
//                .hideBottomControls()// 是否显示uCrop工具栏，默认不显示 true or false
//                .isGif()// 是否显示gif图片 true or false
//                .compressSavePath(getPath())//压缩图片保存地址
//                .freeStyleCropEnabled()// 裁剪框是否可拖拽 true or false
//                .circleDimmedLayer()// 是否圆形裁剪 true or false
//                .showCropFrame()// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
//                .showCropGrid()// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
//                .openClickSound()// 是否开启点击声音 true or false
//                .selectionMedia()// 是否传入已选图片 List<LocalMedia> list
//                .previewEggs()// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
                        .cropCompressQuality(50)// 裁剪压缩质量 默认90 int
                        .minimumCompressSize(100)// 小于100kb的图片不压缩
                        .synOrAsy(true)//同步true或异步false 压缩 默认同步
//                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
//                .rotateEnabled() // 裁剪是否可旋转图片 true or false
//                .scaleEnabled()// 裁剪是否可放大缩小图片 true or false
//                .videoQuality()// 视频录制质量 0 or 1 int
//                .videoMaxSecond(15)// 显示多少秒以内的视频or音频也可适用 int
//                .videoMinSecond(10)// 显示多少秒以内的视频or音频也可适用 int
//                .recordVideoSecond()//视频秒数录制 默认60s int
//                .isDragFrame(false)// 是否可拖动裁剪框(固定)
                        .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code


                break;
            case R.id.rl_name:
                startActivity(new Intent(context, ChangeUserNameActivity.class)
                        .putExtra("name", getText(tvName)));
                break;
            case R.id.tv_shangban:

                if (phoneStatus.equals("0")) {
                    bindPhone();
                    return;
                }
                if (cardStatus.equals("0")) {
                    bindCard();
                    return;
                }

                if (shangbanStatus.equals("0")) {
                    shangban();
                } else {
                    xiaban();
                }

                break;
            case R.id.rl_guanzhu:
                startActivity(new Intent(context, MineFocusListActivity.class)
                        .putExtra("type", "focus"));
                break;
            case R.id.rl_qianbao:
                startIntent(MineWalletActivity.class);
                break;
            case R.id.rl_fans:
                startActivity(new Intent(context, MineFocusListActivity.class)
                        .putExtra("type", "fans"));
                break;
            case R.id.rl_mine_post_work:
                startIntent(MinePostWorkActivity.class);
                break;
            case R.id.rl_mine_join_work:
                startIntent(MinePartWorkActivity.class);
                break;
            case R.id.rl_mine_invist_work:
                startIntent(MineInvistWorkActivity.class);
                break;
            case R.id.rl_mine_money:
                startActivity(new Intent(context, MineWalletActivity.class)
                        .putExtra("yue", yue));
                break;
            case R.id.rl_mine_score:
                startActivity(new Intent(context, MineScoreActivity.class)
                        .putExtra("score", score));
                break;
            case R.id.rl_mine_code:
                break;
            case R.id.rl_mine_card:

                startIntent(BindCardActivity.class);

                break;
            case R.id.rl_mine_phone:
                startIntent(PhoneCertificationActivity.class);
                break;
            case R.id.rl_mine_zili:
                startIntent(MineQualificationActivity.class);
                break;
            case R.id.rl_mine_address:
                startIntent(AddressManageActivity.class);
                break;
            case R.id.rl_yijian:
                startActivity(new Intent(context, FeedbackActivity.class)
                        .putExtra("type", "yijian"));
                break;
            case R.id.rl_tousu:
                startActivity(new Intent(context, FeedbackActivity.class)
                        .putExtra("type", "tousu"));
                break;
            case R.id.tv_exit:

                startIntent(PhoneLoginActivity.class);

                break;
        }
    }

    private void xiaban() {
        CommonDialog commonDialog = new CommonDialog(context);
        commonDialog.commonDialog("提示", "开启下班状态后,系统将清空您的实时位置信息,您将在附近的能人列表中消失", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {

                work("0");

                dialog.dismiss();
            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }

    private void shangban() {

        CommonDialog commonDialog = new CommonDialog(context);
        commonDialog.commonDialog("提示", "开启上班状态后,系统将获取您的实时位置,以便系统为您推荐任务单并且您将出现在附近的能人列表中", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {

                work("1");

                dialog.dismiss();
            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }

    private void work(String status) {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("is_worker", status);

        XUtil.Post(Contants.SHANGBAN_STATUS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {
                    showToast(bean.getErrorMsg());
                    onResume();
                } else {
                    showToast(bean.getErrorMsg());
                }
                hidePro();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());
                hidePro();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }

    private void bindCard() {

        CommonDialog commonDialog = new CommonDialog(context);
        commonDialog.commonDialog("提示", "您还没有进行绑卡开户,还不能进行上下班操作!", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {
                startIntent(BindCardActivity.class);
                dialog.dismiss();
            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }

    private void bindPhone() {

        CommonDialog commonDialog = new CommonDialog(context);
        commonDialog.commonDialog("提示", "您还没有进行手机认证,还不能进行上下班操作!", new CommonDialog.TvClick() {
            @Override
            public void okClick(AlertDialog dialog) {
                startIntent(PhoneCertificationActivity.class);
                dialog.dismiss();
            }

            @Override
            public void cancelClick(AlertDialog dialog) {

                dialog.dismiss();

            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的

                    Glide.with(context).load(selectList.get(0).getCompressPath()).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context))).into(ivAvatar);

                    showToast("success");

                    Log.e("path", selectList.get(0).getCompressPath());

//                    File file = new File(selectList.get(0).getCompressPath());

                    String path = "";

                    List<String> paths = new ArrayList<>();

                    for (int i = 0; i < selectList.size(); i++) {
                        paths.add(selectList.get(i).getCompressPath());
                    }

                    List<KeyValue> list = new ArrayList<KeyValue>();

                    for (int i = 0; i < selectList.size(); i++) {
                        File file = new File(selectList.get(i).getCompressPath());

                        list.add(new KeyValue("file", file));
                    }


                    testUP(list);


                    break;
            }
        }

    }

    private void testUP(List<KeyValue> list) {

        MultipartBody body = new MultipartBody(list, "UTF-8");
        RequestParams params = new RequestParams(Contants.URL_BASE + "fileUploadOrderImage");
        params.setRequestBody(body);
        params.setMultipart(true);

//        for (int i = 0; i < path.size(); i++) {
//            params.addBodyParameter("file", new File(path.get(i)), "multipart/form-data");
//        }


        Callback.Cancelable cancelable = x.http().post(params, new Callback.ProgressCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("result", result);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e("fail", ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public void onWaiting() {

            }

            @Override
            public void onStarted() {

            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {

            }
        });

//        Map<String, Object> map = new HashMap<>();
//        map.put("file", path);
//
//        XUtil.UpLoadFile(Contants.URL_BASE + "fileUploadOrderImage", map, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//
//                Log.e("result",result);
//
//
//
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//
//                Log.e("fail", ex.getMessage());
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });


    }

    private void showImg(final ArrayList<TImage> images) {
        pathImg = images.get(images.size() - 1).getCompressPath();
        Log.e("path111111", pathImg);
        File file = new File(pathImg);
        Log.e("file111111", file + "");
        Glide.with(context).load(file).apply(RequestOptions.bitmapTransform(new GlideCircleTransform(context))).into(ivAvatar);

        if (file.exists()) {
//            if (IsNetWork.isNetWork(this)) {
//                showProgressDialog();
//                UpdatePhoto(file);   //上传头像
//            } else {
//                showToast("请检查网络设置");
//            }

        }
    }


}
