package com.example.vektorel.listleme;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.ilce,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void  ekranaYaz(MenuItem menuItem){
        String veri = getIntent().getStringExtra("ilce");
        ((TextView)findViewById(R.id.tvMenu)).setText(veri);
    }

    public void titleYaz(MenuItem menuItem){
        String veri = getIntent().getStringExtra("ilce");
        this.setTitle(veri);
    }
}
