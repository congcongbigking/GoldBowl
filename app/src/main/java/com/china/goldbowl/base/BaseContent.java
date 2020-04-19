package com.china.goldbowl.base;

import android.os.Environment;

public class BaseContent {
    //base Ip
    public static String baseUrl = "http://15.206.26.15:8080/";
    //视频文件存储路径
    public static String baseFileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "mvp_network/";
    //服务器返回成功的 cdoe
    public static int basecode = 200;
    //接口验签 appkey
    public static String appkey = "52356CA1F8FACE8341409FBA9E872C5F";

}
