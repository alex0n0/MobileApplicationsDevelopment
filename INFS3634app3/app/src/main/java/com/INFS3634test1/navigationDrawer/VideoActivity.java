package com.INFS3634test1.navigationDrawer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.INFS3634test1.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;
import java.util.List;

public class VideoActivity extends NavigationDrawerBaseActivity implements YouTubeThumbnailView.OnInitializedListener, YouTubeThumbnailLoader.OnThumbnailLoadedListener, YouTubePlayer.OnInitializedListener {

    private static final String TAG_Y = "Youtube";
    List<Drawable> thumbnailList;
    List<String> VideoId;
    YouTubePlayerFragment playerFragment;
    YouTubePlayer Player;
    YouTubeThumbnailView thumbnailView;
    YouTubeThumbnailLoader thumbnailLoader;
    RecyclerView playlist;
    RecyclerView.Adapter adapter;
    String API_KEY = "AIzaSyCKpiQ1Il2s-AgIe3441uiHA_xPMJP6wjU";
    String PLAYLIST_ID = "PLRqstEMoLSjeepVkOUgUgG3A9jyPJl2wV";




    @Override
    protected void onCreate(Bundle savedInstanceState) { //This method links the different views to the XML files.
        super.onCreate(savedInstanceState);              //It links the adapter to display in the recycler view.
        setContentView(R.layout.video_activity);
       // Button backButton = findViewById(R.id.button6);
        appBarTxt.setText("Learning Videos");             //Layout managers are provisioned to control the recycler view sizing.
        thumbnailList = new ArrayList<>();              //Fragment is used to hold the player, with the API key used to access the video and thumbnail information.
        VideoId = new ArrayList<>();
        Log.i(TAG_Y, "Array lists are made.");
        playlist = findViewById(R.id.VideoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        playlist.setLayoutManager(layoutManager);
        Log.i(TAG_Y, "Playlist is made.");
        adapter = new VideoListAdapter();
        playlist.setAdapter(adapter);
        Log.i(TAG_Y, "Adapters are made.");
        thumbnailView = new YouTubeThumbnailView(this);
        thumbnailView.initialize(API_KEY, this);
        Log.i(TAG_Y, "Thumbnail views made.");
        playerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.VideoFragment);
        playerFragment.initialize(API_KEY, this);
        Log.i(TAG_Y, "Player fragment made.");

     /** backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VideoActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }); **/
    }


    @Override //This method sets the playlist identified by the playlist ID to the thumbnail loader.
    public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

        thumbnailLoader = youTubeThumbnailLoader;
        youTubeThumbnailLoader.setOnThumbnailLoadedListener(VideoActivity.this);
        thumbnailLoader.setPlaylist(PLAYLIST_ID);
        Log.i(TAG_Y, "Playlist assigned");
    }

    @Override //Method in case of failed initialization of the thumbnail display.
    public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {

        Toast toast1 = Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_LONG);
        toast1.show();
        Log.e(TAG_Y, "Toast displayed from error.");
    }


    public void add() { //The adapter will notify of any changes to the data set and the thumbnail loader will keep loading the next item until the end of the list.
        adapter.notifyDataSetChanged();
        if (thumbnailLoader.hasNext())
            thumbnailLoader.next();
        Log.i(TAG_Y, "Traversing through data.");
    }


    @Override
    //Once the thumbnail is downloaded, it adds it to an array list that can take drawables (images) and then assigns it a position in the other array list.
    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
        thumbnailList.add(youTubeThumbnailView.getDrawable());
        VideoId.add(s);
        add();
        Log.i(TAG_Y, "Thumbnails are being added in.");

    }

    @Override //Method in case of failed thumbnail download, releases the loader.
    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

        thumbnailLoader.release();
        Log.e(TAG_Y, "Thumbnail loader released from error.");
    }

    @Override
    //Once initialized, create the player for the videos. Listen for fullscreen button press.
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Player = youTubePlayer;
        Player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT); //CHECK THIS.
        Player.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
            @Override
            public void onFullscreen(boolean b) {
                playlist.setVisibility(b ? View.GONE : View.VISIBLE); //This is to hide the view when the screen goes fullscreen.
            }
        });
        Log.i(TAG_Y, "Player is made and set.");
    }

    @Override //Method in case of failed initialization for the YouTube player.
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        Log.e(TAG_Y, "Player failed to initialize.");
    }

    public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.MyView> { //This is the adapter to populate the recycler view.

        public class MyView extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView textview;

            public MyView(View itemView) { //Shows the array list to the imageview and textviews to display the data.
                super(itemView);
                imageView = itemView.findViewById(R.id.thumbnailView);
                textview = itemView.findViewById(R.id.description);
                //textview.setText("hi");

                Log.i(TAG_Y, "Views set.");

            }

        }

        @Override
        //Creates a viewholder which is used for the adapter to remember the views so it doesn't have to call FindViewById, saving heaps of performance.
        public VideoListAdapter.MyView onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_row, parent, false);
            return new MyView(itemView);

        }


        @Override
        //This binds it to our view holder to the adapter so data can be passed. The video at the position that is clicked will be cued to the player.
        public void onBindViewHolder(VideoListAdapter.MyView holder, final int position) {
            holder.imageView.setImageDrawable(thumbnailList.get(position));
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Player.cueVideo(VideoId.get(position));
                    Log.i(TAG_Y, "Video cued.");
                }
            });

        }

        @Override //Returns the size of the array that will be displayed in the list view.
        public int getItemCount() {
            Log.i(TAG_Y, "Array list size returned.");
            return thumbnailList.size();

        }

        public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START))
//            drawer.closeDrawer(GravityCompat.START);
            startActivity(new Intent(VideoActivity.this, HomeActivity.class));
            finish();
            Log.i(TAG_N, "Back button pressed.");
        }

    }
}
