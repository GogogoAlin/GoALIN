package com.example.alin.gogogo.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.homenanjin;

import org.xutils.x;

import java.util.List;

public class Nanjinadapter extends BaseAdapter {

    private List<homenanjin.DBean.RowsBean> rowsBeen;
    private  Context context;
    private LayoutInflater inflater;

    public Nanjinadapter(List<homenanjin.DBean.RowsBean> rowsBeen, Context context) {
        this.rowsBeen = rowsBeen;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return rowsBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return rowsBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder  viewHolder=null;
        if(view==null){
            view=inflater.inflate(R.layout.home_nanjin_listviewmb,null);
            viewHolder=new ViewHolder();
            viewHolder.img1= (ImageView) view.findViewById(R.id.home_nanjin_guile);
            viewHolder.introuce= (TextView) view.findViewById(R.id.home_guile_body_tv);
            viewHolder.shopname= (TextView) view.findViewById(R.id.home_guile_title_tv);
            view.setTag(viewHolder);

        }else{

             viewHolder= (ViewHolder)view.getTag();

        }
        viewHolder.shopname.setText(rowsBeen.get(i).getShopName());
        viewHolder.introuce.setText(rowsBeen.get(i).getIntroduce());
        x.image().bind(viewHolder.img1,rowsBeen.get(i).getImg1());
        return view;
    }

    static class ViewHolder{
        ImageView img1;
        TextView introuce;
        TextView shopname;
    }
}
