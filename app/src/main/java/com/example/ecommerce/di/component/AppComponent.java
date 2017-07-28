package com.example.ecommerce.di.component;

import com.example.ecommerce.ui.activity.MainActivity;
import com.example.ecommerce.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by NamNguyen on 25-Jul-17.
 */
@Singleton
@Component(modules = {ServiceModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
