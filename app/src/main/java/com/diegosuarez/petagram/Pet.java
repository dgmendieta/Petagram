package com.diegosuarez.petagram;

public class Pet {

    //Global Variables
    private String name;
    private int photo;
    private String rank;

    //Constructor
    public Pet(String name, int photo, String rank) {
        this.name = name;
        this.photo = photo;
        this.rank = rank;
    }
    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
