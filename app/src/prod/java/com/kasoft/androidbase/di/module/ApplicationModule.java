/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.kasoft.androidbase.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.kasoft.androidbase.common.AppConstants;
import com.kasoft.androidbase.data.AppDataManager;
import com.kasoft.androidbase.data.DataManager;
import com.kasoft.androidbase.data.datasource.DataSource;
import com.kasoft.androidbase.data.datasource.RemoteDataSource;
import com.kasoft.androidbase.data.preferences.AppPreferencesHelper;
import com.kasoft.androidbase.data.preferences.PreferencesHelper;
import com.kasoft.androidbase.data.retrofit.API;
import com.kasoft.androidbase.di.ApiInfo;
import com.kasoft.androidbase.di.ApplicationContext;
import com.kasoft.androidbase.di.PreferenceInfo;
import com.kasoft.androidbase.utils.schedulers.AppSchedulerProvider;
import com.kasoft.androidbase.utils.schedulers.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by khanhnguyen on 19/05/17
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @ApiInfo
    String provideBaseURL() {
        return AppConstants.BASE_URL;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(@ApplicationContext Context context, @PreferenceInfo String prefName) {
        return context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@ApiInfo String baseURL, Gson gson) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseURL)
                .build();
    }

    @Provides
    @Singleton
    API provideApiHelper(Retrofit retrofit) {
        return retrofit.create(API.class);
    }

    @Provides
    @Singleton
    DataSource provideDataSource(RemoteDataSource dataSource) {
        return dataSource;
    }

    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider(AppSchedulerProvider schedulerProvider) {
        return schedulerProvider;
    }
}
