package com.INFS3634test1.navigationDrawer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.INFS3634test1.R;


public class TopicActivity extends NavigationDrawerBaseActivity {

    ListView listView;
    private static final String TAG = "TopicActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity);
        appBarTxt.setText("Module Topics");

        Log.d(TAG, "onCreate: starts");

        final String[] topicHeadingLevelOneArray = {
                "Topic 1: What are Activities?",
                "Topic 2: Introduction to the Activity Lifecycle (Pt.1)",
                "Topic 3: Introduction to the Activity Lifecycle (Pt.2)",
                "Topic 4: Introduction to the Activity Lifecycle (Pt.3)",
                "Topic 5: Activity Lifetimes",
                "Topic 6: Saving an Activities State",
                "Topic 7: Methods and Bundle",
                "Topic 8: Activities in tasks and the back stack",
                "Topic 9: Summary",
        };

        final String[] topicHeadingLevelTwoArray = {
                "INFS3634: Lecture 2",
                "INFS3634: Lecture 2",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",
                "INFS3634: Lecture 3",

        };

        final String[] topicContent = {
                // Topic 1
                "An activity is one of the distinguishing features of the Android Framework.\n" +
                        "\n" +
                        " - Activities provide the user with access to your app, and there may be many activities in a single application.\n" +
                        "\n" +
                        " - An application will usually have a main activity for when the user launches the application and another activity for when they " +
                        "select content to view e.g. when you selected the “Topic Content” option in our navigational menu.\n" +
                        "\n" +
                        "The official definition from “developer.android.com” is that, “an activity is an application component that " +
                        "provides a screen with which users can interact with in to do something, such as dial the phone, take a photo, " +
                        "send an email, or view a map. Each activity is given a window in which to draw its user interface. The window typically" +
                        " fills the screen, but may be smaller than the screen and flow on top of other windows.”\n",
                // Topic 2
                "An activity is created with the following method:\n" +
                        "\n" +
                        "onCreate()\n" +
                        " - The system calls this method when creating your activity. Thus, it must be implemented. \n" +
                        " - Within the implementation, you should also initialise the essential components of your activity after this method.\n" +
                        " - Most importantly, this is where you must call setContentView() to define the layout for the activity’s user interface. \n",
                // Topic 3
                "After creation of an activity, the activity can exist in the following three states:\n" +
                        "\n" +
                        "Resume\n" +
                        "The activity is in the foreground of the screen and has user focus. (This state is also sometimes referred to as \"running\".)\n" +
                        "\n" +
                        "Paused\n" +
                        "Another activity is in the foreground and has focus, but this one is still visible. That is, another activity is visible on top of this one and that activity is partially transparent or doesn't cover the entire screen. A paused activity is completely alive (the Activity object is retained in memory, it maintains all state and member information, and remains attached to the window manager), but can be killed by the system in extremely low memory situations.\n" +
                        "\n" +
                        "Stopped\n" +
                        "The activity is completely obscured by another activity (the activity is now in the \"background\"). A stopped activity is also still alive (the Activity object is retained in memory, it maintains all state and member information, but is not attached to the window manager). However, it is no longer visible to the user and it can be killed by the system when memory is needed elsewhere.\n" +
                        "\n" +
                        "If an activity is paused or stopped, the system can drop it from memory either by asking it to finish (calling its finish() method), or simply killing its process. When the activity is opened again (after being finished or killed), it must be created all over again." +
                        // Topic 4
                        "When an activity transitions into and out of the different states described previously, it is notified through various callback methods. All of the callback methods are hooks that you can override to do appropriate work when the state of your activity changes. \n",
                "\n" +
                        "A summary of the activity lifecycle’s callback methods is provided below:\n" +
                        "\n" +
                        "onCreate() - Called when the activity is first created. This is where you should do all of your normal static set up - create views, bind data to lists, and so on. This method is passed a Bundle object ocntaining the activitiy’s previous state, if that state was captured. \n" +
                        "\n" +
                        "This method is followed by onStart().\n" +
                        "\n" +
                        "onRestart() - Called after the activity has been stopped, just prior to it being started again.\n" +
                        "\n" +
                        "This method is followed by on Start().\n" +
                        "\n" +
                        "onStart() - Called just before the activity becomes visible to the user.\n" +
                        "\n" +
                        "This method is followed by onResume() if the activity comes to the foreground, or onStop() if it becomes hidden.\n" +
                        "\n" +
                        "onResume() - Called just before the activity starts interacting with the user. At this point the activity is at the top of the activity stack, with user input going to it.\n" +
                        "\n" +
                        "Always followed by onPause().\n" +
                        "\n" +
                        "onPause() - Called when the system is about to start resuming another activity. This method is typically used to commit unsaved changes to persistent data, stop animations and other things that may be consuming CPU, and so on. It should do whatever it does very quickly, because the next activity will not be resumed until it returns.\n" +
                        "\n" +
                        "Followed either by onResume() if the activity returns back to the front, or by onStop() if it becomes invisible to the user.\n" +
                        "\n" +
                        "onStop() - Called when the activity is no longer visible to the user. This may happen because it is being destroyed, or because another activity (either an existing one or r a new one) has been resumed and is covering it.\n" +
                        "\n" +
                        "Followed either by onRestart() if the activity is coming back to interact with the user, or by onDestroy() if this activity is going away.\n" +
                        "\n" +
                        "onDestroy() - Called before the activity is destroyed. This is the final call that they activity will receive. It could be called either because the activity is finishing (someone called finish() on it), or because the system is temporarily destroying this instance of the activity to save space. You can distinguish between these two scenarios with the isFinishing() method.\n",
                // Topic 5
                "Entire Lifetime\n" +
                        "The entire lifetime of an activity happens between the call to onCreate() and the call to onDestroy().\n" +
                        "Your activity should perform setup of “global” state (such as defining layout) in onCreate(), and release of all remaining resources in onDestroy().\n" +
                        "For example, if your activity has a thread running in the background to download data from the network, it might create that thread in onCreate() and then stop the thread in onDestroy().\n" +
                        "\n" +
                        "Visible Lifetime\n" +
                        "The visible lifetime of an activity happens between the call to onStart() and the call to onStop(). During this time, the user can see the activity on-screen and interact with it.\n" +
                        "E.g., onStop() is called when a new activity starts and this one is no longer visible. Between these two methods, you can maintain resources that are needed to show the activity to the user.\n" +
                        "For example, you can register a BroadcastReceiver in onStart() to monitor changes that impact your UI, and unregister it in onStop() when the user can no longer see what you are displaying. The system might call onStart() and onStop() multiple times during the entire lifetime of the activity, as the activity alternates between being visible and hidden to the user.\n" +
                        "\n" +
                        "Foreground Lifetime\n" +
                        "The foreground lifetime of an activity happens between the call to onResume() and the call to onPause(). During this time, the activity is in front of all other activities on screen and has user input focus. An activity can frequently transition in and out of the foreground.\n" +
                        "For example, onPause() is called when the device goes to sleep or when a dialog appears. Because this state can transition often, the code in these two methods should be fairly lightweight in order to avoid slow transitions that make the user wait.\n",
                // Topic 6
                "When an activity is paused or stopped, the state of the activity is retained. This is true because the Activity object is still held in memory when it is paused or stopped – all information about its members and current state is still alive. Thus, any changes the user made within the activity are retained so that when the activity returns to the foreground (when it “resumes”), those changes are still there.\n" +
                        " \n" +
                        "However, when the system destroys an activity in order to recover memory, the Activity object is destroyed, so the system cannot simply resume it with its state intact. Instead, the system must recreate the Activity object if the user navigates back to it. Yet, the user is unaware that the system destroyed the activity and recreated it and, thus, probably expects the activity to be exactly as it was. In this situation, you can ensure that important information about the activity state is preserved by implementing an additional callback method that allows you to save information about the state of your activity: onSaveInstanceState().\n",
                // Topic 7
                "The system calls onSaveInstanceState() before making the activity vulnerable to destruction.\n" +
                        "\n" +
                        "The system passes this method a Bundle in which you can save state information about the activity as name-value pairs, using methods such as putString() and putInt(). Then, if the system kills your application process and the user navigates back to your activity, the system recreates the activity and passes the Bundle to both onCreate() and onRestoreInstanceState(). Using either of these methods, you can extract your saved state from the Bundle and restore the activity state. If there is no state information to restore, then the Bundle passed to you is null (which is the case when the activity is created for the first time).",
                // Topic 8
                "A task is a collection of activities that users interact with when performing a certain job. The activities are arranged in a stack (the back stack), in the order in which each activity is opened.\n" +
                        "\n" +
                        "The device Home screen is the starting place for most tasks. When the user touches an icon in the application launcher (or a shortcut on the Home screen), that application's task comes to the foreground. If no task exists for the application (the application has not been used recently), then a new task is created and the \"main\" activity for that application opens as the root activity in the stack.\n" +
                        "\n" +
                        "When the current activity starts another, the new activity is pushed on the top of the stack and takes focus. The previous activity remains in the stack, but is stopped. When an activity stops, the system retains the current state of its user interface. When the user presses the Back button, the current activity is popped from the top of the stack (the activity is destroyed) and the previous activity resumes (the previous state of its UI is restored).\n" +
                        "\n" +
                        "Activities in the stack are never rearranged, only pushed and popped from the stack—pushed onto the stack when started by the current activity and popped off when the user leaves it using the Back button. As such, the back stack operates as a \"last in, first out\" object structure. Figure 1 (next slide) visualizes this behavior with a timeline showing the progress between activities along with the current back stack at each point in time.\n" +
                        "\n" +
                        "If the user continues to press Back, then each activity in the stack is popped off to reveal the previous one, until the user returns to the Home screen (or to whichever activity was running when the task began). When all activities are removed from the stack, the task no longer exists.\n",
                // Topic 9
                "\t1. An Activity is one of the distinguishing features of the Android Framework.\n" +
                        "\n" +
                        "\t2. The Activity Lifecycle consists of the following callback methods\n" +
                        "\t\ta. onCreate()\n" +
                        "\t\tb. onRestart()\n" +
                        "\t\tc. onStart()\n" +
                        "\t\td. onResume()\n" +
                        "\t\te. onPause()\n" +
                        "\t\tf. onStop()\n" +
                        "\t\tg. onDestroy()\n" +
                        "\n" +
                        "\t3. The entire lifetime of an activity happens between the call to onCreate() and the call to onDestroy().\n" +
                        "\n" +
                        "\t4. The visible lifetime of an activity happens between the call to onStart() and the call to onStop().\n" +
                        "\n" +
                        "\t5. The foreground lifetime of an activity happens between the call to onResume() and the call to onPause().\n" +
                        "\n" +
                        "\t6. An Activity can be in the following three states - resume, paused or stopped.\n" +
                        "\n" +
                        "\t7. When an activity is paused or stopped, the state of the activity is retained. This is true because the Activity object is still held in memory when it is paused or stopped – all information about its members and current state is still alive.\n" +
                        "\n" +
                        "\t8. The system calls onSaveInstanceState() before making the activity vulnerable to destruction.The system passes this method a Bundle in which you can save state information about the activity as name-value pairs, using methods such as putString() and putInt(). \n" +
                        "\n" +
                        "\t9. A task is a collection of activities that users interact with when performing a certain job. The activities are arranged in a stack (the back stack), in the order in which each activity is opened. " +
                        "Activities in the stack are never rearranged, only pushed and popped from the stack—pushed onto the stack when started by the current activity and popped off when the user leaves it using the Back button.",

        };

        final String[] youtubeVideoId = {
                "gnIaNU9jI-g",
                "odqACn2Vgic",
                "ecZEMtpw-Gs",
                "jxoG_Y6dvU8",
                "Qs-lGmaMIDk",
                "F7S5QPOEQ3E",
                "ubTyED3ZJVg",
                "m8sf0UkJkxo",
                "pmR1xEqKUCo",

        };

        topicAdapter newTopicAdapter = new topicAdapter(this, topicHeadingLevelOneArray, topicHeadingLevelTwoArray, topicContent);
        listView = (ListView) findViewById(R.id.lv_main);
        listView.setAdapter(newTopicAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TopicActivity.this, topicDetail.class);
                String message = topicHeadingLevelOneArray[position];
                String message2 = topicContent[position];
                String message3 = youtubeVideoId[position];
                intent.putExtra("topic", message);
                intent.putExtra("content", message2);
                intent.putExtra("videoid", message3);
                startActivity(intent);

            }
        });
        Log.d(TAG, "onCreate: ends");

    }
}
