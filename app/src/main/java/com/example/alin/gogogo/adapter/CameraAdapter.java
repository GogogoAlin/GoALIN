package com.example.alin.gogogo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.alin.gogogo.R;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by macbookair on 16/7/23.
 */
public class CameraAdapter extends BaseAdapter{
    private Context context;
    private List<String> url_imagview;
    private LayoutInflater inflater;
    private Bitmap bitmap;
    private Bitmap mBitmap;

    public CameraAdapter(Context context, List<String> url_imagview) {
        this.context = context;
        this.url_imagview = url_imagview;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return url_imagview.size();
    }

    @Override
    public Object getItem(int i) {

        return url_imagview.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder=null;

        if(view==null){
            view=inflater.inflate(R.layout.camera_lv_mb,null);
            holder=new ViewHolder();
            holder.imageview= (ImageView) view.findViewById(R.id.picture);
            view.setTag(holder);

        }else{

            holder = (ViewHolder) view.getTag();
        }

        int w = context.getResources().getDimensionPixelOffset(R.dimen.thumnail_default_width);
        int h = context.getResources().getDimensionPixelSize(R.dimen.thumnail_default_height);
        String str=url_imagview.get(i);
        try {
            bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(Uri.parse(str)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        mBitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);

        holder.imageview.setImageBitmap(mBitmap);
        return view;
    }


    public class ViewHolder{
        private ImageView imageview;

    }
}
