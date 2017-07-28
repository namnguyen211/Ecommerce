package com.example.ecommerce.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.ecommerce.R;
import com.example.ecommerce.data.reponse.Image;

import java.util.List;

/**
 * Created by NamNguyen on 26-Jul-17.
 */

public class ImageAdaper extends PagerAdapter {

    private List<Image> mListImage;
    private Context context;
    private LayoutInflater layoutInflater;

    public ImageAdaper(Context context, List<Image> mListImage) {
        this.mListImage = mListImage;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mListImage.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.item_image, container, false);

        ImageView imageView = view.findViewById(R.id.image);
        Glide.with(context).load(mListImage.get(position).getSrc()).into(imageView);
        container.addView(view);
        return view;
    }
}
