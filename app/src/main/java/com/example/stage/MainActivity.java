package com.example.stage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button login;
    EditText email,pass;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        auth = FirebaseAuth.getInstance();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = email.getText().toString().trim();
                String password = pass.getText().toString().trim();

                auth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(getApplicationContext(),home.class));
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                        }


                    }
                });





            }
        });



    }
}