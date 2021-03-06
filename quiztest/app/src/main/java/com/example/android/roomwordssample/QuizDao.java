package com.example.android.roomwordssample;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;


@Dao
public interface QuizDao {

    @Query("SELECT * from quiz_table ORDER BY id ASC")
//    @Query("SELECT * from word_table WHERE topic ='2' ORDER BY id ASC")
    LiveData<List<Quiz>> getTopicAll();

    @Query("SELECT * from quiz_table WHERE topic ='1' ORDER BY id ASC")
    LiveData<List<Quiz>> getTopic1();

    @Query("SELECT * from quiz_table WHERE topic ='2' ORDER BY id ASC")
    LiveData<List<Quiz>> getTopic2();

    @Query("SELECT * from quiz_table WHERE topic ='3' ORDER BY id ASC")
    LiveData<List<Quiz>> getTopic3();

    @Query("SELECT * from quiz_table WHERE topic ='4' ORDER BY id ASC")
    LiveData<List<Quiz>> getTopic4();

    @Insert
    void insert(Quiz quiz);

    @Query("DELETE FROM quiz_table")
    void deleteAll();
}
