package com.example.mascotasapplication;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.mascotasapplication.Adaptadores.pageAdapter;
import com.example.mascotasapplication.DataSet.Mascotas;
import com.example.mascotasapplication.Fragment.ListaFragment;
import com.example.mascotasapplication.Fragment.PerfilFragment;
import com.example.mascotasapplication.Menu.Acercade;
import com.example.mascotasapplication.Menu.Contacto;
import com.example.mascotasapplication.Menu.Favorito;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Comunica{

    ArrayList<Mascotas> listaMascotas = new ArrayList<Mascotas>();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int selec = item.getItemId();
        if (selec == R.id.action_favorite) {
            Intent favorito = new Intent(this, Favorito.class);
            ArrayList<Mascotas> listaMascotasFav = new ArrayList<Mascotas>();
            for (Mascotas mascota :
                    listaMascotas) {
                if (mascota.isFavorito()) {
                    listaMascotasFav.add(mascota);
                }
            }
            favorito.putExtra("obj", listaMascotasFav);
            this.startActivity(favorito);
        }

        switch (item.getItemId()) {
            case R.id.Contacto:
                Intent Contacto = new Intent(this, Contacto.class);
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
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        setUpViewPager();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#03DAC5")));
            getSupportActionBar().setTitle("Mascotas Application");

        }

    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListaFragment());
        fragments.add(new PerfilFragment());
        return fragments;

    }

    private void setUpViewPager() {
        viewPager.setAdapter(new pageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Lista Mascotas");
        tabLayout.getTabAt(1).setText("Perfil Mascota");
        tabLayout.setBackgroundColor(0);
    }

    public void enviarDatos(Mascotas mascotas) {
        PerfilFragment perfil = new PerfilFragment();
        Bundle bundleEnvio = new Bundle();
        bundleEnvio.putSerializable("objeto", mascotas);
        perfil.setArguments(bundleEnvio);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.PerfilFragmentP, perfil);
        ft.commit();


    }
}