package com.example.jason_jukes.laihuo.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.adapter.WorkDescGridAdapter;
import com.example.jason_jukes.laihuo.bean.ImgPostBean;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.XUtil;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/7 0007.
 */

public class FinishWorkActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.gridView)
    MyGridView gridView;

    private WorkDescGridAdapter adapter;
    private List<String> imgs = new ArrayList<>();

    private WorkDescGridAdapter.delClick delClick;
    private List<String> imgPaths = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_work);
        ButterKnife.inject(this);
        initVIew();
    }

    private void initVIew() {

        tvStatusBarName.setText("确认工作已完成");

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
                        PictureSelector.create(FinishWorkActivity.this)
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

        RequestParams params = new RequestParams(Contants.URL_BASE + "fileUploadWorkerCommitPhoto");
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


    @OnClick({R.id.rl_back, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_sure:
                finishWork();
                break;
        }
    }

    private void finishWork() {

        String str = "";

        for (int i = 0; i < imgPaths.size(); i++) {
            if (i == imgPaths.size()) {
                str += imgPaths.get(i);
            } else {
                str += imgPaths.get(i) + ",";
            }

        }

        Map<String, Object> map = new HashMap<>();
        map.put("order_id", getIntent().getStringExtra("id"));
        map.put("work_commit_imgs", str);

        XUtil.Post(Contants.FINISH_WORK, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast(bean.getErrorMsg());
                    finish();
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
}
