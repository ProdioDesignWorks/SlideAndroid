package com.slidenetwork.Slide.api;

import retrofit.Callback;


public interface DataFetchListener<T> extends Callback {

    void onStart(DataFetchEvent<T> event);


    enum FailureType {NO_INTERNET, PARSE_ERROR, NETWORK_ERROR, DB_ERROR}

}
