package com.gmail.gonzaloantonio.examples.ejemplofichas;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Resources res = getResources ();

        TabHost tabs = (TabHost) findViewById (android.R.id.tabhost);
        tabs.setup ();

        TabSpec spec = tabs.newTabSpec ("gonzotab1");
        spec.setContent (R.id.tab1);
        spec.setIndicator ("", res.getDrawable (R.drawable.ic_launcher));
        tabs.addTab (spec);

        spec = tabs.newTabSpec ("gonzotab2");
        spec.setContent (R.id.tab2);
        spec.setIndicator ("TAB 2", res.getDrawable (R.drawable.ic_launcher));
        tabs.addTab (spec);

        tabs.setOnTabChangedListener (new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i ("FICHAS DEMO", "Pulsada la pestaña " + tabId);
            }
        });

        tabs.setCurrentTab (0);
    }

}
