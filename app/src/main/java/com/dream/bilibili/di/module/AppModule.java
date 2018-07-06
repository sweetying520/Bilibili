package com.dream.bilibili.di.module;


import com.dream.bilibili.common.MyApplication;
import com.dream.bilibili.model.DataManager;
import com.dream.bilibili.model.db.DbHelper;
import com.dream.bilibili.model.db.GreenDaoHelper;
import com.dream.bilibili.model.http.HttpHelper;
import com.dream.bilibili.model.http.RetrofitHelper;
import com.dream.bilibili.model.prefs.PreferenceHelper;
import com.dream.bilibili.model.prefs.PreferenceHelperImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * @author quchao
 * @date 2017/11/27
 */

@Module
public class AppModule {

    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    MyApplication provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }

    @Provides
    @Singleton
    DbHelper provideDBHelper(GreenDaoHelper realmHelper) {
        return realmHelper;
    }

    @Provides
    @Singleton
    PreferenceHelper providePreferencesHelper(PreferenceHelperImpl implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper, DbHelper dbhelper, PreferenceHelper preferencesHelper) {
        return new DataManager(httpHelper, dbhelper, preferencesHelper);
    }

}
