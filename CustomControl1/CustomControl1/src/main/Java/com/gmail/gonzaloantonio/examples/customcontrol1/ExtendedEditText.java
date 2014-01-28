package com.gmail.gonzaloantonio.examples.customcontrol1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

public class ExtendedEditText extends EditText
{
    Paint p1, p2;
    float escala;

    public ExtendedEditText (Context context)
    {
        super (context);
        inicializacion ();
    }

    public ExtendedEditText (Context context, AttributeSet attrs)
    {
        super (context, attrs);
        inicializacion ();
    }

    public ExtendedEditText (Context context, AttributeSet attrs, int defStyle)
    {
        super (context, attrs, defStyle);
        inicializacion ();
    }

    public void inicializacion ()
    {
        try {
            escala = getResources().getDisplayMetrics().density;
        }
        catch (NullPointerException nex) {
            Log.e ("FALLA", nex.getMessage().toString());
            return;
        }

        p1 = new Paint (Paint.ANTI_ALIAS_FLAG);
        p1.setColor (Color.BLACK);
        p1.setStyle (Paint.Style.FILL);

        p2 = new Paint (Paint.ANTI_ALIAS_FLAG);
        p2.setColor (Color.WHITE);
        p2.setTextSize(20);
    }

    @Override
    public void onDraw (Canvas canvas)
    {
        super.onDraw (canvas);

        if (p1 == null || p2 == null ) return;

        canvas.drawRect (this.getWidth () - 30 * escala,
                        5 * escala,
                        this.getWidth () - 5 * escala,
                        20 * escala, p1);

        canvas.drawText ("" + this.getText().toString().length(),
                        this.getWidth () - 28 * escala,
                        17 * escala, p2);
    }
}