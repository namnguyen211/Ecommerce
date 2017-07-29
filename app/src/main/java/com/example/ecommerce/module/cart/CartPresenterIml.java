package com.example.ecommerce.module.cart;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.ecommerce.base.BaseCustomPresenter;
import com.example.ecommerce.base.DataConsumer;
import com.example.ecommerce.base.ErrorConsumer;
import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.data.reponse.OrderReponse;
import com.example.ecommerce.usecase.CreateOrderUseCase;
import com.example.ecommerce.usecase.UpdateOrderUseCase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by brian on 7/29/17.
 */

public class CartPresenterIml extends BaseCustomPresenter<CartPresenter.View> implements CartPresenter.Presenter {

    CreateOrderUseCase createOrderUseCase;
    UpdateOrderUseCase updateOrderUseCase;

    public CartPresenterIml(Context context, MyApi apiService) {
        super(context, apiService);
        createOrderUseCase = new CreateOrderUseCase(context, apiService);
        updateOrderUseCase = new UpdateOrderUseCase(context, apiService);
    }

    @Override
    public void createOrder(OrderReponse orderReponse) {
        compositeDisposable.add(createOrderUseCase.request(orderReponse).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DataConsumer<OrderReponse>() {
                    @Override
                    public void onData(OrderReponse data) {
                        if (isAttached()) {
                            getView().createOrderSuccess(data);
                        }
                    }
                }, new ErrorConsumer() {
                    @Override
                    public void onError(@NonNull String message, Throwable throwable) {
                        if (isAttached()) {
                            getView().createOrderFail(message);
                        }
                    }
                }));
    }

    @Override
    public void updateOrder(Integer idOrder) {
        compositeDisposable.add(updateOrderUseCase.request(idOrder).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DataConsumer<OrderReponse>() {
                    @Override
                    public void onData(OrderReponse data) {
                        if (isAttached()) {
                            getView().updateOrderSuccess(data);
                        }
                    }
                }, new ErrorConsumer() {
                    @Override
                    public void onError(@NonNull String message, Throwable throwable) {
                        if (isAttached()) {
                            getView().createOrderFail(message);
                        }
                    }
                }));
    }
}
