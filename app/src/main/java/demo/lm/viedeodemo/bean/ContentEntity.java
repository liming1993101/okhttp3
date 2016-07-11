package demo.lm.viedeodemo.bean;

import java.io.Serializable;

import io.vov.vitamio.provider.MediaStore;

/**
 * Created by Administrator on 2016/5/12.
 */
public class ContentEntity implements Serializable {
    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public MediaEntity getMedia() {
        return media;
    }

    public void setMedia(MediaEntity media) {
        this.media = media;
    }

    private MediaEntity media;
    private String video;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private  String recommend_caption;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;


    public String getRecommend_cover_pic() {
        return recommend_cover_pic;
    }

    public void setRecommend_cover_pic(String recommend_cover_pic) {
        this.recommend_cover_pic = recommend_cover_pic;
    }

    public String getRecommend_caption() {
        return recommend_caption;
    }

    public void setRecommend_caption(String recommend_caption) {
        this.recommend_caption = recommend_caption;
    }

    private  String recommend_cover_pic;
}
