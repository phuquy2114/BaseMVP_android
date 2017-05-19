package com.kasoft.androidbase.di.module;

import android.app.Activity;
import android.content.Context;

import com.kasoft.androidbase.di.ActivityContext;
import com.kasoft.androidbase.di.PerActivity;
import com.kasoft.androidbase.ui.splash.SplashContract;
import com.kasoft.androidbase.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by khanhnguyen on 19/05/2017
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashContract.Presenter provideSplashPresenter(SplashPresenter presenter) {
        return presenter;
    }
}