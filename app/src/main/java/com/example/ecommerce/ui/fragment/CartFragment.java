package com.example.ecommerce.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.ecommerce.MyApplication;
import com.example.ecommerce.R;
import com.example.ecommerce.base.BaseAppMainFragment;
import com.example.ecommerce.data.reponse.Product;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by NamNguyen on 27-Jul-17.
 */

public class CartFragment extends BaseAppMainFragment {

    @BindView(R.id.recyclerViewProduct)
    RecyclerView recyclerViewProduct;

    private final CompositeDisposable disposables = new CompositeDisposable();

    public static CartFragment newInstance() {

        Bundle args = new Bundle();

        CartFragment fragment = new CartFragment();
        fragment.setArguments(args);
        return fragment;
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

    @Subscribe
    public void onEvent(Product event) {
        event.getDescription();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        disposables.add(MyApplication.getInstance()
//                .getBus()
//                .toObservable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object object) throws Exception {
//                        if (object instanceof Product) {
//
//                        }
//                    }
//                }));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void bindMenu() {
        super.bindMenu();
        getToolbarHelper().setTitle("Cart");
        showRightImage(false, null);
    }


}