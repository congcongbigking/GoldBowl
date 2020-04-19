package com.china.goldbowl.utils;


import com.china.goldbowl.base.BaseContent;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * File descripition:   RetrofitUtil工具类
 *
 * @author lp
 * @date 2018/8/13
 */

public class RetrofitUtil {
    /**
     * 将String 字符串转换为Rrtorfit: requestBody类型的value
     */
    public static RequestBody convertToRequestBody(String param) {
        RequestBody requestBody = null;
        requestBody = RequestBody.create(MediaType.parse("text/plain"), param);
        return requestBody;
    }

    /**
     * 将所有的File图片集合转化为retorfit上传图片所需的： MultipartBody.Part类型的集合
     */
    public static List<MultipartBody.Part> filesToMultipartBodyParts(List<File> files, String key) {
        List<MultipartBody.Part> parts = new ArrayList<>(files.size());
        for (File file : files) {
            parts.add(filesToMultipartBodyParts(file, key));
        }
        return parts;
    }

    /**
     * 将单个File图片转化为retorfit上传图片所需的： MultipartBody.Part类型
     */
    public static MultipartBody.Part filesToMultipartBodyParts(File file, String key) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/png"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData(key, file.getName(), requestBody);
        return part;
    }


    public static List<File> initImages(List<String> mImages) {
        List<File> listPicture = new ArrayList<>();
        listPicture.clear();
        Iterator<String> stuIter = mImages.iterator();
        while (stuIter.hasNext()) {
            String mUrl = stuIter.next();
            listPicture.add(new File(mUrl));
        }
        return listPicture;
    }

    /**
     * md5加密
     *
     * @param sourceStr
     * @return
     */
    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    /**
     * 参数排序转换，md5加密
     */
    public static Map<String,String> getCheckParams(Map<String, String> params) throws UnsupportedEncodingException {
        params.put("mobileType","2");
        params.put("versionNumber","2.0.0");
        params.put("channelCode","google");
        params.put("appFlag","crazyrupee");
        List<String> keys = new ArrayList<String>(params.keySet());
        Map<String,String> parammap = new HashMap<>();
        Collections.sort(keys);
        String prestr = "";
        String param_string ="";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            value = URLEncoder.encode(value, "UTF-8");
            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "|";
            }
        }
        param_string = BaseContent.appkey+""+prestr;
        parammap.put("signMsg",MD5(param_string));
        parammap.put("token","");
        return parammap;
    }
}
