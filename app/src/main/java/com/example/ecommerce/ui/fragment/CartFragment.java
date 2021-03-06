package com.example.ecommerce.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;
import com.example.ecommerce.base.BaseAppMainFragment;
import com.example.ecommerce.data.reponse.Billing;
import com.example.ecommerce.data.reponse.LineItem;
import com.example.ecommerce.data.reponse.OrderReponse;
import com.example.ecommerce.data.reponse.Product;
import com.example.ecommerce.data.reponse.Shipping;
import com.example.ecommerce.module.cart.CartPresenter;
import com.example.ecommerce.module.cart.CartPresenterIml;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by NamNguyen on 27-Jul-17.
 */

public class CartFragment extends BaseAppMainFragment implements CartPresenter.View {

    @BindView(R.id.recyclerViewProduct)
    RecyclerView recyclerViewProduct;

    private SlimAdapter slimAdapter;
    private List<LineItem> items = new ArrayList<>();
    private CartPresenterIml cartPresenter;

    public static CartFragment newInstance() {

        Bundle args = new Bundle();

        CartFragment fragment = new CartFragment();
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

        slimAdapter.updateData(getMainActivity().getListProduct());
    }

    @OnClick(R.id.btnOrder)
    public void onClickOrder() {
        Shipping shipping = new Shipping();
        shipping.setAddress1("588phuthohoa");
        shipping.setCity("hcm");

        Billing billing = new Billing();
        billing.setAddress1("588luybanbich");
        billing.setPhone("12345678");
        billing.setEmail("phuthohoa@gmail.com");

        for (Product p : getMainActivity().getListProduct()) {
            LineItem item = new LineItem();
            item.setProductId(p.getId());
            items.add(item);
        }

        OrderReponse orderReponse = new OrderReponse();
        orderReponse.setBilling(billing);
        orderReponse.setShipping(shipping);
        orderReponse.setLineItems(items);
        cartPresenter.createOrder(orderReponse);
    }

    @Override
    public void onDestroyView() {
        cartPresenter.unbind();
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


    @Override
    public void createOrderSuccess(OrderReponse data) {
        Bundle bundle = new Bundle();
        bundle.putInt("orderId",data.getId());

        changeFragment(ConfirmFragment.newInstance(bundle),true);
    }

    @Override
    public void updateOrderSuccess(OrderReponse data) {

    }

    @Override
    public void createOrderFail(String message) {

    }
}