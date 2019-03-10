package com.example.gameapp.app.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameapp.app.R;
import com.squareup.picasso.Picasso;


public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_gallery);

        getIncomingIntent();
    }

    private void getIncomingIntent(){


        if(getIntent().hasExtra("game_image_url") && getIntent().hasExtra("game_name")){


            String imageUrl = getIntent().getStringExtra("game_image_url");
            String imageName = getIntent().getStringExtra("game_name");
            String releaseDate = getIntent().getStringExtra("game_release_date");
            String developerUrl = getIntent().getStringExtra("game_developer");
            String priceUrl = getIntent().getStringExtra("game_price");
            String discountPriceUrl = getIntent().getStringExtra("game_discount_price");

            setImage(imageUrl, imageName,releaseDate,developerUrl,priceUrl,discountPriceUrl);
        }
    }

    private void setImage(String imageUrl, String imageName,String releaseDate,String developerUrl,String priceUrl,String discountPriceUrl){


        TextView name = findViewById(R.id.name);
        name.setText(imageName);

        TextView release = findViewById(R.id.releaseDate);
        release.setText(releaseDate);

        TextView developer = findViewById(R.id.developer);
        developer.setText(developerUrl);

        TextView price = findViewById(R.id.price);
        price.setText(priceUrl);

        TextView discountPrice = findViewById(R.id.discountPrice);
        discountPrice.setText(discountPriceUrl);

        ImageView image = findViewById(R.id.imageGame);
        Picasso.get().load(imageUrl).into(image);

    }

}
