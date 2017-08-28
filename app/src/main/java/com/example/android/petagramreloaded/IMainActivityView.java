package com.example.android.petagramreloaded;

import com.example.android.petagramreloaded.adapter.MascotaAdaptador;
import com.example.android.petagramreloaded.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/28/2017.
 */

public interface IMainActivityView { //vista de la clase activity (view model)

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
