package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.Citys;

import org.xutils.x;

import java.util.List;

/**
 * Created by Alin on 2016/7/20.
 */
public class CitysAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Citys.DBean.RowsBean> rowsBeanList;

    public CitysAdapter(Context context, List<Citys.DBean.RowsBean> rowsBeanList) {
        this.context = context;
        this.rowsBeanList = rowsBeanList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return rowsBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return rowsBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.city_gridview_item_layout, null);
            holder.tv = (TextView) view.findViewById(R.id.tv_citys);
            holder.iv= (ImageView) view.findViewById(R.id.iv_gv_citys);
            view.setTag(holder);
        } else holder = (ViewHolder) view.getTag();
        Citys.DBean.RowsBean rowsBean = rowsBeanList.get(i);
        holder.tv.setText(rowsBean.getAreaName());
        x.image().bind(holder.iv,rowsBean.getDefaultImg());
        return view;
    }

    class ViewHolder {
        private TextView tv;
        private ImageView iv;
    }
}
