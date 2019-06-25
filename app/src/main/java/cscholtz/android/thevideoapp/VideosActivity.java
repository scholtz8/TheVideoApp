package cscholtz.android.thevideoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        TextView texto = findViewById(R.id.elTexto);
        texto.setText(b.getString("SRV"));

    }
}
