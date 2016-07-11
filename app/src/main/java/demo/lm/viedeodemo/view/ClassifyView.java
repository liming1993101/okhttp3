package demo.lm.viedeodemo.view;

import demo.lm.viedeodemo.bean.ClassifyEntity;

/**
 * Created by Administrator on 2016/5/12.
 */
public interface ClassifyView {
    void showErr();
    void addCategoryInfo(ClassifyEntity entity);
    void bindCategoryData();
}
