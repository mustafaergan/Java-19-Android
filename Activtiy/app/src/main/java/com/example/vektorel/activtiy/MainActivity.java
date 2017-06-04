package com.example.vektorel.activtiy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText etKullanici;
    EditText etSifre;
    TextView tvLogin;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etKullanici = (EditText) findViewById(R.id.eTKullaniciAdi);
        etSifre = (EditText) findViewById(R.id.eTSifre);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kul = etKullanici.getText().toString();
                String sif = etSifre.getText().toString();
                if(kul.equals("leprax") && sif.equals("1234")){
                    Intent inIntent = new Intent(MainActivity.this,UserMenu.class);
                    inIntent.putExtra("etLoginName",kul);
                    startActivity(inIntent);
                }else{
                    tvLogin.setText("Basarisiz");
                }

            }
        });

    }
}
