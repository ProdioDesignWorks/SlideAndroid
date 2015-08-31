package com.slidenetwork.Slide.activities;

import android.app.Activity;

import retrofit.RetrofitError;


public class AbsSlideActiviy extends Activity {

    public void handleRetrofitErrors(RetrofitError error){
        int responseCode=error.getResponse().getStatus();

    }
}
