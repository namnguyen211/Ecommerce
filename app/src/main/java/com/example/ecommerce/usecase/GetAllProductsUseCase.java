package com.example.ecommerce.usecase;

import android.content.Context;


import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.base.BaseCustomUseCase;
import com.example.ecommerce.data.reponse.Product;

import java.util.List;

import io.reactivex.Flowable;
import vn.eazy.architect.mvp.usecase.action.GenericsIORequestUseCase;
import vn.eazy.architect.mvp.usecase.action.StringParamRequestUseCase;

/**
 * Created by brian on 7/1/17.
 */

public class GetAllProductsUseCase extends BaseCustomUseCase implements StringParamRequestUseCase<List<Product>> {


    public GetAllProductsUseCase(Context context, MyApi apiService) {
        super(context, apiService);
    }


    @Override
    public Flowable<List<Product>> request(String... strings) {
        return apiService.getAllProductsByCatId(strings[0],strings[1]);
    }
}
