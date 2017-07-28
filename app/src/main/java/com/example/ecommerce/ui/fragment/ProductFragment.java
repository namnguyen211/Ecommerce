package com.example.ecommerce.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;
import com.example.ecommerce.base.BaseAppMainFragment;
import com.example.ecommerce.data.reponse.Product;
import com.example.ecommerce.module.category.ProductPresenter;
import com.example.ecommerce.module.category.ProductPresenterIml;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.List;

import butterknife.BindView;
import vn.eazy.core.toolbar.OnCallBackToolbarAction;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class ProductFragment extends BaseAppMainFragment implements ProductPresenter.View {

    ProductPresenterIml productPresenterIml;

    @BindView(R.id.recyclerViewProduct)
    RecyclerView recyclerViewProduct;

    private SlimAdapter slimAdapter;

    public static ProductFragment newInstance() {

        Bundle args = new Bundle();

        ProductFragment fragment = new ProductFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productPresenterIml = new ProductPresenterIml(getContext(), getApi());
    }

    @Override
    public void bindMenu() {
        showToolbar(true);
        getToolbarHelper().setTitle("Product");
        showRightImage(true, new OnCallBackToolbarAction() {
            @Override
            public void onCallBackToolbar() {
                changeFragment(CartFragment.newInstance(),true);
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        productPresenterIml.bind(this);
        productPresenterIml.getAllProductByCatId(String.valueOf(15), String.valueOf(1));

        recyclerViewProduct.setLayoutManager(new GridLayoutManager(getContext(), 2));
        slimAdapter = SlimAdapter.create()
                .register(R.layout.item_product, new SlimInjector<Product>() {
                    @Override
                    public void onInject(final Product data, IViewInjector injector) {
                        injector.text(R.id.tvPrice, data.getPrice())
                                .with(R.id.imvProduct, new IViewInjector.Action<ImageView>() {
                                    @Override
                                    public void action(ImageView view) {
                                        Glide.with(view.getContext()).load(data.getImages().get(0).getSrc()).into(view);
                                    }
                                })
                                .clicked(R.id.layoutItem, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Bundle bundle = new Bundle();
                                        bundle.putInt("ID",data.getId());
                                        changeFragment(DetailProductFragment.newInstance(bundle), true);
                                    }
                                });

                    }
                }).attachTo(recyclerViewProduct);
    }

    @Override
    public void onDestroyView() {
        productPresenterIml.unbind();
        super.onDestroyView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_category;
    }

    @Override
    public void getDatasuccess(List<Product> data) {
        slimAdapter.updateData(data);
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
