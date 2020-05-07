package com.onlinepda.hangke.basefragment.tools.dialogtools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.onlinepda.hangke.basefragment.R;


public class BaseicDialog extends AppCompatDialogFragment{
    public BaseicDialog() {

    }
    private View mView;//view布局
    private Context mContext;//依附的activity
    private int layoutId;//布局
    private Boolean fullScreen;//全屏
    private Boolean cancelable;//能否取消
    private CallBack mCallBack;//回调
    View mRootView = null;//根布局
    private int dialogAnim=0;//弹出动画，默认从底部弹出
    private int customAnim;//自定义dialog动画
    private String tag;//dialog的tag
    private float mDimAmount;
    public static class Builder{
        CallBack innerCallBack;
        int innerView;
        View viewInnerView;
        Context innerContext;
        Boolean innerScreen;
        Boolean innerCancelable;
        int innerAnim;
        int innerCustomAnim;
        String innerTag;
        float innerDimAmount;
        public BaseicDialog build(){

            return new BaseicDialog(this);
        }
        public Builder setDimAmount(float dimAmount){
            this.innerDimAmount=dimAmount;
            return this;
        }
        public Builder setTag(String tag){
            this.innerTag=tag;
            return this;
        }
        public Builder setCustomAnim(int resStyle){
            this.innerCustomAnim=resStyle;
            return this;
        }
        public Builder setAnim(int anim){
            this.innerAnim=anim;
            return this;
        }
        public Builder setOnViewClickListaner(CallBack callBack){
            this.innerCallBack=callBack;
            return this;
        }
        public Builder setCancelable(Boolean cancelable){
            this.innerCancelable=cancelable;
            return this;
        }
        public Builder setFullScreen(Boolean fullScreen){
            this.innerScreen=fullScreen;
            return this;
        }
        public Builder setAttachContext(Context context){
            this.innerContext=context;
            return this;
        }
        public Builder setView(int view){
            this.innerView=view;

            return this;
        }
        public Builder setView(View view){
            this.viewInnerView=view;
            return this;
        }
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setFullScreen();
        if(!cancelable){
            getDialog().setCancelable(cancelable);
        }

        if(customAnim!=0){
            setCustomAnim();
        }else {
            setAnim();
        }

    }

    /**
     * 设置是否全屏
     */
    protected void setFullScreen(){
        Window window=getDialog().getWindow();
        if(fullScreen){//全屏控制
            window.getDecorView().setMinimumWidth(getResources().getDisplayMetrics().widthPixels);
            // 一定要设置Background，如果不设置，window属性设置无效
            window.getDecorView().setBackgroundColor(Color.TRANSPARENT);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        WindowManager.LayoutParams lp=window.getAttributes();
        lp.width=WindowManager.LayoutParams.MATCH_PARENT;
        lp.horizontalMargin = 0;
        lp.dimAmount =mDimAmount;
        lp.height=WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
    }

    /**
     * 设置dialog自定义动画
     */
    protected void setCustomAnim(){
        getDialog().getWindow().getAttributes().windowAnimations =customAnim;
    }

    /**
     * 设置dialog弹出动画
     */
    protected void setAnim(){
        switch (dialogAnim){
            case 0:
                getDialog().getWindow().getAttributes().windowAnimations = R.style.dialogWindowAnimButtomToTop;
                break;
            case 1:
                getDialog().getWindow().getAttributes().windowAnimations = R.style.dialogWindowAnimTopToButtom;
                break;
            case 2:
                getDialog().getWindow().getAttributes().windowAnimations = R.style.dialogWindowAnimLeftToRight;
                break;
            case 3:
                getDialog().getWindow().getAttributes().windowAnimations = R.style.dialogWindowAnimRightToLeft;
                break;
            case 4:
                Window window=getDialog().getWindow();
                window.setGravity(Gravity.BOTTOM);
                getDialog().getWindow().getAttributes().windowAnimations = R.style.dialogWindowAnimStayButtom;
                break;
            default:
                getDialog().getWindow().getAttributes().windowAnimations = R.style.dialogWindowAnimButtomToTop;
                break;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(mView!=null){
            mRootView=mView;
        }else if(layoutId!=0){
            mRootView=inflater.inflate(layoutId,container,false);
        }

        if(mRootView==null){
        }else {
            if(mCallBack!=null){
                mCallBack.getDialogView(mRootView);
            }

        }
        return mRootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 显示
     */
    @SuppressLint("RestrictedApi")
    public void show(){
        if(mContext==null){
            throw new NullPointerException("请设置Context");
        } else {


            if(!isAdded()&&!isVisible()&&!isRemoving()) {
                this.show(((AppCompatActivity)mContext).getSupportFragmentManager(),tag);
            }

            }

    }

    public void setBuilder(Builder builder){
        this.mContext=builder.innerContext;
        this.layoutId=builder.innerView;
        this.mView=builder.viewInnerView;
        this.fullScreen=builder.innerScreen==null?false:builder.innerScreen;
        this.cancelable=builder.innerCancelable==null?true:builder.innerCancelable;
        this.mCallBack=builder.innerCallBack;
        this.dialogAnim=builder.innerAnim;
        this.customAnim=builder.innerCustomAnim;
        this.tag=builder.innerTag;
        this.mDimAmount=builder.innerDimAmount==0f?0.6f:builder.innerDimAmount;
    }



    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * 构造
     */
    @SuppressLint("ValidFragment")
    public BaseicDialog(Builder builder) {
        this.mContext=builder.innerContext;
        this.layoutId=builder.innerView;
        this.mView=builder.viewInnerView;
        this.fullScreen=builder.innerScreen==null?false:builder.innerScreen;
        this.cancelable=builder.innerCancelable==null?true:builder.innerCancelable;
        this.mCallBack=builder.innerCallBack;
        this.dialogAnim=builder.innerAnim;
        this.customAnim=builder.innerCustomAnim;
        this.tag=builder.innerTag;
        this.mDimAmount=builder.innerDimAmount==0f?0.6f:builder.innerDimAmount;
    }
}
