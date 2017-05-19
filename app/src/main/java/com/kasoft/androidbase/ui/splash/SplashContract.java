package com.kasoft.androidbase.ui.splash;

import com.kasoft.androidbase.ui.base.BaseView;
import com.kasoft.mvpbase.IPresenter;

/**
 * Created by khanhnguyen on 19/05/2017
 */

public interface SplashContract {

    interface Presenter extends IPresenter<View, State> {

    }

    interface View extends BaseView {
        void navigateToHomeScreen();
        void navigateToLoginScreen();
        void navigateToAppIntroductionScreen();
    }

    interface State extends IPresenter.State {

    }
}
