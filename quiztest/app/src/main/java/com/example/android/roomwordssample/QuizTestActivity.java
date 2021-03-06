package com.example.android.roomwordssample;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.List;


public class QuizTestActivity extends AppCompatActivity {

    private QuizViewModel mQuizViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_test);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        final int topic = intent.getIntExtra("TOPIC_TEST", -1);

        RecyclerView recyclerView = findViewById(R.id.recyclerview_test);
        final QuizTestAdapter adapter = new QuizTestAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Get a new or existing ViewModel from the ViewModelProvider.
        mQuizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);

        // Add an observer on the LiveData returned by getAlphabetizedWords.
        // The onChanged() method fires when the observed data changes and the activity is
        // in the foreground.
        mQuizViewModel.getAllQuiz(topic).observe(this, new Observer<List<Quiz>>() {
            @Override
            public void onChanged(@Nullable final List<Quiz> quiz) {
                // Update the cached copy of the words in the adapter.
                adapter.setQuiz(quiz);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[][] answerCheckArray = QuizTestAdapter.checkArray;

                int correctCount = 0;
                int questionCount = 0;

                boolean[] correctArray = new boolean[answerCheckArray.length];
                for (int i = 0; i < correctArray.length; i++) {
                    correctArray[i] = false;
                }

                String s = "";
                for (int i = 0; i < answerCheckArray.length; i++) {
                    if (i != 0) {
                        s += "\n";
                    }
                    switch (answerCheckArray[i][0]) {
                        case R.id.rb_test_a:
                            s += "Q" + (i + 1) + ": selection A |";
                            break;
                        case R.id.rb_test_b:
                            s += "Q" + (i + 1) + ": selection B |";
                            break;
                        case R.id.rb_test_c:
                            s += "Q" + (i + 1) + ": selection C |";
                            break;
                        case R.id.rb_test_d:
                            s += "Q" + (i + 1) + ": selection D |";
                            break;
                        default:
                            s += "Q" + (i + 1) + ": selection none |";
                    }
                    switch (answerCheckArray[i][1]) {
                        case R.id.rb_test_a:
                            s += " answer A";
                            break;
                        case R.id.rb_test_b:
                            s += " answer B";
                            break;
                        case R.id.rb_test_c:
                            s += " answer C";
                            break;
                        case R.id.rb_test_d:
                            s += " answer D";
                            break;
                        case -1:
                            s += " empty";
                            break;
                        default:
                            s += " should not appear";
                    }
                    if (answerCheckArray[i][1] != -1) {
                        questionCount++;
                    }
                    if (answerCheckArray[i][0] == answerCheckArray[i][1]) {
                        correctCount++;
                        correctArray[i] = true;
                    }
                }

                s += "\n" + correctCount;
                s += "\n" + questionCount;

                Toast.makeText(QuizTestActivity.this, s, Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(QuizTestActivity.this, ResultsActivity.class);
//                intent.putExtra("KEYCORRECT", correctCount);
//                intent.putExtra("KEYTOTAL", questionCount);
//                intent.putExtra("TOPIC_REVIEW", topic);
//                intent.putExtra("KEYCORRECTARRAY", correctArray);
//                startActivity(intent);
            }
        });
//    }


    }
}


