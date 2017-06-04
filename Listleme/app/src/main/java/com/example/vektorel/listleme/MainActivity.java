package com.example.vektorel.listleme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spMainActityIller;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMainActityIller = (Spinner) findViewById(R.id.spMainActityIller);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.iller,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMainActityIller.setAdapter(adapter);

        spMainActityIller.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Secildi", Toast.LENGTH_SHORT).show();

                CharSequence veri = spMainActityIller.getItemAtPosition(position).toString();

                MainActivity.this.setTitle(veri);

                bindList(veri);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void bindList(CharSequence veri) {
        String[] urfa = {"Viranşehir","Haran"};
        String[] gaziantep = {"Şahinbey","ŞehitKamil"};
        String[] trabzon = {"Çarşıbaşı","Dernekpazari","Çaykara","Merkez"};

        List<String> urfaList =  Arrays.asList(urfa);
        List<String> gaziantepList =  Arrays.asList(gaziantep);
        List<String> trabzonList =  Arrays.asList(trabzon);

        List<String> sonucList = new ArrayList<>();

        if(veri.equals("Urfa")){
            sonucList = urfaList;
        }else if(veri.equals("Gaziantep")){
            sonucList = gaziantepList;
        }else{
            sonucList = trabzonList;
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,
                        android.R.id.text1,sonucList);

        listView = (ListView) findViewById(R.id.lVMainActityIlceler);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        listView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();


                Toast.makeText(MainActivity.this,listView.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

                Intent inIntent = new Intent(MainActivity.this,Menu.class);
                inIntent.putExtra("ilce",listView.getItemAtPosition(position).toString());

                startActivity(inIntent);
            }
        });

    }
}
