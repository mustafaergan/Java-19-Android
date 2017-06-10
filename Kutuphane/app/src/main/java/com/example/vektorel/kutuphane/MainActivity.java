package com.example.vektorel.kutuphane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText eTMainActityId;
    EditText eTMainActityName;
    MyDB db;

    EditText eTMainActityGetir;
    TextView tVMainActityGetir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new MyDB(getApplicationContext());
    }


    public void ekle(View view){
        eTMainActityId = (EditText) findViewById(R.id.eTMainActityId);
        eTMainActityName = (EditText) findViewById(R.id.eTMainActityName);
        db.kisiEkle(Integer.parseInt(eTMainActityId.getText().toString()),
                eTMainActityName.getText().toString());
    }

    public void getir(View view){
        eTMainActityGetir = (EditText) findViewById(R.id.eTMainActityGetir);
        tVMainActityGetir = (TextView) findViewById(R.id.tVMainActityGetir);
        Uye uye = db.getKisi(Integer.parseInt(eTMainActityGetir.getText().toString()));
        tVMainActityGetir.setText("Üyenin Adı:"+uye.getName());
    }
}
