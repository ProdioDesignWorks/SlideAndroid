package com.slidenetwork.Slide.api;

import com.slidenetwork.Slide.api.api_interfaces.IApiGetToken;
import com.slidenetwork.Slide.api.entities.TokenRequest;
import com.slidenetwork.Slide.api.entities.email_token_response.EmailTokenResponse;
import com.slidenetwork.Slide.utils.Constants;
import com.slidenetwork.Slide.utils.Toolbox;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public final class APIGetToken extends APIRoot {

    public static void getAuthToken(TokenRequest request, final Callback<EmailTokenResponse> callback){
      IApiGetToken token=createService(IApiGetToken.class,Constants.BASE_URL);

        token.getToken(request, new Callback<EmailTokenResponse>() {
            @Override
            public void success(EmailTokenResponse s, Response response) {
               Toolbox.writeToLog("Retrofit " + response.getHeaders());
                callback.success(s, response);
            }

            @Override
            public void failure(RetrofitError error){
                callback.failure(error);
            }
        });


    }
}
