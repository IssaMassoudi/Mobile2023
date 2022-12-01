package com.example.stage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterList extends ArrayAdapter<offreStage>
{
    TextView title,name,description;
    public AdapterList(Context context , ArrayList<offreStage> arrayList)
    {
        super(context,R.layout.offre,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        offreStage offreStage = getItem(position);

        convertView= LayoutInflater.from(getContext()).inflate(R.layout.offre,parent,false);

        title = convertView.findViewById(R.id.title1);
        name = convertView.findViewById(R.id.name);
        description = convertView.findViewById(R.id.description);

        title.setText(offreStage.getTitle());
        name.setText(offreStage.getName());
        description.setText(offreStage.getDescription());



        return convertView;
    }
}
