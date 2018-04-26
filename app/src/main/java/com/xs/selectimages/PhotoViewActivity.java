package com.xs.selectimages;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.OnScaleChangedListener;
import com.github.chrisbanes.photoview.OnViewTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.xs.selectimages.utils.AnimationUtil;

import java.util.List;

import cn.levey.bannerlib.RxBanner;
import cn.levey.bannerlib.impl.RxBannerChangeListener;
import cn.levey.bannerlib.impl.RxBannerLoaderInterface;

/**
 * @author 小松 2018/4/25.
 */

public class PhotoViewActivity extends BaseActivity {

    private RxBanner rxBanner;
    private RelativeLayout rlLayout;
    private List<String> imageBeans;

    private TranslateAnimation animation;
    ;
    private boolean isGone = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 防止 布局因SystemUI的可见或隐藏而重新layout
         */
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Intent intent = getIntent();
        imageBeans = intent.getStringArrayListExtra("IMAGES");
        int position = intent.getIntExtra("POSITION", 0);
        initView(position);
    }

    private void initView(int position) {

        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbBar.getLayoutParams();
        layoutParams.setMargins(0, getStatusBarHeight(this), 0, 0);
        tbBar.setLayoutParams(layoutParams);

        rxBanner = findViewById(R.id.rx_banner);
        rlLayout = findViewById(R.id.rl_layout);
        rxBanner.setLoader(new RxBannerLoaderInterface<PhotoView>() {

            @Override
            public void show(Context context, Object o, PhotoView photoView) {
                Glide.with(context).load(o).into(photoView);
            }

            @Override
            public PhotoView create(Context context) {

                final PhotoView photoView = new PhotoView(context);
//                photoView.setZoomable(true);
                PhotoViewAttacher viewAttacher = new PhotoViewAttacher(photoView);
                viewAttacher.setOnViewTapListener(new OnViewTapListener() {
                    @Override
                    public void onViewTap(View view, float x, float y) {


                        if (isGone) {
                            rlLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                            animation = AnimationUtil.moveToViewLocation();

                            Handler handler=new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    tbBar.setVisibility(View.VISIBLE);
                                    tbBar.startAnimation(animation);
                                }
                            },400);

                            isGone = false;
                        } else {
                            animation = AnimationUtil.moveToViewBottom();
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                @Override
                                public void onAnimationStart(Animation animation) {

                                }

                                @Override
                                public void onAnimationEnd(Animation animation) {
                                    tbBar.setVisibility(View.GONE);
                                    rlLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                                }

                                @Override
                                public void onAnimationRepeat(Animation animation) {

                                }
                            });
                            tbBar.startAnimation(animation);
                            isGone = true;
                        }

                    }
                });

                viewAttacher.setOnScaleChangeListener(new OnScaleChangedListener() {
                    @Override
                    public void onScaleChange(float scaleFactor, float focusX, float focusY) {
                        Log.e("TAG","==="+scaleFactor);
                    }
                });

//                viewAttacher.setOnSingleFlingListener();
//                viewAttacher.setOnViewTapListener();
//                viewAttacher.setOnMatrixChangeListener();
//                viewAttacher.setOnPhotoTapListener();
//                viewAttacher.setOnViewDragListener();
//                viewAttacher.setOnOutsidePhotoTapListener();
//                viewAttacher.setLis


                return photoView;
            }
        })
                .setDatas(imageBeans)
                .start();
        rxBanner.setOnBannerChangeListener(new RxBannerChangeListener() {
            @Override
            public void onBannerSelected(int position) {
                super.onBannerSelected(position);
                tbBar.setTitle(position + 1 + "/" + imageBeans.size());
            }
        });

    }
    int point=0;
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

    /**
     * 获取状态栏高度
     */
    public int getStatusBarHeight(Context context) {
        int result = 24;
        int resId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            result = context.getResources().getDimensionPixelSize(resId);
        } else {
            result = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    result, Resources.getSystem().getDisplayMetrics());
        }
        return result;
    }

    /**
     * 隐藏状态栏
     */
    private void hideStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
    }

    /**
     * 显示状态栏
     */
    private void showStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
    }


}
