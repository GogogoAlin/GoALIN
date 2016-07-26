package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.LittleFood;

import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/7/20.
 */
public class LittleFoodAdapter extends BaseAdapter {
    private List<LittleFood.DBean.RowsBean> rowsBeen;

    private Context context;
    private LayoutInflater inflater;

    public LittleFoodAdapter(List<LittleFood.DBean.RowsBean> rowsBeen, Context context) {
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
        ViewHolder vh=null;
        if (view==null){
            view=inflater.inflate(R.layout.little_item_layout,null);
            vh=new ViewHolder();
            vh.img1_iv= (ImageView) view.findViewById(R.id.image_food);
            vh.shopname_tv= (TextView) view.findViewById(R.id.name_food);
            vh.recommendReason_tv= (TextView) view.findViewById(R.id.infor_food);
            vh.averagePrice_tv= (TextView) view.findViewById(R.id.price_food);
            vh.categoryName_tv= (TextView) view.findViewById(R.id.select_food);
            vh.good_tv= (TextView) view.findViewById(R.id.support_food);
            vh.instance_tv= (TextView) view.findViewById(R.id.distance_food);
            view.setTag(vh);
        }else{
            vh= (ViewHolder) view.getTag();
        }
        x.image().bind(vh.img1_iv,rowsBeen.get(i).getImg1());
        vh.shopname_tv.setText(rowsBeen.get(i).getShopName());
        vh.recommendReason_tv.setText(rowsBeen.get(i).getRecommendReason());
        vh.averagePrice_tv.setText("¥"+rowsBeen.get(i).getAveragePrice()+"人均");
        vh.categoryName_tv.setText(rowsBeen.get(i).getCategoryName());
        vh.good_tv.setText(rowsBeen.get(i).getGoodAppraiseNum()+"人赞");
        vh.instance_tv.setText(rowsBeen.get(i).getDistance());
        return view;
    }
    class ViewHolder{
        ImageView img1_iv;
        TextView shopname_tv,recommendReason_tv,averagePrice_tv,categoryName_tv,good_tv,instance_tv;
    }
}
