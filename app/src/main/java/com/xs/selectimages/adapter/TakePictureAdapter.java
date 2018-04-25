package com.xs.selectimages.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.xs.selectimages.R;
import com.xs.selectimages.bean.ImageBean;
import com.xs.selectimages.widget.SquareImageView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/25.
 */

public class TakePictureAdapter extends RecyclerView.Adapter<TakePictureAdapter.TakePictureViewHolder> {

    private OnImageClickListener onImageClickListener;

    private List<String> imageBeans;
    private Context mContext;

    public TakePictureAdapter(List<String> imageBeans, Context mContext) {
        this.imageBeans = imageBeans;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TakePictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_select_image, parent, false);

        return new TakePictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TakePictureViewHolder holder, final int position) {
        Glide.with(mContext).load(imageBeans.get(position)).apply(RequestOptions.centerCropTransform()).into(holder.sivImg);
        holder.sivImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageBeans.size();
    }

    class TakePictureViewHolder extends RecyclerView.ViewHolder{

        private SquareImageView sivImg;

        public TakePictureViewHolder(View itemView) {
            super(itemView);
            sivImg=itemView.findViewById(R.id.siv_img);
        }
    }

    public interface OnImageClickListener{
        void onImageClickListener(int position);
    }

    public void setOnImageClickListener(OnImageClickListener onImageClickListener){
        this.onImageClickListener=onImageClickListener;
    }

}
