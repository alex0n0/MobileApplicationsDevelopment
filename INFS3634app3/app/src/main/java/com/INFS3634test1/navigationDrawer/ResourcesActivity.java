package com.INFS3634test1.navigationDrawer;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.INFS3634test1.R;

import java.util.ArrayList;
import java.util.List;

public class ResourcesActivity extends NavigationDrawerBaseActivity implements resourcesActivityGetFlickrJsonData.OnDataAvailable,
        resourcesRecyclerItemOnClickListener.onRecyclerClickerListener {

    private static final String TAG = "ResourcesActivity";
    private resourcesRecyclerViewAdaper mResourcesRecyclerViewAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ResourceActivity starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resources_activity);
        appBarTxt.setText("Visual Resources");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.resources_RV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(new resourcesRecyclerItemOnClickListener(this, recyclerView, this));

        mResourcesRecyclerViewAdaper = new resourcesRecyclerViewAdaper(new ArrayList<resourcesActivityPhoto>(), this);
        recyclerView.setAdapter(mResourcesRecyclerViewAdaper);

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
        Log.d(TAG, "onDataAvailable: start");
        if(status == DownloadedStatus.OK){
            mResourcesRecyclerViewAdaper.loadNewData(data);
        } else {
            // download or processing failed
            Log.e(TAG, "onDataAvailable: failed with status " + status);
        }
        Log.d(TAG, "onDataAvailable: finished");
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d(TAG, "onItemClick: starts");
        Toast.makeText(ResourcesActivity.this, "Normal tap at position " + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Log.d(TAG, "onItemLongClick: starts");
        Toast.makeText(ResourcesActivity.this, "Long tap at position " + position, Toast.LENGTH_SHORT).show();

    }
}
