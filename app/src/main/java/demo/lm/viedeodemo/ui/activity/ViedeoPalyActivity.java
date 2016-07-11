package demo.lm.viedeodemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;

import demo.lm.viedeodemo.R;
import demo.lm.viedeodemo.bean.CommentEntity;
import demo.lm.viedeodemo.bean.MediaEntity;
import demo.lm.viedeodemo.network.MediaInfoNetwork;
import demo.lm.viedeodemo.view.PalyViedeoView;

public class ViedeoPalyActivity extends AppCompatActivity implements PalyViedeoView{

    private String medias_id;
    private VideoControllerView viedeoControlView;
    private MediaInfoNetwork mediaInfoNetwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viedeo_paly);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        medias_id = getIntent().getStringExtra("id");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initView();
        initData();
    }

    private void initView() {
        viedeoControlView= (VideoControllerView) findViewById(R.id.video_view_control);
    }
    private void initData(){
        viedeoControlView.setVideoPath("http://mvvideo2.meitudata.com/57748c3535b0b1652.mp4");
        viedeoControlView.start();



    }

    @Override
    public void showMediaData(MediaEntity mediaEntity) {
        viedeoControlView.setVideoPath(mediaEntity.getVideo());
        viedeoControlView.start();
    }

    @Override
    public void showLoadMediaError() {

    }

    @Override
    public void refreshComment(List<CommentEntity> dataList) {

    }

    @Override
    public void showMoreComments(List<CommentEntity> dataList) {

    }
}
