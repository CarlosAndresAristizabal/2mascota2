package com.example.mascotasapplication.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mascotasapplication.Adaptadores.MascotaAdaptador;
import com.example.mascotasapplication.DataSet.Mascotas;
import com.example.mascotasapplication.R;

import java.util.ArrayList;

public class Favorito extends AppCompatActivity   {

    ArrayList<Mascotas> listaMascotas = new ArrayList<Mascotas>();
    RecyclerView recicler;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("Favoritos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(listaMascotas != null) {
            extras = getIntent().getExtras();
            listaMascotas = (ArrayList<Mascotas>) extras.getSerializable("obj");
            recicler = (RecyclerView) findViewById(R.id.rvMascotasFavorito);
            recicler.setHasFixedSize(true);
            RecyclerView.LayoutManager Manager = new LinearLayoutManager(this);
            recicler.setLayoutManager(Manager);
            MascotaAdaptador adapter = new MascotaAdaptador(listaMascotas, this);
            recicler.setAdapter(adapter);


        }
    }

}