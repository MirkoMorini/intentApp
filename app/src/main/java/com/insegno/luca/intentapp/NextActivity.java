package com.insegno.luca.intentapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String msg = intent.getStringExtra("MSG");

        Toast.makeText(NextActivity.this, msg, Toast.LENGTH_LONG).show();
    }
}
