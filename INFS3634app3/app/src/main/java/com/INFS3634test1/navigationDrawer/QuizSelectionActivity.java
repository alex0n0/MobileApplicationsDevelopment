package com.INFS3634test1.navigationDrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.INFS3634test1.R;


import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class QuizSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_selection);

//        Button button_select_all = (Button) findViewById(R.id.button_select_all);
//        Button button_select_1 = (Button) findViewById(R.id.button_select_1);
//        Button button_select_2 = (Button) findViewById(R.id.button_select_2);
//        Button button_select_3 = (Button) findViewById(R.id.button_select_3);
//        Button button_select_4 = (Button) findViewById(R.id.button_select_4);
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