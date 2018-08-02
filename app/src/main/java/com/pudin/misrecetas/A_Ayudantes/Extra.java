package com.pudin.misrecetas.A_Ayudantes;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.pudin.misrecetas.MainActivity;
import com.pudin.misrecetas.R;

public class Extra {

    public String fromURLtoURI(String url){
        Uri uri = Uri.parse(url);
        return uri.toString();
    }

    public static void pushFragment(Activity activity, Fragment fragment){
        ((MainActivity) activity).pushFragment(fragment);

    }

    public static void MensajeError(String mensaje, Context context){
        MaterialDialog.Builder error = new MaterialDialog.Builder(context);
        error.content(mensaje);
        error.contentColor(context.getResources().getColor(R.color.rojo));
        error.canceledOnTouchOutside(false);
        error.cancelable(false);
        error.positiveColor(context.getResources().getColor(R.color.negro));
        error.positiveText(R.string.aceptar);

        error.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
            }
        });
    }

    public static void MensajeAceptar(String mensaje, Context context){
        MaterialDialog.Builder ok = new MaterialDialog.Builder(context);
        ok.content(mensaje);
        ok.contentColor(context.getResources().getColor(R.color.verde));
        ok.canceledOnTouchOutside(false);
        ok.cancelable(false);
        ok.positiveColor(context.getResources().getColor(R.color.negro));
        ok.positiveText(R.string.aceptar);

        ok.onPositive(new MaterialDialog.SingleButtonCallback() {
            @Override
            public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                dialog.dismiss();
            }
        });
    }
}
