package com.INFS3634test1.navigationDrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.INFS3634test1.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class topicDetail extends NavigationDrawerBaseActivity implements YouTubePlayer.OnInitializedListener {

    TextView textView;
    TextView textView2;
    YouTubePlayer player2;
    YouTubePlayerFragment playerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity_detailactivity);
        Button buttonBack = findViewById(R.id.button7);

        String savedExtra = getIntent().getStringExtra("topic");
        String savedExtra2 = getIntent().getStringExtra("content");

        textView = findViewById(R.id.title_TV);
        textView.setText(savedExtra);

        textView2 = findViewById(R.id.BlockText);
        textView2.setText(savedExtra2);
        textView2.setMovementMethod(new ScrollingMovementMethod());
        playerFragment = (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.VideoFragment2);
        playerFragment.initialize("AIzaSyCKpiQ1Il2s-AgIe3441uiHA_xPMJP6wjU", this);

        buttonBack.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                Intent intent = new Intent(topicDetail.this,TopicActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onInitializationSuccess
            (YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        String savedExtra3 = getIntent().getStringExtra("videoid");
        player2 = youTubePlayer;
        player2.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT); //CHECK THIS.
        //Log.e(TAG, "Initialized youtube player");
        youTubePlayer.cueVideo(savedExtra3);
    }

    @Override
    public void onInitializationFailure
            (YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        // Log.e(TAG, "Failed to initialize youtube player");
    }
}