package com.dream.bilibili.di.component;


import com.dream.bilibili.common.MyApplication;
import com.dream.bilibili.di.module.AppModule;
import com.dream.bilibili.di.module.HttpModule;
import com.dream.bilibili.model.DataManager;

import javax.inject.Singleton;

import dagger.Component;


/**
 * @author quchao
 * @date 2017/11/27
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    /**
     * 提供App的Context
     *
     * @return GeeksApp context
     */
    MyApplication getContext();

    /**
     * 数据中心
     *
     * @return DataManager
     */
    DataManager getDataManager();

}
