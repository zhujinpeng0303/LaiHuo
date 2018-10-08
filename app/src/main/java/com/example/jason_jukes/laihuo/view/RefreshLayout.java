package com.example.jason_jukes.laihuo.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.jason_jukes.laihuo.R;

import static com.baidu.mapsdkvi.VMsg.init;

/**
 * 作者：Jason_Jukes on 2018/10/8 0008 16:29
 * <p>
 * When I wrote this, only God and I understood what I was doing
 * Now, only God knows
 */

public class RefreshLayout extends SwipeRefreshLayout implements AbsListView.OnScrollListener {

    /**
     * 滑动到最下面时的上拉操作
     */

    private int mTouchSlop;
    /**
     * listview实例
     */
    private ListView mListView;

    /**
     * ListView的加载中footer
     */
    private View mListViewFooter;

    private ListView lv;
    int footerLayoutId;
    private boolean isLoading;
    private float downY;
    private float upY;
    private View footer;
    private boolean isRefreshFoot;

    public RefreshLayout(Context context) {
        super(context);
        init();
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childs = getChildCount();
        if (childs > 0) {
            if (getChildAt(1) instanceof ListView) {
                if (lv == null) { // 要判断为空时才进行下面的操作 因为每次当下拉刷新的时候 omeasure 是会多次调用的 所以避免重复调用
                    lv = (ListView) getChildAt(1);// 这里我们是用的1 因为0 是那个下拉刷新的源圈
                    lv.setAdapter(ba);
                    lv.setOnScrollListener(this);
                    lv.setOnItemClickListener(oic);
                    footer = View.inflate(getContext(), footerLayoutId, null);
                }
            }
        }

    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
//        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MySwipeRefreshLayout);// 我这里用了自定义属性来添加footer 的布局
//        footerLayoutId = ta.getResourceId(R.styleable.MySwipeRefreshLayout_footerLayoutId, 0); // 得到footer布局id 加载出view
//        if (footerLayoutId == 0) {
//            Log.e("MySwipeRefreshLayout", "没有在xml配置footer的布局id属性");
//        }
        init();

        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();

        mListViewFooter = LayoutInflater.from(context).inflate(R.layout.footer_refresh_listview, null, false);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downY = ev.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                upY = ev.getRawY();
                canLoadMore();// 抬起是判断是否可以显示上拉加载
        }
        return super.dispatchTouchEvent(ev);
    }

    AdapterView.OnItemClickListener oic;

    public void setListItemClickListener(AdapterView.OnItemClickListener oic) {
        this.oic = oic; // 我这里并没有直接用 lv.setonitemclicklistener(oic)  因为这时候 lv 还没有被赋值 这时候调用时会报空指针的。
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                         int totalItemCount) {
        canLoadMore();
    }

    private void canLoadMore() {
        if (lv.getLastVisiblePosition() == lv.getAdapter().getCount() - 1 &&
                !isLoading && isPullUp()) {
            View lastVisibleItemView = lv.getChildAt(lv.getChildCount() - 1);
            if (lastVisibleItemView != null && lastVisibleItemView.getBottom() == lv.getHeight()) {
                Load();
            }
        }
    }

    private boolean isPullUp() {
        if (upY < downY) {
            return true;
        }
        return false;
    }

    private void Load() {
        isLoading = true;
        lv.addFooterView(footer);
        if (mOnLoadListener != null) {
            mOnLoadListener.onLoad();
        }
    }

    public void setFooter(boolean hasRefreshFoot) {
        if (!hasRefreshFoot) {
            lv.removeFooterView(footer);
            isLoading = false;
        }
    }

//    public void setHeaderListener(OnRefreshListener ol) {
//        setColorSchemeResources(R.color.orange, R.color.green, R.color.holo_red_light); // 进度动画颜色
//        setProgressBackgroundColorSchemeResource(R.color.light_gray); // 进度背景颜色
//        setOnRefreshListener(ol);
//    }

    BaseAdapter ba;

    public void setAdapter(BaseAdapter ba) {
        this.ba = ba;
    }

    /**
     * 刷新结束 取消下拉刷新
     */
    public void setHeader(boolean isHeader) {
        setRefreshing(isHeader);
    }

    /**
     * 加载更多的监听器
     */
    public interface OnLoadMoreListener {
        void onLoad();
    }

    OnLoadMoreListener mOnLoadListener;

    public void setOnLoadListener(OnLoadMoreListener loadListener) {
        mOnLoadListener = loadListener;
    }


}

