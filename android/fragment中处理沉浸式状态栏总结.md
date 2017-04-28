##　fragment中处理沉浸式状态栏总结

## 一个简单的介绍的链接
http://www.jianshu.com/p/ff0c5bab32d6


## 一个全面的介绍的链接

http://www.jianshu.com/p/bae25b5eb867

### 我自己做的时候的思路
我只要第一个用上沉浸式状态栏，其他的都不用了。我的想法是先将全部设置上沉浸式状态栏。然后将除了第一个之外的地方，全部在状态栏的地方用上一个深色背景。

### 备注
* window.setStatusBarColor(color);等一定要在setContentView（）之前设置，否则会出异常
java.lang.RuntimeException:Unable to start activity ComponentInfo{cn.grasscloud.jiaxiao/cn.grasscloud.jiaxiao.MainActivity}: android.util.AndroidRuntimeException: requestFeature() must be called before adding content

