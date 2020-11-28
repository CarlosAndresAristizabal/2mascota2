package com.example.mascotasapplication.Adaptadores;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasapplication.Comunica;
import com.example.mascotasapplication.DataSet.Mascotas;
import com.example.mascotasapplication.Detalle_Mascota;
import com.example.mascotasapplication.Menu.Favorito;
import com.example.mascotasapplication.R;

import java.util.ArrayList;

public class MascotaAdaptador  extends  RecyclerView.Adapter<MascotaAdaptador.MascotasViewHolder>  implements View.OnClickListener  {

    ArrayList<Mascotas> listaMascota;
    private View.OnClickListener listener;
    Activity activity;
    Comunica comunica;


    public MascotaAdaptador(ArrayList<Mascotas> listaMascota,  Activity activity) {
        this.listaMascota = listaMascota;
        this.activity = activity;
            }



    //infla el layout y le pasará al viewholder para obtener los views

    @NonNull
    @Override
    public MascotasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotas_cardview, null, false);
        view.setOnClickListener(this);
        return new MascotasViewHolder(view);
    }

    //asocia cada elemento
    @Override
    public void onBindViewHolder(@NonNull MascotasViewHolder holder, int position) {
        holder.ImgFoto.setImageResource(listaMascota.get(position).getFoto());
        holder.tvNombreCV.setText(listaMascota.get(position).getNombre());
        holder.tvhuesoCV.setText(listaMascota.get(position).getNumerohueso());
        holder.detalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Detalle de "+ listaMascota.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                Intent Siguiente = new Intent(activity, Detalle_Mascota.class);
                Siguiente.putExtra("fotoD", listaMascota.get(position).getFoto());
                Siguiente.putExtra("nombre", listaMascota.get(position).getNombre());
                Siguiente.putExtra("edad", listaMascota.get(position).getEdad());
                Siguiente.putExtra("descripcion", listaMascota.get(position).getDescripcion());
                Siguiente.putExtra("hueso", listaMascota.get(position).getNumerohueso());
                activity.startActivity(Siguiente);
            }
        });
        holder.star.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            Toast.makeText(activity, "Añadido a Favorito", Toast.LENGTH_LONG).show();
            Intent favorito = new Intent(activity, Favorito.class);
             ArrayList<Mascotas> listaMascotasFav = new ArrayList<Mascotas>();
             for (Mascotas mascota :
                     listaMascota) {
                 if (mascota.isFavorito()) {
                     listaMascotasFav.add(mascota);
                 }
            }             favorito.putExtra("obj", listaMascotasFav);
//                this.getContext(favorito);
            }
        });
    }

    @Override  //la cantidad de elementos que tiene la lista
    public int getItemCount() {
        return listaMascota.size();
    }
    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public static class MascotasViewHolder extends RecyclerView.ViewHolder {
        CardView mascotaCardView;
        ImageView   ImgFoto;
        TextView    tvNombreCV;
        TextView    tvhuesoCV;
        ImageView   star, detalle;

        public MascotasViewHolder(@NonNull View itemView) {
            super(itemView);
            mascotaCardView = (CardView) itemView.findViewById(R.id.cardView);
            ImgFoto         = itemView.findViewById(R.id.imgFoto);
            tvNombreCV      = itemView.findViewById(R.id.tvNombreCV);
            tvhuesoCV       = itemView.findViewById(R.id.tvhuesoCV);
            star            = itemView.findViewById(R.id.star);
            detalle         =itemView.findViewById(R.id.iconodetalle);
        }

    }
}