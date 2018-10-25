package com.example.android.roomwordssample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAll = (Button) findViewById(R.id.buttonAll);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
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
