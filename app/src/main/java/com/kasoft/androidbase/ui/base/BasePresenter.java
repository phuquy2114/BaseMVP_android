package com.kasoft.androidbase.ui.base;

import android.support.annotation.Nullable;

import com.kasoft.androidbase.interfaces.ErrorCallback;
import com.kasoft.androidbase.utils.LogUtils;
import com.kasoft.mvpbase.IPresenter;

/**
 * Created by khanhnguyen on 09/05/2017
 */

public abstract class BasePresenter<V extends BaseView, S extends IPresenter.State> implements IPresenter<V, S>, ErrorCallback {

    protected V view;

    @Override
    public final void onAttachView(V view, @Nullable S state) {
        LogUtils.d(getClass().getSimpleName(), "onAttachView " + view + " " + state);
        this.view = view;
        onAttachView(state);
    }

    protected abstract void onAttachView(@Nullable S state);

    @Override
    public void onDetachView() {
        LogUtils.d(getClass().getSimpleName(), "onDetachView");
        this.view = null;
    }

    @Override
    public State getState() {
        LogUtils.d(getClass().getSimpleName(), "getState");
        return null;
    }

    @Override
    public void onDestroy() {
        LogUtils.d(getClass().getSimpleName(), "onDestroy");
    }

    protected V getView() {
        return view;
    }

    @Override
    public void onConnectionTimeout() {
        if (getView() != null)
            getView().showConnectionTimeoutError();
    }

    @Override
    public void onNoConnection() {
        if (getView() != null)
            getView().showNoConnectionError();
    }

    @Override
    public void onServerError() {
        if (getView() != null)
            getView().showMessage("Can't connect to server");
    }
}
