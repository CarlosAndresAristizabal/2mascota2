package com.example.mascotasapplication.Fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mascotasapplication.Adaptadores.PerfilMascotaAdapter;
import com.example.mascotasapplication.DataSet.Mascotas;
import com.example.mascotasapplication.R;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    ArrayList<Mascotas> listaperfilratingMascota;
    ImageView imgPerfil;
    TextView NomPer;
    RecyclerView recyclerlista;
    private Object Mascotas;
    Mascotas mascotas ;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        View vista =inflater.inflate(R.layout.fragment_perfil, container, false);


        imgPerfil=vista.findViewById(R.id.imgPerfil);
        NomPer=vista.findViewById(R.id.NomPerfil);

        listaperfilratingMascota = new ArrayList<Mascotas>();
        recyclerlista = vista.findViewById(R.id.rvRatingFragment);
        recyclerlista.setLayoutManager(new GridLayoutManager(getContext(),3));

        iniciaAdaptador();
        Bundle objetoMascota = getArguments();
        if(objetoMascota !=null){
            mascotas = (Mascotas) objetoMascota.getSerializable("objeto");
            imgPerfil.setImageResource(mascotas.getFoto());
            NomPer.setText(mascotas.getNombre());

        }
        llenarlistarating();

         return vista;
    }

    private void llenarlistarating(){
      if(mascotas != null) {
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "3"));
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "4"));
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "2"));
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "5"));
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "9"));
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "4"));
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "3"));
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "5"));
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "4"));
          listaperfilratingMascota.add(new Mascotas(mascotas.getFoto(), "5"));
      }
}

    private void iniciaAdaptador(){
        PerfilMascotaAdapter adapter = new PerfilMascotaAdapter(listaperfilratingMascota,getActivity());
        recyclerlista.setAdapter(adapter);

    }

}