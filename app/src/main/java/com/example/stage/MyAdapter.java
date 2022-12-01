package com.example.stage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    Context context;
    ArrayList<offreStage> arrOff;

    public MyAdapter (Context context, ArrayList<offreStage> arroff)
    {
        this.context = context;
        this.arrOff = arroff;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.offre,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return arrOff.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title,name,description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title1);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);




        }


    }
}
