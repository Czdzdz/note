package com.api.myapplication;

import android.annotation.SuppressLint;
import android.app.Application;

import com.instacart.library.truetime.TrueTimeRx;

import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class myApplication extends Application {

    @SuppressLint("CheckResult")
    @Override
    public void onCreate() {
        super.onCreate();


        Timber.plant(new Timber.DebugTree());

        TrueTimeRx.build()
                .withRootDelayMax(1000 * 1000)
                .withRootDispersionMax(10 * 60 * 1000)
                .withConnectionTimeout(3 * 60 * 1000)
                .withServerResponseDelayMax(3 * 60 * 1000)
                .withRetryCount(3)
                .withSharedPreferencesCache(this)
                .withLoggingEnabled(true)
                .initializeRx("172.16.2.210")
                .subscribeOn(Schedulers.io())
                .subscribe(date -> {
                    Timber.tag("TrueTime").v("TrueTime was initialized and we have a time: %s", date);
                }, Throwable::printStackTrace);
    }
}
