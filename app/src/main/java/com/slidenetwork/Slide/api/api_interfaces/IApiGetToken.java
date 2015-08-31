package com.slidenetwork.Slide.api.api_interfaces;

import com.slidenetwork.Slide.api.entities.TokenRequest;
import com.slidenetwork.Slide.api.entities.email_token_response.EmailTokenResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public interface IApiGetToken {
    @POST("/tokens")
    void getToken(@Body TokenRequest request, Callback<EmailTokenResponse> listener);
}
