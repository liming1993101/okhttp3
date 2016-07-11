package demo.lm.viedeodemo.network.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lm.okhttputils.OkHttpUtils;
import com.lm.okhttputils.callback.StringCallback;

import java.util.List;

import demo.lm.viedeodemo.bean.ClassifyEntity;
import demo.lm.viedeodemo.bean.MediaEntity;
import demo.lm.viedeodemo.network.MediaInfoNetwork;
import demo.lm.viedeodemo.ui.activity.ViedeoPalyActivity;
import demo.lm.viedeodemo.view.PalyViedeoView;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/5/16.
 */
public class MediaInfoNetworkImpl implements MediaInfoNetwork {
    private PalyViedeoView view;
    public MediaInfoNetworkImpl(ViedeoPalyActivity viedeoPalyActivity) {
        view= (PalyViedeoView) viedeoPalyActivity;
    }

    @Override
    public void MediaInfo(String id) {

        String url ="https://newapi.meipai.com/medias/show.json?id="+id;
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
                        MediaEntity ce=gson.fromJson(response,new TypeToken<MediaEntity>() {}.getType());
                        view.showMediaData(ce);
                    }
                });
    }
}
