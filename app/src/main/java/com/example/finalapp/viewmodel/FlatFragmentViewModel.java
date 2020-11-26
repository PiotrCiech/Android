package com.example.finalapp.viewmodel;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.finalapp.database.model.Flat;
import com.example.finalapp.repositories.FlatRepository;

import java.util.List;

public class FlatFragmentViewModel extends ViewModel {

    private FlatRepository flatRepository;
    private LiveData<List<Flat>> mFlatList;

    public FlatFragmentViewModel(){
        flatRepository = new FlatRepository();
        mFlatList = flatRepository.getFlatList();
    }

    public LiveData<List<Flat>> getAllFlats() {
        return mFlatList;
    }

}
