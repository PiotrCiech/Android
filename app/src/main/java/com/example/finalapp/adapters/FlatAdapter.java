package com.example.finalapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalapp.R;
import com.example.finalapp.database.model.Flat;

import org.w3c.dom.Text;

import java.util.List;

public class FlatAdapter extends RecyclerView.Adapter<FlatAdapter.FlatViewHolder>{

    private List<Flat> flatList;

    public FlatAdapter(List<Flat> flatList) {
        this.flatList = flatList;
    }

    @NonNull
    @Override
    public FlatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.flat_item,parent,false);
        return new FlatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlatViewHolder holder, int position) {
        Flat flat = flatList.get(position);
        if (flat != null) {
            holder.apartment.setText(flat.getId());
            holder.apartmentCategory.setText(flat.getId());
        }
    }

    @Override
    public int getItemCount() {
        return flatList.size();
    }

    public void addFlatList(List<Flat> flats){
        flatList = flats;
        notifyDataSetChanged();
    }

    public static class FlatViewHolder extends RecyclerView.ViewHolder{
        TextView apartment;
        TextView apartmentCategory;
        public FlatViewHolder(@NonNull View itemView){
            super(itemView);
            apartment = itemView.findViewById(R.id.apartment);
            apartmentCategory = itemView.findViewById(R.id.apartment_category);
        }



    }



    }

