package com.example.seu_schedule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class loginActivity extends AppCompatActivity {
    EditText myEmail, myPassword;
    Button myLogin, myForgetPassword;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        firebaseAuth = firebaseAuth.getInstance();
        myEmail = (EditText) findViewById(R.id.edtusername);
        myPassword = (EditText) findViewById(R.id.edtPassword);
        myLogin = (Button) findViewById(R.id.btnLogin);
        myForgetPassword = (Button) findViewById(R.id.btnforgotpass);

        authStateListener = new FirebaseAuth.AuthStateListener(){


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                if(firebaseUser != null){
                    Toast.makeText(loginActivity.this,"you are logged in",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(loginActivity.this, userpageActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(loginActivity.this,"incorrect password",Toast.LENGTH_SHORT).show();
                }

            }
         };
        myLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = myEmail.getText().toString();
                String Pass = myPassword.getText().toString();
                if (Email.isEmpty()) {
                    myEmail.setError("please enter email");
                    myEmail.requestFocus();
                } else if (Pass.isEmpty()) {
                    myPassword.setError("please enter password");
                    myPassword.requestFocus();
                } else if (Email.isEmpty() && Pass.isEmpty()) {
                    Toast.makeText(loginActivity.this, "please enter email & password!", Toast.LENGTH_LONG).show();
                } else if (!(Email.isEmpty() && Pass.isEmpty())){
                    firebaseAuth.signInWithEmailAndPassword(Email, Pass).addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(loginActivity.this, "password is incorrect", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent i = new Intent(loginActivity.this, userpageActivity.class);
                                startActivity(i);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(loginActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        myForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openforgotPasswordActivit();
            }

            private void openforgotPasswordActivit() {
                Intent v = new Intent(loginActivity.this, forgotPasswordActivity.class);
                startActivity(v);
            }

        });
    }
}