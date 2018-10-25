package com.INFS3634test1.navigationDrawer;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.INFS3634test1.R;

public class QuizSelectionAdapter extends ArrayAdapter {

    //to reference the Activity
    private final Activity context;

    //to store the list of Topic Level 1 heading
    private final String[] topicHeadingLevelOneArray;

    //to store the list of countries
    private final String[] topicHeadingLevelTwoArray;



    public QuizSelectionAdapter(Activity context, String[] topicHeadingLevelOneArray, String[] topicHeadingLevelTwoArray) {

        super(context, R.layout.listview_selection_item, topicHeadingLevelOneArray);

        this.context = context;
        this.topicHeadingLevelOneArray = topicHeadingLevelOneArray;
        this.topicHeadingLevelTwoArray = topicHeadingLevelTwoArray;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_selection_item, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView topicTV = (TextView) rowView.findViewById(R.id.tv_selection_topic);
        TextView line2TV = (TextView) rowView.findViewById(R.id.tv_selection_details);

        //this code sets the values of the objects to values from the arrays
        topicTV.setText(topicHeadingLevelOneArray[position]);
        line2TV.setText(topicHeadingLevelTwoArray[position]);

        return rowView;
    };
}
