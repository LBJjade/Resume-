##如何学习gradle
* gradle 用户指南
* android studio 构建指南
* android studio gradle 插件使用指南
* gradle dsl 语言api
* gradle 中文文档 


### gradle 构建文件
* build.gradle
* gradle.properties
* local.properties
* setting.gradle

ps: 会有一个全局的build.gradle文件,每个模块下也有一个build.gradle

### 项目全局的build.gradle
* 最重要的buildscript
* apply plugin 描述了gradle所引入的插件
#### android 领域 
描述了该android module构建过程中所用到的所有参数

* 参数compileSdkVersion ---编译的sdk版本
* 参数buildToolsVersion ---android build tools版本
* 参数defaultConfig
* 参数buildTypes
#### dependencies领域 
描述了该android module 构建过程中所依赖的所有库

* jar
* aar(推荐) gradle向调用者屏蔽了所有的依赖关系,主项目只需要只要依赖了该aar库,而不需要知道aar项目对于其他库的依赖关系
ps: 如果不知道这些配置是干啥的,需要从http://google.github.io/android-gradle-dsl/current/index.html

#### local.properties
配置了gradle插件所需要的sdk的路径

### gradle task
#### assemble task 
* 用于组合项目的所有输出 assembleDebug assembleRelease
#### check
用于执行检查任务
#### build
执行了check和assemble
#### clean
用于清理所有的中间编译结果

## gradle 进阶
### 更改项目结构
可以在android领域进行配置
### 构建全局配置
* 全局参数 ext领域指定
* 引用配置 
``` android{
		compileSdkVersion rootProject.ext.compileSdkVersion
    }
```
### 构建defaultConfig
可以动态的控制编译过程,比如动态控制versionName的生成

### 构建buildTypes
* 构建类型基础
* 构建类型buildTypes的继承
* 构建类型的参数

### 构建signingConfigs
### 生成签名

### android领域中的可选配置
* compileOptions 配置编译的选项
``` compileOptions{
		sourceCompatibility JavaVersion.VERSION_1_8
		targetCompatibility_JavaVersion.VERSION_1_8
	}
```
* lintOptions
用于控制lint代码检查
``` lintOptions{
		abortOnError false
	}
```
### 构建Proguard
### 多渠道打包
#### 创建渠道占位符
#### 配置gradle脚本
productFlavors && 增加定义的渠道名
#### 生成重命名包
#### 为不同版本添加不同的代码
buildType buildConfigField---类型 名称 值 

## gradle多项目依赖
### jar包
### so库
### 本地库项目依赖


## 未完待续
后面的gradle依赖等



