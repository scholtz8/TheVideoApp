package cscholtz.android.thevideoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class VideosListActivity extends AppCompatActivity {

    ListView listaVideos;
    String[][] datos = {
            {"144"},
            {"360"},
            {"720"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        Intent intent = getIntent();
        Bundle bund = intent.getExtras();

        listaVideos = (ListView) findViewById(R.id.idListaVideos);
        listaVideos.setAdapter(new ListadorVideos(this, datos, bund.getString("SERVER"),bund.getString("REGION")));

    }
}
