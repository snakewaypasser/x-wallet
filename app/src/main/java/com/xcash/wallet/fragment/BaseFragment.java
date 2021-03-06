/**
 * Copyright (c) 2019 by snakeway
 * <p>
 * All rights reserved.
 */
package com.xcash.wallet.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.xcash.base.BaseActivity;


public class BaseFragment extends Fragment {

    public static final String POSITION_KEY = "position_key";

    public Handler handler = null;
    private BaseActivity baseActivity;
    private int position = -1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        if (bundle != null) {
            position = bundle.getInt(POSITION_KEY);
        }
        if (context instanceof BaseActivity) {
            baseActivity = (BaseActivity) context;
        }
    }

    public BaseActivity getBaseActivity() {
        if (baseActivity == null) {
            throw new IllegalArgumentException("the acticity must be extends BaseActivity");
        }
        return baseActivity;
    }

    protected void initAll() {
        initHandler();
        initUi();
        initConfigUi();
        initHttp();
        initOther();
    }

    protected void initHandler() {

    }

    protected void initUi() {

    }

    protected void initConfigUi() {

    }


    protected void initHttp() {

    }

    protected void initOther() {

    }

    public int getPosition() {
        return position;
    }

    public void adaptationStatusBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = null;
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            }
            marginLayoutParams.topMargin = baseActivity.getStatusBarHeight();
            view.setLayoutParams(marginLayoutParams);
        }
    }

    @Override
    public void onDestroy() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

}
