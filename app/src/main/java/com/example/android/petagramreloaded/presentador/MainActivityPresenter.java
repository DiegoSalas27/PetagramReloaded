package com.example.android.petagramreloaded.presentador;

import android.content.Context;

import com.example.android.petagramreloaded.IMainActivityView;
import com.example.android.petagramreloaded.db.ConstructorMascota;
import com.example.android.petagramreloaded.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/28/2017.
 */

public class MainActivityPresenter implements IMainActivityPresenter {

    private IMainActivityView iMainActivityView;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascotas;

    //contexto es un objeto para pasar contextos entre actividades y mostrar mensajes
    public MainActivityPresenter(IMainActivityView iMainActivityView, Context context) {
        this.iMainActivityView = iMainActivityView;
        this.context = context;
        obtenerMasctoasBaseDatos();
    }

    @Override
    public void obtenerMasctoasBaseDatos() {
        constructorMascota = new ConstructorMascota(context);
        mascotas = constructorMascota.obtenerDatos(); //separamos la fuente de los datos con la presentacion de los datos
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMainActivityView.inicializarAdaptadorRV(iMainActivityView.crearAdaptador(mascotas));
        iMainActivityView.generarLinearLayoutVertical();
    }
}
