package com.kasoft.mvpbase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class PresenterManager<HP extends IPresenter> {

    public static final String KEY_SAVED_STATE = "saved_state";

    private HP mHostPresenter;
    private Map<UUID, IPresenter> mPresenters =
            new HashMap<>();

    HP getHostPresenter() {
        return mHostPresenter;
    }

    void setHostPresenter(HP presenter) {
        this.mHostPresenter = presenter;
    }

    IPresenter getPresenter(UUID uuid) {
        return mPresenters.get(uuid);
    }

    UUID addPresenter(IPresenter presenter) {
        final UUID uuid = UUID.randomUUID();
        mPresenters.put(uuid, presenter);
        return uuid;
    }

    IPresenter removePresenter(UUID uuid) {
        return mPresenters.remove(uuid);
    }
}
