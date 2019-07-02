package cscholtz.android.thevideoapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListadorServidores extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Context contexto;
    private String[][] datos;

    public ListadorServidores(Context ct, String[][] dt){
        this.contexto = ct;
        this.datos = dt;
        inflater = (LayoutInflater) contexto.getSystemService(ct.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_lista,null);
        final TextView servidor = (TextView) vista.findViewById(R.id.servidor);
        servidor.setText(datos[position][0]);
        vista.setTag(position);

        vista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VideosActivity = new Intent(contexto, VideosListActivity.class);
                VideosActivity.putExtra("REGION",datos[(Integer)vista.getTag()][0]);
                VideosActivity.putExtra("SERVER",datos[(Integer)vista.getTag()][1]);
                contexto.startActivity(VideosActivity);
            }
        });
        return vista;
    }

    @Override
    public int getCount() { return this.datos.length; }

    @Override
    public Object getItem(int position) { return null; }

    @Override
    public long getItemId(int position) { return 0; }

}
