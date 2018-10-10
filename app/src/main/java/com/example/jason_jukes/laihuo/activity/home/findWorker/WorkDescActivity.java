package com.example.jason_jukes.laihuo.activity.home.findWorker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.jason_jukes.laihuo.App;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.WebviewActivity;
import com.example.jason_jukes.laihuo.adapter.WorkDescGridAdapter;
import com.example.jason_jukes.laihuo.bean.ImgPostBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.Singleton;
import com.example.jason_jukes.laihuo.tool.StringUtil;
import com.example.jason_jukes.laihuo.view.MyGridView;
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
    @InjectView(R.id.gridView)
    MyGridView gridView;
    @InjectView(R.id.tv_lunyin_word)
    TextView tvLunyinWord;

    private boolean flag = false;
    private String status = "0", luyin = "";
    private String data = "", time = "";

    private WorkDescGridAdapter adapter;
    private List<String> imgs = new ArrayList<>();

    private WorkDescGridAdapter.delClick delClick;
    private List<String> imgPaths = new ArrayList<>();

    private MediaRecorder mRecorder;
    private String mFileName = "";

    private MediaPlayer mPlayer = new MediaPlayer();

    private boolean isPlaying = false;

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

        delClick = new WorkDescGridAdapter.delClick() {
            @Override
            public void DelClick(int pos) {

                imgs.remove(pos);
                imgPaths.remove(pos - 1);
                adapter.notifyDataSetChanged();

            }
        };

        imgs = new ArrayList<>();
        imgs.add("aa");
        adapter = new WorkDescGridAdapter(this, imgs, delClick);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {

                    if (imgs.size() == 10) {
                        showToast("最多上传9张");
                    } else {
                        //选择图片
                        PictureSelector.create(WorkDescActivity.this)
                                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                                .maxSelectNum(10 - imgs.size())// 最大图片选择数量 int
                                .imageSpanCount(4)// 每行显示个数 int
                                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                                .previewImage(false)// 是否可预览图片 true or false
                                .isCamera(true)// 是否显示拍照按钮 true or false
                                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                                .enableCrop(false)// 是否裁剪 true or false
                                .compress(true)// 是否压缩 true or false
                                .cropCompressQuality(50)// 裁剪压缩质量 默认90 int
                                .minimumCompressSize(100)// 小于100kb的图片不压缩
                                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code

                    }
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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

                    int len = imgs.size();

                    for (int i = 0; i < selectList.size(); i++) {

                        showProgressDialog();
                        postImg(selectList.get(i).getCompressPath(), selectList.size(), len);

                    }

                    break;
            }
        }

    }

    private void postImg(final String path, final int size, final int len) {

        RequestParams params = new RequestParams(Contants.URL_BASE + "fileUploadOrderImage");
//        RequestParams params = new RequestParams(Contants.POST_HUANJIA);
//        params.setRequestBody(body);
        params.setMultipart(true);

        params.addBodyParameter("file", new File(path), "multipart/form-data");


        Callback.Cancelable cancelable = x.http().post(params, new Callback.ProgressCallback<String>() {
            @Override
            public void onSuccess(String result) {

                ImgPostBean bean = new Gson().fromJson(result, ImgPostBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    imgs.add(path);
                    adapter.notifyDataSetChanged();

                    imgPaths.add(bean.getDataObj().getFileName());

                } else {
                    showToast(bean.getErrorMsg());
                }

                if (imgs.size() - len == size) {
                    hideProgressDialog();
                }

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

    }

    @OnClick({R.id.rl_back, R.id.ll_yuyin, R.id.iv_del, R.id.iv_play, R.id.rl_lunyin, R.id.tv_end_luyin, R.id.tv_cancel_luyin, R.id.rl_luyining, R.id.rl_kehuanjia, R.id.rl_yikoujia, R.id.iv_detail, R.id.rl_rb, R.id.tv_time, R.id.ll_work_time, R.id.tv_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.ll_yuyin:
                //开始录音的框

                //判断用户是否已经授权
                if (ContextCompat.checkSelfPermission(WorkDescActivity.this, "Manifest.permission.RECORD_AUDIO") != PackageManager.PERMISSION_GRANTED
                        || ContextCompat.checkSelfPermission(WorkDescActivity.this, "Manifest.permission.WRITE_EXTERNAL_STORAGE") != PackageManager.PERMISSION_GRANTED) {
                    //注意第二个参数没有双引号
                    ActivityCompat.requestPermissions(WorkDescActivity.this, new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

                } else {

                    startRecord();
                }
                break;
            case R.id.iv_del:
                mFileName = "";
//                mRecorder.reset();
//                mRecorder.release();
                rlLuyining.setVisibility(View.GONE);
                ivDel.setVisibility(View.GONE);
                ivPlay.setVisibility(View.GONE);
                llYuyin.setVisibility(View.VISIBLE);
                tvLunyinWord.setText("打字说不清楚?试试语音吧");

                break;
            case R.id.iv_play:
                if (!isPlaying) {
                    ivPlay.setBackgroundResource(R.mipmap.img_desc_luyin_pause);
                    try {
                        isPlaying = true;
                        mPlayer = new MediaPlayer();
                        mPlayer.setDataSource(mFileName);
                        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

                        // 通过异步的方式装载媒体资源
                        mPlayer.prepareAsync();
                        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(MediaPlayer mp) {
                                // 装载完毕回调
                                mPlayer.start();
                            }
                        });
//                        mPlayer.prepare();
//                        mPlayer.start();

                        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                isPlaying = false;
                                ivPlay.setBackgroundResource(R.mipmap.img_desc_luyin_play);
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    ivPlay.setBackgroundResource(R.mipmap.img_desc_luyin_play);

                    if (mPlayer != null) {
                        isPlaying = false;
                        mPlayer.pause();
                    }

                }
                break;

            case R.id.tv_end_luyin:
                mRecorder.stop();
                mRecorder.reset();
                mRecorder.release();
                rlLuyining.setVisibility(View.GONE);
                ivDel.setVisibility(View.VISIBLE);
                ivPlay.setVisibility(View.VISIBLE);
                ivPlay.setBackgroundResource(R.mipmap.img_desc_luyin_play);
                llYuyin.setVisibility(View.VISIBLE);
                tvLunyinWord.setText("点击重新录制");
                break;
            case R.id.tv_cancel_luyin:

                mFileName = "";
                mRecorder.stop();
                mRecorder.reset();
                mRecorder.release();
                rlLuyining.setVisibility(View.GONE);
                ivDel.setVisibility(View.GONE);
                ivPlay.setVisibility(View.GONE);
                llYuyin.setVisibility(View.VISIBLE);
                tvLunyinWord.setText("打字说不清楚?试试语音吧");

                break;

            case R.id.rl_kehuanjia:

                rlKehuanjia.setBackgroundResource(R.drawable.bg_blue_corner);
                tvKehuanjia.setTextColor(getResources().getColor(R.color.white));
                Drawable drawable = getResources().getDrawable(R.mipmap.img_duihao);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                tvKehuanjia.setCompoundDrawables(drawable, null, null, null);

                rlYikoujia.setBackgroundResource(0);
                tvYikoujia.setTextColor(getResources().getColor(R.color.colorBlack));
                tvYikoujia.setCompoundDrawables(null, null, null, null);

                etJiage.setHint("心理预期价格(可不填)");

                status = "0";

                break;
            case R.id.rl_yikoujia:

                rlYikoujia.setBackgroundResource(R.drawable.bg_blue_corner);
                tvYikoujia.setTextColor(getResources().getColor(R.color.white));
                Drawable drawable1 = getResources().getDrawable(R.mipmap.img_duihao);
                drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
                tvYikoujia.setCompoundDrawables(drawable1, null, null, null);


                rlKehuanjia.setBackgroundResource(0);
                tvKehuanjia.setTextColor(getResources().getColor(R.color.colorBlack));
                tvKehuanjia.setCompoundDrawables(null, null, null, null);

                etJiage.setHint("一口价价格(必填)");
                status = "1";
                break;

            case R.id.iv_detail:

                startActivity(new Intent(WorkDescActivity.this, WebviewActivity.class)
                        .putExtra("url", Contants.XINZI_BIAOZHUN));

                break;
            case R.id.rl_rb:

                if (flag) {
                    rlRb.setClickable(false);
                    llWorkTime.setClickable(true);
                    radioBtn.setChecked(false);
                    tvTime.setVisibility(View.GONE);

                    tvWord.setText("未设置要求开工时间");

                    data = "";
                    time = "";

                    flag = !flag;
                }

                break;
            case R.id.tv_time:

                Calendar calendarStart = Calendar.getInstance();
                calendarStart.set(calendarStart.get(Calendar.YEAR), calendarStart.get(Calendar.MONTH), calendarStart.get(Calendar.DATE));

                Calendar calendarEnd = Calendar.getInstance();
                calendarEnd.set(calendarEnd.get(Calendar.YEAR), calendarEnd.get(Calendar.MONTH), calendarEnd.get(Calendar.DATE) + 7);


                TimePickerView pvTime = new TimePickerBuilder(WorkDescActivity.this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm");

                        if (Integer.valueOf(StringUtil.getTimestamp(dateFormat.format(date), "yyyy-MM-dd HH:mm"))
                                <= Integer.valueOf(StringUtil.getTimestamp(StringUtil.getCurrentTime("yyyy-MM-dd HH:mm"), "yyyy-MM-dd HH:mm"))) {

                            showToast("开工时间太早了哦~");
                            tvTime.setText(StringUtil.getCurrentTime("yyyy-MM-dd HH:mm"));
                            data = StringUtil.getCurrentTime("yyyy-MM-dd");
                            time = StringUtil.getCurrentTime("HH:mm");
                        } else {
                            tvTime.setText(dateFormat.format(date));
                            data = dateFormat1.format(date);
                            time = dateFormat2.format(date);
                        }
                    }
                }).setType(new boolean[]{true, true, true, true, true, false})
                        .setLabel("年", "月", "日", "时", "分", "秒")
                        .setRangDate(calendarStart, calendarEnd)
                        .build();

                pvTime.show();

                break;
            case R.id.ll_work_time:

                if (!flag) {
                    tvTime.setVisibility(View.VISIBLE);
                    llWorkTime.setClickable(false);
                    radioBtn.setChecked(true);
                    rlRb.setClickable(true);

                    tvWord.setText("要求开工时间:");
                    tvTime.setText(StringUtil.getCurrentTime("yyyy-MM-dd HH:mm"));
                    data = StringUtil.getCurrentTime("yyyy-MM-dd");
                    time = StringUtil.getCurrentTime("HH:mm");

                    flag = !flag;
                }

                break;
            case R.id.tv_commit:

                if (TextUtils.isEmpty(getText(etWorkDesc)) && TextUtils.isEmpty(mFileName)) {
                    showToast("写点或说点什么吧");
                    return;
                }

                if (status.equals("1")) {

                    if (TextUtils.isEmpty(getText(etJiage))) {
                        showToast("请不要忘记输入一口价价格!");
                        return;
                    }

                }

                if (flag) {
                    if (Integer.valueOf(StringUtil.getTimestamp(getText(tvTime), "yyyy-MM-dd HH:mm"))
                            <= Integer.valueOf(StringUtil.getTimestamp(StringUtil.getCurrentTime("yyyy-MM-dd HH:mm"), "yyyy-MM-dd HH:mm"))) {
                        showToast("开工时间太早了哦~");
                        return;
                    }
                }

                Singleton.instance.setDesc_text(getText(etWorkDesc));
                Singleton.instance.setPrice(getText(etJiage));
                Singleton.instance.setStatus(status);

                Singleton.instance.setData(data);
                Singleton.instance.setTime(time);

                String str = "";

                for (int i = 0; i < imgPaths.size(); i++) {
                    if (i == imgPaths.size()) {
                        str += imgPaths.get(i);
                    } else {
                        str += imgPaths.get(i) + ",";
                    }

                }

                Singleton.instance.setImgPath(str);

//                Singleton.instance.setLuyinPath(mFileName);

                if (StringUtil.isEmpty(mFileName)) {

                    startIntent(WorkAddressActivity.class);
                    App.addDestoryActivity(WorkDescActivity.this, "desc");

                } else {

                    uploadYuyin();

                }

                break;
        }
    }

    private void uploadYuyin() {

        RequestParams params = new RequestParams(Contants.URL_BASE + "fileUploadOrderSound");
//        RequestParams params = new RequestParams(Contants.POST_HUANJIA);
//        params.setRequestBody(body);
        params.setMultipart(true);

        params.addBodyParameter("file", new File(mFileName), "multipart/form-data");


        Callback.Cancelable cancelable = x.http().post(params, new Callback.ProgressCallback<String>() {
            @Override
            public void onSuccess(String result) {

                Log.e("result", result);
                Log.e("file", mFileName);

                ImgPostBean bean = new Gson().fromJson(result, ImgPostBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    if (bean.getDataObj().getFileName() == null) {

                        showToast("您的录音保存未成功,请重新录制");

                    } else {
                        Singleton.instance.setLuyinPath(bean.getDataObj().getFileName());
                        Singleton.instance.setLuyin(mFileName);
                        startIntent(WorkAddressActivity.class);
                        App.addDestoryActivity(WorkDescActivity.this, "desc");
                    }


                } else {
                    showToast(bean.getErrorMsg());
                }

                hideProgressDialog();

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

    }

    private void startRecord() {

        mFileName = "";

        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "ivr_record");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        mFileName = new File(dir, "ivr_" + System.currentTimeMillis() + ".mp3").getAbsolutePath();
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        try {
            mRecorder.prepare();
        } catch (IOException e) {

        }

        mRecorder.start();
//                isCall = true;
        llYuyin.setVisibility(View.GONE);
        ivDel.setVisibility(View.GONE);
        ivPlay.setVisibility(View.GONE);
        rlLuyining.setVisibility(View.VISIBLE);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 原来的敏感操作代码：发短信或者收短信

                    startRecord();

                } else {
                    showToast("您拒绝了该权限");
                }
                break;
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mPlayer != null && mPlayer.isPlaying()) {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }
}
