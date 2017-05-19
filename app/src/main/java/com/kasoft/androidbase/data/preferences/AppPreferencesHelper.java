package com.kasoft.androidbase.data.preferences;

import android.content.SharedPreferences;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class AppPreferencesHelper implements PreferencesHelper {
    private SharedPreferences mSharedPreferences;

    public AppPreferencesHelper(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }
}
