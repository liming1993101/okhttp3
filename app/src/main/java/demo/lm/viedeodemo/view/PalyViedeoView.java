package demo.lm.viedeodemo.view;

import java.util.List;

import demo.lm.viedeodemo.bean.CommentEntity;
import demo.lm.viedeodemo.bean.MediaEntity;

/**
 * Created by Administrator on 2016/5/16.
 */
public interface PalyViedeoView {
    void showMediaData(MediaEntity mediaEntity);

    void showLoadMediaError();

    void refreshComment(List<CommentEntity> dataList);


    void showMoreComments(List<CommentEntity> dataList);
}
