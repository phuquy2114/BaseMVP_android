package com.kasoft.androidbase.ui.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.kasoft.androidbase.R;
import com.kasoft.mvpbase.IPresenter;
import com.kasoft.mvpbase.PresenterActivity;

/**
 * Created by khanhnguyen on 09/05/2017
 */

public abstract class BaseMVPActivity<P extends IPresenter<V, S>, V extends BaseView, S extends IPresenter.State> extends PresenterActivity<P, V, S>
        implements BaseView {
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(getString(R.string.message_loading));
    }

    @Override
    protected void onStop() {
        super.onStop();
        dismissProgressDialog();
    }

    @Override
    @SuppressWarnings("")
    protected V getPresenterView() {
        return (V) this;
    }

    protected void showProgressDialog() {
        mProgressDialog.show();
    }

    protected void dismissProgressDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    public void setLoadingIndicator(boolean visible) {
        if (visible && !mProgressDialog.isShowing()) {
            showProgressDialog();
        } else {
            dismissProgressDialog();
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNoConnectionDialog() {

    }

    @Override
    public void showConnectionTimeoutDialog() {

    }
}
