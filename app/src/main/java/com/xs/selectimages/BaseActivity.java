package com.xs.selectimages;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * @author 小松 2018/4/24
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Toolbar tbBar;
    protected TextView tvToolbarRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        tbBar=findViewById(R.id.tb_bar);
        //setSupportActionBar(tbBar); //如果要调用 ActionBar的方法必须要执行 这句 比如说下面这句 调用 actionBar 的 默认 返回图标！！！！！
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);//很多博客都尼玛不说 为什么要调用上面的 妈的。。
        tbBar.setTitle(setTitle());
        tbBar.setTitleTextColor(Color.WHITE);
        tbBar.setTitleTextAppearance(this,R.style.ToolbarTitleText);
        tbBar.setNavigationIcon(R.drawable.label_return);
        tbBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigationClick();
            }
        });

        tvToolbarRight=findViewById(R.id.tv_toolbar_right);
        tvToolbarRight.setText(setToolbarRightText());
        tvToolbarRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbarRightClick();
            }
        });

    }

    protected void navigationClick(){
        finish();
    }

    protected abstract int getLayoutId();

    protected abstract String setTitle();

    protected abstract void toolbarRightClick();

    protected abstract String setToolbarRightText();
}
