package com.example.stage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addOffer extends AppCompatActivity {

    EditText poste,name,description;
    Button pub;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);

        poste = findViewById(R.id.poste);
        name = findViewById(R.id.nameRec);
        description = findViewById(R.id.descriptionOf);
        pub = findViewById(R.id.publier);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Offers");

        pub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String posteData = poste.getText().toString();
                String nameData = name.getText().toString();
                String descData = description.getText().toString();

                if (TextUtils.isEmpty(posteData) && TextUtils.isEmpty(nameData) && TextUtils.isEmpty(descData))
                {
                    Toast.makeText(addOffer.this, "Veuillez ajouter quelques données!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    offreStage offreStage = new offreStage(posteData,nameData,descData);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            databaseReference.setValue(offreStage);
                            Toast.makeText(addOffer.this, "Données ajoutées", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            Toast.makeText(addOffer.this, "Impossible d'ajouter des données "+error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }



            }
        });








    }
}