package com.china.goldbowl.base;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

public class HttpLogger implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(String message) {
        //修改成分段打印
        if (message.length() > 4000) {
            for (int i = 0; i < message.length(); i += 4000) {
                if (i + 4000 < message.length())
                    Log.d("HttpLogInfo" + i, message.substring(i, i + 4000));
                else
                    Log.d("HttpLogInfo" + i, message.substring(i, message.length()));
            }
        } else
            Log.i("resinfo", message);
    }
}
