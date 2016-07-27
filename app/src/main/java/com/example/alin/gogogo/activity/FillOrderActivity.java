package com.example.alin.gogogo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alin.gogogo.R;
import com.example.alin.gogogo.bean.DBPreOrder;
import com.example.alin.gogogo.utils.PreOrderDBUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_fill_order)
public class FillOrderActivity extends AppCompatActivity {

    //返回上页
   @ViewInject(R.id.iv_fillorder_back)
    private ImageView iv_fillorder_back;
    //商品名称
    @ViewInject(R.id.tv_goodsname)
    private TextView tv_goodsname;
    //商品价格
    @ViewInject(R.id.tv_price)
    private TextView tv_price;
    //减少门票
    @ViewInject(R.id.iv_reduce)
    private ImageView iv_reduce;
    //添加门票
    @ViewInject(R.id.iv_add)
    private ImageView iv_add;
    //门票数量
    @ViewInject(R.id.et_num)
    private EditText et_num;
    //用户名
    @ViewInject(R.id.et_name_order)
    private EditText et_name_order;
    //手机号
    @ViewInject(R.id.et_phone_order)
    private EditText et_phone_order;
    //支付总金
    @ViewInject(R.id.tv_pay)
    private TextView tv_pay;
    //应付金额
    @ViewInject(R.id.tv_allPrice)
    private TextView tv_allPrice;
    //提交订单
    @ViewInject(R.id.btn_tijiao_order)
    private Button btn_tijiao_order;
    //统计门票数

    private static int count=0;
    private  double price2=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
         //修改订单数
        setListener();
        btn_tijiao_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String goodsId = dBean.getGoodsId();
                String pre_goodname=tv_goodsname.getText().toString();
                String pre_price=tv_price.getText().toString();
                String pre_count=count+"";
                String pre_username=et_name_order.getText().toString();
                String pre_phone=et_phone_order.getText().toString();
                String pre_pay=tv_pay.getText().toString();

                DBPreOrder dbPreOrder=new DBPreOrder(pre_goodname,pre_price,pre_count,pre_username,pre_phone,pre_pay);
                PreOrderDBUtils.getInstance().addPreGift(dbPreOrder);
                Toast.makeText(FillOrderActivity.this,"提交订单成功",Toast.LENGTH_SHORT).show();

            }
        });

    }
    private void setListener() {
        Bundle bundle=getIntent().getBundleExtra("bundle");
        String goodsname=bundle.getString("goodsname");
        //获取价格
        String price=bundle.getString("price");
        price2=Double.parseDouble(price);
        tv_goodsname.setText(goodsname);
        tv_price.setText("单价为:¥"+price);

        et_num.setText("1");//数量为1
        count=Integer.parseInt(et_num.getText().toString());
        double price1 = Double.parseDouble(price);
        tv_allPrice.setText(price+"元");
        tv_pay.setText(price+"元");
        iv_fillorder_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                Log.d("-- iv_add--",count+"");
                et_num.setText(Integer.toString(count));
                count=Integer.parseInt(et_num.getText().toString());
                double price1=price2;
                tv_allPrice.setText(count*price1+"元");
                tv_pay.setText(count*price1+"元");
            }
        });

        iv_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count>1){
                    count--;
                    Log.d("-- iv_reduce--",count+"");
                    et_num.setText(Integer.toString(count));
                    count=Integer.parseInt(et_num.getText().toString());
                }else{
                    Toast.makeText(FillOrderActivity.this,"订购数量至少是一",Toast.LENGTH_SHORT).show();
                }
                double price1=price2;
                tv_allPrice.setText(count*price1+"元");
                tv_pay.setText(count*price1+"元");
            }

        });

    }
}
