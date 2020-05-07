package com.onlinepda.hangke.basefragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.onlinepda.hangke.basefragment.tools.dialogtools.BaseicDialog;
import com.onlinepda.hangke.basefragment.tools.dialogtools.CallBack;
import com.onlinepda.hangke.basefragment.tools.dialogtools.DialogAnim;

//外部模糊
//打造多个例子
public class MainActivity extends AppCompatActivity {
    TextView tv1;//从上而上
    TextView tv2;//从下而下
    TextView tv3;//从左而右
    TextView tv4;//从右而左
    TextView tv5;//底部停留
    TextView tv6;//默认显示
    TextView tv7;//拍照选图
    TextView tv8;//今日头条
    TextView tv9;//BOSS直聘
    TextView tv10;//头条评论

    BaseicDialog mBaseicDialog1;
    BaseicDialog mBaseicDialog2=new BaseicDialog();
    private BaseicDialog.Builder builder2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        tv5=findViewById(R.id.tv5);
        tv6=findViewById(R.id.tv6);
        tv7=findViewById(R.id.tv7);
        tv8=findViewById(R.id.tv8);
        tv9=findViewById(R.id.tv9);
        tv10=findViewById(R.id.tv10);

        mBaseicDialog1=new BaseicDialog.Builder()
                .setAttachContext(this)//依附的Context
                .setView(R.layout.dialog_base)//自定义布局
                .setFullScreen(false)//是否全屏，弹窗不留空隙
                .setCancelable(true)//能否取消
                .setAnim(DialogAnim.TOP)//弹窗动画 内置5种 上下左右底部固定
                .setTag("Main")//设置tag
                .setDimAmount(0.3f)//设置背景透明度 0f-1f  透明到黑色
//                .setCustomAnim(R.style.dialogWindowAnimButtomToTop)//自定义动画覆盖内置动画
                .setOnViewClickListaner(new CallBack() {
                    @Override
                    public void getDialogView(View view) {//自定义布局回调与fragment绑定ViewId一样，view.findviewbyid

                    }
                })
                .build();

        clicks();

    }

    private void clicks() {
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBaseicDialog1.show();
            }
        });

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder2 =new BaseicDialog.Builder()
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setView(R.layout.dialog_base)//自定义布局
                        .setFullScreen(false)//是否全屏，弹窗不留空隙
                        .setCancelable(true)//能否取消
                        .setAnim(DialogAnim.BOTTOM)//弹窗动画 内置5种 上下左右底部固定
                        .setTag("Main")//设置tag
                        .setDimAmount(0.3f)//设置背景透明度 0f-1f  透明到黑色
//                .setCustomAnim(R.style.dialogWindowAnimButtomToTop)//自定义动画覆盖内置动画
                        .setOnViewClickListaner(new CallBack() {
                            @Override
                            public void getDialogView(View view) {//自定义布局回调与fragment绑定ViewId一样，view.findviewbyid

                            }
                        });
                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder2 =new BaseicDialog.Builder()
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setView(R.layout.dialog_base)//自定义布局
                        .setAnim(DialogAnim.LEFT);//弹窗动画 内置5种 上下左右底部固定
                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder2 =new BaseicDialog.Builder()
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setView(R.layout.dialog_base)//自定义布局
                        .setAnim(DialogAnim.RIGHT);//弹窗动画 内置5种 上下左右底部固定
                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();
            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder2 =new BaseicDialog.Builder()
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setView(R.layout.dialog_base)//自定义布局
                        .setFullScreen(true)
                        .setAnim(DialogAnim.STAYBOTTOM);//弹窗动画 内置5种 上下左右底部固定
                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();
            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder2 =new BaseicDialog.Builder()
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setView(R.layout.dialog_base);//自定义布局
                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();
            }
        });
        tv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder2 =new BaseicDialog.Builder()
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setView(R.layout.dialog_bottom_sheet)//自定义布局
                        .setFullScreen(true)
                        .setCancelable(false)
                        .setOnViewClickListaner(new CallBack() {
                            @Override
                            public void getDialogView(View view) {
                                TextView menu_camera= view.findViewById(R.id.menu_camera);
                                TextView menu_photo= view.findViewById(R.id.menu_photo);
                                TextView menu_logout= view.findViewById(R.id.menu_logout);
                                TextView menu_cancel= view.findViewById(R.id.menu_cancel);

                                menu_camera.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(MainActivity.this,"点击了拍照",Toast.LENGTH_SHORT).show();
                                        mBaseicDialog2.dismiss();
                                    }
                                });
                                menu_photo.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(MainActivity.this,"点击了相册",Toast.LENGTH_SHORT).show();
                                        mBaseicDialog2.dismiss();
                                    }
                                });
                                menu_logout.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(MainActivity.this,"退出登录",Toast.LENGTH_SHORT).show();
                                        mBaseicDialog2.dismiss();
                                    }
                                });
                                menu_cancel.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        mBaseicDialog2.dismiss();
                                    }
                                });

                            }
                        })
                        .setAnim(DialogAnim.STAYBOTTOM);//弹窗动画 内置5种 上下左右底部固定
                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();
            }
        });

        tv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder2 =new BaseicDialog.Builder()
                        .setAnim(DialogAnim.STAYBOTTOM)
                        .setFullScreen(true)
                        .setDimAmount(0.3f)
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setView(R.layout.dialog_toutiao);//自定义布局

                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();
            }
        });

        tv9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder2 =new BaseicDialog.Builder()
                        .setAnim(DialogAnim.STAYBOTTOM)
                        .setFullScreen(true)
                        .setDimAmount(0.3f)
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setView(R.layout.dialog_boss);//自定义布局
                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();
            }
        });
        tv10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder2 =new BaseicDialog.Builder()
                        .setAnim(DialogAnim.STAYBOTTOM)
                        .setFullScreen(true)
                        .setDimAmount(0.3f)
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setOnViewClickListaner(new CallBack() {
                            @Override
                            public void getDialogView(View view) {
                                AppCompatEditText et=view.findViewById(R.id.et);
                                et.setFocusable(true);
                                et.setFocusableInTouchMode(true);
                                et.requestFocus();
                                mBaseicDialog2.getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                            }
                        })
                        .setView(R.layout.dialog_comment);//自定义布局
                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();

            }
        });
    }

}
