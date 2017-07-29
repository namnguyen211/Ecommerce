package com.example.ecommerce.usecase;

import android.content.Context;

import com.example.ecommerce.base.BaseCustomUseCase;
import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.data.reponse.Category;

import java.util.List;

import io.reactivex.Flowable;
import vn.eazy.architect.mvp.usecase.action.NonParamRequestUseCase;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class GetAllCategoryUseCase extends BaseCustomUseCase implements NonParamRequestUseCase<List<Category>> {


    public GetAllCategoryUseCase(Context context, MyApi apiService) {
        super(context, apiService);
    }

    @Override
    public Flowable<List<Category>> request() {
        return apiService.getAllCategory();
    }
}
