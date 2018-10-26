package com.INFS3634test1.navigationDrawer;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.INFS3634test1.R;

import java.util.Collections;
import java.util.List;

public class QuizReviewAdapter extends RecyclerView.Adapter<QuizReviewAdapter.QuizViewHolder> {

    public boolean[] mQuizResults;

    class QuizViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_review_question;
        private final TextView tv_review_result;
        private final TextView tv_review_answer;
        private final TextView tv_review_explanation;


        private QuizViewHolder(View itemView) {
            super(itemView);
            tv_review_question = itemView.findViewById(R.id.tv_review_question);
            tv_review_result = itemView.findViewById(R.id.tv_review_result);
            tv_review_answer = itemView.findViewById(R.id.tv_review_answer);
            tv_review_explanation = itemView.findViewById(R.id.tv_review_explanation);
        }
    }

    private final LayoutInflater mInflater;
    private List<Quiz> mQuiz = Collections.emptyList(); // Cached copy of words

    QuizReviewAdapter(Context context, boolean[] mResults) {
        mInflater = LayoutInflater.from(context);
        mQuizResults = mResults;
    }

    @Override
    public QuizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_review_item, parent, false);
        return new QuizViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QuizViewHolder holder, int position) {
        Quiz current = mQuiz.get(position);
        String s;
        s = "Question " + (position + 1) + "\n\n" + current.toString();
        holder.tv_review_question.setText(s);
        holder.tv_review_result.setText(mQuizResults[position] ? "Correct" : "Incorrect");
        holder.tv_review_result.setTextColor(Color.parseColor(mQuizResults[position] ? "#00FF00" : "#FF0000"));

        String answer;
        switch (current.getAnswer()) {
            case 1:
                answer = "Answer: " + current.getOption1();
                break;
            case 2:
                answer = "Answer: " + current.getOption2();
                break;
            case 3:
                answer = "Answer: " + current.getOption3();
                break;
            case 4:
                answer = "Answer: " + current.getOption4();
                break;
            default:
                answer = "should not appear";
                break;
        }

        holder.tv_review_answer.setText(answer);
        if (!current.getExplanation().equals("")) {
            holder.tv_review_explanation.setVisibility(View.VISIBLE);
            String explanation = "Explanation: " + current.getExplanation();
            holder.tv_review_explanation.setText(explanation);
        } else {
            holder.tv_review_explanation.setVisibility(View.GONE);
        }


    }



    void setQuiz(List<Quiz> quiz) {
        mQuiz = quiz;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mQuiz.size();
    }
}

