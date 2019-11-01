package com.example.ks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        initView();
    }

    private void initView() {
        web = findViewById(R.id.web);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        web.loadUrl(link);
        web.setWebViewClient(new WebViewClient());
    }
}
