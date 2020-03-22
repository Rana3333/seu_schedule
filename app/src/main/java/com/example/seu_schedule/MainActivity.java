package com.example.seu_schedule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btlogin = (Button) findViewById(R.id.btLogin);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginActivity();

            }
        });


    }
    public void openloginActivity(){
        Intent intentlogin = new Intent(this,loginActivity.class);
        startActivity(intentlogin);
    }
}
