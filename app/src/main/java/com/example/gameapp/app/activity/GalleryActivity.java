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

            String game_platform_name_0 = getIntent().getStringExtra("game_platform_name_0");
            String game_platform_name_1 = getIntent().getStringExtra("game_platform_name_1");
            String game_platform_name_2 = getIntent().getStringExtra("game_platform_name_2");
            String game_platform_name_3 = getIntent().getStringExtra("game_platform_name_3");

            String game_platform_number_0 = getIntent().getStringExtra("game_platform_number_0");
            String game_platform_number_1 = getIntent().getStringExtra("game_platform_number_1");
            String game_platform_number_2 = getIntent().getStringExtra("game_platform_number_2");
            String game_platform_number_3 = getIntent().getStringExtra("game_platform_number_3");


            setImage(imageUrl, imageName,releaseDate,developerUrl,priceUrl,discountPriceUrl,game_platform_name_0,game_platform_name_1,game_platform_name_2,game_platform_name_3,game_platform_number_0,game_platform_number_1,game_platform_number_2,game_platform_number_3);
        }
    }

    private void setImage(String imageUrl, String imageName,String releaseDate,String developerUrl,String priceUrl,String discountPriceUrl,String gpn0 ,String gpn1 ,String gpn2,String gpn3,String gps0,String gps1,String gps2,String gps3){


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

        TextView platform0name = findViewById(R.id.platform0Name);
        platform0name.setText(gpn0);

        TextView platform1name = findViewById(R.id.platform1Name);
        platform1name.setText(gpn1);

        TextView platform2name = findViewById(R.id.platform2Name);
        platform2name.setText(gpn2);

        TextView platform3name = findViewById(R.id.platform3Name);
        platform3name.setText(gpn3);

        TextView platform0number = findViewById(R.id.platform0Number);
        platform0number.setText(gps0);

        TextView platform1number = findViewById(R.id.platform1Number);
        platform1number.setText(gps1);

        TextView platform2number = findViewById(R.id.platform2Number);
        platform2number.setText(gps2);

        TextView platform3number = findViewById(R.id.platform3Number);
        platform3number.setText(gps3);

    }

}
