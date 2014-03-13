package com.gmail.gonzaloantonio.examples.actionbarcompat;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

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
            case R.id.action_settings:
                Log.i ("ActionBar", "¡Ajustes!");
                return true;
            case R.id.action_search:
                Log.i ("ActionBar","Búsqueda");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}