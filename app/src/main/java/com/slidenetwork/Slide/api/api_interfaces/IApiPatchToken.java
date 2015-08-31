package com.slidenetwork.Slide.api.api_interfaces;

import com.slidenetwork.Slide.api.entities.patch_token.PatchTokenRequest;
import com.slidenetwork.Slide.api.entities.patch_token.PatchTokenResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.PATCH;
import retrofit.http.Path;


public interface IApiPatchToken {
    @PATCH("/tokens/{tokenID}")
    void patchToken(@Path("tokenID")String token,@Body PatchTokenRequest request, Callback<PatchTokenResponse> listener);
}