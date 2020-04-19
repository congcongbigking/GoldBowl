package com.china.goldbowl.net.presenter;

import com.china.goldbowl.base.mvp.BaseModel;
import com.china.goldbowl.base.mvp.BaseObserver;
import com.china.goldbowl.base.mvp.BasePresenter;
import com.china.goldbowl.net.bean.MainBean;
import com.china.goldbowl.net.interface_view.MainView;
import com.china.goldbowl.utils.RetrofitUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by congcong on 2020/4/7
 */
public class MainPresenter extends BasePresenter<MainView> {
    public MainPresenter(MainView baseView) {
        super(baseView);
    }

    /**
     *  获取首页数据
     */
    public void getHomeData () throws UnsupportedEncodingException {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId","");
        addDisposable(apiServer.getMainData((HashMap<String, String>) RetrofitUtil.getCheckParams(params),params), new BaseObserver(baseView) {

            @Override
            public void onSuccess(BaseModel o) {
                baseView.onMainSuccess((BaseModel<MainBean>) o);
            }

            @Override
            public void onError(String msg) {
                if (baseView != null) {
                    baseView.showError(msg);
                }
            }
        });
    }
}
