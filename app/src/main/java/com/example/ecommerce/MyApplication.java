package com.example.ecommerce;

import android.app.Application;

import com.example.ecommerce.di.component.AppComponent;
import com.example.ecommerce.di.component.DaggerAppComponent;
import com.example.ecommerce.di.module.ServiceModule;
import com.example.ecommerce.ui.fragment.RxBus;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class MyApplication extends Application {

    private static MyApplication myApplication;
    private RxBus bus;

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        bus = new RxBus();
        appComponent = DaggerAppComponent.builder()
                .serviceModule(new ServiceModule())
                .build();
    }

    public RxBus getBus() {
        return bus;
    }

    public static MyApplication getInstance() {
        return myApplication;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
