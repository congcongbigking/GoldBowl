package com.china.goldbowl.base.mvp;



import com.china.goldbowl.api.ApiRetrofit;
import com.china.goldbowl.api.ApiServer;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * 代理基类
 * Created by congcong on 2020/4/7
 */
public class BasePresenterFlowable<V extends BaseView> {
    private CompositeDisposable compositeDisposable;
    public V baseView;
    protected ApiServer apiServer = ApiRetrofit.getInstance().getApiService();

    public BasePresenterFlowable(V baseView) {
        this.baseView = baseView;
    }
    /**
     * 解除绑定
     */
    public void detachView() {
        baseView = null;
        removeDisposable();
    }
    /**
     * 返回 view
     *
     * @return
     */
    public V getBaseView() {
        return baseView;
    }

    public void addDisposable(Observable<?> observable, BaseObserverFlowable observer) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
       /* compositeDisposable.add(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer));*/
    }

    public void removeDisposable() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
