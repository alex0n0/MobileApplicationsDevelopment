package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.INFS3634test1.R;

public class topicDetail extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity_detailactivity);


        String savedExtra = getIntent().getStringExtra("topic");

        textView = findViewById(R.id.title_TV);
        textView.setText(savedExtra);
    }
}
