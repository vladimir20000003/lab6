package com.example.lab6;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MapKitFactory.setApiKey("abfcc1e5-4686-432a-9097-1066126621d9");
    }
}
