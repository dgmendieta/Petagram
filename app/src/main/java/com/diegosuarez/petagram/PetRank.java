package com.diegosuarez.petagram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.diegosuarez.petagram.Adapters.PageAdapter;
import com.diegosuarez.petagram.Fragments.ProfileFragment;
import com.diegosuarez.petagram.Fragments.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class PetRank extends AppCompatActivity implements RecyclerViewFragment.OnFragmentInteractionListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_rank);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);

        setSupportActionBar(miActionBar);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.itemFav:
                Intent intent = new Intent(PetRank.this, BestRankPets.class);
                startActivity(intent);
                break;
            case R.id.itemAbout:
                Intent intentAbout = new Intent(PetRank.this, AboutActivity.class);
                startActivity(intentAbout);
                break;
            case R.id.itemContact:
                Intent intentContact = new Intent(PetRank.this, ContactActivity.class);
                startActivity(intentContact);

                break;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private ArrayList<Fragment> setFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new ProfileFragment());
        return fragments;
    }
    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), setFragments()));
        tabLayout.setupWithViewPager((viewPager));
        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_cucha_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_impresi_n_de_la_pata_del_perro_64);
    }


    public void onFragmentInteraction(Uri uri) {

    }
}
