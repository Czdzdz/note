package com.api.myapplication;

import android.app.Application;

import timber.log.Timber;

public class myApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        Timber.plant(new Timber.DebugTree());
    }
}
