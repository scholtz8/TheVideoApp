package cscholtz.android.thevideoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class VideosActivity extends AppCompatActivity {

    ListView lista;
    String[][] datos = {
            {"Video 1","movie.mp4"},
            {"Video 2","movie2.mp4"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        lista = (ListView) findViewById(R.id.idListaVideos);
        lista.setAdapter(new Adaptador2(this, datos, b.getString("SRV")));

    }
}
