package com.example.materialdesignlab2day2navigationdrawer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    List<String> worldpopulationArrayList;
    public MyAdapter(List<String> worldpopulationArrayList) {
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
        viewHolder.countryName.setText(worldpopulationArrayList.get(i));
        viewHolder.countryCircularImage.setImageResource(R.drawable.aunt);


    }

    @Override
    public int getItemCount() {
        return  worldpopulationArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CircleImageView countryCircularImage;
        public TextView countryName;

        public MyViewHolder(View v) {
            super(v);
            countryCircularImage=(CircleImageView) itemView.findViewById(R.id.category_image);
            countryName = (TextView)itemView.findViewById(R.id.countryName);


        }
    }


}

