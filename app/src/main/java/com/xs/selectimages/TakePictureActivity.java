package com.xs.selectimages;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/4/24.
 */

public class TakePictureActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

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
        Toast.makeText(TakePictureActivity.this,"完成",Toast.LENGTH_LONG).show();
    }

    @Override
    protected String setToolbarRightText() {
        return "完成";
    }
}
