package com.gmail.gonzaloantonio.examples.actionbar_ii;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.util.Log;

public class MyTabListener implements ActionBar.TabListener {

    private Fragment fragment;

    public MyTabListener (Fragment frg) {
        this.fragment = frg;
    }

    @Override
    public void onTabReselected (ActionBar.Tab tab, FragmentTransaction ft) {
        Log.i ("ActionBar", tab.getText () + " reseleccionada");
    }

    @Override
    public void onTabSelected (ActionBar.Tab tab, FragmentTransaction ft) {
        Log.i ("ActionBar", tab.getText () + " seleccionada");
        ft.replace (R.id.contenedor, fragment);
    }

    @Override
    public void onTabUnselected (ActionBar.Tab tab, FragmentTransaction ft) {
        Log.i ("ActionBar", tab.getText () + " deseleccionada");
        ft.remove (fragment);
    }

}