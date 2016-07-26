package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.DBPreOrder;

import java.util.IllegalFormatFlagsException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/25.
 */
public class PreOrderAdapter extends BaseAdapter {
    private List<DBPreOrder> listorder;
    private Context context;
    private LayoutInflater inflater;
    public PreOrderAdapter(List<DBPreOrder> listorder, Context context) {
        this.listorder = listorder;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listorder.size();
    }

    @Override
    public Object getItem(int i) {
        return listorder.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if (view==null){
            view= inflater.inflate(R.layout.pre_order_fragment_item,null);
            viewHolder=new ViewHolder();
            viewHolder.tv_goodname_prelocation= (TextView) view.findViewById(R.id.tv_goodname_PreOrder);
            viewHolder.tv_price_prelocation= (TextView) view.findViewById(R.id.tv_price_PreOrder);
            viewHolder.tv_count_prelocation= (TextView) view.findViewById(R.id.tv_count_PreOrder);
            viewHolder.tv_username_prelocation= (TextView) view.findViewById(R.id.tv_username_PreOrder);
            viewHolder.tv_phone_prelocation= (TextView) view.findViewById(R.id.tv_phone_PreOrder);
            viewHolder.tv_pay_prelocation= (TextView) view.findViewById(R.id.tv_pay_PreOrder);
            view.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) view.getTag();
        }
        DBPreOrder dbPreOrder=listorder.get(i);
        viewHolder.tv_goodname_prelocation.setText("名称:"+dbPreOrder.getPre_name());
        viewHolder.tv_price_prelocation.setText("价格:"+dbPreOrder.getPre_price());
        viewHolder.tv_count_prelocation.setText("数目为:"+dbPreOrder.getPre_count());
        viewHolder.tv_username_prelocation.setText("用户名:"+dbPreOrder.getPre_username());
        viewHolder.tv_phone_prelocation.setText("用户电话:"+dbPreOrder.getPre_phone());
        viewHolder.tv_pay_prelocation.setText("支付金额为:"+dbPreOrder.getPre_paymoney());

        return view;
    }
    class ViewHolder{
        TextView tv_goodname_prelocation,tv_price_prelocation,tv_count_prelocation,tv_username_prelocation,tv_phone_prelocation,tv_pay_prelocation;
    }
}
