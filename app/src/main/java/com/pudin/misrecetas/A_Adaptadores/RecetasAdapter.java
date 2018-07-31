package com.pudin.misrecetas.A_Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.pudin.misrecetas.A_Ayudantes.Extra;
import com.pudin.misrecetas.MainActivity;
import com.pudin.misrecetas.A_Modelos.Receta;
import com.pudin.misrecetas.Recetas.NuevaReceta;
import com.pudin.misrecetas.R;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecetasAdapter extends BaseAdapter{

    private ArrayList<Receta> items;
    private Context mContext;

    public RecetasAdapter(Context mContext, ArrayList<Receta> items){
        this.mContext = mContext;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(i==0){
            view = LayoutInflater.from(mContext).inflate(R.layout.addcard_receta, viewGroup, false);
            ImageButton addReceta = view.findViewById(R.id.addButton);
            addReceta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NuevaReceta fragment = new NuevaReceta();
                    Extra.pushFragment((MainActivity) mContext,fragment);
                }
            });
        }else {
            Receta item = items.get(i);
            view = LayoutInflater.from(mContext).inflate(R.layout.card_receta, viewGroup, false);
            ImageView imagen = view.findViewById(R.id.imagen);
            TextView nombre = view.findViewById(R.id.nombre);
            TextView categoria = view.findViewById(R.id.categoria);
            TextView votacion = view.findViewById(R.id.votacion);

            //Picasso.get().load(item.getImagen()).into(imagen);
            nombre.setText(item.getNombre());
            categoria.setText("Categoria: " + item.getCategoria());
            votacion.setText("Votacion: " + item.getVotacion());
        }
        return view;
    }
}
