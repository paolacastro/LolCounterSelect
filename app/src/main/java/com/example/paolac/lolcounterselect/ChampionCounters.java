package com.example.paolac.lolcounterselect;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;


public class ChampionCounters extends FragmentActivity {

    public static void start(ChampionSelectActivity context) {
        Intent intent;
        intent = new Intent(context, ChampionCounters.class);
        context.startActivity(intent);
    }
    static final int NUM_ITEMS = 10;

    CountersPagerAdapter mAdapter;

    ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion_counters);

        mAdapter = new CountersPagerAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        // Watch for button clicks.
        Button button = (Button)findViewById(R.id.goto_first);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(0);
            }
        });
        button = (Button)findViewById(R.id.goto_last);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mPager.setCurrentItem(NUM_ITEMS-1);
            }
        });


    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_champion_counters);
//
//        WebView webview = (WebView) findViewById(R.id.webview);
//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.getSettings().setLoadWithOverviewMode(true);
//        webview.getSettings().setUseWideViewPort(true);
//        webview.getSettings().setBuiltInZoomControls(true);
//        webview.getSettings().setSupportZoom(true);
//        webview.setWebViewClient(new WebViewClient() {
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//
//                return true;
//            }
//
//            @Override
//            public void onPageFinished(WebView view, final String url) {
//                onWebviewLoaded();
//            }
//        });
//        webview.loadUrl("http://www.google.com");
//
//    }

    public void onWebviewLoaded() {
        Toast.makeText(this, "webview loaded!", Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.champion_counters, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
