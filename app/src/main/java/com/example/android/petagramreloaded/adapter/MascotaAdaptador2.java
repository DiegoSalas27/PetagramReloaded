package com.example.android.petagramreloaded.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.petagramreloaded.R;
import com.example.android.petagramreloaded.db.ConstructorMascota;
import com.example.android.petagramreloaded.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/28/2017.
 */

public class MascotaAdaptador2 extends RecyclerView.Adapter<MascotaAdaptador2.MascotaViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador2(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaAdaptador2.MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaAdaptador2.MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaAdaptador2.MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getImgFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvnumLikes.setText(String.valueOf(mascota.getNumBones()));

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombre, tvnumLikes;
        private ImageView imgFoto;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvnumLikes = (TextView) itemView.findViewById(R.id.tvnumLikes);
        }
    }
}
