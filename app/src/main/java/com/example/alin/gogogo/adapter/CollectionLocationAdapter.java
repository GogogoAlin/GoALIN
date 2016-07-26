package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.DBGift;

import org.xutils.x;

import java.util.List;

/**
 * Created by Alin on 2016/7/22.
 */
public class CollectionLocationAdapter extends BaseAdapter {
    private List<DBGift> list;
    private Context context;

    public CollectionLocationAdapter(List<DBGift> list, Context context) {
        this.list = list;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    private LayoutInflater inflater;

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
        LocationViewHolder holder = null;
        if (view == null) {
            holder= new LocationViewHolder();
            view = inflater.inflate(R.layout.collection_location_prlv_item_layout, null);
            holder.tv_goodsName_location_collection = (TextView) view.findViewById(R.id.tv_goodsName_location_collection);
            holder.tv_shopName_location_collection = (TextView) view.findViewById(R.id.tv_shopName_location_collection);
            holder.tv_price_location_collection = (TextView) view.findViewById(R.id.tv_price_location_collection);
            holder.tv_goodAppraiseNum_location_collection = (TextView) view.findViewById(R.id.tv_goodAppraiseNum_location_collection);
            holder.iv_imgList_location_item = (ImageView) view.findViewById(R.id.iv_imgList_location_item);
            view.setTag(holder);
        }else {
            holder= (LocationViewHolder) view.getTag();
        }
        DBGift d=list.get(i);
        holder.tv_goodAppraiseNum_location_collection.setText(d.getGoodAppraiseNum());
        holder.tv_goodsName_location_collection.setText(d.getGoodsName());
        holder.tv_price_location_collection.setText(d.getPrice());
        holder.tv_shopName_location_collection.setText(d.getShopName());
        x.image().bind(holder.iv_imgList_location_item,d.getImgList());
        return view;
    }

    class LocationViewHolder {
        public ImageView iv_imgList_location_item;
        public TextView tv_goodsName_location_collection, tv_shopName_location_collection, tv_price_location_collection, tv_goodAppraiseNum_location_collection;
    }
}
