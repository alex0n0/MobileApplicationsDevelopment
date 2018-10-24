package com.INFS3634test1.navigationDrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.INFS3634test1.R;




public class TopicActivity extends NavigationDrawerBaseActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity);
        appBarTxt.setText("Module Topics");


        final String[] topicHeadingLevelOneArray = {
                "Topic 1",
                "Topic 2",
                "Topic 3",
                "Topic 4",
                "Topic 5",
        };

        String[] topicHeadingLevelTwoArray = {
                "Heading 1",
                "Heading 2",
                "Heading 3",
                "Heading 4",
                "Heading 5",
        };

        topicAdapter newTopicAdapter = new topicAdapter(this, topicHeadingLevelOneArray, topicHeadingLevelTwoArray);
        listView = (ListView) findViewById(R.id.lv_main);
        listView.setAdapter(newTopicAdapter);



        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TopicActivity.this, topicDetail.class);
                String message = topicHeadingLevelOneArray[position];
                intent.putExtra("topic", message);
                startActivity(intent);

            }
        });

    }





//        WebView view = new WebView(this);         //Creates a webview to display the local html file.
//        view.getSettings().setJavaScriptEnabled(true);   //Currently having issues where it creates a new page, not within navigation.
//        view.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }});
//        view.loadUrl("file:///android_asset/Topiccontent.html");
//        setContentView(view);
    }
