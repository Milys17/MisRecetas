package com.pudin.misrecetas.Recetas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.pudin.misrecetas.A_Adaptadores.NuevaRecetaAdapter;
import com.pudin.misrecetas.R;


public class NuevaReceta extends Fragment {

    private GridView gridView;
    private NuevaRecetaAdapter adapter;
    public NuevaReceta() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nueva_receta, container, false);
        gridView = view.findViewById(R.id.nueva_receta_gridview);
        if(getArguments() == null){
            // inicial
            adapter = new NuevaRecetaAdapter(getContext());
        }else{
            // previamente llenado
            adapter = new NuevaRecetaAdapter(getContext());
        }
        gridView.setAdapter(adapter);
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
}
