package demo.lm.viedeodemo.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import demo.lm.viedeodemo.R;
import io.vov.vitamio.widget.VideoView;

public class ViedeoActivity extends AppCompatActivity {

    private VideoView mVideoView;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viedeo);
        url=getIntent().getStringExtra("url");
        initView();

    }

    private void initView() {
        mVideoView= (VideoView) findViewById(R.id.videoView1);
        mVideoView.setVideoPath(url);
        mVideoView.start();
    }
}
