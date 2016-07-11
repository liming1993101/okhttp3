package demo.lm.viedeodemo.utils;

import com.lm.okhttputils.callback.Callback;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/5/11.
 */
public abstract class ResultCallback extends Callback<String>
{
    @Override
    public String parseNetworkResponse(Response response) throws IOException
    {
        String sb = response.body().toString();
        // List<?> user = new Gson().fromJson(string, List.class);
        return sb;
    }


}
