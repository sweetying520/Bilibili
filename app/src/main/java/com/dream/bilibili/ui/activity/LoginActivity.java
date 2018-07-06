package com.dream.bilibili.ui.activity;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dream.bilibili.R;
import com.dream.bilibili.base.activity.BaseActivity;
import com.dream.bilibili.contract.LoginContract;
import com.dream.bilibili.presenter.LoginPresenter;
import com.dream.bilibili.util.CommonUtils;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

/**
 * @author Administrator
 * @date 2018/7/6
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R.id.iv_icon_left)
    ImageView ivIconLeft;
    @BindView(R.id.iv_icon_right)
    ImageView ivIconRight;
    @BindView(R.id.et_username)
    TextInputEditText etUsername;
    @BindView(R.id.ibn_delete_username)
    ImageButton ibnDeleteUsername;
    @BindView(R.id.et_password)
    TextInputEditText etPassword;
    @BindView(R.id.login_ll)
    LinearLayout loginLl;
    @BindView(R.id.btn_login)
    Button btnLogin;

    public static void start(Context mContext) {
        CommonUtils.toActivity(mContext, LoginActivity.class);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initEventAndData() {
        setToolbarCenterTitle(CommonUtils.getString(R.string.login));


        //名称监听
        mPresenter.addRxBindingSubscribe(RxView.focusChanges(etUsername)
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        if (etUsername.getText().length() > 0) {
                            visible(ibnDeleteUsername);
                        } else {
                            gone(ibnDeleteUsername);
                        }
                    } else {
                        gone(ibnDeleteUsername);
                    }
                    ivIconLeft.setImageResource(R.drawable.ic_22);
                    ivIconRight.setImageResource(R.drawable.ic_33);
                }));

        //密码监听
        mPresenter.addRxBindingSubscribe(RxView.focusChanges(etPassword)
                .subscribe(aBoolean -> {
                    if (aBoolean) {
                        ivIconLeft.setImageResource(R.drawable.ic_22_hide);
                        ivIconRight.setImageResource(R.drawable.ic_33_hide);
                    }
                }));
        //监听名称变化
        mPresenter.addRxBindingSubscribe(RxTextView.textChangeEvents(etUsername)
                .subscribe(textViewTextChangeEvent -> {
                    etPassword.setText("");
                    if (textViewTextChangeEvent.text().toString().length() > 0) {
                        visible(ibnDeleteUsername);
                    } else {
                        gone(ibnDeleteUsername);
                    }
                }));

        //点击登录监听
        mPresenter.addRxBindingSubscribe(RxView.clicks(btnLogin)
                .throttleFirst(5, TimeUnit.SECONDS)
                .subscribe(o -> {
                    if (!CommonUtils.isNetworkConnected()) {
                        CommonUtils.showMessage(mActivity, "当前网络不可用");
                    } else {
                        //登录
                        login();
                    }
                }));

        //点击删除监听
        mPresenter.addRxBindingSubscribe(RxView.clicks(ibnDeleteUsername)
                .throttleFirst(5, TimeUnit.SECONDS)
                .subscribe(o -> {
                    // 清空用户名以及密码
                    etUsername.setText("");
                    etPassword.setText("");
                    ibnDeleteUsername.setVisibility(View.GONE);
                    etUsername.setFocusable(true);
                    etUsername.setFocusableInTouchMode(true);
                    etUsername.requestFocus();
                }));

    }

    private void login() {
        if (TextUtils.isEmpty(etUsername.getText().toString().trim())) {
            CommonUtils.showMessage(mActivity, CommonUtils.getString(R.string.username_not_null));
            return;
        }

        if (TextUtils.isEmpty(etPassword.getText().toString().trim())) {
            CommonUtils.showMessage(mActivity, CommonUtils.getString(R.string.pwd_not_null));
            return;
        }

        MainActivity.start(mActivity);
        finish();
    }


    @Override
    protected void initInject() {
        getActivityComponent().inject(this);

    }
}
