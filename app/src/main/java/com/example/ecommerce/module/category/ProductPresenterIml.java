package com.example.ecommerce.module.category;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.ecommerce.base.BaseCustomPresenter;
import com.example.ecommerce.base.DataConsumer;
import com.example.ecommerce.base.ErrorConsumer;
import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.data.reponse.Product;
import com.example.ecommerce.module.category.ProductPresenter.Presenter;
import com.example.ecommerce.usecase.GetAllProductsUseCase;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class ProductPresenterIml extends BaseCustomPresenter<ProductPresenter.View> implements Presenter{

    GetAllProductsUseCase getAllProductsUseCase;

    public ProductPresenterIml(Context context, MyApi apiService) {
        super(context, apiService);
        getAllProductsUseCase = new GetAllProductsUseCase(context, apiService);
    }

    @Override
    public void getAllProductByCatId(String catID,String page) {
        compositeDisposable.add(getAllProductsUseCase.request(catID,page).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DataConsumer<List<Product>>() {
                    @Override
                    public void onData(List<Product> data) {
                        if (isAttached()) {
                            getView().getDatasuccess(data);
                        }
                    }
                }, new ErrorConsumer() {
                    @Override
                    public void onError(@NonNull String message, Throwable throwable) {
                        if(isAttached()){
                            getView().onError(message);
                        }
                    }
                }));
    }
}
