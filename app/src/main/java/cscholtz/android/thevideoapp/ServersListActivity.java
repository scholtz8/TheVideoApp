package cscholtz.android.thevideoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ServersListActivity extends AppCompatActivity {

    ListView listaServers;
    String[][] datos = {
            {"Locally","android.resource://cscholtz.android.thevideoapp/raw/"},
            {"South America","https://easymicro-2018.appspot.com/videos/"},
            {"North East Asia","https://hidden-conquest-237802.appspot.com/videos/"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaServers = (ListView) findViewById(R.id.idListaServers);
        listaServers.setAdapter(new ListadorServidores(this, datos));
    }
}
