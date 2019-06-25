package cscholtz.android.thevideoapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contexto;
    String[][] datos;

    public Adaptador(Context ctexto,String[][] dt){
        this.contexto = ctexto;
        this.datos = dt;
        inflater = (LayoutInflater) contexto.getSystemService(ctexto.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return this.datos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_lista_servidor,null);
        final TextView servidor = (TextView) vista.findViewById(R.id.servidor);
        servidor.setText(datos[position][0]);

        vista.setTag(position);

        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VideosActivity = new Intent(contexto,VideosActivity.class);
                VideosActivity.putExtra("SRV",datos[(Integer)vista.getTag()][0]);
                contexto.startActivity(VideosActivity);
            }
        });


        return vista;
    }
}
