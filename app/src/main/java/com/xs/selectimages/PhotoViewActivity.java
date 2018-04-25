package com.xs.selectimages;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import cn.levey.bannerlib.RxBanner;
import cn.levey.bannerlib.impl.RxBannerChangeListener;
import cn.levey.bannerlib.impl.RxBannerClickListener;

/**
 * Created by Administrator on 2018/4/25.
 */

public class PhotoViewActivity extends BaseActivity {

    private RxBanner rxBanner;
    private List<String> imageBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        imageBeans=intent.getStringArrayListExtra("IMAGES");
        int position=intent.getIntExtra("POSITION",0);
        initView(position);
    }

    private void initView(int position){
        rxBanner=findViewById(R.id.rx_banner);
        rxBanner.setLoader(new GlideLoader())
                .setDatas(imageBeans)
//                .setCurrentPosition(position)
                .start();
//        rxBanner;
        rxBanner.setOnBannerChangeListener(new RxBannerChangeListener() {
            @Override
            public void onBannerSelected(int position) {
                super.onBannerSelected(position);
                tbBar.setTitle(position+1+"/"+imageBeans.size());
            }
        });

        rxBanner.setOnBannerClickListener(new RxBannerClickListener() {
            @Override
            public void onItemClick(int position, Object data) {
                Log.e("TAG","单击");
                rxBanner.setSystemUiVisibility(View.GONE);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_photo_view;
    }

    @Override
    protected String setTitle() {
        return null;
    }

    @Override
    protected void toolbarRightClick() {

    }

    @Override
    protected String setToolbarRightText() {
        return "完成";
    }
}
