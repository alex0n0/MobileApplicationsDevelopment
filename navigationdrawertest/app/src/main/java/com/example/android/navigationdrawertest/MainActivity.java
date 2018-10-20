package com.example.android.navigationdrawertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.support.v4.view.GravityCompat;
import android.view.View;
import android.content.Intent;

import android.support.v4.app.FragmentTransaction;



public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //loading initial fragment
        if (findViewById(R.id.fragment_frame) != null) {

            if (savedInstanceState != null) {
                return;
            }

            Activity2 activity2Fragment = new Activity2();

            activity2Fragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_frame, activity2Fragment)
                    .commit();
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        //switching fragments
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        Bundle args = new Bundle();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        switch (menuItem.getItemId()) {
                            case R.id.activity2:
                                Activity2 activity2Fragment = new Activity2();

                                activity2Fragment.setArguments(args);

                                transaction.replace(R.id.fragment_frame, activity2Fragment);
                                transaction.addToBackStack(null);

                                transaction.commit();
                                break;
                            case R.id.activity3:
                                Activity3 activity3Fragment = new Activity3();

                                activity3Fragment.setArguments(args);

                                transaction.replace(R.id.fragment_frame, activity3Fragment);
                                transaction.addToBackStack(null);

                                transaction.commit();
                                break;
                            case R.id.activity4:
                                Activity4 activity4Fragment = new Activity4();

                                activity4Fragment.setArguments(args);

                                transaction.replace(R.id.fragment_frame, activity4Fragment);
                                transaction.addToBackStack(null);

                                transaction.commit();
                                break;
                            case R.id.activity5:
                                Activity5 activity5Fragment = new Activity5();

                                activity5Fragment.setArguments(args);

                                transaction.replace(R.id.fragment_frame, activity5Fragment);
                                transaction.addToBackStack(null);

                                transaction.commit();
                                break;
                        }

                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {

                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {

                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {

                    }
                });




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
