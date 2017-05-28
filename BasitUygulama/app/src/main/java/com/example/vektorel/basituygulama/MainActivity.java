package com.example.vektorel.basituygulama;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView textViewGonder;
    EditText editTextGonder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewGonder = (TextView) findViewById(R.id.tvGonder);
        editTextGonder = (EditText) findViewById(R.id.etGonder);
        Button buttonGonder = (Button)findViewById(R.id.btnGonder);

        buttonGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewGonder.setText(editTextGonder.getText().toString());
            }
        });

    }
}
