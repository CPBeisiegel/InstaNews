package com.example.instanews.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.example.instanews.R;
import com.example.instanews.model.pojos.Article;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import static com.example.instanews.views.fragment.PrincipaisNoticFragment.ARTICLE_KEY;

public class WebViewAcitivity extends AppCompatActivity {

    private WebView myWebView;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view_activity);
        myWebView = findViewById(R.id.webview);
        floatingActionButton = findViewById(R.id.floatingActionButtonnSigno);

        floatingActionButton.setOnClickListener(view -> {
            onBackPressed();
        });

            Article article = getIntent().getExtras().getParcelable(ARTICLE_KEY);
            myWebView.loadUrl(article.getUrl());

    }

}
