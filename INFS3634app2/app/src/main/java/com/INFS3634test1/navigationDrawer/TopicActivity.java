package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.INFS3634test1.R;




public class TopicActivity extends NavigationDrawerBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity);
        appBarTxt.setText("Module Topics");


        WebView view = new WebView(this);                //Creates a webview to display the local html file.
        view.getSettings().setJavaScriptEnabled(true);   //Currently having issues where it creates a new page, not within navigation.
        view.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }});
        view.loadUrl("file:///android_asset/Topiccontent.html");
        setContentView(view);

    }

}
