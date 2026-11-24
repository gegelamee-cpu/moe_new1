package com.moesam.app;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Loads the offline MOE_SAM app (assets/index.html) in a WebView.
 * External links are blocked. The back key asks "هل تريد مغادرة التطبيق؟" (نعم / لا).
 */
public class MainActivity extends AppCompatActivity {
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);

        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setLoadWithOverviewMode(true);
        s.setUseWideViewPort(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri u = request.getUrl();
                return !"file".equals(u.getScheme());   // only the bundled page is allowed
            }
        });

        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("هل تريد مغادرة التطبيق؟")
                .setPositiveButton("نعم", (d, w) -> finish())
                .setNegativeButton("لا", (d, w) -> webView.evaluateJavascript("exitNo();", null))
                .setCancelable(true)
                .show();
    }
}
