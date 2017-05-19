package com.kasoft.mvpbase;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class PresenterViewHolder<P extends IPresenter> extends RecyclerView.ViewHolder implements IPresenter.View {
    protected P presenter;

    public PresenterViewHolder(View itemView) {
        super(itemView);
    }

    public void bindPresenter(P presenter) {
        this.presenter = presenter;
        presenter.onAttachView(this, null);
    }

    public void unbindPresenter() {
        presenter.onDetachView();
        presenter = null;
    }
}