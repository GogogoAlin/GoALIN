package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.Three2;

import org.xutils.x;

import java.util.List;

/**
 * Created by hong on 2016/7/19.
 */
public class ThreeAdapter extends BaseAdapter{
    private Context context;
    private List<Three2.DBean.RowsBean> rowsBeen;
    private LayoutInflater inflater;

    public ThreeAdapter(Context context, List<Three2.DBean.RowsBean>  rowsBeen) {
        this.context = context;
        this. rowsBeen =  rowsBeen;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return  rowsBeen.size();
    }

    @Override
    public Object getItem(int i) {
        return  rowsBeen.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh=null;
        if (view==null){
            view=inflater.inflate(R.layout.three_item_layout,null);
            vh=new ViewHolder();
            vh.iv_guide= (ImageView) view.findViewById(R.id.image_guide);
            vh.tv_name= (TextView) view.findViewById(R.id.tv_name_guide);
            vh.tv_size= (TextView) view.findViewById(R.id.tv_size_guide);
            vh.tv_3d= (TextView) view.findViewById(R.id.tv_3d_guide);
            vh.tv_instance=(TextView) view.findViewById(R.id.tv_instance_guide);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }

        int size=Integer.parseInt(rowsBeen.get(i).getSize());
        int m=size/1024;
        int n=size%1024*10/1024;
        double k=m+n*0.1;
        x.image().bind(vh.iv_guide, rowsBeen.get(i).getSmallUrl());
        vh.tv_name.setText( rowsBeen.get(i).getName());

        vh.tv_size.setText("文件大小:"+ k+"MB");
        vh.tv_3d.setText( rowsBeen.get(i).getComments());
        vh.tv_instance.setText( rowsBeen.get(i).getDistance());
        return view;
    }

    class ViewHolder{
        ImageView iv_guide;
        TextView tv_name,tv_size,tv_3d,tv_instance;
    }
}
