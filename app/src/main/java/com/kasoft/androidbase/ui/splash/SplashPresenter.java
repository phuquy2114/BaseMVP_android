package com.kasoft.androidbase.ui.splash;

import android.support.annotation.Nullable;

import com.kasoft.androidbase.data.DataManager;
import com.kasoft.androidbase.ui.base.BasePresenter;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public class SplashPresenter extends BasePresenter<SplashContract.View, SplashContract.State>
        implements SplashContract.Presenter {

    private final CompositeDisposable mCompositeDisposable;
    private DataManager mDataManager;

    @Inject
    public SplashPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        this.mDataManager = dataManager;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    protected void onAttachView(@Nullable SplashContract.State state) {

        Disposable disposable = Observable.just(true)
                .delay(3000, TimeUnit.MILLISECONDS)
                .subscribe(aBoolean -> {
                    if (mDataManager.isAppFirstLaunch()) {
                        mDataManager.setAppFirstLaunch();
                        getView().navigateToAppIntroductionScreen();
                    } else if (mDataManager.getAccessToken() == null) {
                        getView().navigateToLoginScreen();
                    } else {
                        getView().navigateToHomeScreen();
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onDetachView() {
        super.onDetachView();
        mCompositeDisposable.dispose();
    }
}
