package com.example.finalapp;

import android.graphics.Movie;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalapp.adapters.FlatAdapter;
import com.example.finalapp.database.model.Flat;
import com.example.finalapp.viewmodel.FlatFragmentViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


public class FlatFragment extends Fragment {

    private RecyclerView mFlatRecyclerView;
    private FlatAdapter mFlatAdapter;

    public FlatFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_flat,container,false);


        mFlatRecyclerView = view.findViewById(R.id.flatRecyclerView);
        mFlatRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFlatRecyclerView.setHasFixedSize(true);
        mFlatAdapter = new FlatAdapter(new ArrayList<Flat>());
        mFlatRecyclerView.setAdapter(mFlatAdapter);

        FlatFragmentViewModel mModel = ViewModelProviders.of(this)
                .get(FlatFragmentViewModel.class);

       mModel.getAllFlats().observe(this, new Observer<List<Flat>>() {
           @Override
           public void onChanged( @Nullable List<Flat> flats) {
               mFlatAdapter.addFlatList(flats);
           }
       });

        return view;
    }
}