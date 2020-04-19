package com.china.goldbowl.api;



import com.china.goldbowl.base.mvp.BaseModel;
import com.china.goldbowl.net.bean.HtmlListBean;
import com.china.goldbowl.net.bean.MainBean;
import com.china.goldbowl.net.bean.ProtocolBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * File descripition:
 *
 * @author lp
 * @date 2018/6/19
 */

public interface ApiServer {

    /**
     *首页数据
     * @param params
     * @return
     */
    @FormUrlEncoded
    @POST("/api/borrow/findIndex.htm")
    Observable<BaseModel<MainBean>> getMainData(@HeaderMap HashMap<String,String> header, @FieldMap HashMap<String, String> params);

    /**
     *获取隐私协议列表
     * @return
     */
    @GET("/api/protocol/list.htm")
    Observable<BaseModel<ProtocolBean>> getProtocol(@HeaderMap HashMap<String,String> header);

    /**
     *获取页面列表
     * @return
     */
    @GET("/api/h5/list.htm")
    Observable<BaseModel<HtmlListBean>> getHtmlList(@HeaderMap HashMap<String,String> header);


}
