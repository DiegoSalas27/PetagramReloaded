package com.example.android.petagramreloaded;

import com.example.android.petagramreloaded.adapter.MascotaAdaptador;
import com.example.android.petagramreloaded.adapter.MascotaAdaptador2;
import com.example.android.petagramreloaded.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by DOMINIC on 8/28/2017.
 */

public interface IMascotaFavoritaView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador2 crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador2 adaptador);
}
