package com.example.ecommerce.module.home;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.ecommerce.base.BaseCustomPresenter;
import com.example.ecommerce.base.DataConsumer;
import com.example.ecommerce.base.ErrorConsumer;
import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.data.reponse.Category;
import com.example.ecommerce.usecase.GetAllCategoryUseCase;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class HomePresenterIml extends BaseCustomPresenter<HomePresenter.View> implements HomePresenter.Presenter {

    GetAllCategoryUseCase getAllCategory;

    public HomePresenterIml(Context context, MyApi apiService) {
        super(context, apiService);
        getAllCategory = new GetAllCategoryUseCase(context, apiService);
    }


    @Override
    public void getAllCategory() {
        compositeDisposable.add(getAllCategory.request().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DataConsumer<List<Category>>() {
                    @Override
                    public void onData(List<Category> data) {
                        if (isAttached()) {
                            getView().getDatasuccess(data);
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
