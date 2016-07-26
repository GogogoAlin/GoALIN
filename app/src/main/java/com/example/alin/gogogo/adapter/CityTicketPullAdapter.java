package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.CityScencicSpot;

import org.xutils.x;

import java.util.List;

/**
 * Created by macbookair on 16/7/19.
 */
public class CityTicketPullAdapter  extends BaseAdapter{
    private List<CityScencicSpot.DBean.RowsBean> rowsBeen;
    private Context context;
    private LayoutInflater inflater;

    public CityTicketPullAdapter(List<CityScencicSpot.DBean.RowsBean> rowsBeen, Context context) {
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
            view=inflater.inflate(R.layout.city_ticket_olv,null);
            viewHolder=new ViewHolder();
            viewHolder.logo=(ImageView)view.findViewById(R.id.logo);
            viewHolder.shopName= (TextView) view.findViewById(R.id.shopName);
            viewHolder.shopHours= (TextView) view.findViewById(R.id.shopHours);
            viewHolder.categoryName= (TextView) view.findViewById(R.id.categoryName);
            viewHolder.goodAppraiseNum= (TextView) view.findViewById(R.id.goodAppraiseNum);
            viewHolder.averagePrice= (TextView) view.findViewById(R.id.averagePrice);
            view.setTag(viewHolder);

        }else{

            viewHolder= (ViewHolder)view.getTag();

        }
        viewHolder.shopHours.setText("开放时间："+rowsBeen.get(i).getShopHours());
        viewHolder.shopName.setText(rowsBeen.get(i).getShopName());
        viewHolder.categoryName.setText(rowsBeen.get(i).getCategoryName());
        viewHolder.goodAppraiseNum.setText(rowsBeen.get(i).getGoodAppraiseNum().toString()+"人赞");

        viewHolder.averagePrice.setText("$"+rowsBeen.get(i).getAveragePrice()+"起");

        x.image().bind(viewHolder.logo,rowsBeen.get(i).getLogo());
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
