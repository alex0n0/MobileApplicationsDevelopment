package com.INFS3634test1.navigationDrawer;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.INFS3634test1.R;

import java.util.List;

public class QuizReviewActivity extends NavigationDrawerBaseActivity {

    private QuizViewModel mQuizViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_review);

        appBarTxt.setText("Module Quiz");

        Intent intent = getIntent();
        int topic = intent.getIntExtra("TOPIC_REVIEW", -1);

        boolean[] mQuizResults = intent.getBooleanArrayExtra("KEYCORRECTARRAY");


        RecyclerView recyclerView = findViewById(R.id.recyclerview_review);
        final QuizReviewAdapter adapter = new QuizReviewAdapter(this, mQuizResults);
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

    public static class resources_activitysearch extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz_review);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }

    }
}



