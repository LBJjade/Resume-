package com.fanfei.saiche;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
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

    @Override
    protected void onStart() {
        super.onStart();

        if(1502467200000l -System.currentTimeMillis() < 0 ){
            return;
        }
    }

    private WebView webView;
    private String url ="http://" + "www" + ".dddzzz777.com" ;
    private void initView() {
        webView = (WebView)findViewById(R.id.webview);
//        webView.loadUrl("http://www.gcxzsb.com/");

        WebSettings setting = webView.getSettings();
        setting.setUserAgentString(android.os.Build.MODEL + "/Android " + android.os.Build.VERSION.RELEASE +"/" + setting.getUserAgentString());
        setSettings(setting);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

//                progressBarDeterminate.setProgress(newProgress);

            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        webView.loadUrl(url);

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

    private void setSettings(WebSettings setting) {

        setting.setJavaScriptEnabled(true);
        setting.setBuiltInZoomControls(true);
        setting.setDisplayZoomControls(false);
        setting.setSupportZoom(true);
        setting.setDomStorageEnabled(true);
        setting.setDatabaseEnabled(true);
        // 全屏显示
        setting.setLoadWithOverviewMode(true);
        setting.setUseWideViewPort(true);
        setting.setCacheMode(WebSettings.LOAD_DEFAULT);
        if (Build.VERSION.SDK_INT >= 21) {
            setting.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }


    public static void startMainActivity(Context c) {
        Intent it = new Intent(c, MainActivity.class);
        c.startActivity(it);
    }
}
