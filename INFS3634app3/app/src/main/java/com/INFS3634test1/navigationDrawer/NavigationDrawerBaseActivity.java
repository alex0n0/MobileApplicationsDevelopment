package com.INFS3634test1.navigationDrawer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.INFS3634test1.R;


public class NavigationDrawerBaseActivity extends AppCompatActivity {

    public static final String TAG_N = "Navigation";
    public TextView appBarTxt;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private float lastTranslate = 0.0f;
    private ImageView imgLeftToolbar;
    private boolean isOpenOrClose = false;
    private ActionBarDrawerToggle drawerToggle;
    static final String PHOTO_TRANSFER = "PHOTO_TRANSFER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override public void onBackPressed() { //When back is pressed, takes user back to the home activity.
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent(NavigationDrawerBaseActivity.this, HomeActivity.class));
        finish();
        Log.i(TAG_N, "Back button pressed.");

    }

    @Override
    public void setContentView(int layout) { //This constructs the navigation drawer and its functions.

        View parentView = LayoutInflater.from(NavigationDrawerBaseActivity.this).inflate(R.layout.activity_main, null);
        FrameLayout frame = (FrameLayout) parentView.findViewById(R.id.frame);
        getLayoutInflater().inflate(layout, frame, true);
        super.setContentView(parentView);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appBarTxt = (TextView) findViewById(R.id.app_bar_txt);
        imgLeftToolbar = (ImageView) findViewById(R.id.img_left_toolbar); //Connects the different xml layouts to each item of the navigation.
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setUpNavigationView();

        Log.i(TAG_N, "Navigation views set.");
        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open_drawer, R.string.close_drawer) {
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float moveFactor = (drawerView.getWidth() * slideOffset);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                    findViewById(R.id.app_bar_main_layout).setTranslationX(moveFactor);
                } else {
                    TranslateAnimation anim = new TranslateAnimation(lastTranslate, moveFactor, 0.0f, 0.0f);
                    anim.setDuration(0); //This section is to make the transition of the drawer smooth instead of snappy.
                    anim.setFillAfter(true);
                    findViewById(R.id.app_bar_main_layout).startAnimation(anim);
                    lastTranslate = moveFactor;
                    Log.i(TAG_N, "Drawer transition set.");
                }
            }
        };

        drawer.setDrawerListener(drawerToggle); //Allows the drawer to toggle and stay.

        imgLeftToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpenOrClose)
                    drawer.closeDrawers();
                else
                    drawer.openDrawer(GravityCompat.START);
                drawer.setDrawerListener(drawerToggle);
                Log.i(TAG_N, "Drawer movement onclicks set.");
            }
        });

        drawer.setDrawerListener(new DrawerLayout.DrawerListener() { //These are the methods for drawer movement.
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View view) {
                isOpenOrClose = true;

            }

            @Override
            public void onDrawerClosed(View view) {
                isOpenOrClose = false;

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }


        });
        Log.i(TAG_N, "Drawer methods set.");
    }


    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) { //This entire section is for switching activities with intents on item press.
                switch (menuItem.getItemId()) {                         //It runs a switch which identifies which item was pressed which triggers a respective intent.
                    case R.id.nav_home:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, HomeActivity.class));
                        finish();
                        break;

                    case R.id.nav_topic:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, TopicActivity.class));
                        finish();
                        break;

                    case R.id.nav_video:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, VideoActivity.class));
                        finish();
                        break;

                    case R.id.nav_quiz:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, QuizSelectionActivity.class));
                        finish();
                        break;

                    case R.id.nav_resources:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, ResourcesActivity.class));
                        finish();
                        break;

                    case R.id.nav_search:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, SearchActivity.class));
                        finish();
                        break;

                    default:
                        startActivity(new Intent(NavigationDrawerBaseActivity.this, HomeActivity.class));
                        finish();
                }
                Log.i(TAG_N, "Drawer item intents set.");

                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                return true;
            }
        });
                Log.i(TAG_N, "Navigation drawer base activity complete.");
    }

}
