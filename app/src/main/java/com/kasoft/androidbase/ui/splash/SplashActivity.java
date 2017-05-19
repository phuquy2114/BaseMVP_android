package com.kasoft.androidbase.ui.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kasoft.androidbase.R;
import com.kasoft.androidbase.ui.base.BaseMVPActivity;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class SplashActivity extends BaseMVPActivity<SplashContract.Presenter, SplashContract.View, SplashContract.State>
        implements SplashContract.View {

    @Inject
    Lazy<SplashContract.Presenter> mSplashPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);

        setContentView(R.layout.activity_splash);
    }

    @Override
    protected SplashContract.Presenter onCreatePresenter() {
        return mSplashPresenter.get();
    }

    @Override
    public void navigateToHomeScreen() {

    }

    @Override
    public void navigateToLoginScreen() {

    }

    @Override
    public void navigateToAppIntroductionScreen() {

    }
}
