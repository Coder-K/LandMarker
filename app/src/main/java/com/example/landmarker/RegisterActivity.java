package com.example.landmarker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    EditText email, pass, conPass;
    Button register;
    ImageView login;
    String Email, Pass, ConPass;
    FirebaseUser user;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //initialization  of controlls
        register = findViewById(R.id.btn_register);
        login = findViewById(R.id.leftarrow);

        // initialization of the fields
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_password);
        conPass = findViewById(R.id.et_repassword);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email != null && pass != null && conPass != null) {
                    Pass = pass.getText().toString();
                    Email = email.getText().toString();
                    ConPass = conPass.getText().toString();
                    if (Pass.equals(ConPass)) {
                        auth.createUserWithEmailAndPassword(Email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(RegisterActivity.this, "Registration complete", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterActivity.this, ToSee.class));
                                } else {
                                    Toast.makeText(RegisterActivity.this, "Registration failed " + task.getException(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    } else {
                        Toast.makeText(RegisterActivity.this, "Passwords are not the same", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Fill in all the fields ", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}