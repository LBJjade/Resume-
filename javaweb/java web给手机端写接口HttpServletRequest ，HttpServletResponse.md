## http://www.mamicode.com/info-detail-963374.html


[登录]  [注册]
码迷，mamicode.com

     
    首页
    Web开发
    Windows程序
    编程语言
    数据库
    移动开发
    系统相关
    微信
    其他好文
    会员
     

首页 > 移动开发 > 详细
java web给手机端写接口HttpServletRequest ，HttpServletResponse
时间：2015-08-04 17:21:12      阅读：14975      评论：0      收藏：0      [点我收藏+]

标签：

前言：
作为一名android开发人员，网络数据都是web开发人员提供，每次让他们写一个接口都跟求神拜佛一样，与其求别人还不如自己动手，这是八百年前写的word,今天把它记在csdn,防止以后忘记还可以看看。
1.接口的数据源来自于数据库。（这里没办法提供方法教你怎么查数据，自己去网站上学吧，我觉得挺不错的）
http://www.w3school.com.cn/sql/sql_wildcards.asp
2.我所写接口的框架是structs+spring+ibatis,要会接口首先要学会这三个框架怎么用。下面是myecplise开发的web项目结构图张这样：
技术分享

我们有个大概的了解了，之后你新建一个Javaweb项目都会有个web.xml，这个是入口，我们来看看它里面有啥：
技术分享
web.xml中的东西我没办法讲述的很清楚，待会儿附上源码，公司人说每次新建项目的时候直接复制一下改改就好了，这大概就是通病一是比较懒，而是一个个敲麻烦还要全懂。
3.先说接口，顺序好像反了,这是以登陆为例：
BaseAction类继承ActionSupport类（xwork.jar），我们在BaseAction类写了一些基本的输出方法，就是手机端不是向web请求嘛，web响应后要给手机东西，就好比我登陆的时候给用户名和密码给web,web就去服务器查询是否有这号人，如果有或者没有，web就得告诉手机端，输出格式一般给的是json格式，这是web端的BaseAction类，这个类里面还有HttpServletRequest（手机端传给web的用户名和密码，web就是从这里取出），HttpServletResponse的到他们的实例，以及HttpSession对象，session就是浏览器缓存，比如你登陆别人的网站，别人就可以通过session吧你的账号记录下来。用gessession就可得到。
4，我们写一个LoginAction继承BaseAction，其中写一个登陆的方法如下：

    /**
     * @see 手机端登陆的接口
     */
    @Resource Loginservice loginService;
    //@Resource代表着引用资源
    public void startLogin(){
    Map<String,Object> map=new HashMap<String,Object>();
    //得到请求对象
    HttpServletRequest request=this.getRequest();
    //拿到手机端传给我们的username这个key所对应的的value，用map装起来
    map.put("username",request.getParameter("username"));   
     //拿到密码不为空就 吧它用MD5加密用map装起来，用MD5是为了账户安全，注册的时候都是加密了存入数据库的，简单防止剽窃
     if(StringUtils.isNotNull(request.getParameter("password"))) {
            String password = Md5Utils.MD5_32(request.getParameter("password"));
            map.put("password", password);
        }       
        //在这里就是Service去掉dao层，dao层掉ibatis(数据库层)经过数据库的查询得到一个这个人的信息，查不到返回空
        String json = loginService.Loginmobile(map);
        JSONObject jsonobj=new JSONObject();
        if(json==null){
            json="";
            jsonobj.put("state", "false");
            jsonobj.put("msg", "登陆失败,用户名或密码错误");
        }else{
            jsonobj.put("userinfo", json);
            jsonobj.put("state", "true");
            jsonobj.put("msg", "登陆成功");
        }
        //在这里输出，手机端就拿到web返回的值了
        this.outJsonString(jsonobj.toString());
    }

5.LoginService为接口，里面定义了一系列方法,loginService为其对象，而接口中就有刚调用的Loginmobile方法名，而其方法体在LoginserviceImpl中实现，LoginserviceImpl实现LoginService接口，方法体如下：

