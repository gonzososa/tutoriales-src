package com.gmail.gonzaloantonio.examples.fragments;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class DetalleActivity  extends FragmentActivity {

    public static final String INTENT_TEXTO_EXTRA = "DAENERYS";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_detalle);

        FragmentDetalle detalle =
                (FragmentDetalle) getSupportFragmentManager().findFragmentById (R.id.FrgDetalle);
        detalle.mostrarDetalle (getIntent().getStringExtra (INTENT_TEXTO_EXTRA));
    }

}
