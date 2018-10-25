package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;

import com.INFS3634test1.R;

public class QuizSelectionActivity extends NavigationDrawerBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_selection);

        appBarTxt.setText("Module Quiz");

    }

    public void toQuizAll(View view) {
        int i = -1;
        Intent intent = new Intent(this, QuizTestActivity.class);
        intent.putExtra("TOPIC_TEST", i);
        startActivity(intent);
    }

    public void toQuiz1(View view) {
        int i = 1;
        Intent intent = new Intent(this, QuizTestActivity.class);
        intent.putExtra("TOPIC_TEST", i);

        Log.d("Number", "topic is " + i);

        startActivity(intent);
    }
    public void toQuiz2(View view) {
        int i = 2;
        Intent intent = new Intent(this, QuizTestActivity.class);
        intent.putExtra("TOPIC_TEST", i);

        Log.d("Number", "topic is " + i);

        startActivity(intent);
    }
    public void toQuiz3(View view) {
        int i = 3;
        Intent intent = new Intent(this, QuizTestActivity.class);
        intent.putExtra("TOPIC_TEST", i);

        Log.d("Number", "topic is " + i);

        startActivity(intent);
    }
    public void toQuiz4(View view) {
        int i = 4;
        Intent intent = new Intent(this, QuizTestActivity.class);
        intent.putExtra("TOPIC_TEST", i);

        Log.d("Number", "topic is " + i);

        startActivity(intent);
    }
}