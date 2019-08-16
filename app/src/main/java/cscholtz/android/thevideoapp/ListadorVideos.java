package cscholtz.android.thevideoapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListadorVideos extends BaseAdapter {

    private static LayoutInflater inflater = null;
    private Context contexto;
    private String[][] datos;
    private String server;
    private String region;

    public ListadorVideos(Context ct, String[][] dt, String srv, String reg){
        this.contexto = ct;
        this.datos = dt;
        this.server = srv;
        this.region = reg;
        inflater = (LayoutInflater) contexto.getSystemService(ct.LAYOUT_INFLATER_SERVICE);
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
                String UriStr;

                if(region.equals("Locally")){
                    UriStr = server+"m"+datos[position][0]+"p";
                }
                else{
                    UriStr = server+datos[position][0];
                }
                Intent VideoPlayerActivity = new Intent(contexto,VideoPlayerActivity.class);
                VideoPlayerActivity.putExtra("URI",UriStr);
                VideoPlayerActivity.putExtra("TITULO",region+" - "+datos[position][0]);
                contexto.startActivity(VideoPlayerActivity);
            }
        });
        return vista;
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
}