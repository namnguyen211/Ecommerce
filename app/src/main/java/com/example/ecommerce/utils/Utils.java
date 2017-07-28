package com.example.ecommerce.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;

import com.example.ecommerce.MyApplication;

import org.json.JSONObject;

import okhttp3.ResponseBody;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class Utils {

    public static final String NO_INTERNET_CONNECTION = "No internet connection";

    public static boolean isConnectedToNetwork() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public static String getMessageFromErrorBody(ResponseBody body, @NonNull String defaultMsg) {
        try {
            JSONObject raw = new JSONObject(body.string());
            return raw.optString("message", "");
        } catch (Exception e) {
            e.printStackTrace();
            return defaultMsg;
        }
    }
}
