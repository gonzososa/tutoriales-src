package com.gmail.gonzaloantonio.examples.customcontrol3;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ControlPersonalizado extends View
{
    private int colorSeleccionado;
    private OnColorSelectedListener listener;

    public ControlPersonalizado (Context context)
    {
        super (context);
    }

    public ControlPersonalizado (Context context, AttributeSet attrs)
    {
        super (context, attrs);
    }

    public ControlPersonalizado (Context context, AttributeSet attrs, int defStyle)
    {
        super (context, attrs, defStyle);
    }

    public void onMeasure (int widthMeasureSpec, int heightMeasureSpec)
    {
        int ancho = calcularAncho (widthMeasureSpec);
        int alto = calcularAlto (heightMeasureSpec);

        setMeasuredDimension (ancho, alto);
    }

    private int calcularAlto (int limitesSpec)
    {
        int res = 100;

        int modo = MeasureSpec.getMode (limitesSpec);
        int limite = MeasureSpec.getSize (limitesSpec);

        if (modo == MeasureSpec.AT_MOST) {
            res = limite;
        }
        else if (modo == MeasureSpec.EXACTLY) {
            res = limite;
        }

        return res;
    }

    private int calcularAncho (int limitesSpec)
    {
        int res = 200;

        int modo = MeasureSpec.getMode (limitesSpec);
        int limite = MeasureSpec.getSize (limitesSpec);

        if (modo == MeasureSpec.AT_MOST) {
            res = limite;
        }
        else if (modo == MeasureSpec.EXACTLY) {
            res = limite;
        }

        return res;
    }

    @Override
    protected void onDraw (Canvas canvas)
    {
        int alto = getMeasuredHeight ();
        int ancho = getMeasuredWidth ();

        Paint pRelleno = new Paint ();
        pRelleno.setStyle (Paint.Style.FILL);

        pRelleno.setColor (Color.RED);
        canvas.drawRect (0, 0, ancho / 4, alto / 2, pRelleno);

        pRelleno.setColor (Color.GREEN);
        canvas.drawRect (ancho / 4, 0, 2 * (ancho / 4), alto / 2, pRelleno);

        pRelleno.setColor (Color.BLUE);
        canvas.drawRect (2 * (ancho / 4), 0, 3 * (ancho / 4), alto / 2, pRelleno);

        pRelleno.setColor (Color.YELLOW);
        canvas.drawRect (3 * (ancho / 4), 0, 4 * (ancho / 4), alto / 2, pRelleno);

        pRelleno.setColor (colorSeleccionado);
        canvas.drawRect (0, alto / 2, ancho, alto, pRelleno);

        Paint pBorde = new Paint ();
        pBorde.setStyle (Paint.Style.STROKE);
        pBorde.setColor (Color.WHITE);
        canvas.drawRect (0, 0, ancho - 1, alto / 2, pBorde);
        canvas.drawRect (0, 0, ancho - 1, alto - 1, pBorde);
    }

    @Override
    public boolean onTouchEvent (MotionEvent event)
    {
        if (event.getY() > 0 && event.getY() < (getMeasuredHeight() / 2))
        {
            if (event.getX() > 0 && event.getX() < getMeasuredWidth())
            {
                if (event.getX() > (getMeasuredWidth() / 4) * 3)
                    colorSeleccionado = Color.YELLOW;
                else if (event.getX() > (getMeasuredWidth() / 4) * 2)
                    colorSeleccionado = Color.BLUE;
                else if (event.getX() > (getMeasuredWidth() / 4))
                    colorSeleccionado = Color.GREEN;
                else
                    colorSeleccionado = Color.RED;

                this.invalidate ();
            }
            else if (event.getY() > (getMeasuredHeight() / 2) && event.getY() < getMeasuredHeight())
            {
                listener.onColorSelected (colorSeleccionado);
            }
        }

        return super.onTouchEvent (event);
    }

    public void setOnColorSelectedListener (OnColorSelectedListener l)
    {
        listener = l;
    }
}
