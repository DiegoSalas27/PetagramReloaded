package com.example.android.petagramreloaded;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

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

        mascotas.add(new Mascota(R.drawable.pet1, "Ignacio", 0));
        mascotas.add(new Mascota(R.drawable.pet2, "Pancho", 0));
        mascotas.add(new Mascota(R.drawable.pet3, "Fernando", 0));
        mascotas.add(new Mascota(R.drawable.pet4, "Luis", 0));
        mascotas.add(new Mascota(R.drawable.pet5, "PPK", 0));
        mascotas.add(new Mascota(R.drawable.pet1, "Pepe", 0));
        mascotas.add(new Mascota(R.drawable.pet2, "Penelope", 0));
        mascotas.add(new Mascota(R.drawable.pet3, "Tom", 0));
        mascotas.add(new Mascota(R.drawable.pet4, "Jerry", 0));
        mascotas.add(new Mascota(R.drawable.pet5, "Gianluca", 0));
    }

}
