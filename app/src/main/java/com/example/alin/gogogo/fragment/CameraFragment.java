package com.example.alin.gogogo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.activity.UplodePicture;
import com.example.alin.gogogo.adapter.CameraAdapter;
import com.example.alin.gogogo.myinterface.SlindingOnClickCallback;

import java.util.ArrayList;
import java.util.List;

public class CameraFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private ImageView btn;
    private SlindingOnClickCallback callback;

    private CameraAdapter adapter;
    private List<String>listOne;//存放一组照片的路径
    private ListView listview;
    private Button addImage;
    private List<String>list_image_url;
    private SwipeRefreshLayout refrenceLayout;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    adapter.notifyDataSetChanged();
                    refrenceLayout.setRefreshing(false);

                    break;
            }
        }
    };

    public void setCallback(SlindingOnClickCallback callback) {
        this.callback = callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_camera, null);
        btn= (ImageView) view.findViewById(R.id.camera_btn_back);
        listview=(ListView)view.findViewById(R.id.camera_lv);
        refrenceLayout= (SwipeRefreshLayout) view.findViewById(R.id.camera_spl);
        refrenceLayout.setOnRefreshListener(this);
         //加载头布局
        View view1=inflater.inflate(R.layout.cameraheaderview,null);
        addImage= (Button) view1.findViewById(R.id.camera_btn);

        list_image_url=new ArrayList<>();
        //设置适配器
        listview.addHeaderView(view1);
        adapter=new CameraAdapter(getActivity(),list_image_url);
        listview.setAdapter(adapter);

        //返回键
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               callback.togOnClick();
            }
        });



        //上传图片
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(getActivity(), UplodePicture.class);
                startActivityForResult(intent,100);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
           if(requestCode==100&&resultCode==500){
               listOne= (List<String>) data.getSerializableExtra("list");
               if(listOne.get(0)!=null){
                   list_image_url.add(listOne.get(0));
               }

           }

    }

    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(0);
            }

        }.start();

    }
}
