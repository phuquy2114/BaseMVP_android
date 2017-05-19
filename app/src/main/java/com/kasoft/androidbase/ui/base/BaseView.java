package com.kasoft.androidbase.ui.base;

import com.kasoft.mvpbase.IPresenter;

/**
 * Created by khanhnguyen on 09/05/2017
 */

public interface BaseView extends IPresenter.View {
    void setLoadingIndicator(boolean visible);

    void showNoConnectionDialog();

    void showConnectionTimeoutDialog();

    void showMessage(String message);
}
