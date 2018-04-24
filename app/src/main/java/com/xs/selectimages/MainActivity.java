package com.xs.selectimages;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements PublishAdapter.OnAddImageClickListener
        ,PublishAdapter.OnImageClickListener ,AddImageDialog.OnTakePhotoClickListener,AddImageDialog.OnTakePictureClickListener{

    private RecyclerView rvImageList;
    private PublishAdapter publishAdapter;

    private List<String> images;

    private AddImageDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initRecyclerView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected String setTitle() {
        return "发布动态";
    }

    @Override
    protected void toolbarRightClick() {
        Toast.makeText(MainActivity.this,"发布",Toast.LENGTH_LONG).show();
    }

    @Override
    protected String setToolbarRightText() {
        return "发表";
    }

    /**
     * 初始化控件
     */
    private void initView(){
        rvImageList=findViewById(R.id.rv_image_list);
        dialog=new AddImageDialog(this,R.style.Dialog);
        dialog.setOnTakePhotoClickListener(this);
        dialog.setOnTakePictureClickListener(this);


    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView(){

        images=new ArrayList<>();

        GridLayoutManager manager=new GridLayoutManager(this,3);
        rvImageList.setLayoutManager(manager);
        publishAdapter=new PublishAdapter(images,this);
        publishAdapter.setOnAddImageClickListener(this);
        publishAdapter.setOnImageClickListener(this);
        rvImageList.setAdapter(publishAdapter);
        rvImageList.addItemDecoration(new DividerGridItemDecoration(3,20,false));

    }

    //点击+号
    @Override
    public void onAddImageClickListener() {
        dialog.show();
    }

    //点击图片
    @Override
    public void onImageClickListener(int position) {
        Toast.makeText(MainActivity.this,"图片"+position,Toast.LENGTH_LONG).show();
    }

    //拍照添加
    @Override
    public void onTakePhotoClickListener() {
        Toast.makeText(MainActivity.this,"拍照",Toast.LENGTH_LONG).show();
    }

    //从相册选择
    @Override
    public void onTakePictureClickListener() {
        Intent intent=new Intent(this,TakePictureActivity.class);
        startActivityForResult(intent,IntentConfig.TAKE_PICTURE);
        dialog.dismiss();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
