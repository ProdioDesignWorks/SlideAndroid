package com.slidenetwork.Slide.utils;
import android.support.annotation.NonNull;
import android.util.Log;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;


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
}