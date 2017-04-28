## 思路来源
Android如何高效率的替换整个APP的字体?
https://www.zhihu.com/question/38615247

###　 【Android】修改App字体的三种方法.md
* 参考链接 http://blog.csdn.net/xiaohui_hubei/article/details/49562005

###　ｇｉｔｈｕｂ工程

*　https://github.com/chrisjenx/Calligraphy

### 译】Android：更好的自定义字体方案

* http://ryanhoo.github.io/blog/2014/05/05/android-better-way-to-apply-custom-font/
* 这个写的挺好，文章的布局格式值得参考
* 情景---解决方案一----解决方案二---我的方案---参考链接---原文（翻译的话）

## 自己实现的做法如下
*　 用的是翻译的这个链接
*　 第一种就是直接复制代码
*　 第二种就是自定义类,然后在二个参数的构造方法中强制set字体
*　 注意assets目录跟res是平级的,还有子目录命名是fonts不是font
*　 字体可以随便在网上下载,拿过来用就行了
