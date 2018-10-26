package com.INFS3634test1.navigationDrawer;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.INFS3634test1.R;

public class topicAdapter extends ArrayAdapter {

    private static final String TAG = "topicAdapter";

    //to reference the Activity
    private final Activity context;

    //to store the list of Topic Level 1 heading
    private final String[] topicHeadingLevelOneArray;

    //to store the list of Topic Level 2 Headings
    private final String[] topicHeadingLevelTwoArray;

    //to store the list of Content for each module
    private final String[] topicContent;



    //public topicAdapter(Activity context, String[] topicHeadingLevelOneArray, String[] topicHeadingLevelTwoArray) {

       // super(context, R.layout.topic_activity_listview_row, topicHeadingLevelOneArray);

       // this.context = context;
       // this.topicHeadingLevelOneArray = topicHeadingLevelOneArray;
       // this.topicHeadingLevelTwoArray = topicHeadingLevelTwoArray;

   // }

    public topicAdapter(Activity context, String[] topicHeadingLevelOneArray, String[] topicHeadingLevelTwoArray,
                        String[] topicContent) {

        super(context, R.layout.topic_activity_listview_row, topicHeadingLevelOneArray);

        this.context = context;
        this.topicHeadingLevelOneArray = topicHeadingLevelOneArray;
        this.topicHeadingLevelTwoArray = topicHeadingLevelTwoArray;
        this.topicContent = topicContent;

        Log.d(TAG, "topicAdapter: ends");

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.topic_activity_listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView topicTV = (TextView) rowView.findViewById(R.id.topicTV);
        TextView line2TV = (TextView) rowView.findViewById(R.id.line2TV);

        //this code sets the values of the objects to values from the arrays
        topicTV.setText(topicHeadingLevelOneArray[position]);
        line2TV.setText(topicHeadingLevelTwoArray[position]);

        return rowView;

    };
}
