package com.INFS3634test1.navigationDrawer;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.List;

/**
 * View Model to keep a reference to the word repository and
 * an up-to-date list of all words.
 */

public class QuizViewModel extends AndroidViewModel {

    private QuizRepository mRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<Quiz>> mAllQuiz;
    private LiveData<List<Quiz>> mTopic1Quiz;
    private LiveData<List<Quiz>> mTopic2Quiz;
    private LiveData<List<Quiz>> mTopic3Quiz;
    private LiveData<List<Quiz>> mTopic4Quiz;

    public QuizViewModel(Application application) {
        super(application);
        mRepository = new QuizRepository(application);
        mAllQuiz = mRepository.getAllQuiz();
        mTopic1Quiz = mRepository.getTopic1Quiz();
        mTopic2Quiz = mRepository.getTopic2Quiz();
        mTopic3Quiz = mRepository.getTopic3Quiz();
        mTopic4Quiz = mRepository.getTopic4Quiz();
    }

    LiveData<List<Quiz>> getAllQuiz(int topic) {
        Log.d("Number", "topic is " + topic);
        switch (topic) {
            case 1:
                return mTopic1Quiz;
            case 2:
                return mTopic2Quiz;
            case 3:
                return mTopic3Quiz;
            case 4:
                return mTopic4Quiz;
            default:
                return mTopic2Quiz;
        }
    }

    void insert(Quiz quiz) {
        mRepository.insert(quiz);
    }
}
