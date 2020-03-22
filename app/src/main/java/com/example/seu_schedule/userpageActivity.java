package com.example.seu_schedule;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class userpageActivity extends AppCompatActivity {
    Button signOut, academicCalendar, schedule, search, map;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpage);
        signOut=(Button) findViewById(R.id. btnsignout);
        academicCalendar=(Button) findViewById(R.id. btacademic2);
        schedule=(Button) findViewById(R.id. btschedule);
        search=(Button) findViewById(R.id. btssearch2);
        map=(Button) findViewById(R.id. btMap2);

        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent goback = new Intent(userpageActivity.this,MainActivity.class);
                startActivity(goback);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchbage = new Intent(userpageActivity.this, searchActivity.class);
                startActivity(searchbage);
            }
        });
    }
}
