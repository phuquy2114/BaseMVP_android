package com.kasoft.androidbase.di.component;

import android.support.v4.app.Fragment;

import com.kasoft.androidbase.di.PerActivity;
import com.kasoft.androidbase.di.module.ActivityModule;
import com.kasoft.androidbase.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by khanhnguyen on 19/05/2017
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);

    void inject(Fragment fragment);
}
