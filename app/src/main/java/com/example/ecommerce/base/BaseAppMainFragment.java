package com.example.ecommerce.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.ui.activity.MainActivity;

import vn.eazy.core.base.fragment.BaseMainFragment;
import vn.eazy.core.toolbar.OnCallBackToolbarAction;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public abstract class BaseAppMainFragment extends BaseMainFragment {

    private MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity)getBaseActivity();
    }

    public MainActivity getMainActivity(){
        return activity;
    }

    public void changeFragment(BaseAppMainFragment fragment, boolean isBackStack) {
        activity.changeFragment(fragment, isBackStack);
    }

    public void showToolbar(boolean b){
        activity.showToolbar(b);
    }

    public void showRightImage(boolean b,OnCallBackToolbarAction onCallBackToolbarAction){
        activity.showRightImage(b,onCallBackToolbarAction);

    }

    public MyApi getApi(){
        return activity.getApi();
    }
}
