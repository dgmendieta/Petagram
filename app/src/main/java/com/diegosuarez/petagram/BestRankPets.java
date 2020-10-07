package com.diegosuarez.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.diegosuarez.petagram.Adapters.PetAdapter;
import com.diegosuarez.petagram.POJO.Pet;

import java.util.ArrayList;

public class BestRankPets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_rank_pets);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView petsList = (RecyclerView) findViewById(R.id.bestPetsRecyclerView);

        LinearLayoutManager linear = new LinearLayoutManager(this);
        linear.setOrientation(RecyclerView.VERTICAL);

        petsList.setLayoutManager(linear);

        ArrayList<Pet> petArrayList = new ArrayList<>();
        petArrayList.add(new Pet(getResources().getString(R.string.pet_1), R.drawable.anahisalgado2_thumb, 5));
        petArrayList.add(new Pet(getResources().getString(R.string.pet_2), R.drawable.tldlj9a, 5));
        petArrayList.add(new Pet(getResources().getString(R.string.pet_3), R.drawable.images, 5));
        petArrayList.add(new Pet(getResources().getString(R.string.pet_4), R.drawable.java_logo_640, 5));
        petArrayList.add(new Pet(getResources().getString(R.string.pet_5), R.drawable.android_el_sistema_operativo_movil_de_google, 5));

        PetAdapter adapter = new PetAdapter(petArrayList, this);

        petsList.setAdapter(adapter);

    }
}
