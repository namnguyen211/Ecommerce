package com.example.ecommerce.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;
import com.example.ecommerce.base.BaseAppMainFragment;
import com.example.ecommerce.data.reponse.OrderReponse;
import com.example.ecommerce.data.reponse.Product;
import com.example.ecommerce.module.cart.CartPresenter;
import com.example.ecommerce.module.cart.CartPresenterIml;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by brian on 7/29/17.
 */

public class ConfirmFragment extends BaseAppMainFragment implements CartPresenter.View {

    @BindView(R.id.btnOrder)
    Button btnOrder;

    @BindView(R.id.recyclerViewProduct)
    RecyclerView recyclerViewProduct;

    private SlimAdapter slimAdapter;
    private CartPresenterIml cartPresenter;


    public static ConfirmFragment newInstance(Bundle args) {
        ConfirmFragment fragment = new ConfirmFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cartPresenter = new CartPresenterIml(getContext(), getApi());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cartPresenter.bind(this);

        recyclerViewProduct.setLayoutManager(new LinearLayoutManager(getContext()));

        slimAdapter = SlimAdapter.create().register(R.layout.item_cart, new SlimInjector<Product>() {
            @Override
            public void onInject(final Product data, IViewInjector injector) {
                injector.text(R.id.tvNameCart, data.getName())
                        .text(R.id.tvPriceCart, data.getRegularPrice())
                        .with(R.id.imvCart, new IViewInjector.Action<ImageView>() {
                            @Override
                            public void action(ImageView view) {
                                Glide.with(view.getContext()).load(data.getImages().get(0).getSrc()).into(view);
                            }
                        });
            }
        }).attachTo(recyclerViewProduct);

    }

    @Override
    public void onDestroyView() {
        cartPresenter.unbind();
        super.onDestroyView();
    }

    @Override
    public void bindMenu() {
        getToolbarHelper().setTitle("Confirm Order");
        showRightImage(false, null);
        btnOrder.setText("Confirm");

    }

    @OnClick(R.id.btnOrder)
    public void onClickConfirm() {
        cartPresenter.updateOrder(this.getArguments().getInt("orderId"));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void createOrderSuccess(OrderReponse data) {

    }

    @Override
    public void updateOrderSuccess(OrderReponse data) {
        Toast.makeText(getContext(),String.valueOf(data.getId()),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void createOrderFail(String message) {

    }
}
