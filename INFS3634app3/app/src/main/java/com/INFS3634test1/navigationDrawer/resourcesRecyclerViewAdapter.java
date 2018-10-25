package com.INFS3634test1.navigationDrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.INFS3634test1.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class resourcesRecyclerViewAdapter extends RecyclerView.Adapter<resourcesRecyclerViewAdapter.FlickrImageViewHolder> {
    private static final String TAG = "resourcesRecyclerViewAd";
    private List<resourcesActivityPhoto> mPhotosList;
    private Context mContext;

    public resourcesRecyclerViewAdapter(List<resourcesActivityPhoto> photosList, Context context) {
        mPhotosList = photosList;
        mContext = context;
    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Called by the layout manager when it needs a new view
        Log.d(TAG, "onCreateViewHolder: new view requested");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resources_activity_recyclerview_item, parent, false); // where is the layout brows from???
        return new FlickrImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder holder, int position) {
        // Called by the layout manager when it wants new data in an existing row

        resourcesActivityPhoto photoItem = mPhotosList.get(position);
        Log.d(TAG, "onBindViewHolder: " + photoItem.getTitle() + "-->" + position);
        Picasso.get().load(photoItem.getImage())
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.resourceThumbnail);

        holder.resourceTitle.setText(photoItem.getTitle());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: called");
        return ((mPhotosList != null) && (mPhotosList.size() !=0) ? mPhotosList.size() : 0);
    }

    void loadNewData(List<resourcesActivityPhoto> newPhotos){
        mPhotosList = newPhotos;
        notifyDataSetChanged();
    }

    public resourcesActivityPhoto getPhoto(int position){
        return((mPhotosList != null) && (mPhotosList.size() !=0) ? mPhotosList.get(position) : null);
    }


    static class FlickrImageViewHolder extends RecyclerView.ViewHolder{
        private static final String TAG = "FlickrImageViewHolder";
        ImageView resourceThumbnail = null;
        TextView resourceTitle = null;

        public FlickrImageViewHolder(View itemView){
            super(itemView);
            Log.d(TAG, "FlickrImageViewHolder: ");
            this.resourceThumbnail = (ImageView) itemView.findViewById(R.id.resourceThumbnail);
            this.resourceTitle = (TextView) itemView.findViewById(R.id.resourceTitle);
        }
    }
}
