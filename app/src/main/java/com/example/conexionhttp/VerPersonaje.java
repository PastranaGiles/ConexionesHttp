package com.example.conexionhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.conexionhttp.marvel.Personaje;
import com.squareup.picasso.Picasso;

public class VerPersonaje extends AppCompatActivity {

    TextView nombreP,nombreR, descripcion;
    ImageView img;
    Button volver;
    Personaje p;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p = null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_personaje);

        getSupportActionBar().hide();

        nombreP = findViewById(R.id.nombreP);
        nombreR = findViewById(R.id.nombreR);
        img = findViewById(R.id.foto);
        descripcion = findViewById(R.id.descripcion);
        volver = findViewById(R.id.volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
                return;
            }
        });

        String id = getIntent().getStringExtra("id");
        mostrarPersonaje(id);
    }

    void mostrarPersonaje(String id) {
        p = Personaje.getPersonaje(id);

        if (p != null) {
            nombreP.setText(p.getNombreP());
            nombreR.setText(p.getNombreR());
            Picasso.get().load(p.getImg()).into(img);
            descripcion.setText(p.getDescripcion());
        } else {
            nombreR.setVisibility(View.INVISIBLE);
            img.setVisibility(View.INVISIBLE);
            descripcion.setVisibility(View.INVISIBLE);
            nombreP.setText("No encontrado");
        }
    }
}