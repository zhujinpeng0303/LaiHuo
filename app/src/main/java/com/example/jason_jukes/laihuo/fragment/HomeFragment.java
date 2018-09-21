package com.example.jason_jukes.laihuo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jason_jukes.laihuo.BaseFragment;
import com.example.jason_jukes.laihuo.R;

/**
 * 作者：Jason_Jukes on 2018/9/21 0021 16:25
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class HomeFragment extends BaseFragment {

    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {
    }
}
