package com.diegosuarez.petagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    ArrayList<Pet> pets;

    public PetAdapter(ArrayList<Pet> pets){
        this.pets = pets;
    }
    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PetViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull PetViewHolder petViewHolder, int position) {
        Pet pet = pets.get(position);
        petViewHolder.image_main_cardview.setImageResource(pet.getPhoto());
        petViewHolder.imagebutton_main_cardview.setImageResource(R.drawable.icons8_taz_n_del_perro_100);
        petViewHolder.title_main_cardview.setText(pet.getName());
        petViewHolder.rank_main_cardview.setText(pet.getRank());
        petViewHolder.bone_main_cardview.setImageResource(R.drawable.icons8_taz_n_del_perrof_100);
        
    }

    @Override
    public int getItemCount() {

        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{

        private ImageView image_main_cardview;
        private ImageButton imagebutton_main_cardview;
        private TextView title_main_cardview;
        private TextView rank_main_cardview;
        private ImageView bone_main_cardview;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);

            image_main_cardview = (ImageView) itemView.findViewById(R.id.image_main_cardview);
            imagebutton_main_cardview = (ImageButton) itemView.findViewById(R.id.imagebutton_main_cardview);
            title_main_cardview = (TextView) itemView.findViewById(R.id.title_main_cardview);
            rank_main_cardview = (TextView) itemView.findViewById(R.id.rank_main_cardview);
            bone_main_cardview = (ImageView) itemView.findViewById(R.id.bone_main_cardview);


        }
    }
}
