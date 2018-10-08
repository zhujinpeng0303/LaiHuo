package com.example.jason_jukes.laihuo.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason_jukes.laihuo.R;
import com.example.jason_jukes.laihuo.activity.home.findWorker.WorkDescActivity;
import com.example.jason_jukes.laihuo.bean.ClassifyBean;
import com.example.jason_jukes.laihuo.tool.Contants;
import com.example.jason_jukes.laihuo.tool.SPTool;
import com.example.jason_jukes.laihuo.view.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Jason_Jukes on 2018/9/26 0026 09:42
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class ClassifyExpLVAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ClassifyBean.DataArrBean> groups;
    private List<List<ClassifyBean.DataArrBean.ChildsBean>> items;
    private itemClick itemClick;

    public ClassifyExpLVAdapter(Context context, List<ClassifyBean.DataArrBean> groups, List<List<ClassifyBean.DataArrBean.ChildsBean>> items, ClassifyExpLVAdapter.itemClick itemClick) {
        this.context = context;
        this.groups = groups;
        this.items = items;
        this.itemClick = itemClick;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return groups.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {

        return items.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (null == view) {
            view = View.inflate(context, R.layout.item_explv_group_classify, null);
        }

        TextView tv = view.findViewById(R.id.tv_classify_name);
        tv.setText(groups.get(i).getCertification_classify_name());

        return view;
    }

    @Override
    public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup) {


        if (null == view) {
            view = LayoutInflater.from(context).inflate(R.layout.item_explv_child_classify, viewGroup, false);
        }

        final MyGridView gridView = view.findViewById(R.id.gridView);

        ClassifyGridViewAdapter adapter = new ClassifyGridViewAdapter(context, items.get(i));
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long l) {

                itemClick.ItemClick(i, i2);

            }
        });

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    public interface itemClick {

        void ItemClick(int pos, int p);

    }

}
