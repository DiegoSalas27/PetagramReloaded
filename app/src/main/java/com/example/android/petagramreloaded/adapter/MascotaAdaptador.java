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
 * Created by DOMINIC on 8/12/2017.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getImgFoto());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvnumLikes.setText(String.valueOf(mascota.getNumBones()));

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mascota.getNumBones() < 5)
                Toast.makeText(activity, "Much love! " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                else if(mascota.getNumBones() >= 5 && mascota.getNumBones() < 10)
                    Toast.makeText(activity, "Too much love! " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(activity, "Way too Much love! " + mascota.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorMascota constructorMascota = new ConstructorMascota(activity);
                constructorMascota.darLikeMascota(mascota);
                mascotaViewHolder.tvnumLikes.setText(String.valueOf(constructorMascota.obtenerLikesMascota(mascota)));

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombre, tvnumLikes;
        private ImageView imgFoto;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvnumLikes = (TextView) itemView.findViewById(R.id.tvnumLikes);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }
}
