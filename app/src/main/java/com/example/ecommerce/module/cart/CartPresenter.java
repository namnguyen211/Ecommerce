package com.example.ecommerce.module.cart;

import com.example.ecommerce.data.reponse.OrderReponse;

import vn.eazy.architect.mvp.base.BasePresenter;

/**
 * Created by brian on 7/29/17.
 */

public interface CartPresenter {
    
    interface Presenter{
        void createOrder(OrderReponse orderReponse);

        void updateOrder(Integer idOrder);
    }
    
    interface View extends BasePresenter.View{

        void createOrderSuccess(OrderReponse data);

        void updateOrderSuccess(OrderReponse data);

        void createOrderFail(String message);
    }

}
