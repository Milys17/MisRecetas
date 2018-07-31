package com.pudin.misrecetas.A_Adaptadores;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.pudin.misrecetas.A_Modelos.Ingrediente;
import com.pudin.misrecetas.R;

import java.util.ArrayList;

public class IngredientesAdapter extends BaseAdapter{

    private Context mContext;

    private ArrayList<Ingrediente> Lista;
    private String[] items;
    private int[] unidades;
    private int uso = -1;

    public interface IngredientesListener{
        void eliminar(Ingrediente ing);
        void agregar(Ingrediente ing);
    }

    //receta
    public IngredientesAdapter(Context mContext, String[] items, ArrayList<Ingrediente> Lista){
        this.mContext = mContext;
        this.items = items;
        this.Lista = Lista;
        uso = 1;
           // 0 - Mandado , 1 - receta
    }

    //mandado
    public IngredientesAdapter(Context mContext, String[] items,int[] unidades, ArrayList<Ingrediente> Lista){
        this.mContext = mContext;
        this.items = items;
        this.Lista = Lista;
        this.unidades = unidades;
        uso = 0;
        // 0 - Mandado , 1 - receta
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.card_ingrediente,viewGroup,false);

        Button tituloIngrediente = view.findViewById(R.id.ingredienteTexto);
        LinearLayout use = view.findViewById(R.id.uso);
        switch (uso){
            case 0:
                TextView unidad1 = new TextView(use.getContext());
                unidad1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                unidad1.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                unidad1.setText(mContext.getResources().getStringArray(R.array.unidad_normal)[unidades[i]]);
                use.addView(unidad1);
            break;

            case 1:
                Spinner unidad2 = new Spinner(use.getContext());
                unidad2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                unidad2.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                unidad2.setAdapter(new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,mContext.getResources().getStringArray(R.array.unidad_normal)));
            break;
        }
        Button menos = view.findViewById(R.id.less);
        Button mas = view.findViewById(R.id.more);

        final TextView cuenta = view.findViewById(R.id.count);
        tituloIngrediente.setText(items[i]);

        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(cuenta.getText().toString());
                if(n <= 0){
                    n = 0;
                }else{
                    n--;
                }
                cuenta.setText(String.valueOf(n));
            }
        });

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(cuenta.getText().toString());
                n++;
                cuenta.setText(String.valueOf(n));
            }
        });

        /*int index = -1;
        for(int z=0;z<ingredientes.size();z++){
            if(ingredientes.get(z).getIngrediente().equals(tituloIngrediente.getText().toString())){
                index = z;
                break;
            }
        }
        if(index != -1){
                if(ingredientes.get(index).getCantidad() == 0){
                    ingredientes.remove(index);
                }
        }else{
            if(Integer.parseInt(cuenta.getText().toString()) > 0){
                ingredientes.add(ingredient);
            }
        }
        */
        return view;
    }



}
