package com.example.android.petagramreloaded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.android.petagramreloaded.adapter.MascotaAdaptador;
import com.example.android.petagramreloaded.adapter.MascotaAdaptador2;
import com.example.android.petagramreloaded.pojo.Mascota;
import com.example.android.petagramreloaded.presentador.IMascotaFavoritaPresenter;
import com.example.android.petagramreloaded.presentador.MainActivityPresenter;
import com.example.android.petagramreloaded.presentador.MascotaFavoritaPresenter;

import java.util.ArrayList;

public class MascotaFavorita extends AppCompatActivity implements IMascotaFavoritaView{

    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    private IMascotaFavoritaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMasctoaFavorita);
        presenter = new MascotaFavoritaPresenter(this, getBaseContext());

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador2 crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador2 adaptador = new MascotaAdaptador2(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador2 adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
