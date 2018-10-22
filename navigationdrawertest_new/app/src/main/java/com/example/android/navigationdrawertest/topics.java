package com.example.android.navigationdrawertest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

public class topics extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.home_layout, container, false);

        View view =  inflater.inflate(R.layout.topics_layout, container, false);
        TextView activity_3_tv1 = (TextView) view.findViewById(R.id.activity_3_tv1);
        activity_3_tv1.setText("fragment: activity 3");
        return view;
    }
}
