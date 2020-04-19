package com.china.goldbowl.net.interface_view;

import com.china.goldbowl.base.mvp.BaseModel;
import com.china.goldbowl.base.mvp.BaseView;
import com.china.goldbowl.net.bean.MainBean;

import java.util.List;

/**
 * Created by congcong on 2020/4/7
 */
public interface MainView extends BaseView {
    void onMainSuccess(BaseModel<MainBean> o);
}
