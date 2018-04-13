package com.sebhernandez.platzigram.view;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sebhernandez.platzigram.R;
import com.sebhernandez.platzigram.model.Picture;
import com.squareup.picasso.Picasso;

public class PictureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar("",true);

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().setEnterTransition(new Fade());
        }else{

        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);

        Picture picture = (Picture) getIntent().getExtras().getSerializable("photo");
        Toast toast=Toast.makeText(this,picture.getUsername(),Toast.LENGTH_SHORT);
        toast.show();
        TextView user = (TextView) findViewById(R.id.usernameDetail);
        user.setText(picture.getUsername());
        ImageView imagen = (ImageView) findViewById(R.id.imageHeader);
        Picasso.with(this).load(picture.getPicture()).into(imagen);



    }

    public void showToolbar(String tittle,boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

    }

}
