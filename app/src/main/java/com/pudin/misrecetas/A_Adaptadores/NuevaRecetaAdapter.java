package com.pudin.misrecetas.A_Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import com.pudin.misrecetas.A_Ayudantes.Extra;
import com.pudin.misrecetas.MainActivity;
import com.pudin.misrecetas.Mercado.ListadoIngredientesMercado;
import com.pudin.misrecetas.R;
import com.pudin.misrecetas.Recetas.RecetaImage;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

import pl.aprilapps.easyphotopicker.DefaultCallback;
import pl.aprilapps.easyphotopicker.EasyImage;

public class NuevaRecetaAdapter extends BaseAdapter{

    private Context mContext;
    private ImageView imagen;
    private ImageButton ingredientes;
    private EditText noPersonas,procedimiento;
    private Spinner Categoria;
    private String nombre,imgUri,categoria,descripcion;
    private ArrayList<String> ingrediente,unidad,cantidad;
    public NuevaRecetaAdapter(Context mContext){
        this.mContext = mContext;

    }

    public NuevaRecetaAdapter(Context mContext, String nombre, String imgUri, String categoria, String description, ArrayList<String> ingrediente,ArrayList<String> unidad,ArrayList<String> cantidad){
        this.mContext = mContext;
        this.nombre = nombre;
        this.imgUri = imgUri;
        this.categoria = categoria;
        this.descripcion = description;
        this.ingrediente = ingrediente;
        this.unidad = unidad;
        this.cantidad = cantidad;
    }



    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (i){
            case 0: view = LayoutInflater.from(mContext).inflate(R.layout.new_recipe_image_card, viewGroup, false);
                imagen = view.findViewById(R.id.imageRecipe);
                imagen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        RecetaImage fragment = new RecetaImage(mContext);
                        Extra.pushFragment((MainActivity) mContext,fragment);
                    }
                });

                break;

            case 1: view = LayoutInflater.from(mContext).inflate(R.layout.new_recipe_settings_card, viewGroup, false);
                    Categoria = view.findViewById(R.id.categoriaSpinner);
            break;

            case 2: view = LayoutInflater.from(mContext).inflate(R.layout.new_recipe_ingredients_card, viewGroup, false);
                ingredientes = view.findViewById(R.id.addIngredients);
                ingredientes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ListadoIngredientesMercado fragmet = new ListadoIngredientesMercado(mContext,1);
                        Bundle args = new Bundle();

                        fragmet.setArguments(args);
                        Extra.pushFragment((MainActivity) mContext,fragmet);
                    }
                });
                break;

            case 3: view = LayoutInflater.from(mContext).inflate(R.layout.new_recipe_process_card, viewGroup, false);
                procedimiento = view.findViewById(R.id.procedimiento);
                break;
        }
        return view;
    }

}
