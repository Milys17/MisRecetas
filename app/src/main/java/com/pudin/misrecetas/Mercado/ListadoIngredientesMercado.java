package com.pudin.misrecetas.Mercado;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.pudin.misrecetas.A_Adaptadores.IngredientesAdapter;
import com.pudin.misrecetas.A_Ayudantes.Extra;
import com.pudin.misrecetas.A_Modelos.Ingrediente;
import com.pudin.misrecetas.MainActivity;
import com.pudin.misrecetas.R;
import com.pudin.misrecetas.Recetas.NuevaReceta;

import java.util.ArrayList;


public class ListadoIngredientesMercado extends Fragment {

    private RadioButton todos,verduras, frutas, especias, cereales, leguminosas, carnes, mariscos, chatarras, lacteos, otros;
    private GridView ingredientes;
    private FloatingActionButton fab;
    private IngredientesAdapter adapter;
    private Context mContext;
    private ArrayList<Ingrediente> lista = new ArrayList<>();
    int uso = -1;

    private  String[] verdura,fruta,especia,cereal,leguminosa,carne,marisco,chatarra,lacteo,otro,todo;
    private  int[] unidad_ver,unidad_fru,unidad_esp,unidad_cer,unidad_leg,unidad_car,unidad_mar,unidad_cha,unidad_lac,unidad_otro,unidad_tod;

    public void fillTodo(){
        int index = 0;

        for(int x=0;x<verdura.length;x++) {
            todo[index] = verdura[x];
            unidad_tod[index] = unidad_ver[x];
            index++;
        }

        for(int x=0;x<fruta.length;x++) {
            todo[index] = fruta[x];
            unidad_tod[index] = unidad_fru[x];
            index++;
        }

        for(int x=0;x<especia.length;x++) {
            todo[index] = especia[x];
            unidad_tod[index] = unidad_esp[x];
            index++;
        }

        for(int x=0;x<cereal.length;x++) {
            todo[index] = cereal[x];
            unidad_tod[index] = unidad_cer[x];
            index++;
        }

        for(int x=0;x<leguminosa.length;x++) {
            todo[index] = leguminosa[x];
            unidad_tod[index] = unidad_leg[x];
            index++;
        }

        for(int x=0;x<carne.length;x++) {
            todo[index] = carne[x];
            unidad_tod[index] = unidad_car[x];
            index++;
        }

        for(int x=0;x<marisco.length;x++) {
            todo[index] = marisco[x];
            unidad_tod[index] = unidad_mar[x];
            index++;
        }

        for(int x=0;x<chatarra.length;x++) {
            todo[index] = chatarra[x];
            unidad_tod[index] = unidad_cha[x];
            index++;
        }

        for(int x=0;x<lacteo.length;x++) {
            todo[index] = lacteo[x];
            unidad_tod[index] = unidad_lac[x];
            index++;
        }

        for(int x=0;x<otro.length;x++) {
            todo[index] = otro[x];
            unidad_tod[index] = unidad_otro[x];
            index++;
        }

    }
    //Ideas: Crear ArrayList de ingredientes y dentro de cada ingrediente si el valor es mayor a 1 agregar al ArrayList

    public ListadoIngredientesMercado() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public ListadoIngredientesMercado(Context mContext, int uso){
        this.mContext = mContext;
        this.uso = uso;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_ingredientes, container, false);

        verdura = getActivity().getResources().getStringArray(R.array.verduras);
        fruta = mContext.getResources().getStringArray(R.array.frutas);
        especia = mContext.getResources().getStringArray(R.array.especias);
        cereal = mContext.getResources().getStringArray(R.array.cereales);
        leguminosa = mContext.getResources().getStringArray(R.array.leguminosas);
        carne = mContext.getResources().getStringArray(R.array.carnes);
        marisco = mContext.getResources().getStringArray(R.array.mariscos);
        chatarra = mContext.getResources().getStringArray(R.array.chatarra);
        lacteo = mContext.getResources().getStringArray(R.array.lacteos);
        otro = mContext.getResources().getStringArray(R.array.otros);

