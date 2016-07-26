做过一段状态栏颜色适配，纯色的基本在style直接设置就可以了，
不过最近效果图有一种效果要求 是在状态栏部分也显示内容部分，
像下面这样
[下载地址](http://download.csdn.net/detail/wushge11/9586690)
[github传送门](https://github.com/wushge11/TransparentStatusBarApp)
![这里写图片描述](http://img.blog.csdn.net/20160726161154589)

我是用全屏模式实现的
![这里写图片描述](http://img.blog.csdn.net/20160726162223551)
首先activity的setContentView之前设置 状态栏模式为透明


```
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            // Translucent status bar
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
```
这个时候activity的内容就会在状态栏下面 并且透明，
 ![这里写图片描述](http://img.blog.csdn.net/20160726161753248)
 不过内容也会在状态栏上
想要显示正常的话 要在布局的根节点上`  android:fitsSystemWindows="true"
    android:clipToPadding="true"`
    这样就会给内容留出一个状态栏高度的空间
    或者手动设置跟布局的pandding
    
  设置toolbar全透明
  

```
  //设置toolbar透明
        Drawable d = toolbar.getBackground();
        d.setAlpha(0); // 完全透明
         d.setAlpha(255); // 不透明
```
[下载地址](http://download.csdn.net/detail/wushge11/9586690)
[github传送门](https://github.com/wushge11/TransparentStatusBarApp)
