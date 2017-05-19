package com.kasoft.androidbase.data;

import com.kasoft.androidbase.data.datasource.DataSource;
import com.kasoft.androidbase.data.preferences.PreferencesHelper;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class AppDataManager implements DataManager {
    private PreferencesHelper mPreferencesHelper;
    private DataSource mDataSource;

    public AppDataManager(PreferencesHelper preferencesHelper, DataSource dataSource) {
        this.mPreferencesHelper = preferencesHelper;
        this.mDataSource = dataSource;
    }
}
