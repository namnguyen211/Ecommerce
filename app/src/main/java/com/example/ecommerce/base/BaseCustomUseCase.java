package com.example.ecommerce.base;

import android.content.Context;

import com.example.ecommerce.data.MyApi;

import vn.eazy.architect.mvp.usecase.BaseUseCase;

/**
 * Created by brian on 6/27/17.
 */

public class BaseCustomUseCase extends BaseUseCase {


    public MyApi apiService;

    public BaseCustomUseCase(Context context) {
        super(context);
    }

    public BaseCustomUseCase(Context context, MyApi apiService) {
        super(context);
        this.apiService = apiService;
    }

}
