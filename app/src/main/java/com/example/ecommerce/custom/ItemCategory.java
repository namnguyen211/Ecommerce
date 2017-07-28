package com.example.ecommerce.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ecommerce.R;

/**
 * Created by NamNguyen on 25-Jul-17.
 */

public class ItemCategory extends RelativeLayout {

    private int icon;
    private String title;

    public ItemCategory(Context context) {
        super(context);
        init(null);
    }

    public ItemCategory(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public ItemCategory(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public void init(AttributeSet attributeSet){
        View v = inflate(getContext(),R.layout.item_custom_category,this);

        ImageView imvCustomCat = v.findViewById(R.id.imvCustomCat);
        TextView tvCustomCat = v.findViewById(R.id.tvCustomCat);

        if(attributeSet != null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet,R.styleable.ItemCategory);
            icon = typedArray.getResourceId(R.styleable.ItemCategory_IconRes,0);
            title = typedArray.getString(R.styleable.ItemCategory_TitleCat);
            imvCustomCat.setImageResource(icon);
            tvCustomCat.setText(title);
            typedArray.recycle();
        }
    }
}
