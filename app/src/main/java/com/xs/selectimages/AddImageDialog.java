package com.xs.selectimages;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/4/24.
 */

public class AddImageDialog extends Dialog implements View.OnClickListener {

    private TextView tvTakePhoto;
    private TextView tvTakePicture;

    private OnTakePhotoClickListener onTakePhotoClickListener;
    private OnTakePictureClickListener onTakePictureClickListener;

    public AddImageDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_image);
        initView();
    }

    private void initView(){
        tvTakePhoto=findViewById(R.id.tv_take_photo);
        tvTakePicture=findViewById(R.id.tv_take_picture);

        tvTakePhoto.setOnClickListener(this);
        tvTakePicture.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_take_photo:
                onTakePhotoClickListener.onTakePhotoClickListener();
                break;
            case R.id.tv_take_picture:
                onTakePictureClickListener.onTakePictureClickListener();
                break;
        }
    }

    interface OnTakePhotoClickListener{
        void onTakePhotoClickListener();
    }

    interface OnTakePictureClickListener{
        void onTakePictureClickListener();
    }

    public void setOnTakePhotoClickListener(OnTakePhotoClickListener onTakePhotoClickListener){
        this.onTakePhotoClickListener=onTakePhotoClickListener;
    }

    public void setOnTakePictureClickListener(OnTakePictureClickListener onTakePictureClickListener){
        this.onTakePictureClickListener=onTakePictureClickListener;
    }


}
