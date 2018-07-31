package com.pudin.misrecetas.A_Ayudantes;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.app.Fragment;

import com.pudin.misrecetas.MainActivity;

public class Extra {

    public String fromURLtoURI(String url){
        Uri uri = Uri.parse(url);
        return uri.toString();
    }

    public static void pushFragment(Activity activity, Fragment fragment){
        ((MainActivity) activity).pushFragment(fragment);

    }
}
