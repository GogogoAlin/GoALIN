package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.PicsDefault;

import org.xutils.x;

import java.util.List;

/**
 * Created by Alin on 2016/7/23.
 */
public class PicsDefaultAdaptera extends BaseAdapter{
    private Context context;
    private List<PicsDefault.DBean.RowsBean> list;
    private LayoutInflater inflater;

    public PicsDefaultAdaptera(List<PicsDefault.DBean.RowsBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PicViewHolder holder = null;
        if (view ==null){
            holder = new PicViewHolder();
            view = inflater.inflate(R.layout.default_pics_item_layout,null);
            holder.iv = (ImageView) view.findViewById(R.id.iv_gv_pics_default);
            view.setTag(holder);
        }else holder= (PicViewHolder) view.getTag();

        PicsDefault.DBean.RowsBean rowsBean = list.get(i);
        x.image().bind(holder.iv,rowsBean.getSmallImgUrl());
        return view;
    }
    public class PicViewHolder{
        public ImageView iv;
    }
}
