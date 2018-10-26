package com.INFS3634test1.navigationDrawer;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "quiz_table")
public class Quiz {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    private int topic;
    private boolean isMcq;
    private boolean image;
    private int answer;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String explanation;


    public Quiz(@NonNull int id, int topic, boolean isMcq, boolean image, int answer, String question, String option1, String option2, String option3, String option4, String explanation) {
        this.id = id;
        this.topic = topic;
        this.isMcq = isMcq;
        this.image = image;
        this.answer = answer;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.explanation = explanation;
    }

    //    @NonNull
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTopic() {
        return this.topic;
    }
    public void setTopic(int topic) {
        this.topic = topic;
    }



    public boolean getIsMcq() {
        return this.isMcq;
    }

    public void setIsMcq(boolean isMcq) {
        this.isMcq = isMcq;
    }
    public boolean getImage() {
        return this.image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }






    public int getAnswer() {
        return this.answer;
    }
    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return this.question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return this.option1;
    }
    public void setOption1(String optionAnswer) {
        this.option1 = optionAnswer;
    }

    public String getOption2() {
        return this.option2;
    }
    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return this.option3;
    }
    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return this.option4;
    }
    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public String getExplanation() {
        return this.explanation;
    }
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }





    public String toString() {
        String string = getQuestion();
//        String string = getQuestion() +
//                "\n\t\t\t\t\t\t\t\t\t\t(id: " + getId() + " | topic: " + getTopic() + " | answer: option " + getAnswer() + ")";
        return string;
    }

}