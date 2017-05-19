package com.kasoft.mvpbase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class PresenterFragment<P extends IPresenter<V, S>, V extends IPresenter.View, S extends IPresenter.State> extends Fragment {

    private static final String PRESENTER_SAVE_UUID = "IPresenter save uuid tag";

    private UUID mPresenterUUID;

    private PresenterManager mPresenterManager;
    private S mState;

    /**
     * Provides presenter.
     *
     * @return IPresenter if it was created.
     * null otherwise.
     */
    protected P getPresenter() {
        if (mPresenterUUID != null) {
            return (P) mPresenterManager.getPresenter(mPresenterUUID);
        }
        return null;
    }

    /**
     * Called after presenter restored. Called before {@link #onCreate(Bundle)}.
     * View is not attached to presenter at this moment.
     */
    protected void onPresenterRestored(P presenter) {

    }

    /**
     * Method to instantiate presenter. Called during {@link #onStart()}
     *
     * @return new IPresenter.
     * null if {@link #getPresenterView()} returns null.
     * Otherwise {@link IllegalStateException} will be thrown.
     */
    protected P onCreatePresenter() {
        return null;
    }

    /**
     * Method to instantiate IPresenter.View for presenter. Called during {@link #onStart()}
     *
     * @return View for presenter.
     * null if {@link #onCreatePresenter()} returns null.
     * Otherwise {@link IllegalStateException} will be thrown.
     */
    protected V getPresenterView() {
        return null;
    }

    /**
     * Indicates if presenter should be kept or not.
     *
     * @return true if presenter should be retained, false otherwise.
     * Default value is true
     */
    protected boolean retainPresenter() {
        return true;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PresenterActivity) {
            mPresenterManager = ((PresenterActivity) context).getPresenterManager();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        onRestoreState(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            mState = savedInstanceState.getParcelable(PresenterManager.KEY_SAVED_STATE);
        }
    }

    private void onRestoreState(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mPresenterUUID = (UUID) savedInstanceState.getSerializable(PRESENTER_SAVE_UUID);
            P presenter = getPresenter();
            if (presenter != null) {
                onPresenterRestored(presenter);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        attachViewToPresenter();
    }

    private void attachViewToPresenter() {
        P presenter = getPresenter();

        if (presenter == null) {
            presenter = onCreatePresenter();
        }

        final V view = getPresenterView();

        if (presenter != null && view != null) {
            if (mPresenterManager != null)
                mPresenterUUID = mPresenterManager.addPresenter(presenter);
            presenter.onAttachView(view, mState);
        } else if (presenter == null && view != null) {
            throw new IllegalStateException("You provided a view, but didn't create presenter");
        } else if (presenter != null) {
            throw new IllegalStateException("You created a presenter, but didn't provide a " +
                    "view for it");
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        detachViewFromPresenter();
    }

    private void detachViewFromPresenter() {
        P presenter = getPresenter();
        if (presenter != null) {
            presenter.onDetachView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (!retainPresenter() || !getActivity().isChangingConfigurations()) {
            P presenter = getPresenter();
            if (presenter != null) {
                if (mPresenterManager != null)
                    mPresenterManager.removePresenter(mPresenterUUID);
                presenter.onDestroy();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(PRESENTER_SAVE_UUID, mPresenterUUID);
        outState.putParcelable(PresenterManager.KEY_SAVED_STATE, getPresenter().getState());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenterManager = null;
    }
}
