package com.example.ecommerce.base;

import android.content.Context;

import com.example.ecommerce.data.MyApi;

import vn.eazy.architect.mvp.base.BasePresenter;

/**
 * Created by brian on 6/28/17.
 */

public abstract class BaseCustomPresenter<T extends BasePresenter.View> extends BasePresenter<T> {
    private final MyApi apiService;

    public BaseCustomPresenter(Context context, MyApi apiService) {
        super(context);
        this.apiService = apiService;
    }

}