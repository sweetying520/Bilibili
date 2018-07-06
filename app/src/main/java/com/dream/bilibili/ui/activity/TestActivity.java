package com.dream.bilibili.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.dream.bilibili.R;
import com.dream.bilibili.base.activity.BaseActivity;
import com.dream.bilibili.contract.TestContract;
import com.dream.bilibili.presenter.TestPresenter;

/**
 *继承BaseActivity 适用于MVP模式
 * @author Administrator
 * @date 2018/6/9
 */

public class TestActivity extends BaseActivity<TestPresenter> implements TestContract.View{

    private Context mContext;

    @Override
    public void testPresenter() {
        Log.d("print", "--->持有View层的引用");
    }

    @Override
    public void showSuccess() {
        Toast.makeText(mContext, "获取数据成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }


    @Override
    protected void initEventAndData() {
        mContext = this;
        setToolbarCenterTitle("TestActivity");
        mPresenter.testView();
        mPresenter.testGetData();

        showLoading();


        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(() -> showNormal());
            }
        }.start();
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    public static void start(Context mContext){
        mContext.startActivity(new Intent(mContext,TestActivity.class));
    }

}
