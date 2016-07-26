package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.Hotel;

import org.xutils.x;

import java.util.List;

/**
 * Created by Alin on 2016/7/20.
 */
public class HotelAdapter extends BaseAdapter {

    private List<Hotel.DBean.RowsBean> rowsBeen;
    private Context context;
    private LayoutInflater inflater;

    public HotelAdapter(List<Hotel.DBean.RowsBean> rows, Context context) {
        this.rowsBeen = rows;
        this.context = context;
        inflater = LayoutInflater.from(context);
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
            view=inflater.inflate(R.layout.hotel_item_layout,null);
            viewHolder=new ViewHolder();
            viewHolder.logo=(ImageView)view.findViewById(R.id.iv_logo_hotel);
            viewHolder.shopName= (TextView) view.findViewById(R.id.shopName_tv_hotel);
            viewHolder.shopHours= (TextView) view.findViewById(R.id.shopHours_tv_hotel);
            viewHolder.categoryName= (TextView) view.findViewById(R.id.categoryName_tv_hotel);
            viewHolder.goodAppraiseNum= (TextView) view.findViewById(R.id.goodAppraiseNum_tv_hotel);
            viewHolder.averagePrice= (TextView) view.findViewById(R.id.averagePrice_tv_hotel);
            view.setTag(viewHolder);

        }else{

            viewHolder= (ViewHolder)view.getTag();

        }

        Hotel.DBean.RowsBean bean = rowsBeen.get(i);
        if (bean!=null){
            viewHolder.shopHours.setText("酒店星级："+bean.getRecommendReason());
            viewHolder.shopName.setText(bean.getShopName());
            viewHolder.categoryName.setText(bean.getCategoryName());
            viewHolder.goodAppraiseNum.setText(bean.getGoodAppraiseNum().toString()+"人赞");
            viewHolder.averagePrice.setText("$"+bean.getAveragePrice()+"起");
//            viewHolder.averagePrice.setText("$"+"起");

            x.image().bind(viewHolder.logo,bean.getImg1());
        }

        return view;
    }

    static class ViewHolder{
        ImageView logo;
        TextView shopName;
        TextView shopHours;
        TextView categoryName;
        TextView goodAppraiseNum;
        TextView averagePrice;
    }
}
