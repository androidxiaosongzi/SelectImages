package com.xs.selectimages;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2018/4/23.
 */

public class PublishAdapter extends RecyclerView.Adapter<PublishAdapter.PublishViewHolder>{

    private List<String> images;
    private Context mContext;
    private OnAddImageClickListener onAddImageClickListener;
    private OnImageClickListener onImageClickListener;

    public PublishAdapter(List<String> images, Context mContext) {
        this.images = images;
        this.mContext = mContext;
    }

    @Override
    public PublishViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_image, parent, false);

        return new PublishViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PublishViewHolder holder, final int position) {
        //判断当前position 是否是 列表中最后一个 是则 显示 指定图片
        if(position==images.size()){
            Glide.with(mContext).load(R.mipmap.add_image).into(holder.ivImage);
            holder.ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAddImageClickListener.onAddImageClickListener();
                }
            });
        }else{
            holder.ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onImageClickListener.onImageClickListener(position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        //为列表添加一个 放+号的位置
        return images.size()+1;
    }

    class PublishViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivImage;

        public PublishViewHolder(View itemView) {
            super(itemView);
            ivImage=itemView.findViewById(R.id.iv_image);
        }
    }

    //定义 + 号 图片的点击事件
    interface OnAddImageClickListener{
        void onAddImageClickListener();
    }

    //定义普通图片的点击事件
    interface OnImageClickListener{
        void onImageClickListener(int position);
    }

    public void setOnAddImageClickListener(OnAddImageClickListener onAddImageClickListener){
        this.onAddImageClickListener=onAddImageClickListener;
    }

    public void setOnImageClickListener(OnImageClickListener onImageClickListener){
        this.onImageClickListener=onImageClickListener;
    }

}
