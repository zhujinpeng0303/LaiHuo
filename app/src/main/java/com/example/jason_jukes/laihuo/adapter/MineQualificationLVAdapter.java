package com.example.jason_jukes.laihuo.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jason_jukes.laihuo.App;
import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.ViewPagerActivity;
import com.example.jason_jukes.laihuo.activity.home.MessageDetailActivity;
import com.example.jason_jukes.laihuo.view.CommonDialog;
import com.example.jason_jukes.laihuo.view.nineImage.NineGridlayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/25 0025 14:11
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class MineQualificationLVAdapter extends BaseAdapter {

    private Context context;
    private List<String> been;

    public MineQualificationLVAdapter(Context context, List<String> been) {
        this.context = context;
        this.been = been;
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

        viewHolder.nineGridlayout.setImagesData(been);

        viewHolder.nineGridlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, ViewPagerActivity.class)
                        .putExtra("list", (Serializable) been));
            }

        });

        viewHolder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonDialog commonDialog = new CommonDialog(context);
                commonDialog.commonDialog("提示！", "确认删除此资历吗?", new CommonDialog.TvClick() {
                    @Override
                    public void okClick(AlertDialog dialog) {
                        remove(i);
                        dialog.dismiss();
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

    class MyViewHolder {


        TextView content, del;
        NineGridlayout nineGridlayout;

        public MyViewHolder(View view) {
            del = (TextView) view.findViewById(R.id.tv_del);
            content = (TextView) view.findViewById(R.id.tv_content);
            nineGridlayout = (NineGridlayout) view.findViewById(R.id.iv_img_list);

        }
    }

}
