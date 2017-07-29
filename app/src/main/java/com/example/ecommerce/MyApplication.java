package com.example.ecommerce;

import android.app.Application;

import com.example.ecommerce.di.component.AppComponent;
import com.example.ecommerce.di.component.DaggerAppComponent;
import com.example.ecommerce.di.module.ServiceModule;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class MyApplication extends Application {

    private static MyApplication myApplication;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        appComponent = DaggerAppComponent.builder()
                .serviceModule(new ServiceModule())
                .build();
    }


    public static MyApplication getInstance() {
        return myApplication;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
