package com.example.finalapp;

import android.app.Application;

public class RoomDatabase extends Application {
    private static RoomDatabase instance;


    @Override
    public void onCreate(){
        super.onCreate();
        if (instance == null) {
            instance = this;
        }
    }
    public static RoomDatabase getInstance(){
        return instance;
    }
}
