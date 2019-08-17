package cscholtz.android.thevideoapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoPlayerActivity extends AppCompatActivity {

    private TextView titulo;
    private VideoView videoView;
    private Uri videoUri;
    private Button playBut;
    private TextView ts1, ts2, t;
    private SimpleDateFormat tsf;
    private String t1, t2, t3;
    private Date d1, d2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Intent intent = getIntent();
        Bundle bund = intent.getExtras();

        videoView = (VideoView) findViewById(R.id.videoView);
        titulo = (TextView) findViewById(R.id.tituloText);
        playBut = (Button) findViewById(R.id.playButton);
        ts1 = (TextView) findViewById(R.id.timestampText1);
        ts2 = (TextView) findViewById(R.id.timestampText2);
        t = (TextView) findViewById(R.id.timeText);
        tsf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        d1 = null;
        d2 = null;

        titulo.setText(bund.getString("TITULO"));
        videoUri = Uri.parse(bund.getString("URI"));
        videoView.setVideoURI(videoUri);
        videoView.requestFocus();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                t2 = tsf.format(new Date());
                try {
                    d1 = tsf.parse(t1);
                    d2 = tsf.parse(t2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long diff = d2.getTime() - d1.getTime();
                t3 = String.valueOf(diff);
                ts1.setText(t1);
                ts2.setText(t2);
                t.setText(t3+"ms");
            }
        });

        playBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    t1 = tsf.format(new Date());
                    videoView.start();
                    playBut.setEnabled(false);
            }
        });

    }
}
