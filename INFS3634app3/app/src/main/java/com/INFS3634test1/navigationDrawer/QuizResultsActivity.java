package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.widget.TextView;
import android.view.View;
import android.util.Log;

import com.INFS3634test1.R;

public class QuizResultsActivity extends NavigationDrawerBaseActivity {

    int correctCount;
    int questionCount;
    int topic;
    boolean[] correctArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        appBarTxt.setText("Module Quiz");

        Intent intent = getIntent();
        correctCount = intent.getIntExtra("KEYCORRECT", 0);
        questionCount = intent.getIntExtra("KEYTOTAL", 0);
        topic = intent.getIntExtra("TOPIC_REVIEW", -1);
        correctArray = intent.getBooleanArrayExtra("KEYCORRECTARRAY");

        TextView tv_result = findViewById(R.id.tv_result);
        String message = "Your result is " + correctCount + "/" + questionCount;
        tv_result.setText(message);

    }

    @Override public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START))
//            drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent(QuizResultsActivity.this, QuizSelectionActivity.class));
        finish();
        Log.i(TAG_N, "Back button pressed.");
    }

    public void toReview(View view){

        Intent intent = new Intent(this, QuizReviewActivity.class);

        intent.putExtra("KEYCORRECT", correctCount);
        intent.putExtra("KEYTOTAL", questionCount);
        intent.putExtra("TOPIC_REVIEW", topic);
        intent.putExtra("KEYCORRECTARRAY", correctArray);
        startActivity(intent);
    }
}
