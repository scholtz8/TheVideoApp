package cscholtz.android.thevideoapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Adaptador2 extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contexto;
    String[][] datos;
    String server;

    public Adaptador2(Context ctexto,String[][] dt,String serverdor){
        this.contexto = ctexto;
        this.datos = dt;
        this.server = serverdor;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_lista,null);
        final TextView servidor = (TextView) vista.findViewById(R.id.servidor);
        servidor.setText(datos[position][0]);

        vista.setTag(position);

        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VideoPlayerActivity = new Intent(contexto,VideoPlayerActivity.class);
                String link = "https://"+server+".appspot.com/"+datos[position][1];
                VideoPlayerActivity.putExtra("URL",link);
                contexto.startActivity(VideoPlayerActivity);
            }
        });


        return vista;
    }
}