package com.example.gameapp.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gameapp.app.R;
import com.squareup.picasso.Picasso;

import com.example.gameapp.app.activity.GalleryActivity;
import com.example.gameapp.app.model.RetroPhoto;


import java.util.List;




public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<RetroPhoto> dataList;
    private Context context;





    public CustomAdapter(Context context,List<RetroPhoto> dataList){
        this.context = context;
        this.dataList = dataList;

    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public  View mView;
        TextView txtTitle;

        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.coverImage);


        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.txtTitle.setText(dataList.get(position).getName());

        Picasso.get().load(dataList.get(position).getImageUrl()).into(holder.coverImage);


       holder.itemView.setOnClickListener(new  View.OnClickListener(){

           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, GalleryActivity.class);
               intent.putExtra("game_image_url",dataList.get(position).getImageUrl() );
               intent.putExtra("game_name", dataList.get(position).getName());
               intent.putExtra("game_release_date",dataList.get(position).getRelease());
               intent.putExtra("game_developer",dataList.get(position).getDeveloper() );
               intent.putExtra("game_price",dataList.get(position).getPrice() );
               intent.putExtra("game_discount_price",dataList.get(position).getDiscountPrice() );
               context.startActivity(intent);
           }
       });




    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
