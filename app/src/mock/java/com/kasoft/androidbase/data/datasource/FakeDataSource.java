package com.kasoft.androidbase.data.datasource;

import android.content.Context;

import com.kasoft.androidbase.di.ApplicationContext;

import javax.inject.Inject;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class FakeDataSource implements DataSource {
    private Context context;

    @Inject
    public FakeDataSource(@ApplicationContext Context context) {
        this.context = context;
    }
}
