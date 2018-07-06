package com.dream.bilibili.di.component;

import android.app.Activity;

import com.dream.bilibili.di.module.FragmentModule;
import com.dream.bilibili.di.scope.FragmentScope;
import com.dream.bilibili.ui.fragment.HomeFragment;

import dagger.Component;


/**
 * @author quchao
 * @date 2017/11/27
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    /**
     * 获取Activity实例
     *
     * @return Activity
     */
    Activity getActivity();


    /**
     * 给HomeFragment提供依赖
     * @param homeFragment homeFragment
     */
    void inject(HomeFragment homeFragment);


}
