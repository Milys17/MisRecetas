package com.pudin.misrecetas.A_Ayudantes;

import android.content.Context;
import com.pudin.misrecetas.R;
public class IngredienteHelper {

    private static String[] ingrediente;
    private static int[] unidad;
    private String[] FormaUnidad;

    public static String[][] NombreUnidad;

    public IngredienteHelper(Context context){
        setFormaUnidad(context);
    }

    public IngredienteHelper(String[] ingrediente, int[] unidad, Context context){
        this.ingrediente = ingrediente;
        this.unidad = unidad;
        setFormaUnidad(context);
    }

    private void setFormaUnidad(Context context){
        switch (Configuraciones.FormaDesplegarUnidades){
            case 0: FormaUnidad = context.getResources().getStringArray(R.array.unidad_abreviatura);
                break;

            case 1: FormaUnidad = context.getResources().getStringArray(R.array.unidad_normal);
                break;
        }
    }

    public String[] getFormaUnidad() {
        return FormaUnidad;
    }

    public String[][] getNombreUnidad() {
        NombreUnidad = new String [ingrediente.length][2];
        for(int i=0;i<ingrediente.length;i++){
            for(int j=0;j<2;j++){
                if(j==0){
                    NombreUnidad[i][j] = ingrediente[i];
                }
                if(j==1){
                    NombreUnidad[i][j] = FormaUnidad[unidad[i]];
                }
            }
        }
        return NombreUnidad;
    }
}
