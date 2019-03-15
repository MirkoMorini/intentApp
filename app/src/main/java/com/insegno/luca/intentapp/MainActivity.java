package com.insegno.luca.intentapp;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newActivityClicked(View view) {

        String msg = ((EditText) findViewById(R.id.data)).getText().toString();
        if (msg.isEmpty()) {
            msg = "Messaggio di default!";
        }

        Intent intent = new Intent(MainActivity.this, NextActivity.class);
        intent.putExtra("MSG", msg);
        startActivity(intent);

    }

    public void callClicked(View view) {

        String msg = ((EditText) findViewById(R.id.data)).getText().toString();
        if (msg.isEmpty()) {
            msg = "123456";
        }

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: " + msg));
        startActivity(intent);

    }

    public void viewClicked(View view) {

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("content://contacts/people/1"));
        startActivity(intent);

    }

    public void searchClicked(View view) {

        String msg = ((EditText) findViewById(R.id.data)).getText().toString();
        if (msg.isEmpty()) {
            msg = "https://www.google.it";
        }
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, msg);
        startActivity(intent);

    }

    public void sendClicked(View view) {

        String msg = ((EditText) findViewById(R.id.data)).getText().toString();
        if (msg.isEmpty()) {
            msg = "Messaggio di default!";
        }

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        startActivity(Intent.createChooser(intent, "Condividi tramite:"));

    }
}
