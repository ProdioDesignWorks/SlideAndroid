package com.slidenetwork.Slide.api;

import com.slidenetwork.Slide.BuildConfig;
import com.slidenetwork.Slide.utils.Utility;
import com.squareup.okhttp.OkHttpClient;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class APIRoot {
    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        OkHttpClient client=new OkHttpClient();
        client.setFollowRedirects(true);

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setClient(new OkClient(client))
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addHeader("Content-Type", "application/json");
                        request.addHeader("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 8_1 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/8.0 Mobile/12B410 Safari/600.1.4 [snv/1.1.6;snd/iPhone7,2;sno/8.1;snc/310_AT&T]");
                        request.addHeader("Accept", Utility.getAccept());
                    }
                });
        if(BuildConfig.DEBUG) builder.setLogLevel(RestAdapter.LogLevel.FULL);
//                .setConverter(new JacksonConverter());

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }
}