        unidad_ver = mContext.getResources().getIntArray(R.array.verduras_unidad);
        unidad_fru = mContext.getResources().getIntArray(R.array.frutas_unidad);
        unidad_esp = mContext.getResources().getIntArray(R.array.especias_unidad);
        unidad_cer = mContext.getResources().getIntArray(R.array.cereales_unidad);
        unidad_leg = mContext.getResources().getIntArray(R.array.leguminosas_unidad);
        unidad_car = mContext.getResources().getIntArray(R.array.carnes_unidad);
        unidad_mar = mContext.getResources().getIntArray(R.array.mariscos_unidad);
        unidad_cha = mContext.getResources().getIntArray(R.array.chatarra_unidad);
        unidad_lac = mContext.getResources().getIntArray(R.array.lacteos_unidad);
        unidad_otro = mContext.getResources().getIntArray(R.array.otros_unidad);

        int n = verdura.length+fruta.length+especia.length+cereal.length+leguminosa.length+carne.length+marisco.length+chatarra.length+lacteo.length+otro.length;
        todo  = new String[n];
        unidad_tod = new int[n];

        fillTodo();
        verduras = view.findViewById(R.id.verduras);
        frutas = view.findViewById(R.id.frutas);
        especias = view.findViewById(R.id.especias);
        cereales = view.findViewById(R.id.cereales);
        leguminosas = view.findViewById(R.id.leguminosas);
        carnes = view.findViewById(R.id.carnes);
        mariscos = view.findViewById(R.id.mariscos);
        chatarras = view.findViewById(R.id.chatarra);
        lacteos = view.findViewById(R.id.lacteos);
        otros = view.findViewById(R.id.otros);
        todos = view.findViewById(R.id.todo);
        fab = view.findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NuevaReceta fragment = new NuevaReceta();
                Bundle args = new Bundle();

                String uri = "IMAGEN";
                String cateogia = "la categoia";
                String personas = "2";
                String votar = "2";
                String descripcion = "";

                args.putString("image",uri);
                args.putString("categoria",cateogia);
                args.putString("personas",personas);
                args.putString("votar",votar);
                args.putString("descripcion",descripcion);

                Extra.pushFragment((MainActivity) mContext,fragment);
            }
        });

        onClick();

        todos.setChecked(true);
        ingredientes = view.findViewById(R.id.ingredientesGrid);
        ingredientes.setFocusable(true);
        switch (uso){
            case 0: adapter = new IngredientesAdapter(mContext, todo,unidad_tod,lista); break;
            case 1: adapter = new IngredientesAdapter(mContext, todo,lista); break;
        }
        ingredientes.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    private void onClick(){
        todos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Log.e("modo","todo");
                    switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, todo,unidad_tod,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, todo,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
                }
        });

        verduras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","verdura");
                switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, verdura,unidad_ver,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, verdura,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
            }
        });

        frutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","fruta");
                    switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, fruta,unidad_fru,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, fruta,lista); break;
                    }
                    ingredientes.setAdapter(adapter);

            }
        });

        especias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","especia");
                switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, especia,unidad_esp,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, especia,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
                }
        });

        cereales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","cereal");
                switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, cereal,unidad_cer,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, cereal,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
            }
        });

        leguminosas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","leguminosa");
                switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, leguminosa,unidad_leg,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, leguminosa,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
                }
        });

        carnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","carne");
                switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, carne,unidad_car,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, carne,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
                }

        });

        mariscos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","marisco");
                switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, marisco,unidad_mar,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, marisco,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
                }
        });

        chatarras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","chatarra");
                switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, chatarra,unidad_cha,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, chatarra,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
                }
        });

        lacteos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","lacteo");
                switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, lacteo,unidad_lac,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, lacteo,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
                }
        });

        otros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("modo","otro");
                switch (uso){
                        case 0: adapter = new IngredientesAdapter(mContext, otro,unidad_otro,lista); break;
                        case 1: adapter = new IngredientesAdapter(mContext, otro,lista); break;
                    }
                    ingredientes.setAdapter(adapter);
                }
        });

    }



}

