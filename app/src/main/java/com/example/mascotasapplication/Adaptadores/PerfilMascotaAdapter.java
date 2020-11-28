package com.example.mascotasapplication.Adaptadores;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotasapplication.DataSet.Mascotas;
import com.example.mascotasapplication.R;

import java.util.ArrayList;

public class PerfilMascotaAdapter extends RecyclerView.Adapter<PerfilMascotaAdapter.MascotasPerfilViewHolder> {

    ArrayList<Mascotas> listaperfilratingMascota;
    Activity activity;

    public PerfilMascotaAdapter(ArrayList<Mascotas> listaperfilratingMascota, FragmentActivity activity) {
        this.activity = activity;
        this.listaperfilratingMascota = listaperfilratingMascota;
    }

    public PerfilMascotaAdapter(ArrayList<Mascotas> listaperfilratingMascota) {
    }

    @NonNull
    @Override
    public MascotasPerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotas_cardview_perfil, null, false);
        return new MascotasPerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotasPerfilViewHolder holder, int position) {
        holder.ImgFoto.setImageResource(listaperfilratingMascota.get(position).getFoto());
        holder.tvhueso.setText(listaperfilratingMascota.get(position).getNumerohueso());
    }

    @Override
    public int getItemCount() {
        return listaperfilratingMascota.size();
    }

    public static class MascotasPerfilViewHolder extends RecyclerView.ViewHolder {
        CardView mascotaCardViewPerfil;
        ImageView ImgFoto;
        TextView tvhueso;

        public MascotasPerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            mascotaCardViewPerfil = (CardView) itemView.findViewById(R.id.cardView);
            ImgFoto = (ImageView) itemView.findViewById(R.id.imgPerfil);
            tvhueso = (TextView) itemView.findViewById(R.id.tvhuesoP);
        }
    }
}
