package com.kasoft.androidbase.data.preferences;

import android.content.SharedPreferences;

import javax.inject.Inject;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String KEY_APP_FIRST_LAUNCH = "PREF_KEY_APP_FIRST_LAUNCH";

    private SharedPreferences mSharedPreferences;

    @Inject
    public AppPreferencesHelper(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }

    @Override
    public void setAppFirstLaunch() {
        mSharedPreferences.edit().putBoolean(KEY_APP_FIRST_LAUNCH, false).apply();
    }

    @Override
    public boolean isAppFirstLaunch() {
        return mSharedPreferences.getBoolean(KEY_APP_FIRST_LAUNCH, true);
    }

    @Override
    public void setAccessToken(String accessToken) {

    }

    @Override
    public String getAccessToken() {
        return null;
    }
}
