package com.dream.bilibili.ui.activity;

import android.content.Context;

import com.dream.bilibili.R;
import com.dream.bilibili.base.activity.AbstractSimpleActivity;
import com.dream.bilibili.util.CommonUtils;

/**
 *此方式直接继承AbstractSimpleActivity 适用于mvc模式
 * @author Administrator
 * @date 2018/7/6
 */

public class Test2Activity extends AbstractSimpleActivity{



    @Override
    protected int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected void initEventAndData() {
        setToolbarCenterTitle("Test2Activity");


        showLoadingView();


        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                runOnUiThread(() -> showNormalView());
            }
        }.start();
    }


    public static void start(Context mContext){
        CommonUtils.toActivity(mContext,Test2Activity.class);
    }

}
