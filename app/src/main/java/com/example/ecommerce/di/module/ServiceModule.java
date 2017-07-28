package com.example.ecommerce.di.module;

import android.app.Application;
import android.content.Context;
import android.util.Base64;

import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.MyApplication;
import com.example.ecommerce.di.OAuthInterceptor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.util.concurrent.TimeUnit.MINUTES;

/**
 * Created by NamNguyen on 25-Jul-17.
 */
@Singleton
@Module
public class ServiceModule {
    String mBaseUrl = "https://unboastful-wing.000webhostapp.com";

//    @Singleton
//    @Named("normal")
//    @Provides
//    MyApi provideApi(Gson gson,@Named("normal")OkHttpClient okHttpClient) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(mBaseUrl)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .client(okHttpClient)
//                .build();
//        return retrofit.create(MyApi.class);
//    }

    @Singleton
    @Named("oauth")
    @Provides
    MyApi provideApiOauth(Gson gson,@Named("oauth")OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://tangtkdropbox1.esy.es")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit.create(MyApi.class);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

//    @Provides
//    @Named("normal")
//    @Singleton
//    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//        httpClient.connectTimeout(1, MINUTES);
//        httpClient.readTimeout(1, TimeUnit.DAYS);
//        httpClient.writeTimeout(1, TimeUnit.DAYS);
//        httpClient.addInterceptor(httpLoggingInterceptor);
//        httpClient.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request request = chain.request();
//                Request.Builder requestBuilder = request.newBuilder();
//
//                String username = "ck_6b7053c2e943f738cde7232641224a458e99c731";
//                String password = "cs_84a1be6f9404684b6a95f4ff88398a984638fc68";
//                String credentials = username + ":" + password;
//                final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
//                requestBuilder.addHeader("Authorization", basic);
//
//                return chain.proceed(requestBuilder.build());
//            }
//        });
//
//        return httpClient.build();
//    }

    @Singleton
    @Named("oauth")
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, OAuthInterceptor oAuthInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(oAuthInterceptor)
                .build();
    }

    @Singleton
    @Provides
    OAuthInterceptor provideOAuthInterceptor() {
        return new OAuthInterceptor.Builder()
                .consumerKey("ck_1931681956189c2d3adecd4b6968c0327b524074")
                .consumerSecret("cs_33896a8953a82ca2dd880a580a2701199fb0683c")
                .build();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    Context provideContext() {
        return MyApplication.getInstance();
    }

    @Provides
    @Singleton
    protected Application provideApplication() {
        return MyApplication.getInstance();
    }
}
