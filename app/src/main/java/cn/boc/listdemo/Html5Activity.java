package cn.boc.listdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static cn.boc.listdemo.R.id.webview;

public class Html5Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html5);

        final WebView webView = (WebView) findViewById(webview);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                webView.loadUrl(url);

                return true;
            }
        });
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        //加载web地址
//        webView.loadUrl("http://m.sui.taobao.org/demos/");
//        webView.loadUrl("http://www.baidu.com");
        //加载assets目录网页
        webView.loadUrl("file:///android_asset/index.html");


    }
}
