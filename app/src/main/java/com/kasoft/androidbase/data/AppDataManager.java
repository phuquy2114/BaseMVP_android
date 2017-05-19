package com.kasoft.androidbase.data;

import com.kasoft.androidbase.data.datasource.DataSource;
import com.kasoft.androidbase.data.preferences.PreferencesHelper;

import javax.inject.Inject;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class AppDataManager implements DataManager {
    private PreferencesHelper mPreferencesHelper;
    private DataSource mDataSource;

    @Inject
    public AppDataManager(PreferencesHelper preferencesHelper, DataSource dataSource) {
        this.mPreferencesHelper = preferencesHelper;
        this.mDataSource = dataSource;
    }

    @Override
    public void setAppFirstLaunch() {
        mPreferencesHelper.setAppFirstLaunch();
    }

    @Override
    public boolean isAppFirstLaunch() {
        return mPreferencesHelper.isAppFirstLaunch();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }
}
