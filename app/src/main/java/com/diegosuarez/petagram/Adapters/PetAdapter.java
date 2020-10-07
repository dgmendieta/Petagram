package com.diegosuarez.petagram.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.diegosuarez.petagram.POJO.Pet;
import com.diegosuarez.petagram.Constructors.PetConstructor;
import com.diegosuarez.petagram.R;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    ArrayList<Pet> pets;
    Activity activity;

    public PetAdapter(ArrayList<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet,parent, false);


        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetViewHolder holder, int position) {
        final Pet pet = pets.get(position);
        holder.photo_imageview.setImageResource(pet.getPhoto());
        holder.name_text.setText(pet.getName());
        holder.rank_text.setText(String.valueOf(pet.getRank()));


        final TextView rank_text_change = holder.rank_text;
        ImageButton addLikeButton = holder.like_button;
        addLikeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                PetConstructor petsConstructor = new PetConstructor(activity);
                petsConstructor.setPetLikes(pet);
                holder.rank_text.setText(String.valueOf(petsConstructor.getPetLikes(pet)));

            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView photo_imageview;
        private TextView name_text;
        private TextView rank_text;
        private ImageButton like_button;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            photo_imageview = (ImageView) itemView.findViewById(R.id.photo_imageview);
            name_text = (TextView) itemView.findViewById(R.id.name_text);
            rank_text = ( TextView) itemView.findViewById(R.id.rank_text);
            like_button = (ImageButton) itemView.findViewById(R.id.like_button);

        }
    }

}
