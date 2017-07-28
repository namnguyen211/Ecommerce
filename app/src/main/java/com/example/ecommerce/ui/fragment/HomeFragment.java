package com.example.ecommerce.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.ecommerce.R;
import com.example.ecommerce.base.BaseAppMainFragment;
import com.example.ecommerce.custom.ItemCategory;
import com.example.ecommerce.data.reponse.Category;
import com.example.ecommerce.module.home.HomePresenter;
import com.example.ecommerce.module.home.HomePresenterIml;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class HomeFragment extends BaseAppMainFragment implements HomePresenter.View {

    private HomePresenterIml homePresenter;

    @BindView(R.id.catOne)
    ItemCategory catOne;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void bindMenu() {
        showToolbar(false);
        showRightImage(false, null);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homePresenter = new HomePresenterIml(getContext(), getApi());

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homePresenter.bind(this);
        homePresenter.getAllCategory();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onDestroyView() {
        homePresenter.unbind();
        super.onDestroyView();
    }

    @OnClick(R.id.catOne)
    public void OnClickCategory() {
        changeFragment(ProductFragment.newInstance(), true);
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void getDatasuccess(List<Category> data) {
        data.get(0).getId();
        Toast.makeText(getContext(),data.get(0).getDescription(),Toast.LENGTH_SHORT).show();
    }
}
