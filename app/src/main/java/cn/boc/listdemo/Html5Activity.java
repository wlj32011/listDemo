package cn.boc.listdemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static cn.boc.listdemo.R.id.webview;

public class Html5Activity extends Activity {

    private  WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html5);

        webView = (WebView) findViewById(webview);

        webView.getSettings().setJavaScriptEnabled(true);
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("加载中...");


        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                dialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("url","url="+url);
                view.loadUrl(url);
                return true;

//                return super.shouldOverrideUrlLoading(view, url);
            }
        });


        //加载web地址
//        webView.loadUrl("http://m.sui.taobao.org/demos/");
//
//
//
//
//         webView.loadUrl("http://www.baidu.com");


        webView.loadUrl("file:///android_asset/index.html");




//        webView.loadUrl("http://www.baidu.com");
        //加载assets目录网页
//        webView.loadUrl("file:///android_asset/index.html");

//        webView.setWebViewClient(new WebViewClient(){
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//            }
//
//            @Override
//            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//                super.onReceivedError(view, request, error);
//            }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                webView.loadUrl(url);
//
//                return true;
//            }
//        });


//        webView.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
//                return super.onJsAlert(view, url, message, result);
//            }
//
//            @Override
//            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
//                return super.onConsoleMessage(consoleMessage);
//            }
//
//            @Override
//            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
//                return super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
//            }
//
//
//        });
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setBlockNetworkLoads(true);





    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.removeAllViews();
        webView.destroy();
    }
}
