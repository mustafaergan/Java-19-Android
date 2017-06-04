package com.example.vektorel.webservis;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void veriGetir(View view){
        String url = "http://10.0.8.100:8088/KullaniciServisi/rest/person/get/";
        String veri = ((EditText)findViewById(R.id.editText)).getText().toString();
        veri = url+veri;

        Servis servis = new Servis();

        servis.execute(veri);
    }


    private class Servis extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... params) {
            String veri = params[0];
            try {
                URL url = new URL(veri);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                connection.connect();

                if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                    BufferedReader buf = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));

                    StringBuilder sb = new StringBuilder();

                    String satir;

                    while ((satir = buf.readLine())!= null ){
                        sb.append(satir);
                    }
                    return sb.toString();
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

             textView = (TextView) findViewById(R.id.textView);

            try {
                JSONObject jsonObject = new JSONObject(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            textView.setText(s);

        }



    }

}
