package com.kasoft.mvpbase;

import android.os.Parcelable;
import android.support.annotation.Nullable;

public interface IPresenter<V extends IPresenter.View, S extends IPresenter.State> {

    /**
     * Called to attach view to the IPresenter
     * @param view view to attach
     */
    void onAttachView(V view, @Nullable S state);

    /**
     * Called to detach view from the IPresenter
     */
    void onDetachView();

    /**
     * Called to get presenter's state
     * @return presenter's state
     */
    State getState();

    /**
     * Called when presenter is going to be destroyed.
     */
    void onDestroy();

    /**
     * Interface represents View in MVP approach.
     */
    interface View {
    }

    /**
     * Interface represents IPresenter's state in MVP approach
     */
    interface State extends Parcelable {

    }
}
