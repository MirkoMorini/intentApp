package com.insegno.luca.intentapp;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newActivityClicked(View view) {
        String messaggio = ((EditText)findViewById(R.id.data)).getText().toString();
        if (messaggio.isEmpty())
            messaggio = getString(R.string.defaultMsg);

        Intent intent = new Intent(MainActivity.this, NextActivity.class);
        intent.putExtra("MSG", messaggio);
        startActivity(intent);
    }

    public void callClicked(View view) {
        String numero = ((EditText)findViewById(R.id.data)).getText().toString();
        if (numero.isEmpty())
            numero = getString(R.string.defaultNum);

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel: "+numero));
        startActivity(intent);
    }

    public void viewClicked(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("content://contacts/people/1"));
        startActivity(intent);
    }

    public void searchClicked(View view) {
        String indirizzo = ((EditText)findViewById(R.id.data)).getText().toString();
        if (indirizzo.isEmpty())
            indirizzo = getString(R.string.defaultAddr);

        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, indirizzo);
        startActivity(intent);
    }

    public void sendClicked(View view) {
        String messaggio = ((EditText)findViewById(R.id.data)).getText().toString();
        if (messaggio.isEmpty())
            messaggio = getString(R.string.defaultMsg);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messaggio);
        startActivity(Intent.createChooser(intent, getString(R.string.share_with)));
    }
}
