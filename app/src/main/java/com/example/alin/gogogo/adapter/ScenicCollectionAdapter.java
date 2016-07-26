package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.DBScinceBean;

import org.xutils.x;

import java.util.List;

/**
 * Created by Alin on 2016/7/21.
 */
public class ScenicCollectionAdapter extends BaseAdapter {
    private Context context;
    private List<DBScinceBean> list;
    private LayoutInflater inflater;

    public ScenicCollectionAdapter(Context context, List<DBScinceBean> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
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
        CoViewHolder holder = null;
        if (view == null) {
            holder = new CoViewHolder();
            view = inflater.inflate(R.layout.collcection_scenic_prlv_item_layout, null);
            holder.iv_collection_scenic = (ImageView) view.findViewById(R.id.iv_collection_scenic);
            holder.tv_shopHours_goodAppraiseNum_collection = (TextView) view.findViewById(R.id.tv_goodAppraiseNum_collection);
            holder.tv_shopHours_scenic_collection = (TextView) view.findViewById(R.id.tv_shopHours_scenic_collection);
            holder.tv_shopName_scenic_collection = (TextView) view.findViewById(R.id.tv_shopName_scenic_collection);
            view.setTag(holder);
        } else holder = (CoViewHolder) view.getTag();

        DBScinceBean bean = list.get(i);
        if (bean!=null){
            holder.tv_shopName_scenic_collection.setText(bean.getShopName());
            holder.tv_shopHours_scenic_collection.setText(bean.getShopHours());
            holder.tv_shopHours_goodAppraiseNum_collection.setText(bean.getGoodAppraiseNum());
            x.image().bind(holder.iv_collection_scenic,bean.getImgList());

        }
        return view;
    }

    class CoViewHolder {
        public TextView tv_shopName_scenic_collection, tv_shopHours_scenic_collection, tv_shopHours_goodAppraiseNum_collection;
        public ImageView iv_collection_scenic;
    }
}
