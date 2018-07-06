package com.dream.bilibili.model.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.dream.bilibili.common.MyApplication;

import javax.inject.Inject;

/**
 * @author quchao
 * @date 2017/11/27
 */

public class PreferenceHelperImpl implements PreferenceHelper {

    private static final String MY_SHARED_PREFERENCE = "my_shared_preference";
    private final SharedPreferences mPreferences;

    @Inject
    PreferenceHelperImpl() {
        mPreferences = MyApplication.getInstance().getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
    }

}
