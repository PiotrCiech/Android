package com.example.finalapp.repositories;

import androidx.lifecycle.LiveData;

import com.example.finalapp.RoomDatabase;
import com.example.finalapp.database.AppDatabase;
import com.example.finalapp.database.model.Flat;

import java.util.List;

public class FlatRepository {

    private LiveData<List<Flat>> flatList;

    public FlatRepository(){

        flatList = AppDatabase.getInstance(RoomDatabase.getInstance())
                .flatDao().loadAllFlats();
    }

    public LiveData<List<Flat>> getFlatList() {
        return flatList;
    }
}
