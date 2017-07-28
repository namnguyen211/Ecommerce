package com.example.ecommerce.base;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.ecommerce.utils.Utils;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;

import javax.net.ssl.SSLException;

import io.reactivex.functions.Consumer;
import timber.log.Timber;

import static com.example.ecommerce.utils.Utils.NO_INTERNET_CONNECTION;

/**
 * Created by Harry on 2/21/17.
 */

public abstract class ErrorConsumer implements Consumer<Throwable> {
    private static final String GENERAL_ERROR = "Error! Please try again.";

    @Override
    public void accept(Throwable e) throws Exception {
        String message = GENERAL_ERROR;
        retrofit2.Response response;

        try {
            if (!Utils.isConnectedToNetwork()) {
                onError(NO_INTERNET_CONNECTION, e);
                return;
            }

            if (e instanceof SocketTimeoutException) {
                onError("Request Timed Out.", e);
                return;
            }

            if (e instanceof UnknownHostException) {
                onError("No address associated", e);
                return;
            }

            if (e instanceof UnknownServiceException) {
                onError("No service associated", e);
                return;
            }

            if (e instanceof SSLException) {
                onError("SSL Failed.", e);
                return;
            }

            if (e instanceof HttpException) {
                response = ((HttpException) e).response();
                if (response.code() != 500) {
                    String m = Utils.getMessageFromErrorBody(response.errorBody(), GENERAL_ERROR);
                    if (!TextUtils.isEmpty(m)) {
                        message = m;
                    }
                }

                if (response.code() != 401) {
                    if (!TextUtils.isEmpty(message)) {
                        onError(message, e);
                        return;
                    }
                } else {
//                    PrefHelper.setLoginToken("");
//                    PrefHelper.setRefreshToken("");
                    return;
                }
            }

            onError(message, e);

        } catch (Exception exp) {
            Timber.e(exp.getMessage());
        }
    }

    public abstract void onError(@NonNull String message, Throwable throwable);
}
