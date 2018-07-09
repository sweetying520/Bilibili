package com.dream.bilibili.common;

import java.io.File;

/**
 *
 * @author Administrator
 * @date 2018/6/9
 */

public class MyConstants {

    /**
     * Path
     */
    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/NetCache";

    static final String BUGLY_ID = "16e54f8921";

    public static final String PARAMS_ONE = "params_1";
    public static final String PARAMS_TWO = "params_2";

    public static final String KEY_LIVE = "live";
    public static final String KEY_APP = "app";
    public static final String KEY_RANK = "rank";
    public static final String KEY_API = "api";
    public static final String KEY_BANGUMI = "bangumi";
    public static final String KEY_IM9 = "im9";
    public static final String KEY_COMMON = "common";
    public static final String KEY_AII = "aii";
}
