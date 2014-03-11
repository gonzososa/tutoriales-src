package com.gmail.gonzaloantonio.examples.actionbar_i.actionbar_i;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate (R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId ()) {
            case R.id.menu_new:
                Log.i ("ActionBar", "Nuevo!");
                return true;
            case R.id.menu_save:
                Log.i ("ActionBar", "Guardar!");
                return true;
            case R.id.menu_settings:
                Log.i ("ActionBar", "Ajustes!");
                return true;
            default:
                return super.onOptionsItemSelected (item);
        }
    }

}