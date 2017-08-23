http://blog.csdn.net/u010397369/article/details/17465649

## 这个是观察工程代码的定时任务举例

### Spring整合Quartz实现定时任务步骤，大致需要经过如下几步：创建任务（Job）、配置JobDetail、配置触发器（Trigger）、配置SchedulerFactoryBean

* ImportCsvQuartzJob 工程这个类可以用来举例
* 该例子使用到了链接上对应的第二种写法
* 更低耦合
* 1 com.hydlgs.hyems.job.ImportCsvQuartzJob
* 2 spring-quart.xml在这里配置
* 3 配置JobDetail、配置触发器（Trigger）、配置SchedulerFactoryBean
* 4 打个log看看是不是定时触发了



##　流程

* com.hydlgs.hyems.HyemsConstants 任务状态
* // 监控任务中是否有未执行的任务
* // 循环执行
* List<WrkJob> jobs 
* 难道所有的job,
* 遍历到如果有未开始的job
* 开线程干活(job放到map里面)
* 如果是做完了或者出错了(从map中移除)


## 举例 ImportRawMarketingCsvJob
* run 方法干活
* 继承自抽象类 ImportCsvJob

* 选择文件----id btnUpload ---uploader.start();----  url : '/hyems/file/upload',----对应的action----com.hydlgs.hyems.action.HyemsFileAction 的upload方法
---走js的插件的上传中,上传后----jobStart----请求成功后,等2S后开始执行---任务检测---jobDetected----如果有任务就把任务检测的定时关掉----然后看任务有没有执行完,没有就弹出继续执行的对话框----开启定时器,执行获取处理进度-----然后看状态---


### 走完了