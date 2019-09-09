package com.example.zjjc.frugalfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://www.frugalfinances.weebly.com");
        myWebView.setWebViewClient(new WebViewClient()
        {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String newUrl = "https://frugalfinances.weebly.com";

                int firstCompare = url.substring(0, 7).compareTo("http://");
                if (firstCompare == 0)
                    newUrl = "https://" + url.substring(7, 33);
                else
                    newUrl = url;
                int compare = newUrl.substring(8, 33).compareTo("frugalfinances.weebly.com");
                try {
                    if (compare == 0)
                        return false;
                    else
                        return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
    }
    @Override
    public void onBackPressed ()
    {
        if (myWebView.canGoBack())
            myWebView.goBack();
        else
            super.onBackPressed();
    }
}
