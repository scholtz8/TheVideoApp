package cscholtz.android.thevideoapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.VideoView;

public class VideoPlayerActivity extends AppCompatActivity {

    private VideoView videoView;
    private Uri videoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        videoView = (VideoView) findViewById(R.id.videoView);
        videoUri = Uri.parse(b.getString("URL"));
        videoView.setVideoURI(videoUri);
        videoView.requestFocus();
        videoView.start();


    }
}
