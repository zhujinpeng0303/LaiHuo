package com.example.jason_jukes.laihuo.activity.mine;

import android.app.AlertDialog;
import android.graphics.Color;
import android.hardware.Camera;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.example.jason_jukes.laihuo.BaseActivity;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.bean.AreaBean;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.IsNetWork;
import com.example.jason_jukes.laihuo.tool.LimitTextWatcher;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.tool.StringUtil;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.CommonDialog;
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

public class AddAddressActivity extends BaseActivity {

    @InjectView(R.id.tv_status_bar_name)
    TextView tvStatusBarName;
    @InjectView(R.id.et_name)
    EditText etName;
    @InjectView(R.id.et_phone)
    EditText etPhone;
    @InjectView(R.id.tv_service_place)
    TextView tvServicePlace;
    @InjectView(R.id.et_detail_address)
    EditText etDetailAddress;
    @InjectView(R.id.tv_del)
    TextView tvDel;

//    private List<AreaBean.DataArrBean> options1Items = new ArrayList<>();
    private List<AreaBean.DataArrBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<String> areas = new ArrayList<>();

    private String area_id = "",city_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.inject(this);
        initView();
        initData();
    }

    private void initView() {
        if (getIntent().getStringExtra("type").equals("add")) {
            tvStatusBarName.setText("添加地址");
            tvDel.setVisibility(View.GONE);
        } else {
            tvStatusBarName.setText("修改地址");
            tvDel.setVisibility(View.VISIBLE);
            etName.setText(getIntent().getStringExtra("name"));
            etPhone.setText(getIntent().getStringExtra("phone"));
            tvServicePlace.setTextColor(getResources().getColor(R.color.colorBlack));
            tvServicePlace.setText(getIntent().getStringExtra("place"));
            etDetailAddress.setText(getIntent().getStringExtra("address"));
            area_id = getIntent().getStringExtra("area_id");
        }

        etName.addTextChangedListener(new LimitTextWatcher(getText(etName), etName));
    }

    private void initData() {


        if (IsNetWork.isNetWork(this)) {
            showProgressDialog();
            getArea();
        } else {
            showToast("请检查网络设置");

        }

    }

    private void getArea() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("city_id", "haerbin");
        map.put("id", "0");

        XUtil.Post(Contants.AREA_LIST, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                AreaBean bean = new Gson().fromJson(result, AreaBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    for (int i = 0; i < bean.getDataArr().size(); i++) {

                        options1Items.add(bean.getDataArr().get(i));
                        areas = new ArrayList<String>();
                        for (int i1 = 0; i1 < bean.getDataArr().get(i).getChilds().size(); i1++) {

                            areas.add(bean.getDataArr().get(i).getChilds().get(i1).getArea_name());

                        }

                        options2Items.add(areas);
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


    private void showPickerView() {// 弹出选择器

        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置

                tvServicePlace.setText(options1Items.get(options1).getArea_name() + " - " +
                        options2Items.get(options1).get(options2));

//                city_id = options1Items.get(options1).getCity_id();
                area_id = options1Items.get(options1).getChilds().get(options2).getId() + "";

            }
        })

                .setDividerColor(getResources().getColor(R.color.colorGreenBottle))
                .setTextColorCenter(Color.BLACK)
                .setContentTextSize(15)
                .setCancelColor(getResources().getColor(R.color.colorGray))
                .setSubmitColor(getResources().getColor(R.color.colorGreenBottle))
                .build();

        pvOptions.setPicker(options1Items, options2Items);//二级选择器
        pvOptions.show();
    }


    @OnClick({R.id.rl_back, R.id.tv_service_place, R.id.tv_commit, R.id.tv_del})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_service_place:
                showPickerView();
                break;
            case R.id.tv_commit:

                if (TextUtils.isEmpty(getText(etName))) {
                    showToast("请输入联系人姓名");
                    return;
                }

                if (TextUtils.isEmpty(getText(etPhone))) {
                    showToast("请输入联系人手机号");
                    return;
                }

                if (!StringUtil.isMobileNo(getText(etPhone))) {
                    showToast("手机号格式不正确");
                    return;
                }

//                if (TextUtils.isEmpty(getText(tvServicePlace))) {
//                    showToast("请选择区域");
//                    return;
//                }

                if (TextUtils.isEmpty(getText(etDetailAddress))) {
                    showToast("请输入详细地址");
                    return;
                }

                if (getIntent().getStringExtra("type").equals("add")) {
                    addAddress();
                } else {
                    changeAddress();
                }

                break;
            case R.id.tv_del:

                CommonDialog commonDialog = new CommonDialog(this);
                commonDialog.commonDialog("提示", "确认删除此地址吗?", new CommonDialog.TvClick() {
                    @Override
                    public void okClick(AlertDialog dialog) {

//                        showToast("删除");
                        delAddress();

                        dialog.dismiss();


                    }

                    @Override
                    public void cancelClick(AlertDialog dialog) {

                        dialog.dismiss();

                    }
                });

                break;
        }
    }

    private void delAddress() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("id", getIntent().getStringExtra("id"));

        XUtil.Post(Contants.DEL_ADDRESS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast("删除成功");

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

    private void addAddress() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("address", getText(etDetailAddress));
        map.put("tel", getText(etPhone));
        map.put("username", getText(etName));
        map.put("area_id", area_id);
        map.put("city_id", "1");

        XUtil.Post(Contants.ADD_ADDRESS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast("添加成功");
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

    private void changeAddress() {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("address", getText(etDetailAddress));
        map.put("tel", getText(etPhone));
        map.put("username", getText(etName));
        map.put("area_id", area_id);
        map.put("city_id", "1");
        map.put("id", getIntent().getStringExtra("id"));

        XUtil.Post(Contants.CHANGE_ADDRESS, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    showToast("修改成功");
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