public class LoginserviceImpl implements Loginservice{
    @Resource LoginDao loginDao; //引用dao资源
//方法调用LoginDao 的Loginmobile方法
    public String Loginmobile(Map<String,Object> params){
           return loginDao.Loginmobile(params);
    }

6.LoginDao 也是接口类，他的实现类是LoginDaoImpl，LoginDao 类申明了一个Loginmobile方法名，其方法体在LoginDaoImpl中实现。具体实现为：
LoginDaoImpl类继承AbstactTemplateDao 类（）

public class LoginDaoImpl extends AbstactTemplateDao implements LoginDao {
    public String Loginmobile(Map<String,Object> params){       
    //查询数据库，"login.loginmobile"中，login代表ibatis中name=login的文件，下的loginmobile方法(就是查语句，看下图)
        List<Map<String,String>> list = this.getSqlMapClientTemplate().queryForList("login.loginmobile",params);
        return list.toString();     
    }

技术分享
技术分享

现在知道大致的流程了吧，总结一下：
一个登陆模块我们把它划在一个包下，不管是web还是手机登陆都放这里，一个登陆包下分四个分支，一个action层，一个service层（业务逻辑层），一个dao层（数据库操作层），一个Entry（实体类，对应数据库表） ，四个层次，如下图：
技术分享

技术分享

打箭头的代表要配置，所有的继承Baseaction的类以及各自的service实现类和dao的实现类都要在各自对应的文件中配置，比如loginaction就要在applicationContext-action中配置如下

<beans
    xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

    <bean name="loginAction" class="org.U9APP.login.action.LoginAction" scope="prototype"></bean>

</beans>

dao的实现类也是一样，在applicationContext-dao中注册

<?xml version="1.0" encoding="UTF-8"?>
<beans
    xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd">

    <!-- 登陆管理 -->
    <bean name="loginDao" class="org.U9APP.login.dao.LoginDaoImpl" />

</beans>

技术分享
structs也有类似的配置，而之前说的web.xml中吧spring中下的四个文件配置了。sping中的applicationContext是用来配置ibatis的，上面有个图画错了哈，最后就是你写的接口的url是这样拼起来的。

http:192.168.0.100:8080/loginAction/startLogin.action?username=”123”&password=”123456”

其中：
192.168.0.100你电脑ip,8080tomcat端口号，loginAction为applicationContext-action中登陆所在类class=”org.U9APP.login.action.LoginAction”它的name值，startLogin为登陆类下的刚写的登陆方法名。action,？后为参数，usname为key，这个是web和手机对接key,123为用户名，123456为密码，这个key可以换成其他的字符串不过你要知其意思并且要和手机一直才能收到。

版权声明：本文为博主原创文章，未经博主允许不得转载。

java web给手机端写接口HttpServletRequest ，HttpServletResponse

标签：
踩
(5)
赞
(13)
   
举报
评论 一句话评论（0）
共0条  
登录后才能评论！
分享档案
更多>
2017年06月29日 (825)
2017年06月28日 (1500)
2017年06月27日 (1630)
2017年06月26日 (1603)
2017年06月25日 (1397)
2017年06月24日 (1629)
2017年06月23日 (1622)
2017年06月22日 (1579)
2017年06月21日 (1560)
2017年06月20日 (1583)
周排行
mamicode.com排行更多图片
更多

    Mac下获取AppStore安装包文件路径  2015-03-11
    win7系统电脑连接小米蓝牙音箱  2015-03-08
    android开发之onCreate( )方法详解  2014-11-07
    windows平台下Android studio开发环境搭建教程  2015-06-29
    谈谈APP架构选型：React Native还是HBuilder  2016-01-21
    Android Studio 连接真机不识别  2015-02-11
    中央部门领导地址维权邮箱和记者手机号码大全2016（王焰）  2016-06-25
    Android Studio导入项目非常慢的解决办法  2016-01-22
    iOS开发——网络编程OC篇&Socket编程  2015-06-23
    Android Studio 安装及常见问题  2015-02-17

友情链接
兰亭集智  国之画  百度统计   站长统计  阿里云  chrome插件
关于我们 - 联系我们 - 留言反馈
© 2014 mamicode.com 版权所有 京ICP备13008772号-2
迷上了代码！
      
