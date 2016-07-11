package com.lm.okhttputils.builder;


import com.lm.okhttputils.OkHttpUtils;
import com.lm.okhttputils.request.OtherRequest;
import com.lm.okhttputils.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers).build();
    }
}
