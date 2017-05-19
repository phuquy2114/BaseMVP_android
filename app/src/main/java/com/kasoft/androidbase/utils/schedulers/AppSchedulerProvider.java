package com.kasoft.androidbase.utils.schedulers;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Provides different types of schedulers.
 */
public class AppSchedulerProvider implements SchedulerProvider {

    @Nullable
    private static AppSchedulerProvider INSTANCE;

    // Prevent direct instantiation.
    private AppSchedulerProvider() {
    }

    public static synchronized AppSchedulerProvider getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AppSchedulerProvider();
        }
        return INSTANCE;
    }

    @Override
    @NonNull
    public Scheduler computation() {
        return Schedulers.computation();
    }

    @Override
    @NonNull
    public Scheduler io() {
        return Schedulers.io();
    }

    @Override
    @NonNull
    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
