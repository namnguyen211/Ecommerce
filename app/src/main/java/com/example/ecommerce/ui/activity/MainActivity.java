package com.example.ecommerce.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.ecommerce.MyApplication;
import com.example.ecommerce.base.BaseAppMainFragment;
import com.example.ecommerce.data.MyApi;
import com.example.ecommerce.R;
import com.example.ecommerce.data.reponse.Product;
import com.example.ecommerce.ui.fragment.HomeFragment;
import com.example.ecommerce.utils.MyAppToolbar;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import vn.eazy.core.base.activity.BaseMainActivity;
import vn.eazy.core.toolbar.OnCallBackToolbarAction;

public class MainActivity extends BaseMainActivity<MyAppToolbar> {

    private int backPressCount;
    private BaseAppMainFragment currentFragment;

    private List<Product> mListProduct = new ArrayList<>();

    @Inject
    @Named("oauth")
    MyApi myApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public void setUpViewsAndData() {
        changeFragment(HomeFragment.newInstance(), false);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public int onColorOfToolbar() {
        return R.color.colorPrimary;
    }

    @Override
    public int onImageForLeftButtonToolbar() {
        return R.mipmap.ic_back;
    }

    @Override
    public boolean useFragmentState() {
        return false;
    }

    @Override
    public void showMenu(boolean b) {

    }

    public void showToolbar(boolean b){
//        toolbarHelper.showToolbar(b);
        getToolbarHelper().showToolbar(b);
    }

    public void showRightImage(boolean b, OnCallBackToolbarAction onCallBackToolbarAction){
        getToolbarHelper().showRightImage(b,onCallBackToolbarAction);
    }

    @Override
    public void onBackPressed() {
//        WidgetUtils.hideSoftKeyboard(this);

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            super.onBackPressed();
            return;
        }
        backPressCount++;
        if (backPressCount > 1) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, getString(R.string.back_to_exit), Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    backPressCount = 0;
                }
            }, 3000);
        }

    }

    public MyApi getApi() {
        return myApi;
    }

    public void changeFragment(BaseAppMainFragment fragment, boolean isBackStack) {
        if (fragment == null) {
            return;
        }
        currentFragment = fragment;
//        if (homeFragment == null) {
//            homeFragment = fragment;
//        }
        fragmentHelper.replaceFragment(fragment, isBackStack, R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public MyAppToolbar getToolbarHelper() {
        try {
            return new MyAppToolbar(toolbar);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Product> getListProduct(){
        return mListProduct;
    }

    @Subscribe
    public void onEvent(Product product){
        mListProduct.add(product);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
}
