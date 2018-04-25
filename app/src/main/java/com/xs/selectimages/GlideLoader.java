package com.xs.selectimages;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.xs.selectimages.widget.SingleCilckPhotoView;

import cn.levey.bannerlib.impl.RxBannerLoaderInterface;

/**
 * Created by Administrator on 2018/4/25.
 */

public class GlideLoader implements RxBannerLoaderInterface<PhotoView> {
    @Override
    public void show(Context context, Object o, PhotoView photoView) {
        Glide.with(context).load(o).into(photoView);
    }

    @Override
    public PhotoView create(Context context) {
        return new SingleCilckPhotoView(context);
    }
}
