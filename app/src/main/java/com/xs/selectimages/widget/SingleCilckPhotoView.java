package com.xs.selectimages.widget;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;

import com.github.chrisbanes.photoview.PhotoView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/4/25.
 */

public class SingleCilckPhotoView extends PhotoView {
    public SingleCilckPhotoView(Context context) {
        super(context);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//
//        //处理 photoView的点击事件 如果是单击 交给 父布局 rxBanner处理 单击就自己消耗掉
//
//
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN:
//
//                isSingleClick();
//
//                break;
//        }
//
//        return isIntercept;
//
//    }
//
//    boolean isSingle=true; //是否为
//    boolean isIntercept=false;
//
//    private void isSingleClick(){
////        Timer timer=null;
//
//        if (isSingle){
//            Log.e("TAG","第一次点击");
//            isSingle=false;
////            timer=new Timer();
////            timer.schedule(new TimerTask() {
////                @Override
////                public void run() {
////                    Log.e("TAG","判断为点击一次");
////                    isSingle=true;
////                    isIntercept=true;
////                }
////            },1000);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            isSingle=true;
//            isIntercept=false;
//
//        }else{
////            if (timer!=null){
////                timer.cancel();
////            }
//            isIntercept=false;
//            isSingle=true;
//            Log.e("TAG","第二次点击");
//        }
//
//    }

}
