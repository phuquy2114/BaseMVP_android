package com.kasoft.androidbase.ui.base;

import com.kasoft.mvpbase.IPresenter;

/**
 * Created by khanhnguyen on 09/05/2017
 */

public interface BaseView extends IPresenter.View {

    void hideKeyboard();

    void setLoadingIndicator(boolean visible);

    void showNoConnectionError();

    void showConnectionTimeoutError();

    void showMessage(String message);
}
