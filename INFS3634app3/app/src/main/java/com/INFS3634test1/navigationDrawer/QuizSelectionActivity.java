package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;

import com.INFS3634test1.R;

public class QuizSelectionActivity extends NavigationDrawerBaseActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_selection2);

        appBarTxt.setText("Module Quiz");
//////////////////////////////////////////////////////////////////////////////
        final String[] topicHeadingLevelOneArray = {
                "Topic 1: What are Activities?",
                "Topic 2: Introduction to the Activity Lifecycle (Pt.1)",
                "Topic 3: Introduction to the Activity Lifecycle (Pt.2)",
                "Topic 4: Introduction to the Activity Lifecycle (Pt.3)",
                "Topic 5: Activity Lifetimes",
                "Topic 6: Saving an Activities State",
                "Topic 7: Methods and Bundle",
                "Topic 8: Activities in tasks and the back stack",
        };

        final String[] topicHeadingLevelTwoArray = {
                "INFS3634: Lecture 2",
                "INFS3634: Lecture 2",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
        };

        QuizSelectionAdapter newQuizSelectionAdapter = new QuizSelectionAdapter(this, topicHeadingLevelOneArray, topicHeadingLevelTwoArray);
        listView = (ListView) findViewById(R.id.lv_quiz_selection);
        listView.setAdapter(newQuizSelectionAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(QuizSelectionActivity.this, QuizTestActivity.class);
                intent.putExtra("TOPIC_TEST", (position + 1));
                startActivity(intent);

            }
        });
//////////////////////////////////////////////////////////////////////////////
    }

//    public void toQuizAll(View view) {
//        int i = -1;
//        Intent intent = new Intent(this, QuizTestActivity.class);
//        intent.putExtra("TOPIC_TEST", i);
//        startActivity(intent);
//    }
//
//    public void toQuiz1(View view) {
//        int i = 1;
//        Intent intent = new Intent(this, QuizTestActivity.class);
//        intent.putExtra("TOPIC_TEST", i);
//
//        Log.d("Number", "topic is " + i);
//
//        startActivity(intent);
//    }
//    public void toQuiz2(View view) {
//        int i = 2;
//        Intent intent = new Intent(this, QuizTestActivity.class);
//        intent.putExtra("TOPIC_TEST", i);
//
//        Log.d("Number", "topic is " + i);
//
//        startActivity(intent);
//    }
//    public void toQuiz3(View view) {
//        int i = 3;
//        Intent intent = new Intent(this, QuizTestActivity.class);
//        intent.putExtra("TOPIC_TEST", i);
//
//        Log.d("Number", "topic is " + i);
//
//        startActivity(intent);
//    }
//    public void toQuiz4(View view) {
//        int i = 4;
//        Intent intent = new Intent(this, QuizTestActivity.class);
//        intent.putExtra("TOPIC_TEST", i);
//
//        Log.d("Number", "topic is " + i);
//
//        startActivity(intent);
//    }
}