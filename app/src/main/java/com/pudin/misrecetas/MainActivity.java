package com.pudin.misrecetas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavSwitchController;
import com.ncapdevi.fragnav.FragNavTransactionOptions;
import com.pudin.misrecetas.Menu_Semanal.MenuSemanal;
import com.pudin.misrecetas.Mercado.Mercado;
import com.pudin.misrecetas.Recetas.Recetas;

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
}
