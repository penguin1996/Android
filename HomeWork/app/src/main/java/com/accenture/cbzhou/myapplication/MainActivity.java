package com.accenture.cbzhou.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    SearchHandler searchHandler = new SearchHandler();

    //private static final String TAG = "MainActivity";//an TAG flag
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textView =  findViewById(R.id.TextView);

        int value = searchHandler.searchFlight();

        textView.setText("Flight Data size info:"+value);
    }
}
