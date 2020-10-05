package com.diegosuarez.petagram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList pets;
    private RecyclerView petsList;
    ImageButton mainImageButton;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainToolBar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolBar);

        petsList = (RecyclerView) findViewById(R.id.main_recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        petsList.setLayoutManager(manager);
        petPopulator();
        initAdapter();

        mainImageButton = (ImageButton) findViewById(R.id.star_main_toolbar);
        mainImageButton.setImageResource(R.drawable.icons8_star_logo_48);
        mainImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PetRank.class);
                startActivity(intent);
            }
        });

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
  //  public void mainFloatingButton(){
  //      FloatingActionButton mainFloatingButton = (FloatingActionButton) findViewById(R.id.main_floating_button);
  //      mainFloatingButton.setOnClickListener(new View.OnClickListener() {
  //          @Override
  //          public void onClick(View v) {
//
  //          }
   //     });
   // }

}