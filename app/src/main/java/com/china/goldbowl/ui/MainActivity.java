package com.china.goldbowl.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.china.goldbowl.R;
import com.china.goldbowl.base.BaseActivity;
import com.china.goldbowl.base.mvp.BaseModel;
import com.china.goldbowl.base.mvp.BasePresenter;
import com.china.goldbowl.net.bean.MainBean;
import com.china.goldbowl.net.interface_view.MainView;
import com.china.goldbowl.net.presenter.MainPresenter;
import com.china.goldbowl.utils.Toast;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {
    private TextView textView;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        textView = findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mPresenter.getHomeData();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    /**
     * 首页数据请求的回调
     * @param o
     */
    @Override
    public void onMainSuccess(BaseModel<MainBean> o) {
        Toast.showSuccessToast(o.getMsg());

    }
}
