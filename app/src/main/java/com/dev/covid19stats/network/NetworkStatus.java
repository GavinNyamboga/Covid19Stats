package com.dev.covid19stats.network;

import android.content.Context;
import android.net.ConnectivityManager;

import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class NetworkStatus {
    @RequiresApi(api = Build.VERSION_CODES.M)
    public boolean isConnected(Context context){
        boolean flag = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected() ){
            flag = true;
        }
        return flag;

    }
}
