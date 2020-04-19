package com.china.goldbowl.utils;

import android.text.TextUtils;



/**
 * 事件处理工具
 *
 * @author momo
 */
public class RunUtils {



    /**
     * 执代代码块
     *
     * @param action 执行代码块
     */
    public static void run(Runnable action) {
        try {
            if (null != action) {
                action.run();
            }
        } catch (Exception e) {
            e(e);
        }
    }

    /**
     * 异常处理
     *
     * @param e
     */
    public static void e(Throwable e) {
        if (null != e) {
            e.printStackTrace();
        }
    }

    /**
     * 异常处理
     *
     * @param text
     */
    public static void error(String tag, String text) {
        if (TextUtils.isEmpty(text)) {

        }
    }

}
