package com.gmail.gonzaloantonio.examples.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity implements CorreosListener {

    private static final boolean DEVELOPER_MODE = true;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy (new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .build());

            StrictMode.setVmPolicy (new StrictMode.VmPolicy.Builder()
                .penaltyLog()
                .penaltyDeath()
                .build());
        }

        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        FragmentListado frgListado =
                (FragmentListado) getSupportFragmentManager().findFragmentById (R.id.FrgListado);
        frgListado.setCorreosListener (this);
    }

    public void onCorreoSeleccionado (Correo c) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById (R.id.FrgDetalle)) != null;

        if (hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager()
                    .findFragmentById (R.id.FrgDetalle))
                    .mostrarDetalle (c.getTexto());
        }
        else {
            Intent i = new Intent (this, DetalleActivity.class);
            i.putExtra (DetalleActivity.INTENT_TEXTO_EXTRA, c.getTexto ());
            startActivity (i);
        }
    }

}
