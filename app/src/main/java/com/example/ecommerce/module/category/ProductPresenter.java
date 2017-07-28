package com.example.ecommerce.module.category;

import com.example.ecommerce.data.reponse.Product;

import java.util.List;

import vn.eazy.architect.mvp.base.BasePresenter;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public interface ProductPresenter {

    interface Presenter{
        void getAllProductByCatId(String catId,String page);
    }

    interface View extends BasePresenter.View{

        void getDatasuccess(List<Product> data);

        void onError(String message);
    }
}
