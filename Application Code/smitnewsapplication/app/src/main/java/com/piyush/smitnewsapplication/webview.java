package com.piyush.smitnewsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class webview extends AppCompatActivity {

    private WebView webView;

    private String URL = "https://www.google.com/search?q=sikkim+manipal+institute+of+technology&rlz=1C1CHBD_enIN879IN879&sxsrf=ACYBGNR2LZc4duIH4aibVRMW5RATRA7OxQ:1581230019880&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjG_JHt7MPnAhV7yTgGHbePA0QQ_AUoAXoECCMQAw&biw=1536&bih=674&dpr=1.25";

    private String LocalURL = "file:///android_asset/a2.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_webview);

        webView = findViewById(R.id.webview);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), description, Toast.LENGTH_SHORT).show();
            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(view, rerr.getErrorCode(), rerr.getDescription().toString(), req.getUrl().toString());
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(URL);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}