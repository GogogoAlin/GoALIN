package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.VoiceGuide;

import org.xutils.x;

import java.util.List;

/**
 * Created by Alin on 2016/7/19.
 */
public class SenceGuideAdapter extends BaseAdapter {

    private List<VoiceGuide.DBean.RowsBean> rowsBeanList;
    private Context context;
    private LayoutInflater inflater;

    public SenceGuideAdapter(List<VoiceGuide.DBean.RowsBean> rowsBeanList, Context context) {
        this.rowsBeanList = rowsBeanList;
        this.context = context;
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
        if (view==null){
            view = inflater.inflate(R.layout.voice_guide_listview_item_layout, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) view.findViewById(R.id.iv_voice_guide);
            holder.tv_comments= (TextView) view.findViewById(R.id.tv_comments_voice_guide);
            holder.tv_distance= (TextView) view.findViewById(R.id.tv_distance);
            holder.tv_size= (TextView) view.findViewById(R.id.tv_size_voice_guide);
            view.setTag(holder);
        }
        else holder= (ViewHolder) view.getTag();
        VoiceGuide.DBean.RowsBean rowsBean = rowsBeanList.get(i);

        holder.tv_comments.setText(rowsBean.getName());
        holder.tv_size.setText(rowsBean.getSize());
        holder.tv_distance.setText(rowsBean.getDistance());
        x.image().bind(holder.imageView,rowsBean.getImg());

        return view;
    }

    class ViewHolder {
        public ImageView imageView;
        public TextView tv_comments, tv_size, tv_distance;
    }
}
