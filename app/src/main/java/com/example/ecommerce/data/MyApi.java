package com.example.ecommerce.data;


import com.example.ecommerce.data.reponse.Category;
import com.example.ecommerce.data.reponse.OrderReponse;
import com.example.ecommerce.data.reponse.Product;

import java.util.List;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public interface MyApi {

    @GET("/wp-json/wc/v2/products")
    Flowable<List<Product>> getAllProductsByCatId(@Query("category")String catId,@Query("page")String page);

    @GET("/wp-json/wc/v2/products/{id}")
    Flowable<Product> getProductById(@Path("id")int id);

    @GET("wp-json/wc/v2/products/categories")
    Flowable<List<Category>> getAllCategory();

    @POST("/wp-json/wc/v2/orders")
    Flowable<OrderReponse> createOrder(@Body RequestBody requestBody);
}
