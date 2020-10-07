package com.diegosuarez.petagram.POJO;

public class Pet {

    //Global Variables
    private int id;
    private String name;
    private int photo;
    private int rank;

    //Constructor
    public Pet() {

    }

    public Pet(String name, int photo, int rank) {
        this.name = name;
        this.photo = photo;
        this.rank = rank;
    }
    //Getters and Setters


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
