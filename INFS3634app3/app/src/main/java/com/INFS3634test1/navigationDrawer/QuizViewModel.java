package com.INFS3634test1.navigationDrawer;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.util.List;

public class QuizViewModel extends AndroidViewModel {

    private QuizRepository mRepository;
//    private LiveData<List<Quiz>> mAllQuiz;
    private LiveData<List<Quiz>> mTopic1Quiz;
    private LiveData<List<Quiz>> mTopic2Quiz;
    private LiveData<List<Quiz>> mTopic3Quiz;
    private LiveData<List<Quiz>> mTopic4Quiz;
    private LiveData<List<Quiz>> mTopic5Quiz;
    private LiveData<List<Quiz>> mTopic6Quiz;
    private LiveData<List<Quiz>> mTopic7Quiz;
    private LiveData<List<Quiz>> mTopic8Quiz;

    public QuizViewModel(Application application) {
        super(application);
        mRepository = new QuizRepository(application);
//        mAllQuiz = mRepository.getAllQuiz();
        mTopic1Quiz = mRepository.getTopic1Quiz();
        mTopic2Quiz = mRepository.getTopic2Quiz();
        mTopic3Quiz = mRepository.getTopic3Quiz();
        mTopic4Quiz = mRepository.getTopic4Quiz();
        mTopic5Quiz = mRepository.getTopic5Quiz();
        mTopic6Quiz = mRepository.getTopic6Quiz();
        mTopic7Quiz = mRepository.getTopic7Quiz();
        mTopic8Quiz = mRepository.getTopic8Quiz();
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
            case 5:
                return mTopic5Quiz;
            case 6:
                return mTopic6Quiz;
            case 7:
                return mTopic7Quiz;
            case 8:
                return mTopic8Quiz;
            default:
                return mTopic1Quiz;
        }
    }

    void insert(Quiz quiz) {
        mRepository.insert(quiz);
    }
}
