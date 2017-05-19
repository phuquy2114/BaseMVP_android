package com.kasoft.androidbase.data.preferences;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public interface PreferencesHelper {
    void setAppFirstLaunch();

    boolean isAppFirstLaunch();

    void setAccessToken(String accessToken);
    String getAccessToken();
}
