package com.dream.bilibili.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */

public class ButtonObserver extends android.support.v7.widget.AppCompatButton implements TextWatcher {

    ArrayList<EditText> list = new ArrayList<>();

    public ButtonObserver(Context context) {
        this(context,null);
    }

    public ButtonObserver(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ButtonObserver(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * watch
     * @param ets ets
     */
    public void observer(EditText... ets){
        //遍历所有的et
        for(EditText et : ets){
            et.addTextChangedListener(this);
            list.add(et);
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        setEnabled(checkEmpty());
    }

    public boolean checkEmpty(){
        boolean isFlag = true;

        for(EditText et : list){
            if(TextUtils.isEmpty(et.getText().toString().trim())){
                isFlag = false;
                break;
            }
        }
        return isFlag;
    }
}
