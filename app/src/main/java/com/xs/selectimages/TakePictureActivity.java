package com.xs.selectimages;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.xs.selectimages.adapter.TakePictureAdapter;
import com.xs.selectimages.bean.FolderBean;
import com.xs.selectimages.bean.ImageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小松 2018/4/24
 */

public class TakePictureActivity extends BaseActivity implements TakePictureAdapter.OnImageClickListener {

    private RecyclerView rvImageList;
    private TakePictureAdapter adapter;
    private List<FolderBean> folderBeans;
    private List<String> imageBeans;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAllImages();
        initView();


    }

    private void initView() {
        folderBeans=new ArrayList<>();
        imageBeans=new ArrayList<>();

        rvImageList = findViewById(R.id.rv_image_list);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        rvImageList.setLayoutManager(manager);
        rvImageList.addItemDecoration(new DividerGridItemDecoration(4,5,false));
        adapter=new TakePictureAdapter(imageBeans,this);
        rvImageList.setAdapter(adapter);
        adapter.setOnImageClickListener(this);
    }


    /**
     * 获取相册中所有图片
     */
    private void getAllImages() {
        ImageModel.loadImageForSDCard(this, new ImageModel.DataCallback() {
            @Override
            public void onSuccess(List<FolderBean> folders) {
                folderBeans.addAll(folders);
                imageBeans.addAll(folders.get(0).getImageBeans());
                handler.sendEmptyMessage(1);
            }
        });
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
        Toast.makeText(TakePictureActivity.this, "完成", Toast.LENGTH_LONG).show();
    }

    @Override
    protected String setToolbarRightText() {
        return "完成";
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    public void onImageClickListener(int position) {
        Intent intent=new Intent(this,PhotoViewActivity.class);
//        Bundle bundle=new Bundle();
//        bundle.putSerializable("IMAGES", (Serializable) imageBeans);
        intent.putStringArrayListExtra("IMAGES", (ArrayList<String>) imageBeans);
        intent.putExtra("POSITION",position);
        startActivity(intent);
    }
}
