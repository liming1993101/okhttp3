package demo.lm.viedeodemo.view;

import java.util.List;

import demo.lm.viedeodemo.bean.ContentEntity;

/**
 * Created by Administrator on 2016/5/12.
 */
public interface ContentView {
    void showMediaData(ContentEntity contentEntity);

    void showLoadMediaError();

    void refreshComment(List<ContentEntity> dataList);


    void showMoreComments(List<ContentEntity> dataList);
}
