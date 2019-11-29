#### 1、BeanPostProcessor
     提供的功能： Bean创建前后的操作
     a. 对应的代码演示： MyBeanPostProcess
     
#### 2、BeanFactoryPostProcessor
     提供的功能： 获取到Bean 的详细信息数据，并且允许修改Bean的信息
     a. 对应的代码演示： GetBeanDesc
      
#### 3、ApplicationContextAware
      提供的功能： 可以获取到ApplicationContext,获取到容器的相关信息，如Bean的信息。常用来作为Spring的工具类
      a.对应的代码演示： SpringUtil
      
#### 4、ApplicationContextInitializer
      提供的功能： ApplicationContext容器加载的时候，一起初始化
           Spring的扩展应用包
      a. 对应的代码演示： MyApplicationContextInitializer
#### 5、ApplicationListener和ApplicationEvent
      提供的功能： 基于Application的事件任务监听，如邮件的发送
      a. 对应的代码演示：  MyApplicationListener和NotifyEvent
#### 6、FactoryBean

#### 7、CommandLineRunner(ApplicationRunner)
    提供的功能： Spring容器执行完毕最后一步的方法回调
          有别于ApplicationContextInitializer，容器初始化之前；
          而CommandRunner，是容器初始化完毕后。
    a. 对应的代码演示： MyCommandLineRunner 

#### 8、InitialingBean和DisposableBean
    提供的功能： 
        InitialingBean: Bean属性设置后的操作
        DisposableBean: Bean销毁的时候触发的操作
         
    
   
_**参考资料：**_
  1、SpringBoot的扩展接口
 https://blog.csdn.net/zhaocuit/article/details/83784079
