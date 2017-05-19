package com.kasoft.androidbase.data.datasource;

import com.kasoft.androidbase.data.retrofit.API;

import javax.inject.Inject;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class RemoteDataSource implements DataSource {
    private API mAPI;

    @Inject
    public RemoteDataSource(API mAPI) {
        this.mAPI = mAPI;
    }
}
