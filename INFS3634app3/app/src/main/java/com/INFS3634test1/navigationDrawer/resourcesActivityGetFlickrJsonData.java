package com.INFS3634test1.navigationDrawer;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class resourcesActivityGetFlickrJsonData extends AsyncTask<String, Void, List<resourcesActivityPhoto>> implements resourcesActivityGetRawData.OnDownloadComplete {
    private static final String TAG = "GetFlickrJsonData";

    private List<resourcesActivityPhoto> mPhotoList = null;
    private String mBaseURL;
    private String mLanguage;
    private boolean mMatchAll;
    private boolean runningOnSameThread = false;

    private final OnDataAvailable mCallBack;

    interface OnDataAvailable{
        void onDataAvailable(List<resourcesActivityPhoto> data, DownloadedStatus status);
    }

    public resourcesActivityGetFlickrJsonData(OnDataAvailable callBack, String baseURL, String language,boolean matchAll) {
        Log.d(TAG, "GetFlickrJsonData: called");
        mBaseURL = baseURL;
        mLanguage = language;
        mMatchAll = matchAll;
        mCallBack = callBack;

    }

    @Override
    protected void onPostExecute(List<resourcesActivityPhoto> resourcesActivityPhotos) {
        Log.d(TAG, "onPostExecute: starts");
        super.onPostExecute(resourcesActivityPhotos);

        if(mCallBack != null){
            mCallBack.onDataAvailable(mPhotoList, DownloadedStatus.OK);
        }
        Log.d(TAG, "onPostExecute: ends");
    }

    @Override
    protected List<resourcesActivityPhoto> doInBackground(String... params) {
        Log.d(TAG, "doInBackground: ");
        String destinationUri = createUri(params[0], mLanguage, mMatchAll);

        resourcesActivityGetRawData getRawData = new resourcesActivityGetRawData(this);
        getRawData.runInSameThread(destinationUri);
        Log.d(TAG, "doInBackground: ends");
        return mPhotoList;
    }

    public void executeOnSameThread(String searchCriteria){
        Log.d(TAG, "executeOnSameThread: starts!");
        String desinationUri = createUri(searchCriteria, mLanguage, mMatchAll);
        runningOnSameThread = true;
        resourcesActivityGetRawData getRawData = new resourcesActivityGetRawData(this);
        getRawData.execute(desinationUri);
        Log.d(TAG, "executeOnSameThread: ends!");
    }

    private String createUri(String searchCriteria, String lang, boolean matchAll){
        Log.d(TAG, "createUri: starts");

        return Uri.parse(mBaseURL).buildUpon()
                .appendQueryParameter("tags", searchCriteria)
                .appendQueryParameter("tagmode", matchAll ? "ALL" : "ANY")
                .appendQueryParameter("lang", lang)
                .appendQueryParameter("format", "json")
                .appendQueryParameter("nojsoncallback", "1")
                .build().toString();
    }

    @Override
    public void onDownloadComplete(String data, DownloadedStatus status) {
        Log.d(TAG, "onDownloadComplete: starts. Satus = " + status);

        if(status == DownloadedStatus.OK){
            mPhotoList = new ArrayList<>();
            try {
                JSONObject jsonData = new JSONObject(data);
                JSONArray itemsArray = jsonData.getJSONArray("items");

                for(int i=0; i<itemsArray.length(); i++){
                    JSONObject jsonPhoto = itemsArray.getJSONObject(i);
                    String title = jsonPhoto.getString("title");
                    String author = jsonPhoto.getString("author");
                    String authorId = jsonPhoto.getString("author_id");
                    String tags = jsonPhoto.getString("tags");

                    JSONObject jsonMedia = jsonPhoto.getJSONObject("media");
                    String photoUrl = jsonMedia.getString("m");

                    String link = photoUrl.replaceFirst("_m.", "_b.");

                    resourcesActivityPhoto photoObject = new resourcesActivityPhoto(title, author, authorId, link, tags, photoUrl);
                    mPhotoList.add(photoObject);

                    Log.d(TAG, "onDownloadComplete: " + photoObject.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(TAG, "onDownloadComplete: Error processing Json data" + e.getMessage() );
                status = DownloadedStatus.FAILED;
            }
        }

        if(runningOnSameThread && mCallBack != null){
            mCallBack.onDataAvailable(mPhotoList,status);
     }

        Log.d(TAG, "onDownloadComplete: ends");
    }
}
