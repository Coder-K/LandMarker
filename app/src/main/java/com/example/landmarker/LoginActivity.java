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

public class LoginActivity extends AppCompatActivity {

    Button login;
    FirebaseAuth auth;
    EditText email, pass, conPass;
    ImageView register;
    String Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialization of controls
        login = findViewById(R.id.btn_login1);
        register = findViewById(R.id.rightarrow);

        //initialiaztion of the fields
        email = findViewById(R.id.et_email);
        pass = findViewById(R.id.et_password);

//         Button skip = findViewById(R.id.skip);
//         skip.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View view) {
//                 startActivity(new Intent(LoginActivity.this,MapDisplay.class));
//             }
//         });


        auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email != null && pass != null) {
                    Password = pass.getText().toString();
                    Email = email.getText().toString();
                    auth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Authentication complete ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, ToSee.class));
                            } else {
                                Toast.makeText(LoginActivity.this, "Login Failed" + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(LoginActivity.this, "Fill in all the details please", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}