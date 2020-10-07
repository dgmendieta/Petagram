package com.diegosuarez.petagram.POJO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {




    public DataBase(@Nullable Context context) {
        super(context, Const.DATABASE_NAME, null, Const.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateTablePet = "CREATE TABLE " + Const.TABLE_PET + "(" +
                Const.TABLE_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Const.TABLE_PET_NAME + " TEXT, " +
                Const.TABLE_PET_PHOTO + " INTEGER" +
                ")";
        String queryCreateTableLikesPet = "CREATE TABLE " + Const.TABLE_LIKES_PET + "(" +
                Const.TABLE_LIKES_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Const.TABLE_LIKES_PET_ID_PET + " INTEGER, " +
                Const.TABLE_LIKES_PET_QTY_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + Const.TABLE_LIKES_PET_ID_PET + ") " +
                "REFERENCES " + Const.TABLE_PET + "(" + Const.TABLE_PET_ID + ")" +
                ")";

        db.execSQL(queryCreateTablePet);
        db.execSQL(queryCreateTableLikesPet);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  Const.TABLE_PET);
        db.execSQL("DROP TABLE IF EXISTS " + Const.TABLE_LIKES_PET);
        onCreate(db);
    }

    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + Const.TABLE_PET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery(query, null);

        while (data.moveToNext()){
            Pet thisPet = new Pet();
            thisPet.setId(data.getInt(0));
            thisPet.setName(data.getString(1));
            thisPet.setPhoto(data.getInt(2));

            String queryLikes = "SELECT COUNT("+Const.TABLE_LIKES_PET_QTY_LIKES+") as likes " +
                    " FROM " + Const.TABLE_LIKES_PET +
                    " WHERE " + Const.TABLE_LIKES_PET_ID_PET + "=" + thisPet.getId();

            Cursor likesQty = db.rawQuery(queryLikes, null);
            if (likesQty.moveToNext()){
                thisPet.setRank(likesQty.getInt(0));
            }else {
                thisPet.setRank(0);
            }

            pets.add(thisPet);

        }

        db.close();

        return pets;
    }

    public void setPet(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Const.TABLE_PET,null, contentValues);
        db.close();
    }

    public void setPetLike(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Const.TABLE_LIKES_PET, null, contentValues);
        db.close();
    }


    public int getPetLikes(Pet pet){
        int likes = 0;

        String query = "SELECT COUNT("+Const.TABLE_LIKES_PET_QTY_LIKES+")" +
                " FROM " + Const.TABLE_LIKES_PET +
                " WHERE " + Const.TABLE_LIKES_PET_ID_PET + "="+pet.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery(query, null);

        if (data.moveToNext()){
            likes = data.getInt(0);
        }

        db.close();

        return likes;
    }
}
