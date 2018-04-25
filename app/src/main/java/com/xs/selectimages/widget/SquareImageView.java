package com.xs.selectimages.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author 小松 2018/4/24
 */

public class SquareImageView extends android.support.v7.widget.AppCompatImageView {
    public SquareImageView(Context context) {
        this(context,null);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SquareImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

//        setMeasuredDimension(getDefaultSize(0,widthMeasureSpec),getDefaultSize(0,heightMeasureSpec));
//
//        int WidthSize=getMeasuredWidth();
//
//        heightMeasureSpec=widthMeasureSpec=MeasureSpec.makeMeasureSpec(WidthSize,MeasureSpec.EXACTLY);

        super.onMeasure(widthMeasureSpec,widthMeasureSpec);

    }
}
