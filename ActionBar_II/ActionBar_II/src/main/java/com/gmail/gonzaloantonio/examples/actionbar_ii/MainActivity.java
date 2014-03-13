package com.gmail.gonzaloantonio.examples.actionbar_ii;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        ActionBar abar = getActionBar ();
        abar.setNavigationMode (ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = abar.newTab().setText ("Tab 1");
        ActionBar.Tab tab2 = abar.newTab().setText ("Tab 2");

        Fragment tab1frag = new Tab1Fragment ();
        Fragment tab2frag = new Tab2Fragment ();

        tab1.setTabListener (new MyTabListener (tab1frag));
        tab2.setTabListener (new MyTabListener (tab2frag));

        abar.addTab (tab1);
        abar.addTab (tab2);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate (R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId ()) {
            case R.id.menu_settings:
                Log.i ("ActionBar", "¡Ajustes!");
                return true;
            case R.id.menu_save:
                Log.i ("ActionBar", "¡Guardar!");
                return true;
            case R.id.menu_new:
                Log.i ("ActionBar", "¡Nuevo!");
                return true;
            default:
                return super.onOptionsItemSelected (item);
        }
    }

}