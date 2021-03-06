package com.example.alin.gogogo.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alin.gogogo.Cans.Cans;
import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.DBGift;
import com.example.alin.gogogo.bean.DBScinceBean;
import com.example.alin.gogogo.bean.GiftDetail;
import com.example.alin.gogogo.utils.DBLocationDBUtils;
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

@ContentView(R.layout.activity_gift_detail)
public class GiftDetailActivity extends AppCompatActivity {
    @ViewInject(R.id.input_blessing_back)
    private ImageView input_blessing_back;

    @ViewInject(R.id.iv_giftdetail)
    private ImageView iv_giftdetail;//大图片
    @ViewInject(R.id.iv_top_share)
    private ImageView iv_top_share;//大图片

    @ViewInject(R.id.tv_faguantouku_giftdetail)
    private TextView tv_faguantouku_giftdetail;//图片名

    @ViewInject(R.id.tv_price_detailgift)
    private TextView tv_price_detailgift;//价格

    @ViewInject(R.id.btn_order_giftdetail)
    private Button btn_order_giftdetail;//订购

    @ViewInject(R.id.produce_tv_good)
    private TextView produce_tv_good;//商品介绍

    @ViewInject(R.id.tv_gift_diftdetail)
    private TextView  tv_gift_diftdetail;//秦淮礼物
    @ViewInject(R.id.btn_goshop_giftdetail)
    private Button btn_goshop_giftdetail;//进入店铺

    @ViewInject(R.id.layout_notice)
    private LinearLayout layout_notice;
    @ViewInject(R.id.online_buy)
    private TextView tv_online_buy;//隐藏在线订购
    @ViewInject(R.id.layout_pics)
    private LinearLayout layout_pics;//图片
    @ViewInject(R.id.layout_recall_giftdetail)
    private LinearLayout layout_recall_giftdetail;//常见回答
    @ViewInject(R.id.iv_my_collection)
    private ImageView iv_my_collection;
    private String goodsId;
    private DbManager dbManager;
    private GiftDetail.DBean dBean;
    private List<DBScinceBean> list = new ArrayList<>();
    private DBScinceBean dbScinceBean=new DBScinceBean();

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==100){
             tv_faguantouku_giftdetail.setText(dBean.getGoodsName());
                tv_price_detailgift.setText("¥"+dBean.getPrice()+"元");
                produce_tv_good.setText(dBean.getIntroduction());
                tv_online_buy.setText(dBean.getBuyRule());
                tv_gift_diftdetail.setText(dBean.getShopName());
                x.image().bind(iv_giftdetail,dBean.getImgList().get(0));

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        Intent intent=getIntent();
        goodsId=intent.getStringExtra("shopId");
        loadData();
        setOnListener();
        btn_order_giftdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GiftDetailActivity.this,FillOrderActivity.class);
                Bundle bundle=new Bundle();
                String price= tv_price_detailgift.getText().toString().substring(1,tv_price_detailgift.getText().toString().length()-1);
                Log.d("————————price的值————",price);
                bundle.putString("goodsname",tv_faguantouku_giftdetail.getText().toString());
                bundle.putString("price",price);
                intent.putExtra("bundle",bundle);

                startActivity(intent);
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
    private void setOnListener() {
        iv_top_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShare();
            }
        });
        //点击返回
        input_blessing_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //监听显示线上订购的TextView
        layout_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( tv_online_buy.getVisibility() == View.GONE) {
                    tv_online_buy.setVisibility(View.VISIBLE);
                } else
                    tv_online_buy.setVisibility(View.GONE);
            }
        });

        //订购button
        btn_order_giftdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GiftDetailActivity.this,FillOrderActivity.class);
                startActivity(intent);
            }
        });
        //进入商店button
        btn_goshop_giftdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(GiftDetailActivity.this,StoreDetailActivity.class);
                startActivity(intent);
            }
        });
        //图片layout
        layout_pics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //常见问题layout
        layout_recall_giftdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //收藏按钮
        iv_my_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String goodsId = dBean.getGoodsId();
                String shopName = dBean.getShopName();
                String goodAppraiseNum = dBean.getGoodAppraiseNum();
                String imgList = dBean.getImgList().get(0);
                String price = dBean.getPrice();
                String goodsName = dBean.getGoodsName();
                DBGift dbGift = new DBGift(goodsId,goodsName,price,goodAppraiseNum,shopName,imgList);
                DBLocationDBUtils.getInstance().addGift(dbGift);
                Toast.makeText(GiftDetailActivity.this,"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadData() {
        Intent intent=getIntent();
        goodsId=intent.getStringExtra("shopId");
        //
        RequestParams requestparams=new RequestParams(String.format(Cans.GiftDetail, goodsId));
        x.http().get(requestparams, new Callback.CacheCallback<String>() {

            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                GiftDetail giftdetail=new Gson().fromJson(result,GiftDetail.class);
                dBean=giftdetail.getD();
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
}
