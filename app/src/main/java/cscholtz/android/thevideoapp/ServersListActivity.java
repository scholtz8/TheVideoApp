package cscholtz.android.thevideoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ServersListActivity extends AppCompatActivity {

    ListView listaServers;
    String[][] datos = {
            {"South America","easymicro-2018"},
            {"North East Asia","hidden-conquest-237802"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaServers = (ListView) findViewById(R.id.idListaServers);
        listaServers.setAdapter(new ListadorServidores(this, datos));
    }
}
