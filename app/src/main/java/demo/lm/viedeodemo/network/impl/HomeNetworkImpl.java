package demo.lm.viedeodemo.network.impl;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lm.okhttputils.OkHttpUtils;
import com.lm.okhttputils.callback.StringCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.lm.viedeodemo.bean.ClassifyEntity;
import demo.lm.viedeodemo.bean.ContentEntity;
import demo.lm.viedeodemo.network.HomeNetwork;
import demo.lm.viedeodemo.utils.ResultCallback;
import demo.lm.viedeodemo.utils.TimeUtils;
import demo.lm.viedeodemo.view.ContentView;
import okhttp3.Call;

/**
 * Created by Administrator on 2016/5/11.
 */
public class HomeNetworkImpl implements HomeNetwork {
    ContentView view;
    public HomeNetworkImpl(ContentView context) {
        view=context;
    }

    @Override
    public void loadMore(int id,int page) {

        requsetInfo(id,page,2);
    }

    @Override
    public void refresh(int id,int page) {
        requsetInfo(id,page,1);
    }
    public void requsetInfo(int id,int page,final int type)
    {
        final long current_time = TimeUtils.getCurrentTime();
        String url ="https://newapi.meipai.com/channels/feed_timeline.json?id="+id+"&page="+page;
        Map<String,String> map=new HashMap<String,String>();
        map.put("id",id+"");
        map.put("page",page+"");
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
                        final   List<ContentEntity> ce=gson.fromJson(response,new TypeToken<List<ContentEntity>>() {}.getType());
                        if (type==1) {
                            int delay = 0;
                            if (TimeUtils.getCurrentTime() - current_time < 1000) {
                                //延时一秒
                                delay =1000;
                            }
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    view.refreshComment(ce);
                                }
                            }, delay);

                        }
                        else
                        {
                            int delay = 0;
                            if (TimeUtils.getCurrentTime() - current_time < 1000) {
                                //延时一秒
                                delay =1000;
                            }
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    view.showMoreComments(ce);
                                }
                            }, delay);

                        }

                    }
                });
    }
    private void updateView(final List<ContentEntity> entities, int delay, final int page) {
        //定时器延时刷新接界面
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, delay);
    }
}
