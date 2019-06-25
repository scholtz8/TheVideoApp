package cscholtz.android.thevideoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    String[][] datos = {
            {"America"},
            {"Asia"},
            {"Europa"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.idListaServers);
        lista.setAdapter(new Adaptador(this, datos));
    }
}
