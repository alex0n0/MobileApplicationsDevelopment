package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.util.Log;

import com.INFS3634test1.R;

public class ResourcesActivity extends NavigationDrawerBaseActivity  {

    private static final String TAG = "ResourcesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ResourceActivity starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resources_activity);
        appBarTxt.setText("Visual Resources");

        resourcesActivityGetRawData getRawData = new resourcesActivityGetRawData();
        getRawData.execute("https://api.flickr.com/services/feeds/photos_public.gne?tags=android,nougat&format=json&nojsoncallback=1");

        Log.d(TAG, "onCreate: end");
    }


}
