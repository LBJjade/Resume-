gradle复习(4)-Cannot find System Java Compiler  
 


http://blog.csdn.net/itfootball/article/details/42963987


新建一个gradle.properties文件，在里面添加javahome的属性，指定jdk的根目录

org.gradle.java.home=D:/PROJECTS/JAVA/Envs/java

org.gradle.java.home=C:/Program Files/Java/jdk1.8.0_111

## 下面这个办法可行
Error:Execution failed for task ':xxxxx:compileDebugJava'.

> Cannot find System Java Compiler. Ensure that you have installed a JDK (not just a JRE) and configured your JAVA_HOME system variable to point to the according directory.




Android studio环境下，新建的项目正常，导入其他项目出现这么一个异常

解决方法

File-->Project-->Structrue-->SDK Location-->JDK location  


Use embedded JDK 前面勾去掉，指定一个JDK地址。


默认使用的embedded JDK ，可能是我的JDK同时装了1.7和1.8的JDK或者项目环境变量原因导致出错。
