package com.example.ecommerce.usecase;

import android.content.Context;

import com.example.ecommerce.base.BaseCustomUseCase;
import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.data.reponse.Product;

import io.reactivex.Flowable;
import vn.eazy.architect.mvp.usecase.action.GenericsIORequestUseCase;

/**
 * Created by NamNguyen on 26-Jul-17.
 */

public class GetProductByIdUseCase extends BaseCustomUseCase implements GenericsIORequestUseCase<Integer,Product> {


    public GetProductByIdUseCase(Context context, MyApi apiService) {
        super(context, apiService);
    }

    @Override
    public Flowable<Product> request(Integer integer) {
        return apiService.getProductById(integer);
    }
}
