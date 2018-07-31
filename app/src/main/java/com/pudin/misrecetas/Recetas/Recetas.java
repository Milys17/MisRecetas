package com.pudin.misrecetas.Recetas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.pudin.misrecetas.A_Adaptadores.RecetasAdapter;
import com.pudin.misrecetas.A_Ayudantes.Extra;
import com.pudin.misrecetas.A_Modelos.Receta;
import com.pudin.misrecetas.R;

import java.util.ArrayList;

public class Recetas extends Fragment {

    private GridView Grid;
    private ArrayList<Receta> items = new ArrayList<>();
    private RecetasAdapter adapter;

    public Recetas() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fillRecipes();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recetas, container, false);
        Grid = view.findViewById(R.id.grid);
        Grid.setFocusable(true);
        adapter = new RecetasAdapter(getContext(), items);
        Grid.setAdapter(adapter);
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

    private void fillRecipes(){
        for (int x=0;x<10;x++){
            Receta recipe = new Receta();
            recipe.setImagen(new Extra().fromURLtoURI("https://image.flaticon.com/icons/png/512/532/532437.png"));
            recipe.setNombre("Nombre");
            recipe.setCategoria("Categoria");
            recipe.setVotacion(x);
            items.add(x,recipe);
        }
    }

}
