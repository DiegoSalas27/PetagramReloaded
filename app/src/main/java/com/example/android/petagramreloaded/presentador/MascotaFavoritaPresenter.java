package com.example.android.petagramreloaded.presentador;

import android.content.Context;

import com.example.android.petagramreloaded.IMainActivityView;
import com.example.android.petagramreloaded.IMascotaFavoritaView;
import com.example.android.petagramreloaded.db.ConstructorMascota;
import com.example.android.petagramreloaded.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/28/2017.
 */

public class MascotaFavoritaPresenter implements IMascotaFavoritaPresenter {

    private IMascotaFavoritaView iMascotaFavoritaView;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    public MascotaFavoritaPresenter(IMascotaFavoritaView iMascotaFavoritaView, Context context) {
        this.iMascotaFavoritaView = iMascotaFavoritaView;
        this.context = context;
        obtenerMasctoasBaseDatos();
    }

    @Override
    public void obtenerMasctoasBaseDatos() {
        constructorMascota = new ConstructorMascota(context);
        mascotas = constructorMascota.obtenerDatosUltimos(); //separamos la fuente de los datos con la presentacion de los datos
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotaFavoritaView.inicializarAdaptadorRV(iMascotaFavoritaView.crearAdaptador(mascotas));
        iMascotaFavoritaView.generarLinearLayoutVertical();
    }
}
