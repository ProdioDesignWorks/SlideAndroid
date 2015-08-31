package com.slidenetwork.Slide.utils;

/**
 * Created by Bhagyashree on 25-08-2015.
 */
public class Constants {
    public static String LOG_TAG="com.slidenetwork.Slide";
    public static String BASE_URL = "https://api.getslide.io";
    public static final String API_PATH_TOKEN = "/tokens/";
    public static String keystorePassword = "123456";
    public static String type = "token";
    public static String AUTHMETHOD_EMAIL = "email";
    public static String AUTHMETHOD_FACEBOOK = "facebook";
    public static String AUTHMETHOD_GOOGLE = "google";
    public static String authMethod_refresh = "refresh";
    public static final String EMAIL_VALIDATION_REGEX =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String LOWERCASE_REGEX = "^[a-z ]+$";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_CONTENT_ENCODING_VALUE_GZIP= "gzip";
    public static final String DEEPLINK_TOKEN = "auth_token";
    public static final String PREFS_TOKENID="tokenid";
    public static final String PREFS_AUTHTOKEND="auth_token";
    public static final String PREFS_TOKEN_CREATED_AT="created_at";
    public static final String PREFS_TOKEN_EXPIRES_AT="expires_at";
    public static final String PREFS_REFRESH_TOKEN="refresh_token";
    public enum AUTHMETHOD{
        EMAIL(Constants.AUTHMETHOD_EMAIL),FACEBOOK(Constants.AUTHMETHOD_FACEBOOK),GPLUS(Constants.AUTHMETHOD_GOOGLE);
        private final String methodname;
        AUTHMETHOD(String method){
            methodname=method;
        }
        public String getName(){
            return methodname;
        }

    };




}
