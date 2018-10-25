package com.INFS3634test1.navigationDrawer;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * This is the backend. The database. This used to be done by the OpenHelper.
 * The fact that this has very few comments emphasizes its coolness.
 */

@Database(entities = {Quiz.class}, version = 4)
public abstract class QuizRoomDatabase extends RoomDatabase {

    public abstract QuizDao quizDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile QuizRoomDatabase INSTANCE;

    static QuizRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuizRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuizRoomDatabase.class, "quiz_database")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     *
     * If you want to populate the database only when the database is created for the 1st time,
     * override RoomDatabase.Callback()#onCreate
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    /**
     * Populate the database in the background.
     * If you want to start with more words, just add them.
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final QuizDao mDao;

        PopulateDbAsync(QuizRoomDatabase db) {
            mDao = db.quizDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteAll();

            Quiz quiz = new Quiz(1, 1, true, false, 1,"question 1", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(2, 1, true, false, 1,"question 2", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(3, 1, true, false, 2,"question 3", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(4, 1, true, false, 2,"question 4", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(5, 1, true, false, 3,"question 5", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(6, 1, true, false, 3,"question 6", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(7, 1, true, false, 4,"question 7", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(8, 1, true, false, 4,"question 8", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(9, 1, true, false, 1,"question 9", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(10, 1, true, false, 1,"question 10", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);



            quiz = new Quiz(11, 2, false, false, 1,"question 1", "true", "false", "", "", "something");
            mDao.insert(quiz);
            quiz = new Quiz(12, 2, false, false, 1,"question 2", "true", "false", "", "", "something");
            mDao.insert(quiz);
            quiz = new Quiz(13, 2, false, false, 2,"question 3", "true", "false", "", "", "something");
            mDao.insert(quiz);
            quiz = new Quiz(14, 2, false, false, 2,"question 4", "true", "false", "", "", "something");
            mDao.insert(quiz);
            quiz = new Quiz(15, 2, false, false, 1,"question 5", "true", "false", "", "", "something");
            mDao.insert(quiz);
            Log.d("Insert", "is this working");

            quiz = new Quiz(16, 2, true, false, 2,"question 6", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(17, 2, true, false, 1,"question 7", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(18, 2, true, false, 1,"question 8", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(19, 2, true, false, 4,"question 9", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(20, 2, true, false, 3,"question 10", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);

            quiz = new Quiz(21, 3, true, false, 2,"question 1", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(22, 3, true, false, 1,"question 2", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(23, 3, true, false, 1,"question 3", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(24, 3, true, false, 4,"question 4", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(25, 3, true, false, 3,"question 5", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);

            quiz = new Quiz(26, 4, true, false, 2,"question 1", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(27, 4, true, false, 1,"question 2", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(28, 4, true, false, 1,"question 3", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(29, 4, true, false, 4,"question 4", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);
            quiz = new Quiz(30, 4, true, false, 3,"question 5", "random option 1", "random option 2", "random option 3", "random option 4", "something");
            mDao.insert(quiz);

            return null;
        }
    }

}
