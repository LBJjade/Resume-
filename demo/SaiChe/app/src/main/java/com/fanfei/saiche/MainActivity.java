package com.fanfei.saiche;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        setContentView(R.layout.activity_main);
        initView();

    }

    private WebView webView;
    private void initView() {
        webView = (WebView)findViewById(R.id.webview);
        webView.loadUrl("http://www.gcxzsb.com/");
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setAppCacheEnabled(true);
//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                webView.loadUrl("https://www.dddzzz777.com ");
////                webView.loadUrl("https://www.baidu.com/");
//                webView.loadUrl("http://www.gcxzsb.com/");
//                return false;
//            }
//
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//
//                //handler.cancel(); 默认的处理方式，WebView变成空白页
//                handler.proceed();//接受证书
//
//                //handleMessage(Message msg); 其他处理
//            }
//        });
    }


    public static void startMainActivity(Context c) {
        Intent it = new Intent(c, MainActivity.class);
        c.startActivity(it);
    }
}
