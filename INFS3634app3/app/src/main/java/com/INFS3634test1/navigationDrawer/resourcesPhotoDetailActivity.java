package com.INFS3634test1.navigationDrawer;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.INFS3634test1.R;
import com.squareup.picasso.Picasso;

import static com.INFS3634test1.navigationDrawer.NavigationDrawerBaseActivity.PHOTO_TRANSFER;


public class resourcesPhotoDetailActivity extends NavigationDrawerBaseActivity {
    @Override public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START))
//            drawer.closeDrawer(GravityCompat.START);
        Intent intent = new Intent(resourcesPhotoDetailActivity.this, ResourcesActivity.class);
        finish();
        Log.i(TAG_N, "Back button pressed.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resources_activity_photodetail);

        appBarTxt.setText("Visual Resources");

        Intent intent = getIntent();
        resourcesActivityPhoto photo = (resourcesActivityPhoto) intent.getSerializableExtra(PHOTO_TRANSFER);
        if(photo != null){
            TextView photoTitle = (TextView) findViewById(R.id.photoTitle);
            photoTitle.setText("Title: " + photo.getTitle());

            TextView photoAuthor = (TextView) findViewById(R.id.photoAuthor);
            photoAuthor.setText("Author: " + photo.getAuthor());

            TextView photoTag = (TextView) findViewById(R.id.photoTag);
            photoTag.setText("Tags: " + photo.getTags());

            ImageView photoImage = (ImageView) findViewById(R.id.photoImage);
            Picasso.get().load(photo.getLink())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(photoImage);
        }
    }
}
