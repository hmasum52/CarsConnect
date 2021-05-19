package com.hmasum18.carsconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity->";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = super.findViewById(R.id.textView);
        textView.setText(R.string.hello);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(v->{
            Intent intent = new Intent(this, MyMapActivity.class);
            super.startActivity(intent);
        });
    }


}