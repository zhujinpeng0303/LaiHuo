package com.example.jason_jukes.laihuo.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.ViewPagerActivity;
import com.example.jason_jukes.laihuo.bean.MessageBean;
import com.example.jason_jukes.laihuo.bean.MineQuaBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.XUtil;
import com.example.jason_jukes.laihuo.view.CommonDialog;
import com.example.jason_jukes.laihuo.view.MyGridView;
import com.google.gson.Gson;

import org.xutils.common.Callback;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 14:11
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MineQualificationLVAdapter extends BaseAdapter {

    private Context context;
    private List<MineQuaBean.DataArrBean> been;
    private String type;

    public MineQualificationLVAdapter(Context context, List<MineQuaBean.DataArrBean> been, String type) {
        this.context = context;
        this.been = been;
        this.type = type;
    }

    public void remove(int pos) {
        been.remove(pos);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return been != null && been.size() > 0 ? been.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return been == null ? null : been.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        MineQualificationLVAdapter.MyViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_lv_mine_qualification, viewGroup, false);
            viewHolder = new MineQualificationLVAdapter.MyViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (MineQualificationLVAdapter.MyViewHolder) view.getTag();
        }

//        viewHolder.nineGridlayout.setImagesData(been);

//        viewHolder.nineGridlayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                context.startActivity(new Intent(context, ViewPagerActivity.class)
//                        .putExtra("list", (Serializable) been));
//            }
//
//        });

        viewHolder.content.setText(been.get(i).getCert_title());

        final List<String> imgs = new ArrayList<>();
        String str = been.get(i).getCert_imgs();
        String[] arr = str.split(",");//分割字符串得到数组
        List<String> list = java.util.Arrays.asList(arr);//字符数组转list

        for (int i1 = 0; i1 < list.size(); i1++) {
            imgs.add(Contants.URL_IMG_BASE + list.get(i1));
        }

        if (!TextUtils.isEmpty(been.get(i).getCert_imgs())) {
            viewHolder.gridView.setVisibility(View.VISIBLE);
            GridAdapter adapter = new GridAdapter(context, imgs);
            viewHolder.gridView.setAdapter(adapter);

            viewHolder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    context.startActivity(new Intent(context, ViewPagerActivity.class)
                            .putExtra("list", (Serializable) imgs)
                            .putExtra("pos", i));

                }
            });
        } else {
            viewHolder.gridView.setVisibility(View.GONE);
        }
        if (type.equals("yes")) {
            viewHolder.del.setVisibility(View.VISIBLE);
        } else {
            viewHolder.del.setVisibility(View.GONE);
        }

        viewHolder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonDialog commonDialog = new CommonDialog(context);
                commonDialog.commonDialog("提示！", "确认删除此资历吗?", new CommonDialog.TvClick() {
                    @Override
                    public void okClick(AlertDialog dialog) {

                        del(i, dialog);

                    }

                    @Override
                    public void cancelClick(AlertDialog dialog) {
                        dialog.dismiss();
                    }
                });
            }
        });

        return view;
    }

    private void del(final int pos, final Dialog dialog) {

        Map<String, Object> map = new HashMap<>();
        map.put("token", "gggg");
        map.put("custom_cert_id", been.get(pos).getId() + "");

        XUtil.Post(Contants.DEL_QUALIFICATION, map, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

                MessageBean bean = new Gson().fromJson(result, MessageBean.class);
                if (bean.getErrorCode().equals(Contants.HTTP_OK)) {

                    remove(pos);
                    dialog.dismiss();

                } else {
                    dialog.dismiss();
                    Toast.makeText(context, bean.getErrorMsg(), Toast.LENGTH_SHORT).show();

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
        });

    }

    class MyViewHolder {


        TextView content, del;
        //        NineGridlayout nineGridlayout;
        MyGridView gridView;

        public MyViewHolder(View view) {
            del = (TextView) view.findViewById(R.id.tv_del);
            content = (TextView) view.findViewById(R.id.tv_content);
//            nineGridlayout = (NineGridlayout) view.findViewById(R.id.iv_img_list);
            gridView = view.findViewById(R.id.gridView);
        }
    }

}
