package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.NativegiftBean;

import org.xutils.x;

import java.util.List;

/**
 * Created by macbookair on 16/7/20.
 */
public class NativegiftAdapter extends BaseAdapter{


    private List<NativegiftBean.DBean.RowsBean>  rowsBeenList;
    private Context context;
    private LayoutInflater inflater;

    public NativegiftAdapter(List<NativegiftBean.DBean.RowsBean> rowsBeenList, Context context) {
        this.rowsBeenList = rowsBeenList;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return rowsBeenList.size();
    }

    @Override
    public Object getItem(int i) {
        return rowsBeenList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view==null){
            view = inflater.inflate(R.layout.city_ticket_olv, null);
            viewHolder=new ViewHolder();
            viewHolder.logo=(ImageView)view.findViewById(R.id.logo);
            viewHolder.shopName= (TextView) view.findViewById(R.id.shopName);
            viewHolder.shopHours= (TextView) view.findViewById(R.id.shopHours);
            viewHolder.categoryName= (TextView) view.findViewById(R.id.categoryName);
            viewHolder.goodAppraiseNum=(TextView) view.findViewById(R.id.goodAppraiseNum);
            viewHolder.averagePrice=(TextView) view.findViewById(R.id.averagePrice);
            view.setTag(viewHolder);
        } else{

             viewHolder= (ViewHolder) view.getTag();
        }
        NativegiftBean.DBean.RowsBean rowsBean = rowsBeenList.get(i);

        viewHolder.shopHours.setText(rowsBean.getShopName());
        viewHolder.shopName.setText(rowsBean.getGoodsName());
        viewHolder.categoryName.setText(rowsBean.getCategoryName());
        viewHolder.goodAppraiseNum.setText(rowsBean.getGoodAppraiseNum().toString()+"人赞");
        viewHolder.averagePrice.setText("$"+rowsBean.getPreferentialPrice());
        x.image().bind(viewHolder.logo,rowsBean.getImg1());

        return view;
    }

    class ViewHolder {
        ImageView logo;
        TextView shopName;
        TextView shopHours;
        TextView categoryName;
        TextView goodAppraiseNum;
        TextView averagePrice;


    }
}
