package com.INFS3634test1.navigationDrawer;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class resourcesRecyclerItemOnClickListener extends RecyclerView.SimpleOnItemTouchListener {
    private static final String TAG = "resourcesRecyclerItemOn";

    interface onRecyclerClickerListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private final onRecyclerClickerListener mListener;
    private final GestureDetectorCompat mGestureDetectorCompat;

    public resourcesRecyclerItemOnClickListener(Context context, final RecyclerView recyclerView, onRecyclerClickerListener listener) {
        mListener = listener;
        mGestureDetectorCompat = null;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Log.d(TAG, "onInterceptTouchEvent: starts");
        if(mGestureDetectorCompat != null){

        }
        return true;
    }
}
