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
    public void onBindViewHolder(PublishViewHolder holder, int position) {
//        Glide.with(mContext).load(images.get(position)).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class PublishViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivImage;

        public PublishViewHolder(View itemView) {
            super(itemView);
            ivImage=itemView.findViewById(R.id.iv_image);

            Log.e("TAG","ImageView宽度："+ivImage.getWidth()+"");
        }
    }

}
