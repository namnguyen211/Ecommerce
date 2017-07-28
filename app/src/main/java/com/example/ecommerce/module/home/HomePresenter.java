package com.example.ecommerce.module.home;

import com.example.ecommerce.data.reponse.Category;
import com.example.ecommerce.data.reponse.Product;

import java.util.List;

import vn.eazy.architect.mvp.base.BasePresenter;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public interface HomePresenter {

    interface Presenter {
        void getAllCategory();
    }

    interface View extends BasePresenter.View {

        void onError(String message);

        void getDatasuccess(List<Category> data);
    }
}
