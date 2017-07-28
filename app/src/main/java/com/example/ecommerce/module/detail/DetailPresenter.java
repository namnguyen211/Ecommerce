package com.example.ecommerce.module.detail;

import com.example.ecommerce.data.reponse.Product;

import vn.eazy.architect.mvp.base.BasePresenter;

/**
 * Created by NamNguyen on 26-Jul-17.
 */

public interface DetailPresenter  {

    interface View extends BasePresenter.View{

        void onGetProductSuccess(Product data);

        void onError(String message);
    }

    interface Presenter {
        void getProducById(Integer id);
    }
}

