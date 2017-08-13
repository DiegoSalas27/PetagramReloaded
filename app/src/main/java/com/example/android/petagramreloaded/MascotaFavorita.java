package com.example.android.petagramreloaded;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MascotaFavorita extends AppCompatActivity {

    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMasctoaFavorita);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();


    }
    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaContactos(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.pet3, "Pedro", 3));
        mascotas.add(new Mascota(R.drawable.pet5, "Clarita", 4));
        mascotas.add(new Mascota(R.drawable.pet1, "Akira", 1));
        mascotas.add(new Mascota(R.drawable.pet2, "Toyotaro", 5));
        mascotas.add(new Mascota(R.drawable.pet4, "Mimascot", 6));
    }
}
