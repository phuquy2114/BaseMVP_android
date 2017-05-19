package com.kasoft.androidbase.ui.base;

import com.kasoft.mvpbase.IPresenter;
import com.kasoft.mvpbase.PresenterFragment;

/**
 * Created by khanhnguyen on 09/05/2017
 */

public class BaseMVPFragment<P extends IPresenter<V, S>, V extends BaseView, S extends IPresenter.State> extends PresenterFragment<P, V, S>
        implements BaseView {

    @Override
    @SuppressWarnings("unchecked")
    protected V getPresenterView() {
        return (V) this;
    }

    @Override
    public void setLoadingIndicator(boolean visible) {
        ((BaseMVPActivity) getActivity()).setLoadingIndicator(visible);
    }

    @Override
    public void showNoConnectionDialog() {
        ((BaseMVPActivity) getActivity()).showNoConnectionDialog();
    }

    @Override
    public void showConnectionTimeoutDialog() {
        ((BaseMVPActivity) getActivity()).showConnectionTimeoutDialog();
    }

    @Override
    public void showMessage(String message) {
        ((BaseMVPActivity) getActivity()).showMessage(message);
    }
}
