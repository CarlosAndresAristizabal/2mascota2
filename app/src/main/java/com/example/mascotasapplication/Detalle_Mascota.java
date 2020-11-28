package com.example.mascotasapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mascotasapplication.DataSet.Mascotas;
import com.example.mascotasapplication.Menu.Acercade;
import com.example.mascotasapplication.Menu.Contacto;
import com.example.mascotasapplication.Menu.Favorito;
import com.example.mascotasapplication.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Detalle_Mascota extends AppCompatActivity  implements Serializable {
    TextView tvNombre,tvhueso, tvedad, tvdescripcion;
    ImageView imgFoto;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Contacto:
                Intent Contacto = new Intent(this, com.example.mascotasapplication.Menu.Contacto.class);
                startActivity(Contacto);
                break;
            case R.id.Acercade:
                Intent Acerca = new Intent(this, Acercade.class);
                startActivity(Acerca);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__mascota);
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar);

        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("Detalle Mascota");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgFoto         =(ImageView) findViewById(R.id.imgFotoD);
        tvNombre        =(TextView) findViewById(R.id.tvNombreD);
        tvedad          =(TextView) findViewById(R.id.tvedadD);
        tvdescripcion   =(TextView) findViewById(R.id.tvdescripcionD);
        tvhueso         =(TextView) findViewById(R.id.tvhuesoD);

        int imgf             = getIntent().getExtras().getInt("fotoD");
        String nombre        = getIntent().getStringExtra("nombre");
        String descripcion   = getIntent().getStringExtra("descripcion");
        String edad          = getIntent().getStringExtra("edad");
        String huesos        = getIntent().getStringExtra("hueso");

        imgFoto.setImageResource(imgf);
        tvNombre.setText(nombre);
        tvdescripcion.setText(descripcion);
        tvedad.setText(edad);
        tvhueso.setText(huesos);



    }

}