package demo.lm.viedeodemo.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/16.
 */
public class MediaEntity implements Serializable {
    private String video;
    private String id;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    private String caption;
    private String avatar;
}
