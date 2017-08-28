package com.example.android.petagramreloaded;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.android.petagramreloaded.adapter.MascotaAdaptador;
import com.example.android.petagramreloaded.pojo.Mascota;
import com.example.android.petagramreloaded.presentador.IMainActivityPresenter;
import com.example.android.petagramreloaded.presentador.MainActivityPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IMainActivityView{

    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    private IMainActivityPresenter presenter; //muestra los views en la actividad

    public void click(View view){

        Intent intent = new Intent(this, MascotaFavorita.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMasctoas);
        presenter = new MainActivityPresenter(this, getBaseContext());
    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
