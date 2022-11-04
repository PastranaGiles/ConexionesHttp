package com.example.conexionhttp.marvel;

import android.os.AsyncTask;

import com.example.conexionhttp.MainActivity;
import com.example.conexionhttp.conexion.Conexion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Personaje  {

    private String id;
    private String nombreP;
    private String nombreR;
    private String descripcion;
    private String img;

    public Personaje() {

    }

    public Personaje(String id, String nombreP, String nombreR, String descripcion, String img) {
        this.id = id;
        this.nombreP = nombreP;
        this.nombreR = nombreR;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public String getNombreR() {
        return nombreR;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImg() {
        return img;
    }

    public static Personaje getPersonaje(String id) {
        Conexion c = new Conexion();
        String res = "";

        try {
            res = c.execute("http://huasteco.tiburcio.mx/marvel/" + id).get();

            JSONObject renglon = new JSONObject(res);

            String ide = renglon.getString("id");
            String nombreP = renglon.getString("nombreP");
            String nombreR = renglon.getString("nombreR");
            String descripcion = renglon.getString("descripcion");
            String img = renglon.getString("foto");

            return new Personaje(ide,nombreP,nombreR,descripcion,img);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static Personaje[] getAllPersonajes() {
        Conexion c = new Conexion();
        String res = "";
        Personaje[] personajes = null;
        try {
            res = c.execute("http://huasteco.tiburcio.mx/marvel").get();
            JSONArray array = new JSONArray(res);
            personajes = new Personaje[array.length()];

            for (int i = 0; i < array.length(); i++) {
                JSONObject renglon = array.getJSONObject(i);
                String id = renglon.getString("id");
                String nombreP = renglon.getString("nombreP");
                String nombreR = renglon.getString("nombreR");
                String descripcion = renglon.getString("descripcion");
                String img = renglon.getString("foto");
                personajes[i] = new Personaje(id,nombreP,nombreR,descripcion,img);
            }

            return personajes;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
