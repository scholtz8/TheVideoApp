package cscholtz.android.thevideoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lista;

    String[][] datos = {
            {"South America","easymicro-2018"},
            {"North East Asia","hidden-conquest-237802"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.idListaServers);
        lista.setAdapter(new Adaptador(this, datos));
    }
}
