package com.example.ecommerce.usecase;

import android.content.Context;


import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.base.BaseCustomUseCase;
import com.example.ecommerce.data.reponse.OrderReponse;

import io.reactivex.Flowable;
import vn.eazy.architect.mvp.usecase.action.GenericsIORequestUseCase;

/**
 * Created by brian on 7/1/17.
 */

public class CreateOrderUseCase extends BaseCustomUseCase implements GenericsIORequestUseCase<OrderReponse,OrderReponse> {


    public CreateOrderUseCase(Context context, MyApi apiService) {
        super(context, apiService);
    }

    @Override
    public Flowable<OrderReponse> request(OrderReponse orderReponse) {
        return apiService.createOrder(orderReponse.getRequestBody());
    }
}
