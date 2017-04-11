application
GrassApp

全局异常处理
CrashHandler

网络访问
okhttp
OkHttpUtils
HttpManager 在这个okhttpUtils的基础上在封装

第三方

聊天室 环信EMOptions
统计、推送   umeng

Preferences管理类
PrefManager


mipmap里面按分辨率分了，
drawable放xml
ps:也行吧，另一种方式drawable可以参考eclipse,mipmap里面放icluncher

事件通信
EventBus

基类
BaseActivity 里面放了加载的提示框 
引导页就不看了
MainActivity 主界面
LoginActivity  登录


工具类
CommonUtils 电话号码校验等


mvp
参考登录代码
登录流程：

GrassApp---SplashActivity---第一次（用sp来保存这个）进来进引导页，非进入登录---未登录，进入主界面的登录界面---登录了，从db里面取出user，然后判断后进入角色界面

未登录---tv_login---LoginActivity---再去LoginPresenter实现逻辑---校验成功返回数据---获取角色---FileUtil.saveObj---回调Roleview.getRoleList(callId,roleInfos,msg)
---LoginActivity实现了Roleview接口setCurrentUserRole并saveUserInfo---保存到了db的user表里---


调试日志
LogUtil.show("toast:"+msg);


ClassAlbumDetailActivity------班级相册列表详情，不是查看单张照片的地方-----activity_class_ablum_detail2

ClassAlbumListActivity----相册的列表viewpager----

AlbumListFragment----相册的列表viewpager放fragment的地方


TeaClassTaskActivity---作业----TaskFragment---TaskPresenter(不只是作业还有通知；删除通知，删除作业，获取已发通知，获取通知，获取作业)



FirstPageActivity----MainActivity---MainPresenter---HttpManager
这些我在代码里模拟了用户后，可以开始玩了

AccountEvent--- 注册了事件---eventbus---1定义一个消息类2在需要订阅事件的地方注册3发送消息4处理消息----记住这个步骤----



## 发现问题
*　iv.setPadding(10,0,0,0);　像这样的屏幕适配的没考虑到
*　





