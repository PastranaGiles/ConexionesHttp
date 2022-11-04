package com.example.conexionhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conexionhttp.conexion.Conexion;
import com.example.conexionhttp.helpers.Adaptador;
import com.example.conexionhttp.marvel.Personaje;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    String [] nom = {"N","M","O"};
    int [] imgs = {R.mipmap.sin_img,R.mipmap.sin_img,R.mipmap.sin_img};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);

        getSupportActionBar().hide();

        Personaje[] personajes = Personaje.getAllPersonajes();
        llenarLista(lista, personajes);
    }

    private void llenarLista(ListView lista, Personaje[] personajes) {
        ArrayAdapter<Personaje> arr = new ArrayAdapter<Personaje>(this, android.R.layout.simple_list_item_1,personajes);
        lista.setAdapter(new Adaptador(this,personajes));
    }
}