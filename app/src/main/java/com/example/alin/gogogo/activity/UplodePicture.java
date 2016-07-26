package com.example.alin.gogogo.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.example.alin.gogogo.HorizontalListView;
import com.example.alin.gogogo.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UplodePicture extends AppCompatActivity implements View.OnClickListener {
    HorizontalListView hListView;
    HorizontalListViewAdapter hListViewAdapter;
    private Button add;
    private PopupWindow mPopWindow;
    private Intent intent=new Intent();
    private List<String>list;
    private Button commit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uplode_picture);
        add=(Button)findViewById(R.id.upload);//从相机照相还是自己选择照片
        list=new ArrayList<>();
        commit=(Button)findViewById(R.id.commit);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpopupwindow();
            }
        });

        initUI();
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("list",(Serializable)list);
                setResult(500,intent);
                finish();
            }
        });


    }

    private void showpopupwindow() {
        View contentView = LayoutInflater.from(UplodePicture.this).inflate(R.layout.camera_popupwindow, null);

        mPopWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopWindow.setContentView(contentView);

        Button button1= (Button) contentView.findViewById(R.id.button1);
        Button button2= (Button) contentView.findViewById(R.id.button2);
        Button button3= (Button) contentView.findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        //popupwindow的显示位置
        View rootview = LayoutInflater.from(UplodePicture.this).inflate(R.layout.activity_uplode_picture, null);
        mPopWindow.showAtLocation(rootview, Gravity.BOTTOM, 0, 0);


    }


    public void initUI() {
        hListView = (HorizontalListView) findViewById(R.id.hlistview);
        hListViewAdapter = new HorizontalListViewAdapter(getApplicationContext(),list);//是数组
        hListView.setAdapter(hListViewAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 相册
        if (requestCode == 500) {
            Uri uri = data.getData();
            list.add(uri.toString());
            hListViewAdapter.notifyDataSetChanged();
        }
        if(requestCode==300){
            hListViewAdapter.notifyDataSetChanged();
        }

    }

    public Bitmap rotateBitmap(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(90);
        Bitmap map = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return map;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button1:
                 String mFilePath =
                 Environment.getExternalStorageDirectory().getAbsolutePath()+
                 "/picture.png";
                 intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                 Uri uri = Uri.fromFile(new File(mFilePath));
                 //指定路径
                 list.add(uri.toString());
                 intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                 startActivityForResult(intent, 300);
                 mPopWindow.dismiss();
                 break;
            case R.id.button2:
                //从照片中选择一张上传
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 500);
                mPopWindow.dismiss();
                break;
            case R.id.button3:
                mPopWindow.dismiss();
                break;
        }

    }

    private class HorizontalListViewAdapter extends BaseAdapter {
        private Context mContext;
        private LayoutInflater mInflater;
        private List<String>list;
        private Bitmap mBitmap;

        public HorizontalListViewAdapter(Context mContext, List<String> list) {
            this.mContext = mContext;
            this.list = list;
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);//LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.horizontal_list_item, null);
                holder.mImage = (ImageView) convertView.findViewById(R.id.img_list_item);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            String str=list.get(position);
            Bitmap bitmap = null;
            try {
                int w = mContext.getResources().getDimensionPixelOffset(R.dimen.thumnail_default_width);
                int h = mContext.getResources().getDimensionPixelSize(R.dimen.thumnail_default_height);
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(Uri.parse(str)));
                mBitmap = Bitmap.createScaledBitmap(bitmap,w,h,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            holder.mImage.setImageBitmap(mBitmap);
            return convertView;
        }
        private class ViewHolder {
            private ImageView mImage;
        }
    }
}