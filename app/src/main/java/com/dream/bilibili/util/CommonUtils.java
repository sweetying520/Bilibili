package com.dream.bilibili.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dream.bilibili.R;
import com.dream.bilibili.common.MyApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



/**
 * 常用的方法 工具
 */
public class CommonUtils {

    private static Toast myToast;
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * Show message
     *
     * @param activity Activity
     * @param msg message
     */
    @SuppressLint("ShowToast")
    public static void showMessage(Activity activity, String msg) {
        if (myToast == null) {
            myToast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.CENTER,0,0);
        }else {
            myToast.setText(msg);
        }
        myToast.show();
    }

    /**
     * Show message
     *
     * @param activity Activity
     * @param msg message
     */
    public static void showSnackMessage(Activity activity, String msg) {

        Snackbar snackbar = Snackbar.make(activity.getWindow().getDecorView(), msg, Snackbar.LENGTH_SHORT);
        View view = snackbar.getView();
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(ContextCompat.getColor(activity, android.R.color.white));
        snackbar.show();
    }

    /**
     * 判断2个对象是否相等
     *
     * @param a Object a
     * @param b Object b
     * @return isEqual
     */
    public static boolean isEquals(Object a, Object b) {
        return (a == null) ? (b == null) : a.equals(b);
    }

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) MyApplication.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        assert connectivityManager != null;
        return connectivityManager.getActiveNetworkInfo() != null;
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }



    /**
     * 泛型转换工具方法 eg:object ==> map<String, String>
     *
     * @param object Object
     * @param <T> 转换得到的泛型对象
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object object) {
        return (T) object;
    }

    /**
     * 获取Drawable
     * @param resid resid
     * @return Drawable
     */
    public static Drawable getDrawable(int resid) {
        return getResoure().getDrawable(resid);
    }

    /**
     * 获取颜色
     * @param resid resid
     * @return int
     */
    public static int getColor(int resid) {
        return getResoure().getColor(resid);
    }

    /**
     * 获取resources
     * @return Resources
     */
    public static Resources getResoure() {
        return MyApplication.getInstance().getResources();
    }

    /**
     * 获取数组
     * @param resid
     * @return
     */
    public static String[] getStringArray(int resid) {
        return getResoure().getStringArray(resid);
    }

    /**
     * 获取string字符串
     * @param resid
     * @return
     */
    public static String getString(int resid) {
        return getResoure().getString(resid);
    }

    /**
     * 获取Dimens
     * @param resId resId
     * @return float
     */
    public static float getDimens(int resId) {
        return getResoure().getDimension(resId);
    }

    public static void toActivity(Context mContext,Class mClass){
        Intent intent = new Intent(mContext,mClass);
        mContext.startActivity(intent);
    }

    public static void toActivity(Context mContext, Class mClass, Bundle mBundle){
        Intent intent = new Intent(mContext,mClass);
        intent.putExtras(mBundle);
        mContext.startActivity(intent);
    }


    public static String valueOf(Object o){
        return String.valueOf(o);
    }


}
