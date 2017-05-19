package com.kasoft.androidbase;

import android.app.Application;

import com.kasoft.androidbase.data.DataManager;
import com.kasoft.androidbase.di.component.ApplicationComponent;
import com.kasoft.androidbase.di.component.DaggerApplicationComponent;
import com.kasoft.androidbase.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class MyApplication extends Application {

    @Inject
    DataManager mDataManager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }
}
