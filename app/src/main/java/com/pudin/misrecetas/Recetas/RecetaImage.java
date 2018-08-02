package com.pudin.misrecetas.Recetas;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.pudin.misrecetas.A_Ayudantes.Extra;
import com.pudin.misrecetas.MainActivity;
import com.pudin.misrecetas.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.net.URI;

import pl.aprilapps.easyphotopicker.EasyImage;

public class RecetaImage extends Fragment {

    private Button guardar,cancelar;
    public static ImageView imagen;
    public static URI uriImagen;
    private Context mContext;

    public RecetaImage() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public RecetaImage(Context mContext) {
        this.mContext = mContext;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_receta_image, container, false);
        imagen = view.findViewById(R.id.imagen);
        guardar = view.findViewById(R.id.guardar);
        cancelar = view.findViewById(R.id.cancelar);

        Picasso.get().load(R.drawable.default_camera).resize(250,250).into(imagen);

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EasyImage.openChooserWithGallery((MainActivity) mContext,"Agregar una imagen",0);
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uriImagen != null){
                    NuevaReceta fragment = new NuevaReceta();
                    Bundle args = new Bundle();
                    args.putString("imagen",uriImagen.toString());
                    fragment.setArguments(args);
                    Extra.pushFragment(getActivity(),fragment);
                }else{
                    Extra.MensajeError(getString(R.string.imagen_erronea),getContext());
                }
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NuevaReceta fragment = new NuevaReceta();
                Extra.pushFragment(getActivity(),fragment);
            }
        });
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
