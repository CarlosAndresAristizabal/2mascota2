package com.example.mascotasapplication.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.mascotasapplication.R;

public class Acercade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("Acerca de");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}