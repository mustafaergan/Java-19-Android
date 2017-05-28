package com.example.vektorel.merhabadunya;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.HORIZONTAL);
        Button button1 = new Button(this);

        button1.setText("Selam");
        Button button2 = new Button(this);
        button2.setText("Selam2");
        root.addView(button1);
        root.addView(button2);
//        setContentView(root);

        setContentView(R.layout.activity_main);
    }
}
