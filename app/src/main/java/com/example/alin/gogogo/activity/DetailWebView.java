package com.example.alin.gogogo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.alin.gogogo.R;

public class DetailWebView extends Activity {
    private WebView webView;
    String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_web_view);
        webView = (WebView)findViewById(R.id.webView);

        content= getIntent().getStringExtra("detail");
		webView.loadData(content, "text/html;charset=utf-8", "");



        //设置之间在本app中打开，不跳转到手机浏览器中显示
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadData(content,"text/html;charset=utf-8","");
                return true;
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            //返回上一页，而不是之间关闭Activity
            webView.goBack();
        }
        return super.onKeyDown(keyCode, event);
    }

}
