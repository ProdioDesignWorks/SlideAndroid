package com.slidenetwork.Slide.utils;
import android.content.Context;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.slidenetwork.Slide.api.entities.TokenRequest;
import com.slidenetwork.Slide.api.entities.TokenRequestData;
import com.slidenetwork.Slide.api.entities.patch_token.PatchTokenRequest;
import com.slidenetwork.Slide.api.entities.patch_token.PatchTokenRequestData;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public final class Toolbox {
    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    private Toolbox() {
    }

    /**
     * Write to debug log with tag set to {@link Constants}.LOG_TAG. Equivalent to calling {@link android.util.Log}.d
     *
     * @param logMessage the log message
     * @return returns whether the message was written to log
     */
    public static boolean writeToLog(@NonNull String logMessage) {
        return writeToLog(Log.DEBUG, Constants.LOG_TAG, logMessage);
    }

    /**
     * Write to log with given level and tag set to {@link Constants}.LOG_TAG.
     *
     * @param level      the log level
     * @param logMessage the log message
     * @return returns whether the message was written to log
     */
    public static boolean writeToLog(int level, @NonNull String logMessage) {
        return writeToLog(level, Constants.LOG_TAG, logMessage);
    }

    /**
     * Write to debug log with given tag and message.
     *
     * @param tag        the log tag
     * @param logMessage the log message
     * @return returns whether the message was written to log
     */
    public static boolean writeToLog(String tag, @NonNull String logMessage) {
        return writeToLog(Log.DEBUG, tag, logMessage);
    }

    /**
     * Write to log.
     *
     * @param level      the log level
     * @param tag        the log tag
     * @param logMessage the log message
     * @return the boolean
     */
    public static boolean writeToLog(int level, String tag, @NonNull String logMessage) {

        if (logMessage == null) {
            return false;
        }

        if (tag == null) {
            tag = Constants.LOG_TAG;
        }
        {
            switch (level) {
                case Log.ASSERT:
                    Log.e(tag, logMessage);
                    break;
                case Log.DEBUG:
                    Log.d(tag, logMessage);
                    break;
                case Log.WARN:
                    Log.w(tag, logMessage);
                    break;
                case Log.VERBOSE:
                    Log.v(tag, logMessage);
                    break;
                case Log.ERROR:
                    Log.e(tag, logMessage);
                    break;
                case Log.INFO:
                    Log.i(tag, logMessage);
                    break;
                default:
                    Log.d(tag, logMessage);
                    break;

            }
            return true;
        }

    }

    public static PatchTokenRequest getPatchRequest(String auth){
        PatchTokenRequest req=new PatchTokenRequest();
        PatchTokenRequestData data=new PatchTokenRequestData();
        data.setAuth_token(auth);
        data.setEmail("");
        data.setType(Constants.DEEPLINK_TOKEN);
        data.setAuth_method(Constants.AUTHMETHOD.EMAIL.getName());
        req.setData(data);
        return req;
    }

    public static TokenRequest getTokenRequest(Context context,String email){
        TokenRequest request=new TokenRequest();
        TokenRequestData data=new TokenRequestData();
        data.setAuthMethod(Constants.AUTHMETHOD.EMAIL.getName());
        data.setAuthToken("");
//        jsonParam.put("auth_token", "");
        data.setEmail(email);
        data.setDeviceName(Utility.getDeviceName());
        ArrayList<Integer> nums=new ArrayList<Integer>();
        nums.add(750);
        nums.add(1334);
        nums.add(24);
        data.setDeviceDisplay(nums);

        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId();
        data.setDeviceIdentifier(deviceId);
        Calendar cal=Calendar.getInstance(Locale.getDefault());
        cal.setTimeInMillis(System.currentTimeMillis());

        String date= Toolbox.formatDate(cal.getTimeInMillis(), TimeZone.getDefault());
        data.setLocalTime(date);
//        Toolbox.formatDate(cal.getTimeInMillis(), TimeZone.getDefault());
        data.setLocale(Locale.getDefault().getDisplayLanguage());
        request.setData(data);
        return request;
    }

    /**
     * Format date.
     *
     * @param unixTimestamp the unix timestamp
     * @param timeZone      the time zone
     * @return the string
     */
    public static String formatDate(long unixTimestamp, TimeZone timeZone) {
        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat.toPattern());
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date(unixTimestamp));
    }
}