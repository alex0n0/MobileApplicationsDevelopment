package com.INFS3634test1.navigationDrawer;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;



class QuizRepository {

    private QuizDao mQuizDao;
    private QuizDao mQuizDao1;
    private QuizDao mQuizDao2;
    private QuizDao mQuizDao3;
    private QuizDao mQuizDao4;
    private LiveData<List<Quiz>> mAllQuiz;

    private LiveData<List<Quiz>> mQuizTopic1;
    private LiveData<List<Quiz>> mQuizTopic2;
    private LiveData<List<Quiz>> mQuizTopic3;
    private LiveData<List<Quiz>> mQuizTopic4;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    QuizRepository(Application application) {
        QuizRoomDatabase db = QuizRoomDatabase.getDatabase(application);
        mQuizDao = db.quizDao();
        mQuizDao1 = db.quizDao();
        mQuizDao2 = db.quizDao();
        mQuizDao3 = db.quizDao();
        mQuizDao4 = db.quizDao();

        mAllQuiz = mQuizDao.getTopicAll();
        mQuizTopic1 = mQuizDao1.getTopic1();
        mQuizTopic2 = mQuizDao2.getTopic2();
        mQuizTopic3 = mQuizDao3.getTopic3();
        mQuizTopic4 = mQuizDao4.getTopic4();
    }



    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Quiz>> getAllQuiz() {
        return mAllQuiz;
    }
    LiveData<List<Quiz>> getTopic1Quiz() {
        return mQuizTopic1;
    }
    LiveData<List<Quiz>> getTopic2Quiz() {
        return mQuizTopic2;
    }
    LiveData<List<Quiz>> getTopic3Quiz() {
        return mQuizTopic3;
    }
    LiveData<List<Quiz>> getTopic4Quiz() {
        return mQuizTopic4;
    }

    // You must call this on a non-UI thread or your app will crash.
    // Like this, Room ensures that you're not doing any long running operations on the main
    // thread, blocking the UI.
    void insert(Quiz quiz) {
        new insertAsyncTask(mQuizDao).execute(quiz);
    }

    private static class insertAsyncTask extends AsyncTask<Quiz, Void, Void> {

        private QuizDao mAsyncTaskDao;

        insertAsyncTask(QuizDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Quiz... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
