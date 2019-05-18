package com.example.countriesretrofit.Screens;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.countriesretrofit.Model.Worldpopulation;
import com.example.countriesretrofit.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    List<Worldpopulation> worldpopulationArrayList;
    public MyAdapter(List<Worldpopulation> worldpopulationArrayList) {
    this.worldpopulationArrayList=worldpopulationArrayList;

    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup   , false);
        MyViewHolder vh = new MyViewHolder(v);
        return  vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        viewHolder.countryName.setText(worldpopulationArrayList.get(i).getCountry());
        Integer rank=worldpopulationArrayList.get(i).getRank();
        viewHolder.countryRank.setText(rank.toString());
        viewHolder.countryPop.setText(worldpopulationArrayList.get(i).getPopulation());
        Glide.with(viewHolder.itemView).load(worldpopulationArrayList.get(i).getFlag())
                .into(viewHolder.countryCircularImage);
        //viewHolder.circleImageView.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return  worldpopulationArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        //public ImageView itemImage;
        //CircleImageView countryCircularImage;
        ImageView countryCircularImage;
        public TextView countryName;
        public TextView countryRank;
        public TextView countryPop;
        public MyViewHolder(View v) {
            super(v);
            //itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            countryCircularImage=(ImageView) itemView.findViewById(R.id.countryFlag);
            countryName = (TextView)itemView.findViewById(R.id.countryName);
            countryRank =(TextView)itemView.findViewById(R.id.countryRank);
            countryPop =(TextView)itemView.findViewById(R.id.countryPop);

        }
    }


}

