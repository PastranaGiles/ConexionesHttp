package com.example.conexionhttp.helpers;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.conexionhttp.MainActivity;
import com.example.conexionhttp.R;
import com.example.conexionhttp.VerPersonaje;
import com.example.conexionhttp.marvel.Personaje;
import com.squareup.picasso.Picasso;

public class Adaptador extends BaseAdapter {
    Personaje p[];
    Context contexto;
    private static LayoutInflater inflater= null;

    public Adaptador (MainActivity mainActivity, Personaje[] p) {
        this.p = p;
        contexto = mainActivity;
        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount(){
        return p.length;
    }
    @Override
    public  Object getItem(int posicion) {
        return posicion;
    }
    @Override
    public  long  getItemId(int posicion) {
        return posicion;
    }

    public class Holder
    {
        String id;
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int posicion, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View fila;
        fila = inflater.inflate(R.layout.list_item, null);
        holder.tv=(TextView) fila.findViewById(R.id.textView);
        holder.img=(ImageView) fila.findViewById(R.id.foto);
        holder.tv.setText(p[posicion].getNombreP());
        Picasso.get().load(p[posicion].getImg()).into(holder.img);
        holder.id = p[posicion].getId();

        fila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(contexto, VerPersonaje.class);
                intent.putExtra("id",p[posicion].getId());
                contexto.startActivity(intent);
            }
        });
        return fila;
    }
}