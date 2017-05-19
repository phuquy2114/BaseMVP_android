package com.kasoft.androidbase.interfaces;

/**
 * Created by khanhnguyen on 09/05/2017
 */

public interface ErrorCallback {
    void onConnectionTimeout();

    void onNoConnection();

    void onServerError();
}
