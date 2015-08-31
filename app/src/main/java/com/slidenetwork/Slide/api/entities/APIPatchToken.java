package com.slidenetwork.Slide.api.entities;

import com.slidenetwork.Slide.api.APIRoot;
import com.slidenetwork.Slide.api.api_interfaces.IApiPatchToken;
import com.slidenetwork.Slide.api.entities.patch_token.PatchTokenRequest;
import com.slidenetwork.Slide.api.entities.patch_token.PatchTokenResponse;
import com.slidenetwork.Slide.utils.Constants;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class APIPatchToken extends APIRoot {
    public static void patchAuthToken(final String token,PatchTokenRequest req, final Callback<PatchTokenResponse> listener){
        IApiPatchToken patchReq=createService(IApiPatchToken.class, Constants.BASE_URL);
        patchReq.patchToken(token, req, new Callback<PatchTokenResponse>() {
            @Override
            public void success(PatchTokenResponse o, Response response) {
                listener.success(o,response);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.failure(error);
            }
        });
    }
}
