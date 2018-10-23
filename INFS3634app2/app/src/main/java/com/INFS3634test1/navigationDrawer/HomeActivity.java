package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;

import com.INFS3634test1.R;


public class HomeActivity extends NavigationDrawerBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        appBarTxt.setText("Home");
    }


}
