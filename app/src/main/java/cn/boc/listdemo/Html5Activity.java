package cn.boc.listdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Html5Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html5);

        WebView webView = (WebView) findViewById(R.id.webview);
        //加载web地址
        webView.loadUrl("http://m.sui.taobao.org/demos/");
//        webView.loadUrl("http://www.baidu.com");
        //加载assets目录网页
//        webView.loadUrl("file:///android_asset/index.html");
    }
}
