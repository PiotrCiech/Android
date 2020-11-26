package com.example.finalapp.database.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "flats")
public class Flat {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String address;
    private int cost;
    private int room;

    public Flat(int id, String address, int cost, int room) {
        this.id = id;
        this.address = address;
        this.cost = cost;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
