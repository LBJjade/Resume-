##  Genymotion模拟器adb冲突解决方法 

#### http://blog.csdn.net/HelloMagina/article/details/52346860

#### 我遇到的是这样的情况
情况2：AndroidStudio与Genymotion能连接上，但用cmd操作adb命令时出现如下报错提示：error: could not install smartsocket listener: cannot bind to 127.0.0.1:5037: 通常每个套接字地址(协议/网络地址/端口)只允许使用一次。 (10048)
解决方法：到Genymotion的安装目录，譬如C:\Program Files\Genymobile\Genymotion\tools，Genymotion会自带一个adb工具，该工具会和sdk的adb工具产生冲突，所以我们要删除Genymotion自带的adb.
删除后，再次启动Genymotion，会弹出提示是否用AndroidSDK的adb工具来替代，选择androidsdk的路径就可以了。