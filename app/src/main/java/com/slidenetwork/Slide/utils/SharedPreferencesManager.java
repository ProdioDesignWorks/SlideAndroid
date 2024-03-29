package com.slidenetwork.Slide.utils;



/**
 * Created by Bhagyashree on 8/29/15.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;



public final class SharedPreferencesManager {

    private static final String SHARED_PREFS_NAME = "slide";
    private static SharedPreferences sharedPreferences;

    private SharedPreferencesManager() {
    }

    /**
     * Write string to shared preferences.
     *
     * @param context the context
     * @param key     the key
     * @param value   the value
     * @return true if value was written successfully
     */
    public static boolean writeString(@NonNull Context context, String key, String value) {
        if (context == null) {
            return false;
        }
        getSharedPreferencesEditor(context).putString(key, value).apply();
        return true;
    }

    /**
     * Write int to shared preferences.
     *
     * @param context the context
     * @param key     the key
     * @param value   the value
     * @return true if value was written successfully
     */
    public static boolean writeInt(@NonNull Context context, String key, int value) {
        if (context == null) {
            return false;
        }
        getSharedPreferencesEditor(context).putInt(key, value).apply();
        return true;
    }

    /**
     * Write boolean to shared preferences.
     *
     * @param context the context
     * @param key     the key
     * @param value   the value
     * @return true if value was written successfully
     */
    public static boolean writeBoolean(@NonNull Context context, String key, boolean value) {
        if (context == null) {
            return false;
        }
        getSharedPreferencesEditor(context).putBoolean(key, value).apply();
        return true;
    }

    /**
     * Write long to shared preferences.
     *
     * @param context the context
     * @param key     the key
     * @param value   the value
     * @return true if value was written successfully
     */
    public static boolean writeLong(@NonNull Context context, String key, long value) {
        if (context == null) {
            return false;
        }
        getSharedPreferencesEditor(context).putLong(key, value).apply();
        return true;
    }

    /**
     * Write float to shared preferences.
     *
     * @param context the context
     * @param key     the key
     * @param value   the value
     * @return true if value was written successfully
     */
    public static boolean writeFloat(@NonNull Context context, String key, float value) {
        if (context == null) {
            return false;
        }
        getSharedPreferencesEditor(context).putFloat(key, value).apply();
        return true;
    }

    /**
     * Get string to shared preferences.
     *
     * @param context      the context
     * @param key          the key
     * @param defaultValue the default value
     * @return string for this key, or defaultValue if not found
     */
    public static String getString(@NonNull Context context, String key, String defaultValue) {
        if (context == null) {
            return defaultValue;
        }
        return getSharedPreferences(context).getString(key, defaultValue);
    }

    /**
     * Get int to shared preferences.
     *
     * @param context      the context
     * @param key          the key
     * @param defaultValue the default value
     * @return int for this key, or defaultValue if not found
     */
    public static int getInt(@NonNull Context context, String key, int defaultValue) {
        if (context == null) {
            return defaultValue;
        }
        return getSharedPreferences(context).getInt(key, defaultValue);
    }

    /**
     * Get long to shared preferences.
     *
     * @param context      the context
     * @param key          the key
     * @param defaultValue the default value
     * @return long for this key, or defaultValue if not found
     */
    public static long getLong(@NonNull Context context, String key, long defaultValue) {
        if (context == null) {
            return defaultValue;
        }
        return getSharedPreferences(context).getLong(key, defaultValue);
    }

    /**
     * Get float to shared preferences.
     *
     * @param context      the context
     * @param key          the key
     * @param defaultValue the default value
     * @return float for this key, or defaultValue if not found
     */
    public static float getFloat(@NonNull Context context, String key, float defaultValue) {
        if (context == null) {
            return defaultValue;
        }
        return getSharedPreferences(context).getFloat(key, defaultValue);
    }

    /**
     * Get boolean to shared preferences.
     *
     * @param context      the context
     * @param key          the key
     * @param defaultValue the default value
     * @return boolean for this key, or defaultValue if not found
     */
    public static boolean getBoolean(@NonNull Context context, String key, boolean defaultValue) {
        if (context == null) {
            return defaultValue;
        }
        return getSharedPreferences(context).getBoolean(key, defaultValue);
    }

    /**
     * Gets shared preferences for {@link Constants}.SHARED_PREFS_NAME
     * Preferences are encrypted for release builds using
     * https://github.com/scottyab/secure-preferences
     * and plain text for debug builds
     *
     * @param context the context
     * @return either {@link SharedPreferences} or {@link }
     * based on {@link Constants}.IS_DEBUG
     * for {@link Constants}.SHARED_PREFS_NAME
     */
    public static SharedPreferences getSharedPreferences(@NonNull Context context) {

        if (context == null) {
            return null;
        }

        if (sharedPreferences == null) {

//            if (Constants.IS_DEBUG)
            {
                sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
            }
//            else {
//                sharedPreferences = new SecurePreferences(context, BuildConfig.APPLICATION_ID + "!sp0rtk1x#b0mb4y#r0b1n@!", SHARED_PREFS_NAME);
//            }
        }
        return sharedPreferences;
    }

    /**
     * Gets shared preferences editor.
     *
     * @param context the context
     * @return the shared preferences editor
     */
    public static SharedPreferences.Editor getSharedPreferencesEditor(@NonNull Context context) {

        if (context == null) {
            return null;
        }
        return getSharedPreferences(context).edit();
    }

}
