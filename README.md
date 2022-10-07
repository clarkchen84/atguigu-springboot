#### 微服务架构
1. 微服务是一种服务架构
2. 一个应用拆分为一组小型服务
3. 每个服务运行在自己的进程里，也可以进行杜立德部署和升级
4. 服务之间使用轻量级http 交互
5. 可以由全自动部署机制独立部署
6. 去中心化，服务自制，服务可以使用不同的语言，不同的存储技术

#### 分布式的困难
1. 远程调用
2. 服务发现
3. 负载均衡
4. 服务容错： 
5. 配置管理
6. 服务监控
7. 链路追踪
8. 日志管理
9. 任务调度
#### 上云的困难
1. 服务自愈
2. 弹性伸缩
3. 服务隔离
4. 自动化部署
5. 灰度发布
6. 流量治理
#### 容器组件
1. @Configuration
    * full 模式与little 模式
      1. 配置类组件之间没有依赖关系，用little模式加速容器的启动过程，减少判断
      2. 配置累组件之间由依赖关系，方法会被调用得到之前实例组件，使用full模式
2. 配置绑定
   1. @ConfigurationProperties
      1. 方式1：需要将@ConifgurationProperties 标记的类同时标间@Componnet注解， 因为只有对象在Spring容器中才能生效。
      2. 方式2：
         1. 在配置类（标记@Confi guration）上追加@EnableConfigurationProperties ，并追加 @ConfigurationProperties
            1. 开启对象的属性配置
            2. 将组件对象 注入动容器中
#### 自动配置原理
1. @SpringBootConfiguration 代表当前类是一个配置类
2. @ComponentScan 指定扫描哪些 package
3. @EnableAutoConfiguration
   1. @AutoConfigurationPackage
      1. @Import(AutoConfigurationPackages.Registrar.class)
   2. @Import(AutoConfigurationImportSelector.class)
#### 按需开启自动配置项
1. spring.factories 中EnableAutoConfiguration对应的所有类都会加载， 但是最终会按照条件装配规则按需配置，加载到spring容器中
#### 原理总结
1. SpringBoot 先加载所有的自动配置类
2. 每个自动配置类按照条件进行生效，默认都会绑定配置文件指定的值。值从XXXXProperties中获取，XXXXProperties中的属性和配置文件进行了绑定
3. 生效的配置类会会给容器中装配很多组件
4. 只要容器中有这些组件，这些功能就有了
5. 只要用户有自己配置的组件，就以用户的优先
   1. 用户自己使用@Bean替换底层的组件 
   2. 用户去看这个组件获取的配置文件什么值，并进行修改 
#### 最佳实践
1. 引入场景依赖
2. 查看自动配置了哪些
   1. 在application.properties 中设置 debug=true 可以查看容器中加载了哪些类，哪些类没有加载
3. 是否需要修改
   1. 参考文档修改配置项
   2. 自定义加入或者修改配置项
#### 如何让自写的yml有提示
1. 追加maven依赖
   ``` xml
      <dependency>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-configuration-processor</artifactId>
         <optional>true</optional>
      </dependency>
   ```
### Spring boot web
#### 静态资源访问
1. 静态资源目录
   * /static(or /public or /resources or /META-INF/resources)
2. 访问
   * 项目根目录/静态资源名
3. 当动态资源与静态资源有相同路径的情况下，先访问静态资源， 在访问动态资源。原理
   * 静态资源映射/** 拦截所有的请求 ，动态资源映射 /**， 请求进来，先找Controller ，看是否能处理， 如果不能处理的所有请求都交给静态资源处理器。
4. 静态资源访问前缀
   1. 默认是没有前缀的
   2. 可以通过下面的方式进行配置
      ``` properties
      spring.mvc.static-path-pattern=/res/** # url 映射
      spring.resources.static-location=classpath:/haha # 物理路径
      ```
   