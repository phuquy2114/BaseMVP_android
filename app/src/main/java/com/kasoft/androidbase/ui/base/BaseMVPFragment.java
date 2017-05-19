package com.kasoft.androidbase.ui.base;

import android.content.Context;

import com.kasoft.androidbase.di.component.ActivityComponent;
import com.kasoft.mvpbase.IPresenter;
import com.kasoft.mvpbase.PresenterFragment;

/**
 * Created by khanhnguyen on 09/05/2017
 */

public abstract class BaseMVPFragment<P extends IPresenter<V, S>, V extends BaseView, S extends IPresenter.State> extends PresenterFragment<P, V, S>
        implements BaseView {

    private BaseMVPActivity mActivity;

    @Override
    @SuppressWarnings("unchecked")
    protected V getPresenterView() {
        return (V) this;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mActivity = (BaseMVPActivity) context;
        } catch (ClassCastException e) {
            throw new IllegalArgumentException(context.getClass().getSimpleName() + " must be extend BaseMVPActivity");
        }
    }

    public ActivityComponent getActivityComponent() {
        return mActivity.getActivityComponent();
    }

    @Override
    public void hideKeyboard() {
        mActivity.hideKeyboard();
    }

    @Override
    public void setLoadingIndicator(boolean visible) {
        ((BaseMVPActivity) getActivity()).setLoadingIndicator(visible);
    }

    @Override
    public void showNoConnectionError() {
        ((BaseMVPActivity) getActivity()).showNoConnectionError();
    }

    @Override
    public void showConnectionTimeoutError() {
        ((BaseMVPActivity) getActivity()).showConnectionTimeoutError();
    }

    @Override
    public void showMessage(String message) {
        ((BaseMVPActivity) getActivity()).showMessage(message);
    }
}
