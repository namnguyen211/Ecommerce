package com.example.ecommerce.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.MyApplication;
import com.example.ecommerce.R;
import com.example.ecommerce.adapter.ImageAdaper;
import com.example.ecommerce.base.BaseAppMainFragment;
import com.example.ecommerce.data.reponse.Product;
import com.example.ecommerce.module.detail.DetailPresenter;
import com.example.ecommerce.module.detail.DetailPresenterIml;
import com.example.ecommerce.utils.MyAppToolbar;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;
import vn.eazy.core.toolbar.OnCallBackToolbarAction;

/**
 * Created by NamNguyen on 26-Jul-17.
 */

public class DetailProductFragment extends BaseAppMainFragment implements DetailPresenter.View {


    private DetailPresenterIml detailPresenterIml;

    private ImageAdaper imageAdaper;
    @BindView(R.id.pager)
    ViewPager viewPager;
    @BindView(R.id.tvNameProduct)
    TextView tvNameProduct;
    @BindView(R.id.tvPriceProduct)
    TextView tvPriceProduct;
    @BindView(R.id.tvDesProduct)
    TextView tvDesProduct;
    @BindView(R.id.btnAddToCart)
    Button btnAddToCart;
    @BindView(R.id.btnBuyNow)
    Button btnBuyNow;

    private Product product;


    public static DetailProductFragment newInstance(Bundle bundle) {
        DetailProductFragment fragment = new DetailProductFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailPresenterIml = new DetailPresenterIml(getContext(), getApi());

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailPresenterIml.bind(this);
        int id = this.getArguments().getInt("ID");
        detailPresenterIml.getProducById(id);
    }

    @Override
    public void onDestroyView() {
        detailPresenterIml.unbind();
        super.onDestroyView();
    }

    @Override
    public void bindMenu() {
        getToolbarHelper().setTitle("Detail");
        showRightImage(true, new OnCallBackToolbarAction() {
            @Override
            public void onCallBackToolbar() {
                changeFragment(CartFragment.newInstance(), true);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_detail;
    }

    @Override
    public void onGetProductSuccess(Product data) {
        this.product = data;
        imageAdaper = new ImageAdaper(getContext(), data.getImages());
        viewPager.setAdapter(imageAdaper);
        tvNameProduct.setText(data.getName());
        tvPriceProduct.setText(data.getPrice());
        tvDesProduct.setText(data.getDescription());
    }

    @OnClick(R.id.btnAddToCart)
    public void onClickAddToCart() {
        EventBus.getDefault().post(product);
    }

    @OnClick(R.id.btnBuyNow)
    public void onClickBuyNow() {

    }

    @Override
    public void onError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
