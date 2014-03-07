package com.gmail.gonzaloantonio.examples.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentListado extends Fragment
{
    private Correo[] datos = new Correo [] {
            new Correo ("Persona 1", "Asunto de Correo 1", "Texto de Correo 1"),
            new Correo ("Persona 2", "Asunto de Correo 2", "Texto de Correo 2"),
            new Correo ("Persona 3", "Asunto de Correo 3", "Texto de Correo 3"),
            new Correo ("Persona 4", "Asunto de Correo 4", "Texto de Correo 4"),
            new Correo ("Persona 5", "Asunto de Correo 5", "Texto de Correo 5")
    };


    private ListView listado;

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {

        return inflater.inflate (R.layout.fragment_listado, container, false);

    }

    @Override
    public void onActivityCreated (Bundle state) {
        super.onActivityCreated (state);
        listado = (ListView) getView().findViewById (R.id.LstListado);
        listado.setAdapter (new AdaptadorCorreos (this));
    }

    class AdaptadorCorreos extends ArrayAdapter<Correo> {
        Activity context;

        AdaptadorCorreos (Fragment context) {
            super (context.getActivity (), R.layout.listitem_correo, datos);
            this.context = context.getActivity ();
        }

        public View getView (int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater ();
            View item = inflater.inflate (R.layout.listitem_correo, null);

            TextView LblDe = (TextView) item.findViewById (R.id.LblDe);
            LblDe.setText (datos[position].getDe ());

            TextView LblAsunto = (TextView) item.findViewById (R.id.LblAsunto);
            LblAsunto.setText (datos[position].getAsunto ());

            return item;
        }
    }
}
