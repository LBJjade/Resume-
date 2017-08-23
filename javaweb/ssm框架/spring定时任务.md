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



