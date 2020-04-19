package com.china.goldbowl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.china.goldbowl.app.MyApplication;


/**
 * 账户缓存工具类
 */
public class AccountHelper {

    private final String TOKEN = "token";
    private final String PHONENUM="phoneNum";
    private final String HASORDER="has_order";
    private final String HASREGISTER="has_register";
    private final String ORTERID = "order_id";
    private final String IMAGESHOW= "imageShow";
    private final String REDIRECTBUTTON = "redirectButton";
    private final String FAKEPAGE = "fakePage";
    private final String ISFIRSR ="isFirst";
    private final String SPAREURL="spare_url";//备用url
    private final String REPLACEURL = "replace_url";
    private String token;//登录获取token
    private String has_order;//是否是老用户
    private String has_register;//是否注册过
    private String phoneNum;//手机号
    private String order_id ;//订单id；
    private String isFirst;//是否是第一次进入软件





    private static AccountHelper mHelper;

    public static Context mContext;
    private SharedPreferences mSPreferences;


    public static void init(Context context) {
        mContext = context;
    }
    /**
     * 获取应用全局Application context对象
     *
     * @return
     */
    public static Context getAppContext() {
        return mContext;
    }

    public static AccountHelper getInstance() {
        if (mHelper == null) {
            mHelper = new AccountHelper();
        }
        return mHelper;
    }


    private AccountHelper() {
        mSPreferences = MyApplication.getContext().getSharedPreferences("account", Context.MODE_PRIVATE);
    }

    /**
     * 设置是否是老用户
     */
    public void setOldOrder (String oldOrder){
        this.has_order = oldOrder;
        mSPreferences.edit().putString(HASORDER, has_order).commit();
    }

    /**
     * 获取是否为老用户
     */
    public String getOldOrder () {
        has_order = mSPreferences.getString(HASORDER, "");
        return has_order;
    }




    /**
     * 设置是否第一次注册
     */

    public void setHasRegister (String has_register){
        this.has_register = has_register;
        mSPreferences.edit().putString(HASREGISTER, has_register).commit();
    }

    /**
     * 获取是否已经注册
     */
    public String getHas_register () {
        has_register = mSPreferences.getString(HASREGISTER, "");
        return has_register;
    }


    /**
     * 登录设置token
     * @param token
     */
    public void setCurLogin(String token) {
        this.token = token;
        mSPreferences.edit().putString(TOKEN, token).commit();

    }

    /**
     * 设置电话号码
     * @param num
     */
    public void setPhoneNum (String num){
        this.phoneNum =num;
        mSPreferences.edit().putString(PHONENUM,phoneNum).commit();
    }

    /**
     * 获取电话号码
     */

    public String getPhoneNum (){
        return mSPreferences.getString(PHONENUM, "");
    }

    /**
     * 设置是否第一次打开
     */
    public void setISFIRSR(String isFirst){
        this.isFirst =isFirst;
        mSPreferences.edit().putString(ISFIRSR, isFirst).commit();
    }


    /**
     * 获取备用url
     */
    public String getSPAREURL (){
        return mSPreferences.getString(SPAREURL, "");
    }

    /**
     * 创建订单设置orderid
     *
     */
    public void setOrder_id (String order_id){
        this.order_id = order_id;
        mSPreferences.edit().putString(ORTERID,order_id).commit();
    }




    /**
     * 获取是否显示定向按钮
     */
    public String getRedirectButton (){
        return mSPreferences.getString(REDIRECTBUTTON, "");
    }
    /**
     * 获取是否显示壳子
     */

    public String getFakePage (){
        return mSPreferences.getString(FAKEPAGE, "");
    }

    /**
     * 获取是否显示拍照
     */
    public String getImageShow (){
        return mSPreferences.getString(IMAGESHOW, "");
    }


    /**
     * 获取orderid
     */

    public String getOrder_id (){
        return mSPreferences.getString(ORTERID, "");
    }

    /**
     * 判断是否登录
     * @return
     */
    public boolean hasLogin () {
        token = mSPreferences.getString(TOKEN, "");
        return !TextUtils.isEmpty(token);
    }

    /**
     * 判断是否第一次打开
     */

    public boolean isFirst (){
        isFirst = mSPreferences.getString(ISFIRSR,"");
        return TextUtils.isEmpty(isFirst);
    }

    /**
     * 获取token
     * @return
     */
    public String getId () {
        return mSPreferences.getString(TOKEN, "");

    }

    /**
     * token过期 清空缓存
     */
    public void logout(){
        token = "";
        order_id="";
        phoneNum="";
        mSPreferences.edit().putString(TOKEN, token).commit();
        mSPreferences.edit().putString(ORTERID,order_id).commit();
        mSPreferences.edit().putString(PHONENUM,phoneNum).commit();
    }

    /**
     * 获取App的名称
     *
     * @param context 上下文
     *
     * @return 名称
     */
    public static String getAppName(Context context) {
        PackageManager pm = context.getPackageManager();
        //获取包信息
        try {
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            //获取应用 信息
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            //获取albelRes
            int labelRes = applicationInfo.labelRes;
            //返回App的名称
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
