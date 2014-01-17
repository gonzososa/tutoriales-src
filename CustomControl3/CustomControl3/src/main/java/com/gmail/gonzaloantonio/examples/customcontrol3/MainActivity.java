package com.gmail.gonzaloantonio.examples.customcontrol3;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        ControlPersonalizado customControl3 = (ControlPersonalizado) findViewById (R.id.customControl3);
        customControl3.setOnColorSelectedListener (
                new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int color) {

                    }
                }
        );
    }

}
