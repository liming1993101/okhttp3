package com.lm.okhttputils.callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/5/16.
 */
public class StringBuilderCallback extends Callback<StringBuilder> {
    @Override
    public StringBuilder parseNetworkResponse(Response response) throws Exception {
        StringBuilder builder = new StringBuilder();
        return builder.append(response.body().charStream());
    }

    @Override
    public void onError(Call call, Exception e) {

    }

    @Override
    public void onResponse(StringBuilder response) {

    }
}
