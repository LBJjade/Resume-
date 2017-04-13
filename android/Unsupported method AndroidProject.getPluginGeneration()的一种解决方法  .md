
## http://blog.csdn.net/y505772146/article/details/53038921


最近在进行Android开发的过程中，发现自己在debug自己的项目的时候，出现了如下的错误：

UnsupportedMethodException
Unsupported method: AndroidProject.getPluginGeneration().
The version of Gradle you connect to does not support that method.
To resolve the problem you can change/upgrade the target version of Gradle you connect to.
Alternatively, you can ignore this exception and read other information from the model.1
2
3
4
5


1
2
3
4
5

这个错误应该是由于项目的Gradle文件和自己的Android Studio设置的有了冲突，原来的Gradle代码如下：

build.gradle:

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.5.0'
    }
}1
2
3
4
5
6
7
8


1
2
3
4
5
6
7
8

gradle-wrapper.properties:

#Wed Apr 10 15:27:10 PDT 2013
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-2.2.1-all.zip1
2
3
4
5
6


1
2
3
4
5
6

这里应该分别改为如下，然后再同步即可（针对Gradle进行修改）：

build.gradle:

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.2'
    }
}1
2
3
4
5
6
7
8


1
2
3
4
5
6
7
8

gradle-wrapper.properties:

#Wed Apr 10 15:27:10 PDT 2013
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-2.14.1-all.zip1
2
3
4
5
6


1
2
3
4
5
6

也就是说，当出现问题的时候，应该就是Gradle的版本问题，我们只要在上面的两个地方分别进行新的配置，就可以正常在手机上运行自己的项目了。
