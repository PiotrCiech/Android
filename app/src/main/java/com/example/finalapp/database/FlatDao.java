package com.example.finalapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.finalapp.database.model.Flat;

import java.util.List;

@Dao
public interface FlatDao {

    @Query("SELECT * FROM flats")
    LiveData<List<Flat>>loadAllFlats();

    @Insert
    void insertAll(Flat[] flats);
}
