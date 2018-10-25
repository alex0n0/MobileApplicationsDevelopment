package com.example.android.roomwordssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;
import android.util.Log;

public class ResultsActivity extends AppCompatActivity {

    int topic;
    boolean[] mCorrectArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        int count = intent.getIntExtra("KEYCORRECT", 0);
        int total = intent.getIntExtra("KEYTOTAL", 0);
        topic = intent.getIntExtra("TOPIC_REVIEW", -1);
        mCorrectArray = intent.getBooleanArrayExtra("KEYCORRECTARRAY");

        TextView tv_result = findViewById(R.id.tv_result);
        String message = "your result is " + count + "/" + total;
        tv_result.setText(message);

    }

    public void toReview(View view){
        Intent intent = new Intent(this, QuizReviewActivity.class);
        Log.d("Number", "topic is " + topic);
        intent.putExtra("TOPIC_REVIEW", topic);
        intent.putExtra("KEYCORRECTARRAY", mCorrectArray);
        startActivity(intent);
    }
}
