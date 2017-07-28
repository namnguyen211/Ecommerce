package com.example.ecommerce.utils;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.ecommerce.R;

import vn.eazy.core.toolbar.OnCallBackToolbarAction;
import vn.eazy.core.toolbar.ToolbarHelper;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class MyAppToolbar extends ToolbarHelper {

    Toolbar toolbar;
    ImageView rightImage;

    public MyAppToolbar(Toolbar toolbar) throws IllegalAccessException {
        super(toolbar);
        this.toolbar = toolbar;
//        toolbar = toolbar.findViewById(R.id.toolbar);
        rightImage = toolbar.findViewById(R.id.imvRightBtn);
    }

    public void showToolbar(boolean b) {
        if (b) {
            toolbar.setVisibility(View.VISIBLE);
        } else {
            toolbar.setVisibility(View.INVISIBLE);
        }
    }

    public void showRightImage(boolean b, final OnCallBackToolbarAction onCallBackToolbarAction){
        if(b){
            rightImage.setVisibility(View.VISIBLE);
            rightImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onCallBackToolbarAction != null){
                        onCallBackToolbarAction.onCallBackToolbar();
                    }
                }
            });
        }else {
            rightImage.setVisibility(View.GONE);
        }
    }
}
