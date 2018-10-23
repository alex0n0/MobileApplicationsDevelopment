package com.example.android.app_name;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class customSearchActivity extends AppCompatActivity {

    private EditText userInput;
    private Button button;
    // private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private TextView textView;
    Gson gson = new Gson();

    private static final String TAG = "customSearchActivity";
    static String result = null;
    Integer responseCode = null;
    String responseMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_search);

        // Connecting our views to the xml
        userInput = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.buttonCustomSearch);
        // recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        textView = (TextView) findViewById(R.id.result);


        // What happens when button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // hide keyboard
                InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                // Getting userInput and changing it to a string
                String searchString = userInput.getText().toString().replace(" ", "+");

                // API key
                String key="AIzaSyA2qt3Fnfp-sBq2ITaZpV4Qc0m5pIjPAgo";

                // Search Engine ID
                String cx = "013687627485596005068:cjr-zowyv3o";

                // Creating the URL we send the request to
                String urlString = String.format("https://www.googleapis.com/customsearch/v1?q=" +
                        searchString + "&key=" + key + "&cx=" + cx + "&alt=json");

                URL url = null;
                try {
                    url = new URL(urlString);
                } catch (MalformedURLException e) {
                    Log.e(TAG, "ERROR converting String to URL " + e.toString());
                }
                Log.d(TAG, "Url = "+  urlString);

                // start AsyncTask
                GoogleSearchAsyncTask searchTask = new GoogleSearchAsyncTask();
                searchTask.execute(url);

            }
        });
    }

    private class GoogleSearchAsyncTask extends AsyncTask<URL, Integer, String> {

        protected void onPreExecute(){
            Log.d(TAG, "AsyncTask - onPreExecute");
            // show progressbar
            progressBar.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(URL... urls) {

            URL url = urls[0];
            Log.d(TAG, "AsyncTask - doInBackground, url=" + url);

            // Http connection
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
            } catch (IOException e) {
                Log.e(TAG, "Http connection ERROR " + e.toString());
            }


            try {
                responseCode = conn.getResponseCode();
                responseMessage = conn.getResponseMessage();
            } catch (IOException e) {
                Log.e(TAG, "Http getting response code ERROR " + e.toString());
            }

            Log.d(TAG, "Http response code =" + responseCode + " message=" + responseMessage);

            try {

                if(responseCode == 200) {

                    // response OK

                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                 //   searchResult results = new Gson().fromJson(rd, searchResult.class);
                   StringBuilder sb = new StringBuilder();
                   String line;

                   while ((line = rd.readLine()) != null) {
                       sb.append(line + "\n");
                       //sb.append(results.getLink() + "\n");
                   }
                    rd.close();

                    conn.disconnect();

                    result = sb.toString();

                    //result = results.getLink();

                    Log.d(TAG, "result=" + result);

                    return result;

                }else{

                    // response problem

                    String errorMsg = "Http ERROR response " + responseMessage + "\n";
                    Log.e(TAG, errorMsg);
                    result = errorMsg;
                    return  result;

                }
            } catch (IOException e) {
                Log.e(TAG, "Http Response ERROR " + e.toString());
            }
            return null;
        }

        protected void onProgressUpdate(Integer... progress) {
            Log.d(TAG, "AsyncTask - onProgressUpdate, progress=" + progress);

        }

        protected void onPostExecute(String result) {

            Log.d(TAG, "AsyncTask - onPostExecute, result=" + result);

            // hide progressbar
            progressBar.setVisibility(View.GONE);

            // make TextView scrollable
            textView.setMovementMethod(new ScrollingMovementMethod());

            // show result


            //searchResult SR = gson.fromJson(result, searchResult.class);
           //System.out.println(SR);

            textView.setText(result);
            //textView.setText(SR.getTitle());
        }
    }
}
