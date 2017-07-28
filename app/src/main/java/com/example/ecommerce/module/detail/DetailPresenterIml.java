package com.example.ecommerce.module.detail;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.ecommerce.base.BaseCustomPresenter;
import com.example.ecommerce.base.DataConsumer;
import com.example.ecommerce.base.ErrorConsumer;
import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.data.reponse.Product;
import com.example.ecommerce.usecase.GetProductByIdUseCase;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by NamNguyen on 26-Jul-17.
 */

public class DetailPresenterIml extends BaseCustomPresenter<DetailPresenter.View> implements DetailPresenter.Presenter {

    GetProductByIdUseCase getProductByIdUseCase;

    public DetailPresenterIml(Context context, MyApi apiService) {
        super(context, apiService);
        getProductByIdUseCase = new GetProductByIdUseCase(context, apiService);
    }


    @Override
    public void getProducById(Integer id) {
        compositeDisposable.add(getProductByIdUseCase.request(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DataConsumer<Product>() {
                    @Override
                    public void onData(Product data) {
                        if (isAttached()) {
                            getView().onGetProductSuccess(data);
                        }
                    }
                }, new ErrorConsumer() {
                    @Override
                    public void onError(@NonNull String message, Throwable throwable) {
                        if (isAttached()) {
                            getView().onError(message);
                        }
                    }
                }));
    }
}
