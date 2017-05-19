package com.kasoft.androidbase.utils;

import com.kasoft.androidbase.BuildConfig;
import com.kasoft.androidbase.interfaces.ErrorCallback;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by khanhnguyen on 09/05/2017
 */

public class ErrorHandleUtil {

    public static void handleError(Throwable throwable, ErrorCallback callback) {

        if (BuildConfig.DEBUG)
            throwable.printStackTrace();

        if (throwable instanceof SocketTimeoutException) {
            callback.onConnectionTimeout();
        } else if (throwable instanceof UnknownHostException) {
            callback.onNoConnection();
        } else {
            callback.onServerError();
        }
    }
}
