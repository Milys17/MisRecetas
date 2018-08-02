package com.pudin.misrecetas;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavSwitchController;
import com.ncapdevi.fragnav.FragNavTransactionOptions;
import com.pudin.misrecetas.A_Adaptadores.NuevaRecetaAdapter;
import com.pudin.misrecetas.A_Modelos.Receta;
import com.pudin.misrecetas.Menu_Semanal.MenuSemanal;
import com.pudin.misrecetas.Mercado.Mercado;
import com.pudin.misrecetas.Recetas.RecetaImage;
import com.pudin.misrecetas.Recetas.Recetas;
import com.squareup.picasso.Picasso;

import java.io.File;

import pl.aprilapps.easyphotopicker.EasyImage;

public class MainActivity extends AppCompatActivity implements FragNavController.RootFragmentListener, BottomNavigationView.OnNavigationItemSelectedListener{
    public FragNavController.Builder builder;
    private FragNavController mFragNavController;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        configFragNav(savedInstanceState);

    }

    private void configFragNav(Bundle savedInstanceState) {
        builder = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.container);
        mFragNavController = builder.rootFragmentListener(this, 3)
                .switchController(new FragNavSwitchController() {
                    @Override
                    public void switchTab(int index, @Nullable FragNavTransactionOptions transactionOptions) {

                    }
                }).build();
    }

    @Override
    public Fragment getRootFragment(int index) {

        switch (index) {
            case 0:
                return new Recetas();
            case 1:
                return new Mercado();
            case 2:
                return new MenuSemanal();

        }
        throw new IllegalStateException("Need to send an index that we know");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mFragNavController != null) {
            mFragNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.Recetas:
                mFragNavController.switchTab(0);
                return true;
            case R.id.Mercado:
                mFragNavController.switchTab(1);
                return true;
            case R.id.Menu:
                mFragNavController.switchTab(2);
                return true;
        }
        return false;
    }

    public void pushFragment(Fragment fragment) {
        mFragNavController.pushFragment(fragment);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EasyImage.handleActivityResult(requestCode, resultCode, data, this, new EasyImage.Callbacks() {
            @Override
            public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {

            }

            @Override
            public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
                Log.e("mostrar","llega hasta aca");
                RecetaImage.uriImagen = imageFile.toURI();
                Picasso.get().load(imageFile).into(RecetaImage.imagen);
            }

            @Override
            public void onCanceled(EasyImage.ImageSource source, int type) {

            }
        });
    }
}


