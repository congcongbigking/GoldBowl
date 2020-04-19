package com.china.goldbowl.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.StringRes;

import com.china.goldbowl.R;
import com.china.goldbowl.view.ErrorTickView;
import com.china.goldbowl.view.SuccessTickView;

import java.util.ArrayList;

/**
 * @author momo
 * @Toast工具类
 * @Date 2014/5/27
 */
public class Toast {
    private static final Handler handler;
    private static final ArrayList<String> toastValues;
    // 是否隐藏测试Toast
    private static boolean isShow;

    static {
        toastValues = new ArrayList<>();
        handler=new Handler(Looper.getMainLooper());
    }

    public static void setDebug(boolean debug) {
        isShow = debug;
    }

    public static void testToast(String text) {
        if (isShow&&!TextUtils.isEmpty(text)) {
            toast(text);
        }
    }

    public static void testToast(@StringRes int resId) {
        if (isShow) {
            toast(Res.getString(resId));
        }
    }

    public static void toast(final String text) {
        frequently(text, new Runnable() {
            @Override
            public void run() {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    android.widget.Toast.makeText(Res.getContext(), text, android.widget.Toast.LENGTH_SHORT).show();
                } else {
                    Looper.prepare();
                    android.widget.Toast.makeText(Res.getContext(), text, android.widget.Toast.LENGTH_SHORT).show();
                    Looper.loop();
                }
            }
        });
    }

    public static void toast(@StringRes int resId) {
        toast(Res.getString(resId));
    }

    public static void toast(@StringRes int resId, Object... params) {
        toast(Res.getString(resId,params));
    }


    /**
     * 显示自定义弹出窗
     *
     * @param res
     */
    public static void showToast(@StringRes int res) {
        showToast(Res.getString(res),android.widget.Toast.LENGTH_SHORT);
    }

    /**
     * 显示自定义弹出窗
     *
     * @param text
     */
    public static void showToast(String text) {
        showToast(text,android.widget.Toast.LENGTH_SHORT);
    }

    /**
     * 显示自定义弹出窗
     *
     * @param res
     */
    public static void showToast(@StringRes int res, int duration) {
        showToast(Res.getString(res),duration);
    }


    /**
     * 显示自定义弹出窗
     * @param text
     * @param duration  @see #LENGTH_SHORT @see #LENGTH_LONG
     */
    public static void showToast(String text, int duration) {
        Context con = Res.getContext();
        if (null != con) {
            LayoutInflater in = LayoutInflater.from(con);
            View toastView = in.inflate(R.layout.toast_custom, null);
            final TextView localTextView = (TextView) toastView.findViewById(R.id.tv_content);
            localTextView.setText(text);

            android.widget.Toast toast = new android.widget.Toast(con);
            toast.setDuration(duration);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.setView(toastView);
            toast.show();
        }
    }

    /**
     * 显示自定义弹出窗
     *
     * @param res
     */
    public static void showFailToast(@StringRes int res) {
        showFailToast(Res.getString(res));
    }

    public static void showFailToast(final String text) {
        frequently(text, new Runnable() {
            @Override
            public void run() {
                Context context = Res.getContext();
                final android.widget.Toast toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL);
                View view = View.inflate(context, R.layout.prompt_error_item, null);
                ErrorTickView tickView = (ErrorTickView) view.findViewById(R.id.iv_icon);
                tickView.startErrorTick();
                TextView textView = (TextView) view.findViewById(R.id.tv_text);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                textView.setText(text);
                toast.setView(view);
                toast.show();
            }
        });
    }
    /**
     * 显示自定义弹出窗
     *
     * @param res
     */
    public static void showSuccessToast(@StringRes int res) {
        showToast(Res.getString(res), true, false);
    }

    /**
     * 显示自定义弹出窗
     *
     * @param msg
     */
    public static void showSuccessToast(String msg) {
        showToast(msg, true, false);
    }

    public static void showSuccessToast2(Context context, String msg) {
        showToast2(context,msg, true, false);
    }




    private static void showToast(final String text, final boolean isSuccess, final boolean isShowTick) {
        frequently(text, new Runnable() {
            @Override
            public void run() {
                Context context = Res.getContext();
                final android.widget.Toast toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL);
                View view = View.inflate(context, R.layout.prompt_item, null);
                SuccessTickView tickView = (SuccessTickView) view.findViewById(R.id.iv_icon);
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_cold);
                tickView.setVisibility(isSuccess ? View.VISIBLE : View.GONE);
                imageView.setVisibility(isShowTick ? View.VISIBLE : View.GONE);
                if (isSuccess) {
                    tickView.startTickAnim();
                }
                TextView textView = (TextView) view.findViewById(R.id.tv_text);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, isSuccess ? 13 : 15);
                textView.setText(text);
                toast.setView(view);
                toast.show();
            }
        });
    }


    private static void showToast2(final Context context, final String text, final boolean isSuccess, final boolean isShowTick) {
        frequently(text, new Runnable() {
            @Override
            public void run() {
                final android.widget.Toast toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, Gravity.CENTER_HORIZONTAL, Gravity.CENTER_VERTICAL);
                View view = View.inflate(context, R.layout.prompt_item, null);
                SuccessTickView tickView = (SuccessTickView) view.findViewById(R.id.iv_icon);
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_cold);
                tickView.setVisibility(isSuccess ? View.VISIBLE : View.GONE);
                imageView.setVisibility(isShowTick ? View.VISIBLE : View.GONE);
                if (isSuccess) {
                    tickView.startTickAnim();
                }
                TextView textView = (TextView) view.findViewById(R.id.tv_text);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, isSuccess ? 13 : 15);
                textView.setText(text);
                toast.setView(view);
                toast.show();
            }
        });
    }


    private static void frequently(final String text, Runnable action){
        if (!toastValues.contains(text)) {
            toastValues.add(text);//添加正在执行吐司对象
            if(null!=action) {
                RunUtils.run(action);
            }
            //短吐司2秒,后移除对象.
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toastValues.remove(text);
                }
            }, 2 * 1000);
        }
    }



}
