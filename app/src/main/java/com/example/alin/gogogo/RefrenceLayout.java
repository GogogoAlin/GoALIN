package com.example.alin.gogogo;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

/**
 * Created by macbookair on 16/7/18.
 */
public class RefrenceLayout extends SwipeRefreshLayout implements AbsListView.OnScrollListener {

    private onLoadingListener listener;
    private View footerview;
    private ListView listview;
    private  boolean isloading=false;

    public void setonLoadingListener(onLoadingListener listener){
        //实例话监听器
        this.listener=listener;
    }



    public interface  onLoadingListener{
        public void onLoad();
    }



    public RefrenceLayout(Context context) {
        super(context);
        footerview= LayoutInflater.from(context).inflate(R.layout.footerview,null);

    }
    public RefrenceLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        footerview= LayoutInflater.from(context).inflate(R.layout.footerview,null);
    }

    public void setLoadingState(boolean loading){
        isloading=loading;
        if(loading){
            listview.addFooterView(footerview);
        }else{

            listview.removeFooterView(footerview);
        }

    }


    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        int childCount = getChildCount();
        if(childCount>0){
            for (int i = 0; i <childCount; i++) {
                View childview=getChildAt(i);
                if(childview instanceof  ListView){
                    listview=(ListView)childview;
                    listview.setOnScrollListener(this);
                }

            }
        }



    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        if(i+i1==i2-1&&isloading==false){
            setLoadingState(true);
            listener.onLoad();
        }


    }
}
