package com.example.android.navigationdrawertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

public class Activity5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.activity_2, container, false);

        View view =  inflater.inflate(R.layout.activity_5, container, false);
        TextView activity_5_tv1 = (TextView) view.findViewById(R.id.activity_5_tv1);
        activity_5_tv1.setText("fragment: activity 5");
        return view;
    }
}
