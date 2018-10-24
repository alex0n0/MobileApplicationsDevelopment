package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.INFS3634test1.R;

public class topicDetail extends AppCompatActivity {

    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity_detailactivity);

        String savedExtra = getIntent().getStringExtra("topic");
        String savedExtra2 = getIntent().getStringExtra("content");

        textView = findViewById(R.id.title_TV);
        textView.setText(savedExtra);

        textView2 = findViewById(R.id.BlockText);
        textView2.setText(savedExtra2);
        textView2.setMovementMethod(new ScrollingMovementMethod());
    }
}
