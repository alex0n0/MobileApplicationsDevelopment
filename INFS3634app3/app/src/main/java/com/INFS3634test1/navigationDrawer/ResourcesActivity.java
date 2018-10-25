package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.INFS3634test1.R;

import java.util.List;

public class ResourcesActivity extends NavigationDrawerBaseActivity implements resourcesActivityGetFlickrJsonData.OnDataAvailable {

    private static final String TAG = "ResourcesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ResourceActivity starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resources_activity);
        appBarTxt.setText("Visual Resources");

       // resourcesActivityGetRawData getRawData = new resourcesActivityGetRawData(this);
       // getRawData.execute("https://api.flickr.com/services/feeds/photos_public.gne?tags=android,nougat&format=json&nojsoncallback=1");

        Log.d(TAG, "onCreate: end");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: starts");
        super.onResume();
        resourcesActivityGetFlickrJsonData getFlickrJsonData = new resourcesActivityGetFlickrJsonData(this,"https://api.flickr.com/services/feeds/photos_public.gne?", "en-us", true);
        getFlickrJsonData.execute("android, nougat");
        Log.d(TAG, "onResume: ends");
    }


    @Override
    public void onDataAvailable(List<resourcesActivityPhoto> data, DownloadedStatus status){
        if(status == DownloadedStatus.OK){
            Log.d(TAG, "onDataAvailable: data is " + data);
        } else {
            // download or processing failed
            Log.e(TAG, "onDataAvailable: failed with status " + status);
        }
    }

}
