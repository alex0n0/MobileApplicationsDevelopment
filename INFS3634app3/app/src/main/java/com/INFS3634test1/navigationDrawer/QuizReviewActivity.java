package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.List;

import com.INFS3634test1.R;

public class QuizReviewActivity extends NavigationDrawerBaseActivity {

    private QuizViewModel mQuizViewModel;

    int correctCount;
    int questionCount;
    int topic;
    boolean[] correctArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_review);

        appBarTxt.setText("Module Quiz");

        Intent intent = getIntent();
        correctCount = intent.getIntExtra("KEYCORRECT", 0);
        questionCount = intent.getIntExtra("KEYTOTAL", 0);
        topic = intent.getIntExtra("TOPIC_REVIEW", -1);
        correctArray = intent.getBooleanArrayExtra("KEYCORRECTARRAY");


        RecyclerView recyclerView = findViewById(R.id.recyclerview_review);
        final QuizReviewAdapter adapter = new QuizReviewAdapter(this, correctArray);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        mQuizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);



        mQuizViewModel.getAllQuiz(topic).observe(this, new Observer<List<Quiz>>() {
            @Override
            public void onChanged(@Nullable final List<Quiz> quiz) {
                adapter.setQuiz(quiz);
            }
        });


//    }


    }

    @Override public void onBackPressed() {
        Intent intent = new Intent(QuizReviewActivity.this, QuizResultsActivity.class);
        intent.putExtra("KEYCORRECT", correctCount);
        intent.putExtra("KEYTOTAL", questionCount);
        intent.putExtra("TOPIC_REVIEW", topic);
        intent.putExtra("KEYCORRECTARRAY", correctArray);
        startActivity(intent);
        finish();
        Log.i(TAG_N, "Back button pressed.");
    }

//    public static class resources_activitysearch extends AppCompatActivity {
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_quiz_review);
//            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//            setSupportActionBar(toolbar);
//
//            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//            fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
//            });
//        }
//
//    }
}



