package com.diegosuarez.petagram.Constructors;

import android.content.ContentValues;
import android.content.Context;

import com.diegosuarez.petagram.POJO.Const;
import com.diegosuarez.petagram.POJO.DataBase;
import com.diegosuarez.petagram.POJO.Pet;
import com.diegosuarez.petagram.R;

import java.util.ArrayList;

public class PetConstructor {


        private static final int LIKE = 1;
        private Context context;
        public PetConstructor(Context context) {
            this.context = context;
        }

        public ArrayList<Pet> getData() {
            DataBase db = new DataBase(context);
            populatePets(db);
            return  db.getAllPets();
        }



        public void populatePets(DataBase db){
            ContentValues contentValues = new ContentValues();
            contentValues.put(Const.TABLE_PET_NAME, "Anahí");
            contentValues.put(Const.TABLE_PET_PHOTO, R.drawable.anahisalgado2_thumb);

            db.setPet(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Const.TABLE_PET_NAME, "Aldo");
            contentValues.put(Const.TABLE_PET_PHOTO, R.drawable.tldlj9a);

            db.setPet(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Const.TABLE_PET_NAME, "Uml");
            contentValues.put(Const.TABLE_PET_PHOTO, R.drawable.images);

            db.setPet(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Const.TABLE_PET_NAME, "Android");
            contentValues.put(Const.TABLE_PET_PHOTO, R.drawable.android_el_sistema_operativo_movil_de_google);

            db.setPet(contentValues);

            contentValues = new ContentValues();
            contentValues.put(Const.TABLE_PET_NAME, "Java");
            contentValues.put(Const.TABLE_PET_PHOTO, R.drawable.java_logo_640);

            db.setPet(contentValues);
        }

        public void setPetLikes(Pet pet){
            DataBase db = new DataBase(context);
            ContentValues contentValues = new ContentValues();
            contentValues.put(Const.TABLE_LIKES_PET_ID_PET, pet.getId());
            contentValues.put(Const.TABLE_LIKES_PET_QTY_LIKES, LIKE);
            db.setPetLike(contentValues);
        }

        public int getPetLikes(Pet pet){
            DataBase db = new DataBase(context);
            return db.getPetLikes(pet);
        }



}
