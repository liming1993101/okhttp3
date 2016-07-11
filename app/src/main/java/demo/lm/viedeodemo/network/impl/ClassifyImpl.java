package demo.lm.viedeodemo.network.impl;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lm.okhttputils.OkHttpUtils;
import com.lm.okhttputils.callback.StringCallback;

import java.util.List;

import demo.lm.viedeodemo.bean.ClassifyEntity;
import demo.lm.viedeodemo.utils.ResultCallback;
import demo.lm.viedeodemo.network.Classify;
import demo.lm.viedeodemo.view.ClassifyView;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/5/12.
 */
public class ClassifyImpl implements Classify {

    private ClassifyView view;
    public ClassifyImpl(Context context) {
        view= (ClassifyView) context;
    }

    @Override
    public void classifyInfo() {

        String url ="https://newapi.meipai.com/channels/header_list.json?language=zh-Hans";
        OkHttpUtils
                .post()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        Gson gson=new Gson();
                        List<ClassifyEntity> ce=gson.fromJson(response,new TypeToken<List<ClassifyEntity>>() {}.getType());
                        for(ClassifyEntity classifyEntity:ce) {
                            classifyEntity.setName(classifyEntity.getName().trim().replaceAll("#", ""));
                            view.addCategoryInfo(classifyEntity);
                        }
                        view.bindCategoryData();
                    }
                });
    }
}
