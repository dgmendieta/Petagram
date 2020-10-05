package com.diegosuarez.petagram;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetRank extends AppCompatActivity {

    ArrayList pets;
    RecyclerView petsList;
    ImageButton backBtn;
    Toolbar rankToolBar;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_rank);

        rankToolBar = (Toolbar) findViewById(R.id.rank_toolbar);
        setSupportActionBar(rankToolBar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeAsUpIndicator(R.drawable.icons8_chevron_izquierda_en_c_rculo_64);




        petsList = (RecyclerView) findViewById(R.id.rank_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        petsList.setLayoutManager(manager);
        petPopulator();
        initAdapter();

    }
    public void initAdapter(){
        PetAdapter adapter = new PetAdapter(pets);
        petsList.setAdapter(adapter);
    }
    public void petPopulator(){
        pets = new ArrayList<Pet>();
        pets.add(new Pet("Anahí", R.drawable.anahisalgado2_thumb, "3"));
        pets.add(new Pet("Aldo", R.drawable.tldlj9a, "4"));
        pets.add(new Pet("Sr UML", R.drawable.images, "1"));
        pets.add(new Pet("Javita", R.drawable.java_logo_640, "5"));
        pets.add(new Pet("Android", R.drawable.android_el_sistema_operativo_movil_de_google, "4"));
    }
}
