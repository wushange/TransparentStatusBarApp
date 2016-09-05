最近整理了一下代码，发现代码好乱，，，，
这里简单整理一下 我平时常用的代码块

 - BaseActivity 基类acitity
 - BaseFragement 基类fragment 
 - Operation 基本操作抽取
 - 设置状态栏透明（全屏模式沉浸）
 - 设置状态栏字体颜色（适配 MIUI MEIZU Android6.0+）
 - -常用工具类

做过一段状态栏颜色适配，纯色的基本在style直接设置就可以了，
不过最近效果图有一种效果要求 是在状态栏部分也显示内容部分，
像下面这样
[下载地址](http://download.csdn.net/detail/wushge11/9586690)
[github传送门](https://github.com/wushge11/TransparentStatusBarApp)
![这里写图片描述](http://img.blog.csdn.net/20160726161154589)

我是用全屏模式实现的


![这里写图片描述](http://img.blog.csdn.net/20160726162223551)

首先activity的setContentView之前设置 状态栏模式为透明
最近整理了一下代码 不是太会整理，，，
封装成了工具类直接调用即可，
StatusBarUtil.java

我是在BaseActivity中写的 直接调用statusbarutil

```
 /**
     * 设置状态栏颜色
     *
     * @param color
     */

    public void setStatusColor(int color) {
        StatusBarUtil.setColor(this, color);
    }

    /**
     * 设置全屏模式透明
     */
    public void setTranslucentStatus() {
        StatusBarUtil.setTranslucentStatus(this, true);
    }

    /**
     * 设置全屏模式透明内容padding
     */
    public void setTranslucentStatusPadding() {
        StatusBarUtil.setTransparent(this);
    }
```



```
  //设置toolbar透明
        Drawable d = toolbar.getBackground();
        d.setAlpha(0); // 完全透明
         d.setAlpha(255); // 不透明
```
[下载地址](http://download.csdn.net/detail/wushge11/9586690)
[github传送门](https://github.com/wushge11/TransparentStatusBarApp)
