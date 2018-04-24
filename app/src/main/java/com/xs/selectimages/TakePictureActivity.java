package com.xs.selectimages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2018/4/24.
 */

public class TakePictureActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_take_picture;
    }

    @Override
    protected String setTitle() {
        return "图片";
    }

    @Override
    protected void toolbarRightClick() {

    }

    @Override
    protected String setToolbarRightText() {
        return "完成";
    }
}
