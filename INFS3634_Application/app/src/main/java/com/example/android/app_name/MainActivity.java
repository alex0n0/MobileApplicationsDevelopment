package com.example.android.app_name;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_1.setText("put some text here");
    }

    // Test
}
