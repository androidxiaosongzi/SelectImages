package com.xs.selectimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvImageList;
    private PublishAdapter publishAdapter;

    private List<String> images;

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
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView(){

        images=new ArrayList<>();
        for (int i=0;i<9;i++){
            images.add(""+i);
        }

        GridLayoutManager manager=new GridLayoutManager(this,3);
        rvImageList.setLayoutManager(manager);
        publishAdapter=new PublishAdapter(images,this);
        rvImageList.setAdapter(publishAdapter);

    }

}
