package com.example.jason_jukes.laihuo.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.mine.AddressManageActivity;
import com.example.jason_jukes.laihuo.activity.mine.BindCardActivity;
import com.example.jason_jukes.laihuo.activity.mine.FeedbackActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineFocusListActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineInvistWorkActivity;
import com.example.jason_jukes.laihuo.activity.mine.MinePartWorkActivity;
import com.example.jason_jukes.laihuo.activity.mine.MinePostWorkActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineQualificationActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineScoreActivity;
import com.example.jason_jukes.laihuo.activity.mine.MineWalletActivity;
import com.example.jason_jukes.laihuo.activity.mine.PhoneCertificationActivity;
import com.example.jason_jukes.laihuo.tool.PhotoHelper;
import com.example.jason_jukes.laihuo.view.glide.GlideCircleTransform;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TImage;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * 作者：Jason_Jukes on 2018/9/21 0021 16:36
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */


public class MineFragment extends BaseFragment implements InvokeListener, TakePhoto.TakeResultListener {

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
    private View view;

    private PhotoHelper photoHelper;
    private static final String TAG = "-----------99-------";
    private TakePhoto takePhoto;
    private InvokeParam invokeParam;
    private String pathImg = "";

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
        photoHelper = PhotoHelper.of(view, context);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.iv_avatar, R.id.rl_name, R.id.tv_shangban, R.id.rl_guanzhu, R.id.rl_qianbao, R.id.rl_fans, R.id.rl_mine_post_work, R.id.rl_mine_join_work, R.id.rl_mine_invist_work, R.id.rl_mine_money, R.id.rl_mine_score, R.id.rl_mine_code, R.id.rl_mine_card, R.id.rl_mine_phone, R.id.rl_mine_zili, R.id.rl_mine_address, R.id.rl_yijian, R.id.rl_tousu, R.id.tv_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_avatar:
                showToast("头像");

                selectFromPicture(view);

                break;
            case R.id.rl_name:
                break;
            case R.id.tv_shangban:
                break;
            case R.id.rl_guanzhu:
                startIntent(MineFocusListActivity.class);
                break;
            case R.id.rl_qianbao:

                break;
            case R.id.rl_fans:
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
                startIntent(MineWalletActivity.class);
                break;
            case R.id.rl_mine_score:
                startIntent(MineScoreActivity.class);
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
                startIntent(FeedbackActivity.class);
                break;
            case R.id.rl_tousu:
                break;
            case R.id.tv_exit:
                break;
        }
    }

    public void selectFromPicture(View v) {
        final View view = v;
        final String[] items = new String[]{"拍照", "相册"};
        new AlertDialog.Builder(context).setTitle("选择").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        // 调用系统的拍照功能
                        photoHelper.onCamera(view, getTakePhoto(), 800, 800);
                        break;
                    case 1:
                        //调用系统图库
                        photoHelper.onPicture(view, getTakePhoto(), 800, 800);
                        break;
                }
            }
        }).show();
    }

    private void showImg(final ArrayList<TImage> images) {
        pathImg = images.get(images.size() - 1).getCompressPath();
        Log.e("path111111", pathImg);
        File file = new File(pathImg);
        Log.e("file111111", file + "");
        Glide.with(context).load(file).transform(new GlideCircleTransform(context)).placeholder(R.mipmap.img_home).into(ivAvatar);

        if (file.exists()) {
//            if (IsNetWork.isNetWork(this)) {
//                showProgressDialog();
//                UpdatePhoto(file);   //上传头像
//            } else {
//                showToast("请检查网络设置");
//            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    /**
     * 获取TakePhoto实例
     *
     * @return
     */

    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(getActivity(), this));
        }
        return takePhoto;
    }

    /*调用完系统相机和相册后的结果*/
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        Log.e("data111111", resultCode + "");
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.handlePermissionsResult(getActivity(), type, invokeParam, this);
    }

    @Override
    public void takeSuccess(TResult result) {
        showImg(result.getImages());
    }

    @Override
    public void takeFail(TResult result, String msg) {
        Log.i(TAG, "takeFail:" + msg);
    }

    @Override
    public void takeCancel() {
        Log.i(TAG, getResources().getString(R.string.msg_operation_canceled));
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }


}
