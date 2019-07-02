package cscholtz.android.thevideoapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {

    private TextView titulo;
    private VideoView videoView;
    private Uri videoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent intent = getIntent();
        Bundle bund = intent.getExtras();

        videoView = (VideoView) findViewById(R.id.videoView);
        titulo = (TextView) findViewById(R.id.tituloText);

        titulo.setText(bund.getString("TITULO"));
        videoUri = Uri.parse(bund.getString("URI"));

        videoView.setVideoURI(videoUri);
        videoView.requestFocus();
        videoView.start();


    }
}
