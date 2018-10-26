package com.INFS3634test1.navigationDrawer;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

@Database(entities = {Quiz.class}, version = 4)
public abstract class QuizRoomDatabase extends RoomDatabase {

    public abstract QuizDao quizDao();

    private static volatile QuizRoomDatabase INSTANCE;

    static QuizRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuizRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuizRoomDatabase.class, "quiz_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

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

            Quiz quiz = new Quiz(1, 1, false, false,
                    2,
                    "There can be only one activity in an app.",
                    "True",
                    "False",
                    "",
                    "",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(2, 1, false, false,
                    1,
                    "Each activity can be given a window to draw a user interface.",
                    "True",
                    "False",
                    "",
                    "",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(3, 1, true, false,
                    3,
                    "What is an activity in Android?",
                    "Screen UI",
                    "It manages application content.",
                    "It performs actions on screen.",
                    "None of the above",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(4, 1, true, false,
                    2,
                    "A(n) ______ provides a screen for users to interact with to do something.",
                    "Method",
                    "Activity",
                    "Layout",
                    "User map",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(5, 1, false, false,
                    2,
                    "An activity has to have a default layout.",
                    "True",
                    "False",
                    "",
                    "",
                    "An activity’s layout file can be customised.");
            mDao.insert(quiz);




            quiz = new Quiz(6, 2, true, false,
                    3,
                    "On which thread services work in android?",
                    "Worker thread",
                    "Back thread",
                    "Main thread",
                    "Focus thread",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(7, 2, false, false,
                    2,
                    "A singleton class can create multiple objects.",
                    "True",
                    "False",
                    "",
                    "",
                    "A singleton class can only create one object.");
            mDao.insert(quiz);

            quiz = new Quiz(8, 2, true, false,
                    3,
                    "What is the use of a content provider?",
                    "To store information.",
                    "To create UI.",
                    "To share data between activities.",
                    "To stop services.",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(9, 2, false, false,
                    1,
                    "The onCreate() method is called when creating your activity.",
                    "True",
                    "False",
                    "",
                    "",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(10, 2, true, false,
                    4,
                    "What must be called to define the layout for an activity?",
                    "setLayout()",
                    "attachContent()",
                    "attachContentView()",
                    "setContentView()",
                    "");
            mDao.insert(quiz);



            quiz = new Quiz(11, 3, false, false,
                    2,
                    "Service class is the parent class of activity.",
                    "True",
                    "False",
                    "",
                    "",
                    "It is object class that is the parent.");
            mDao.insert(quiz);

            quiz = new Quiz(12, 3, true, false,
                    1,
                    "Which is not a state an activity can exist in?",
                    "Destroyed",
                    "Resumed",
                    "Paused",
                    "Stopped",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(13, 3, true, false,
                    4,
                    "What is JSON in android?",
                    "Java Script Object Note",
                    "Java Script Oriented Native",
                    "Java Source Objection Notation",
                    "Java Script Object Notation",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(14, 3, false, false,
                    1,
                    "onCreate() is followed by onStart().",
                    "True",
                    "False",
                    "",
                    "",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(15, 3, false, false,
                    1,
                    "You declare activities in the manifest file.",
                    "True",
                    "False",
                    "",
                    "",
                    "");
            mDao.insert(quiz);




            quiz = new Quiz(16, 4, true, false,
                    3,
                    "When an activity is stopped, what happened?",
                    "It is partially visible.",
                    "The activity was duplicated.",
                    "It is completely obscured from view.",
                    "None of the above.",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(17, 4, false, false,
                    2,
                    "onStop() is the final method called before activity destruction.",
                    "True",
                    "False",
                    "",
                    "",
                    "onDestroy() is the final method to be called before activity destruction.");
            mDao.insert(quiz);

            quiz = new Quiz(18, 4, true, false,
                    3,
                    "If a stopped activity starts again, what is called first?",
                    "onStart()",
                    "onReboot()",
                    "onRestart()",
                    "onStop()",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(19, 4, true, false,
                    4,
                    "Which method may be called multiple times the app comes back from the paused state?",
                    "onStart()",
                    "onContinue()",
                    "onState()",
                    "onResume()",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(20, 4, false, false,
                    1,
                    "The resumed state is often called the running state.",
                    "True",
                    "False",
                    "",
                    "",
                    "");
            mDao.insert(quiz);



            quiz = new Quiz(21, 5, true, false,
                    2,
                    "The entire lifetime of an activity happens between the call to onCreate() and the call to?",
                    "onStart()",
                    "onDestroy()",
                    "onPause()",
                    "onStop()",
                    "onDestroy() is the last step before the activity is shut down.");
            mDao.insert(quiz);

            quiz = new Quiz(22, 5, true, false,
                    1,
                    "What lifetime of an activity happens between the call to onResume() and the call to onPause()?",
                    "Foreground",
                    "Middle ground",
                    "Background",
                    "Inbetweenground",
                    "The foreground is when the activity is in attention and use.");
            mDao.insert(quiz);

            quiz = new Quiz(23, 5, true, false,
                    4,
                    "What lifetime of an activity happens between the call to onStart() and the call to onStop()?",
                    "Invisible",
                    "Background",
                    "Partial",
                    "Visible",
                    "Visible is when the activity is in view but not necessarily completely in view or in use.");
            mDao.insert(quiz);

            quiz = new Quiz(24, 5, true, false,
                    3,
                    "Which is not a valid callback method for an activity?",
                    "onCreate()",
                    "onPause()",
                    "onKill()",
                    "onDestroy()",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(25, 5, true, false,
                    2,
                    "In which method should basic application start up logic happen?",
                    "onStart()",
                    "onCreate()",
                    "onResume()",
                    "onGenerate()",
                    "onCreate() is where basic logic is set up for an application and generally only happens once.");
            mDao.insert(quiz);



            quiz = new Quiz(26, 6, true, false,
                    3,
                    "When an activity is paused or stopped, the state of the activity is?",
                    "Destroyed",
                    "Altered",
                    "Retained",
                    "Split",
                    "It is retained because the activity object is held in memory.");
            mDao.insert(quiz);

            quiz = new Quiz(27, 6, true, false,
                    2,
                    "The system destroys an activity in order to?",
                    "Resume the same activity",
                    "Recover memory",
                    "Run a thread",
                    "Copy data",
                    "A system often needs more memory to run other activities so it would destroy an activity that is not in use to do it." );
            mDao.insert(quiz);

            quiz = new Quiz(28, 6, true, false,
                    1,
                    "How can a user ensure to save important state information?",
                    "onSaveInstanceState",
                    "onRetainInstanceState",
                    "onRecordInstanceState",
                    "onFinaliseInstanceState",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(29, 6, true, false,
                    1,
                    "When an activity returns to the foreground, what method is called to retrieve any state information?",
                    "onResume()",
                    "onMemory()",
                    "onRetrieve()",
                    "onLoad()",
                    "onResume is called when an activity is back in use which would retrieve the instance state information if available." );
            mDao.insert(quiz);

            quiz = new Quiz(30, 6, true, false,
                    4,
                    "If another activity takes focus of the current activity, what state does the covered activity go to?",
                    "Held state",
                    "Stable state",
                    "Memory state",
                    "Paused state",
                    "");
            mDao.insert(quiz);


            quiz = new Quiz(31, 7, true, false,
                    1,
                    "What is a bundle?",
                    "It is used to pass data between activities.",
                    "It combines different activity methods.",
                    "It glues together an app.",
                    "It puts together a bunch of APIs.",
                    "");
            mDao.insert(quiz);


            quiz = new Quiz(32, 7, true, false,
                    3,
                    "Which one is a possible method to populate a bundle?",
                    "onCreate",
                    "getString",
                    "putString",
                    "onGrab",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(33, 7, true, false,
                    4,
                    "Which method allows a user to restore data from a bundle?",
                    "onSaveInstanceState",
                    "onReloadInstanceState",
                    "onRecoverInstanceState",
                    "onRestoreInstanceState",
                    "");
            mDao.insert(quiz);

            quiz = new Quiz(34, 7, true, false,
                    2,
                    "If there is no information in a bundle to restore, what is passed to the user?",
                    "A zero",
                    "A null",
                    "A blank",
                    "The last bundle used",
                    "A null is passed to the user, which is like when the activity is first made." );
            mDao.insert(quiz);

            quiz = new Quiz(35, 7, true, false,
                    3,
                    "Where can a bundle be passed to?",
                    "A constraint",
                    "A layout",
                    "An intent",
                    "A null",
                    "A bundle can be passed to an intent in order to send the data to another activity." );
            mDao.insert(quiz);




            quiz = new Quiz(36, 8, true, false,
                    2,
                    "What is a collection of activities that users interact with when performing a certain job?",
                    "A back stack",
                    "A task",
                    "An intent",
                    "A bundle",
                    "none");
            mDao.insert(quiz);

            quiz = new Quiz(37, 8, true, false,
                    4,
                    "When the current activity starts another, where does the new activity go in the stack?",
                    "The bottom",
                    "The middle",
                    "Not in the stack",
                    "The top",
                    "The new activity is pushed on the top of the stack and takes focus.");
            mDao.insert(quiz);


            quiz = new Quiz(38, 8, true, false,
                    1,
                    "What happens to the new activity when the back button is pressed?",
                    "It is popped off the stack.",
                    "It is re-opened",
                    "It is collected",
                    "It is saved",
                    "none");
            mDao.insert(quiz);


            quiz = new Quiz(39, 8, true, false,
                    3,
                    "What type of structure does the back stack operate as?",
                    "First in, last out",
                    "First come, first out",
                    "Last in, first out",
                    "Last in, last out",
                    "The latest activity added to the stack is the first to go.");
            mDao.insert(quiz);


            quiz = new Quiz(40, 8, true, false,
                    2,
                    "What happens if the user continues to press the back button?",
                    "Nothing, only 1 activity is popped off.",
                    "Each activity in the stack is popped off until the home screen.",
                    "The task recycles previous activities.",
                    "After the third press, it stops.",
                    "none");
            mDao.insert(quiz);




            return null;
        }
    }

}
