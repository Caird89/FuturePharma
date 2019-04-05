package com.TriviaForTechnicians.a5in5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class CaseStudyActivity extends AppCompatActivity {
   ProgressBar CaseprograssBar;
   ImageView CaseImageView;
   WebView CaseWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_study);
        CaseprograssBar=findViewById(R.id.CaseProgressBar);
        CaseImageView=findViewById(R.id.CaseImageView);
        CaseWebView=findViewById(R.id.CaseWebView);

        CaseprograssBar.setMax(100);
        Intent intent = getIntent();
        CaseWebView.loadUrl(intent.getStringExtra("case"));
        CaseWebView.getSettings().setJavaScriptEnabled(true);
        CaseWebView.setWebViewClient(new WebViewClient());
        CaseWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                CaseprograssBar.setProgress(newProgress);
            }



            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
                CaseImageView.setImageBitmap(icon);
            }
        });


    }
    @Override
    public void onBackPressed() {

        if(CaseWebView.canGoBack()){
            CaseWebView.goBack();
        }else{
            super.onBackPressed();
        }
    }

}
