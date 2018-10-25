package com.INFS3634test1.navigationDrawer;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

enum DownloadedStatus {IDLE, PROCESSING, NOT_STARTED, FAILED, OK}

public class resourcesActivityGetRawData extends AsyncTask<String, Void, String> {
    private static final String TAG = "resourcesActivityGetRaw";

    private final OnDownloadComplete mCallback;
    private DownloadedStatus mDownloadedStatus;
    interface OnDownloadComplete {
        void onDownloadComplete(String data, DownloadedStatus status);
    }

    public resourcesActivityGetRawData(OnDownloadComplete callback) {
        this.mDownloadedStatus = DownloadedStatus.IDLE;
        mCallback = callback;
    }

    void runInSameThread(String s){
        Log.d(TAG, "runInSameThread: starts");
        // onPostExecute(doInBackground(s));

        if(mCallback != null){
            String result = doInBackground(s);
            mCallback.onDownloadComplete(result,mDownloadedStatus);
        }

        Log.d(TAG, "runInSameThread: ends");
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d(TAG, "onPostExecute: paramenter = " + s);
        if(mCallback != null){
            mCallback.onDownloadComplete(s, mDownloadedStatus);
        }
        Log.d(TAG, "onPostExecute: ends");
    }

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        // Checking if the URL parsed is null
        if(strings == null){
            mDownloadedStatus = DownloadedStatus.NOT_STARTED;
            return null;
        }

        try{
            mDownloadedStatus = DownloadedStatus.PROCESSING;
            URL url = new URL(strings[0]);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int response = connection.getResponseCode();
            Log.d(TAG, "doInBackground: The response code was " + response);

            StringBuilder result = new StringBuilder();

            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));


            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                result.append(line).append("\n");
            }

            mDownloadedStatus = DownloadedStatus.OK;
            return result.toString();

        } catch (MalformedURLException e){
            Log.e(TAG, "doInBackground: Invalid URL " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "doInBackground: IO Exeception reading data: " + e.getMessage());
        } catch (SecurityException e){
            Log.e(TAG, "doInBackground: Security Exception. Needs permissions?" + e.getMessage());
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    Log.e(TAG, "doInBackground: Error closing stream " + e.getMessage());
                }
            }
        }

        mDownloadedStatus = DownloadedStatus.FAILED;

        return null;
    }

}
