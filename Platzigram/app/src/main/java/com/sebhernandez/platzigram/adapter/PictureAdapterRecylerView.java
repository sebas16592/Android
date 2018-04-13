package com.sebhernandez.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sebhernandez.platzigram.R;
import com.sebhernandez.platzigram.model.Picture;
import com.sebhernandez.platzigram.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PictureAdapterRecylerView extends RecyclerView.Adapter<PictureAdapterRecylerView.PicturViewHolder> {

    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecylerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PicturViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);

        return new PicturViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PicturViewHolder holder, int position) {
        final Picture picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUsername());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                intent.putExtra("photo",picture);

                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new  Explode();

                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity,view,activity.getString(R.string.transitionname_picture)).toBundle());
                }else{
                    activity.startActivity(intent);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PicturViewHolder extends RecyclerView.ViewHolder {

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        public PicturViewHolder(View itemView) {
            super(itemView);
            pictureCard = (ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard = (TextView) itemView.findViewById(R.id.userNameCard);
            timeCard = (TextView) itemView.findViewById(R.id.timeCard);
            likeNumberCard = (TextView) itemView.findViewById(R.id.likeNumberCard);

        }
    }
}
