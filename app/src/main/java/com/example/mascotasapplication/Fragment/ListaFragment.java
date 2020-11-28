package com.example.mascotasapplication.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mascotasapplication.Adaptadores.MascotaAdaptador;
import com.example.mascotasapplication.Comunica;
import com.example.mascotasapplication.DataSet.Mascotas;
import com.example.mascotasapplication.R;

import java.util.ArrayList;

public class ListaFragment extends Fragment {

    ArrayList<Mascotas> listaMascotas;
    RecyclerView recyclerlista;
    Activity actividad;
    Comunica comunica;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_lista, container, false);
        recyclerlista = vista.findViewById(R.id.rvMascotasFragment);
        recyclerlista.setLayoutManager(new LinearLayoutManager(getContext()));

        listaMascotas = new ArrayList<>();
        llenarLista();
        inicializarAdaptador();
        return vista;
    }

    private void llenarLista(){
        listaMascotas.add(new Mascotas(R.drawable.perro0, "Luna", "3", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "5 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro1, "Kira", "5", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro2, "Thor", "4", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "1 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro3, "Lola", "2", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años" ));
        listaMascotas.add(new Mascotas(R.drawable.perro4, "Nala", "5", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "1 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro5, "Rex", "4", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "1 años" ));
        listaMascotas.add(new Mascotas(R.drawable.perro6, "Zeus", "3", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro7, "Rocky", "5", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro8, "Taison", "4", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "1 años"));
        listaMascotas.add(new Mascotas(R.drawable.perro9, "Rambo", "5", "El perro doméstico es un mamífero carnívoro que se integra en la familiaCanidae (cánidos), complexión fuerte, boca poderosa con unos caninos muy desarrollados, además, son unos animales veloces y resistentes.,", "2 años"));

    }

    private void inicializarAdaptador(){

        MascotaAdaptador adapter  = new MascotaAdaptador(listaMascotas,actividad);
        recyclerlista.setAdapter(adapter);
        adapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "selecciono a:  " + listaMascotas.get(recyclerlista.getChildAdapterPosition(v)).getNombre(), Toast.LENGTH_LONG).show();
                comunica.enviarDatos(listaMascotas.get(recyclerlista.getChildAdapterPosition(v)));

            }
        } );
        }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            this.actividad= (Activity) context;
            comunica= (Comunica) this.actividad;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}