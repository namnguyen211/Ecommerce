package com.example.ecommerce.usecase;

import android.content.Context;

import com.example.ecommerce.base.BaseCustomUseCase;
import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.data.reponse.OrderReponse;
import com.example.ecommerce.data.request.UpdateOrderRequest;

import io.reactivex.Flowable;
import vn.eazy.architect.mvp.usecase.action.GenericsIORequestUseCase;
import vn.eazy.architect.mvp.usecase.action.IntegerParamRequestUseCase;

/**
 * Created by brian on 7/29/17.
 */

public class UpdateOrderUseCase extends BaseCustomUseCase implements IntegerParamRequestUseCase<OrderReponse> {



    public UpdateOrderUseCase(Context context, MyApi apiService) {
        super(context, apiService);
    }


    @Override
    public Flowable<OrderReponse> request(Integer... integers) {
        return apiService.updateOrder(integers[0],"processing");
    }
}
