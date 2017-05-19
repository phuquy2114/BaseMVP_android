package com.kasoft.androidbase.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.kasoft.androidbase.MyApplication;
import com.kasoft.androidbase.R;
import com.kasoft.androidbase.di.component.ActivityComponent;

import com.kasoft.androidbase.di.component.DaggerActivityComponent;
import com.kasoft.androidbase.di.module.ActivityModule;
import com.kasoft.mvpbase.IPresenter;
import com.kasoft.mvpbase.PresenterActivity;

/**
 * Created by khanhnguyen on 09/05/2017
 */

public abstract class BaseMVPActivity<P extends IPresenter<V, S>, V extends BaseView, S extends IPresenter.State> extends PresenterActivity<P, V, S>
        implements BaseView {
    private ActivityComponent mActivityComponent;
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((MyApplication) getApplication()).getComponent())
                .build();

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
    @SuppressWarnings("unchecked")
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
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
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
    public void showNoConnectionError() {

    }

    @Override
    public void showConnectionTimeoutError() {

    }

    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }
}
