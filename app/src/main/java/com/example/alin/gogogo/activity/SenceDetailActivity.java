package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.DBScinceBean;
import com.example.alin.gogogo.bean.Detail;
import com.example.alin.gogogo.bean.SenceDetail;
import com.example.alin.gogogo.myinterface.OnCollectionListener;
import com.example.alin.gogogo.utils.ScenicDBUtil;
import com.google.gson.Gson;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

@ContentView(R.layout.activity_sence_detail)
public class SenceDetailActivity extends AppCompatActivity {

    @ViewInject(R.id.iv_senceDetail_fragment)
    private ImageView iv_senceDetail_fragment;
    @ViewInject(R.id.tv_title_senceDetail_framlayout)
    private TextView tv_title_senceDetail_framlayout;
    @ViewInject(R.id.tv_shushidu_senceDetail_fragment)
    private TextView tv_shushidu_senceDetail_fragment;
    @ViewInject(R.id.btn_detail_senceDetail_fragment)
    private Button btn_detail_senceDetail_fragment;
    @ViewInject(R.id.btn_pics_senceDetail_fragment)
    private Button btn_pics_senceDetail_fragment;
    @ViewInject(R.id.btn_surrend_senceDetail_fragment)
    private Button btn_surrend_senceDetail_fragment;
    @ViewInject(R.id.btn_translation_senceDetail_fragment)
    private Button btn_translation_senceDetail_fragment;
    @ViewInject(R.id.tv_details)
    private TextView tv_details;
    @ViewInject(R.id.tv_address_senceDetail_fragment)
    private TextView tv_address_senceDetail_fragment;
    @ViewInject(R.id.tv_time_senceDetail_fragment)
    private TextView tv_time_senceDetail_fragment;
    @ViewInject(R.id.tv_notice_senceDetail_fragment)
    private TextView tv_notice_senceDetail_fragment;
    @ViewInject(R.id.layout_notice)
    private LinearLayout layout_notice;
    @ViewInject(R.id.input_blessing_left)
    private ImageView input_blessing_left;
    @ViewInject(R.id.iv_top_share)
    private ImageView iv_top_share;
    @ViewInject(R.id.iv_my_collection)
    private ImageView iv_my_collection;
    private String shopId;
    private OnCollectionListener callback;
    private SenceDetail.DBean d = new SenceDetail.DBean();
    private DbManager dbManager;
    private ScenicDBUtil scenicDBUtil;
    private List<DBScinceBean> list = new ArrayList<>();
    private DBScinceBean dbScinceBean = new DBScinceBean();
    private String url = "http://m.51zouyizou.com/zouyizou_app/actionDispatcher.do?reqUrl=viewspotContent&reqMethod=queryDesc&shopId=";
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 100) {
                tv_title_senceDetail_framlayout.setText(d.getShopName());
                tv_details.setText(d.getIntroduce());
                tv_address_senceDetail_fragment.setText(d.getAddress());
                tv_time_senceDetail_fragment.setText(d.getShopHours());
                tv_notice_senceDetail_fragment.setText(d.getBuyRule());
                x.image().bind(iv_senceDetail_fragment, d.getImgList().get(0));
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        Intent intent = getIntent();
        shopId = intent.getStringExtra("shopId");
        loadData();
        setOnListener();
        btn_surrend_senceDetail_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SenceDetailActivity.this, AroundInfo.class);
                intent.putExtra("longitude", d.getLongitude());
                intent.putExtra("latitude", d.getLatitude());
                startActivity(intent);


            }
        });
        //详情页
        btn_detail_senceDetail_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RequestParams params = new RequestParams(url + d.getShopId());
                x.http().get(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {


                        Intent intent = new Intent(SenceDetailActivity.this, DetailWebView.class);
                        Detail detail = new Gson().fromJson(result, Detail.class);
                        String detailD = detail.getD();
                        intent.putExtra("detail", detailD);
                        startActivity(intent);

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });

                //intent .putExtra("data",);
            }
        });
    }


    //各种监听事件的设置
    private void setOnListener() {
        //返回图标的监听事件
        input_blessing_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SenceDetailActivity.this.finish();
            }
        });
        //相关须知点击出现的监听事件
        layout_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_notice_senceDetail_fragment.getVisibility() == View.GONE) {
                    tv_notice_senceDetail_fragment.setVisibility(View.VISIBLE);
                } else
                    tv_notice_senceDetail_fragment.setVisibility(View.GONE);
            }
        });
        iv_top_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //设置分享按钮的点击事件
                showShare();
            }
        });
        //设置收藏按钮的监听事件
        iv_my_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbScinceBean.setShopId(d.getShopId());
                dbScinceBean.setShopName(d.getShopName());
                dbScinceBean.setGoodAppraiseNum(d.getGoodAppraiseNum());
                dbScinceBean.setShopHours(d.getShopHours());
                dbScinceBean.setImgList(d.getImgList().get(0));
                ScenicDBUtil.getInstance().addScenicBean(dbScinceBean);
                Toast.makeText(SenceDetailActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
            }
        });
        //交通按钮的跳转监听事件
        btn_translation_senceDetail_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SenceDetailActivity.this, TranslationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("DBean", d);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });

        //美图按钮的跳转监听事件
        btn_pics_senceDetail_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SenceDetailActivity.this, PictureShowActivity.class);
                intent.putExtra("shopId", d.getShopId());
                startActivity(intent);
            }
        });
    }

    private void loadData() {
        Intent intent = getIntent();
        String shopId = intent.getStringExtra("shopId");

        RequestParams requestParams = new RequestParams(String.format(Cans.SENCE_DETAIL, shopId));
        x.http().get(requestParams, new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                SenceDetail senceDetail = new Gson().fromJson(result, SenceDetail.class);
                d = senceDetail.getD();

                handler.sendEmptyMessage(100);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("分享");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是走一走旅游");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
    }

}
