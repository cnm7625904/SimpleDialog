# SimpleDialog
一款简单通用的FragmentDialog
##先看看效果
![top.gif](https://upload-images.jianshu.io/upload_images/6307403-691bd441d6e9a46f.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/310)
![bottom.gif](https://upload-images.jianshu.io/upload_images/6307403-7da4151017b05b00.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/310)
![device-2020-05-07-112100.gif](https://upload-images.jianshu.io/upload_images/6307403-182cea80e7cc8e59.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/310)

![device-2020-05-07-112048.gif](https://upload-images.jianshu.io/upload_images/6307403-d91473f6c26b8777.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/310)

![device-2020-05-07-112029.gif](https://upload-images.jianshu.io/upload_images/6307403-f80d7f81e0df122c.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/310)

![device-2020-05-07-112017.gif](https://upload-images.jianshu.io/upload_images/6307403-e89f8cb0f1e4fad9.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/310)

![device-2020-05-07-111959.gif](https://upload-images.jianshu.io/upload_images/6307403-7a1200bb5abd879e.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/310)

![device-2020-05-07-112112.gif](https://upload-images.jianshu.io/upload_images/6307403-79399ede934d6142.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/310)

![device-2020-05-07-171652_tF3dcC9Lyq.gif](https://upload-images.jianshu.io/upload_images/6307403-d59c66f8663d3c9a.gif?imageMogr2/auto-orient/strip%7CimageView2/2/w/310)


##以上几种弹窗基本满足日常工作需求
这个弹窗类刚开始写，还有许多东西没有完善，还有一些方法需要剥离。但会一直更新下去。
```
主要类只有三个
BaseicDialog  //dialogfragment
CallBack  //存放回调
DialogAnim  //存放一些常量
```

##使用方法和系统的dialog类似
方法一：
```
   BaseicDialog   mBaseicDialog1=new BaseicDialog.Builder()
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
mBaseicDialog1.show();
```


方法二：
```
 BaseicDialog mBaseicDialog2=new BaseicDialog();
 builder2 =new BaseicDialog.Builder()
                        .setAttachContext(MainActivity.this)//依附的Context
                        .setView(R.layout.dialog_base)//自定义布局
                        .setAnim(DialogAnim.LEFT);//弹窗动画 内置5种 上下左右底部固定
                mBaseicDialog2.setBuilder(builder2);
                mBaseicDialog2.show();
```


简单使用：


```
 new BaseicDialog.Builder()
                .setAttachContext(this)//依附的Context
                .setView(R.layout.dialog_base)//自定义布
                .build().show();
```
有兴趣的朋友可以下载源码查看，里面用到了builder设计模式和fragment的生命周期，总的来说，还有很大的优化空间。

使用方法
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.cnm7625904:SimpleDialog:Tag'
	}
Share this release:














