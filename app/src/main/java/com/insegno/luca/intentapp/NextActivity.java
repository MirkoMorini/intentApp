package com.insegno.luca.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent intentGen = getIntent();
        String messaggio = intentGen.getStringExtra("MSG");

        Toast.makeText(NextActivity.this, messaggio, Toast.LENGTH_LONG).show();
    }
}
