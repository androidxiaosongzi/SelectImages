package com.xs.selectimages;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PublishAdapter.OnAddImageClickListener
        ,PublishAdapter.OnImageClickListener ,AddImageDialog.OnTakePhotoClickListener,AddImageDialog.OnTakePictureClickListener{

    private RecyclerView rvImageList;
    private PublishAdapter publishAdapter;

    private List<String> images;

    private AddImageDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRecyclerView();
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
        for (int i=0;i<4;i++){
            images.add("");
        }

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
        Toast.makeText(MainActivity.this,"相册",Toast.LENGTH_LONG).show();
    }
}
