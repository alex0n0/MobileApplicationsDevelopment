package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;

import com.INFS3634test1.R;




public class SearchActivity extends NavigationDrawerBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        appBarTxt.setText("Search Engine");
    }



}


