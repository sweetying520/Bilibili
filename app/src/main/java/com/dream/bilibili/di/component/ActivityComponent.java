package com.dream.bilibili.di.component;

import android.app.Activity;

import com.dream.bilibili.di.module.ActivityModule;
import com.dream.bilibili.di.scope.ActivityScope;
import com.dream.bilibili.ui.activity.LoginActivity;
import com.dream.bilibili.ui.activity.MainActivity;
import com.dream.bilibili.ui.activity.SplashActivity;
import com.dream.bilibili.ui.activity.TestActivity;

import dagger.Component;


/**
 * @author quchao
 * @date 2017/11/27
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    /**
     * 获取Activity实例
     *
     * @return Activity
     */
    Activity getActivity();



    /**
     * 注入TestActivity所需的依赖
     *
     * @param testActivity testActivity
     */
    void inject(TestActivity testActivity);

    /**
     * 注入SplashActivity所需的依赖
     *
     * @param splashActivity splashActivity
     */
    void inject(SplashActivity splashActivity);

    /**
     * 注入LoginActivity所需的依赖
     *
     * @param loginActivity loginActivity
     */
    void inject(LoginActivity loginActivity);

    /**
     * 注入MainActivity所需的依赖
     *
     * @param mainActivity mainActivity
     */
    void inject(MainActivity mainActivity);





}
