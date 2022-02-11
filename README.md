- [一、微服务架构编码构建](#一微服务架构编码构建)
  - [1.1、IDEA新建project工作空间](#11idea新建project工作空间)
    - [1.1.2、导入pom](#112导入pom)
  - [1.2、Rest微服务工程构建](#12rest微服务工程构建)
    - [1.2.1、新建provider-payment8001子项目](#121新建provider-payment8001子项目)
    - [1.2.2、修改子项目的pom](#122修改子项目的pom)
    - [1.2.3、写yml配置](#123写yml配置)
    - [1.2.4、主启动类](#124主启动类)
    - [1.2.6、创建实体类](#126创建实体类)
    - [1.2.7、创建DAO](#127创建dao)
    - [1.2.8、创建mapper](#128创建mapper)
    - [1.2.9、接口PaymentService](#129接口paymentservice)
    - [1.2.10、编写controller](#1210编写controller)
    - [1.2.11、运行测试](#1211运行测试)
  - [1.3、DevTools热部署](#13devtools热部署)
    - [1.3.1、添加依赖](#131添加依赖)
    - [1.3.2、在父类pom里添加build](#132在父类pom里添加build)
    - [1.3.3、开启自动构建](#133开启自动构建)
    - [1.3.4、重启IDEA](#134重启idea)
  - [1.4、创建consumer-order80项目](#14创建consumer-order80项目)
    - [1.4.1、创建项目](#141创建项目)
    - [1.4.2、改pom](#142改pom)
    - [1.4.3、写yml](#143写yml)
    - [1.4.4、主方法](#144主方法)
    - [1.4.5、创建实体类](#145创建实体类)
    - [1.4.6 、创建ApplicationContextConfig](#146-创建applicationcontextconfig)
    - [1.4.7、写OrderController](#147写ordercontroller)
    - [1.4.8、启动测试](#148启动测试)
  - [1.5、工程重构](#15工程重构)
    - [1.5.1、新建api-commons项目](#151新建api-commons项目)
    - [1.5.2、改pom](#152改pom)
    - [1.5.3、提取冗余代码](#153提取冗余代码)
    - [1.5.4、上传本地库](#154上传本地库)
    - [1.5.5、修改其余项目](#155修改其余项目)
- [二、Eureka服务注册与发现](#二eureka服务注册与发现)
  - [2.1、Eureka基础知识](#21eureka基础知识)
    - [2.1.1、什么是服务治理](#211什么是服务治理)
    - [2.1.2、什么是服务注册](#212什么是服务注册)
    - [2.1.3、Eureka两个组件](#213eureka两个组件)
  - [2.2、单机Eureka构建步骤](#22单机eureka构建步骤)
    - [2.1.1 生成EurekaServer端服务注册中心](#211-生成eurekaserver端服务注册中心)
      - [2.1.1.1 创建eureka-server7001模块](#2111-创建eureka-server7001模块)
      - [2.1.1.2 改POM](#2112-改pom)
      - [2.1.1.3 写yml](#2113-写yml)
      - [2.1.1.4 启动类](#2114-启动类)
      - [2.1.1.5 启动测试](#2115-启动测试)
    - [2.1.2 注册provider-payment8001](#212-注册provider-payment8001)
      - [2.1.2.1 改POM](#2121-改pom)
      - [2.1.2.2 写yml](#2122-写yml)
      - [2.1.2.3 改主启动类](#2123-改主启动类)
      - [2.1.2.4 启动测试](#2124-启动测试)
    - [2.1.3 注册consumer-order](#213-注册consumer-order)
      - [2.1.3.1 改POM](#2131-改pom)
      - [2.1.3.2 写yml](#2132-写yml)
      - [2.1.3.3 改主启动类](#2133-改主启动类)
      - [2.1.3.4 启动测试](#2134-启动测试)
  - [2.3、集群Eureka构建步骤](#23集群eureka构建步骤)
    - [2.3.1 Eureka集群原理说明](#231-eureka集群原理说明)
    - [2.3.2 Eureka Server集群环境构建步骤](#232-eureka-server集群环境构建步骤)
      - [2.3.2.1 新建eureka-server7002模块](#2321-新建eureka-server7002模块)
      - [2.3.2.2 修改本机host文件](#2322-修改本机host文件)
      - [2.3.2.3 相互注册Eureka Server](#2323-相互注册eureka-server)
      - [2.3.2.4 启动测试](#2324-启动测试)
    - [2.3.3 将服务提供者与消费者发布到euerka集群中](#233-将服务提供者与消费者发布到euerka集群中)
      - [2.3.3.1 修改服务提供者8001与消费者80的yml文件](#2331-修改服务提供者8001与消费者80的yml文件)
      - [2.3.3.2 启动测试](#2332-启动测试)
    - [2.3.4 服务提供者集群环境构建](#234-服务提供者集群环境构建)
      - [2.3.4.1 新建provider-payment8002模块](#2341-新建provider-payment8002模块)
      - [2.3.4.2 启动测试](#2342-启动测试)
    - [2.3.5 负载均衡](#235-负载均衡)
      - [2.3.5.1 修改服务消费者80的controller](#2351-修改服务消费者80的controller)
      - [2.3.5.2 添加@LoadBalanced注解](#2352-添加loadbalanced注解)
      - [2.3.5.3 运行测试](#2353-运行测试)
  - [2.4、actuator微服务信息完善](#24actuator微服务信息完善)
    - [2.4.1 主机名称的修改](#241-主机名称的修改)
    - [2.4.2 访问路径显示ip](#242-访问路径显示ip)
  - [2.5、服务发现Discovery](#25服务发现discovery)
    - [2.5.1 修改provider-payment8001的Controller](#251-修改provider-payment8001的controller)
  - [2.6、Eureka自我保护](#26eureka自我保护)
    - [2.6.1 故障现象](#261-故障现象)
    - [2.6.2 导致原因](#262-导致原因)
    - [2.6.3 怎么禁止自我保护（一般生产环境中不会禁止自我保护）](#263-怎么禁止自我保护一般生产环境中不会禁止自我保护)
      - [2.6.3.1 注册中心EurekaServer端7001](#2631-注册中心eurekaserver端7001)
      - [2.6.3.2 生产者eurekaClient端8001](#2632-生产者eurekaclient端8001)
- [三、Zookeeper服务注册与发现](#三zookeeper服务注册与发现)
  - [3.1 安装Zookepper](#31-安装zookepper)
  - [3.2 服务提供者](#32-服务提供者)
    - [3.2.1 创建provider-payment8004模块](#321-创建provider-payment8004模块)
    - [3.2.2 创建POM](#322-创建pom)
    - [3.2.3 创建yml](#323-创建yml)
    - [3.2.4 主启动类](#324-主启动类)
    - [3.2.5 写Controller](#325-写controller)
    - [3.2.6 启动zookeeper服务j](#326-启动zookeeper服务j)
    - [3.2.7 启动微服务测试](#327-启动微服务测试)
    - [3.2.8 Zookeeper是临时节点](#328-zookeeper是临时节点)
  - [3.3 服务消费者](#33-服务消费者)
    - [3.3.1 创建consumerzk-order80模块](#331-创建consumerzk-order80模块)
    - [3.3.2 写POM](#332-写pom)
    - [3.3.3 写yml](#333-写yml)
    - [3.3.4 主启动类](#334-主启动类)
    - [3.3.5 写ApplicationContextConfig](#335-写applicationcontextconfig)
    - [3.3.6 写OrderZKController](#336-写orderzkcontroller)
    - [3.3.7 启动测试](#337-启动测试)
- [四、Consul服务注册与发现](#四consul服务注册与发现)
  - [4.1 Consul简介](#41-consul简介)
    - [4.1.1 Consul是什么](#411-consul是什么)
    - [4.1.2 Consul能做什么](#412-consul能做什么)
  - [4.2 安装并运行Consul](#42-安装并运行consul)
  - [4.3 服务提供者](#43-服务提供者)
    - [4.3.1 创建providerconsul-payment8006模块](#431-创建providerconsul-payment8006模块)
    - [4.3.2 修改pom](#432-修改pom)
    - [4.3.3 写下xml](#433-写下xml)
    - [4.3.4 主启动类](#434-主启动类)
    - [4.3.5 编写PaymentController](#435-编写paymentcontroller)
    - [4.3.6 运行测试](#436-运行测试)
  - [4.4 服务消费者](#44-服务消费者)
    - [4.4.1 创建consumerconsul-order80模块](#441-创建consumerconsul-order80模块)
    - [4.4.2 写POM](#442-写pom)
    - [4.4.3 写xml](#443-写xml)
    - [4.4.4 主启动类](#444-主启动类)
    - [4.4.5 写ApplicationContextConfig配置类](#445-写applicationcontextconfig配置类)
    - [4.4.6 写Controller](#446-写controller)
    - [4.4.7 启动测试](#447-启动测试)
  - [4.5 三个注册中心异同点](#45-三个注册中心异同点)
- [五、Ribbon负载均衡服务调用](#五ribbon负载均衡服务调用)
  - [5.1 Ribbon概述](#51-ribbon概述)
    - [5.1.1 什么是Ribbon](#511-什么是ribbon)
    - [5.1.2 Ribbon能做什么](#512-ribbon能做什么)
  - [5.2 Ribbon负载较均衡演示](#52-ribbon负载较均衡演示)
    - [5.2.1 getForObject方法/getForEntity方法](#521-getforobject方法getforentity方法)
  - [5.3 Ribbon核心组件IRule](#53-ribbon核心组件irule)
    - [5.3.1 替换负载均衡方式](#531-替换负载均衡方式)
    - [5.3.2 Ribbon负载均衡算法](#532-ribbon负载均衡算法)
    - [5.3.4 自己写负载均衡算法](#534-自己写负载均衡算法)
      - [5.3.4.1 改造8001/8002微服务](#5341-改造80018002微服务)
      - [5.3.4.2 改造80订单微服务](#5342-改造80订单微服务)
- [六、OpenFeign服务接口调用](#六openfeign服务接口调用)
  - [6.1 OpenFeign概述](#61-openfeign概述)
    - [6.1.1 OpenFeign是什么](#611-openfeign是什么)
    - [6.1.2 OpenFeign能干什么](#612-openfeign能干什么)
    - [6.1.3 Feign和Open Feign两者区别](#613-feign和open-feign两者区别)
  - [6.2 OpenFeign使用步骤](#62-openfeign使用步骤)
    - [6.2.1 新建consumer-feign-order80模块](#621-新建consumer-feign-order80模块)
    - [6.2.2 写POM](#622-写pom)
    - [6.2.3 写yml](#623-写yml)
    - [6.2.4 主启动类](#624-主启动类)
    - [6.2.5 业务类](#625-业务类)
    - [6.2.6 启动测试](#626-启动测试)
  - [6.3 OpenFeign超时控制](#63-openfeign超时控制)
    - [6.3.1 超时设置](#631-超时设置)
    - [6.3.2 什么是OpenFeign超时控制](#632-什么是openfeign超时控制)
    - [6.3.3 修改Feign超时控制](#633-修改feign超时控制)
  - [6.4 OpenFeign日志打印功能](#64-openfeign日志打印功能)
    - [6.4.1 什么是日志打印功能](#641-什么是日志打印功能)
    - [6.4.2 日志级别](#642-日志级别)
    - [6.4.3 配置日志bean](#643-配置日志bean)
    - [6.4.4 配置yml](#644-配置yml)
- [七、Hystrix断路器](#七hystrix断路器)
  - [7.1 Hystrix概述](#71-hystrix概述)
    - [7.1.1 分布式系统面临的问题](#711-分布式系统面临的问题)
    - [7.1.2 Hystrix是什么](#712-hystrix是什么)
    - [7.1.3 Hystrix能做什么](#713-hystrix能做什么)
  - [7.2 Hystrix重要概念](#72-hystrix重要概念)
    - [7.2.1 服务降级 fallback](#721-服务降级-fallback)
      - [7.2.1.1 哪些情况会触发降级？](#7211-哪些情况会触发降级)
    - [7.2.2 服务熔断 break](#722-服务熔断-break)
    - [7.2.3 服务限流 flowlimit](#723-服务限流-flowlimit)
  - [7.3 Hystrix案例](#73-hystrix案例)
    - [7.3.1 构建](#731-构建)
      - [7.3.1.1 创建provider-hystrix-payment8001模块](#7311-创建provider-hystrix-payment8001模块)
      - [7.3.1.2 写POM](#7312-写pom)
      - [7.3.1.3 写yml](#7313-写yml)
      - [7.3.1.4 主启动类](#7314-主启动类)
      - [7.3.1.5 业务类](#7315-业务类)
      - [7.3.1.6 启动测试](#7316-启动测试)
    - [7.3.2 高并发测试](#732-高并发测试)
      - [7.3.2.1 Jmeter压力测试](#7321-jmeter压力测试)
      - [7.3.2.2 创建consumer-feign-hystrix-order80模块](#7322-创建consumer-feign-hystrix-order80模块)
    - [7.3.3 故障现象和导致原因](#733-故障现象和导致原因)
    - [7.3.4 如何解决](#734-如何解决)
    - [7.3.5 服务降级](#735-服务降级)
    - [7.3.6 服务熔断](#736-服务熔断)
      - [7.3.6.1 什么是熔断](#7361-什么是熔断)
      - [7.3.6.2 实际操作](#7362-实际操作)
      - [7.3.6.3 原理(总结)](#7363-原理总结)
    - [7.3.7 服务限流](#737-服务限流)
  - [7.4 Hystrix工作流程](#74-hystrix工作流程)
  - [11. 当Hystrix命令执行成功之后，它会将处理结果直接返回或是以Observable的形式返回。](#11-当hystrix命令执行成功之后它会将处理结果直接返回或是以observable的形式返回)
  - [7.5 HysstrixDashboard服务监控](#75-hysstrixdashboard服务监控)
    - [7.5.1 搭建HysstrixDashboard](#751-搭建hysstrixdashboard)
    - [7.5.2 使用HysstrixDashboard](#752-使用hysstrixdashboard)
- [八、Gateway新一代网关](#八gateway新一代网关)
  - [8.1 Gateway概述](#81-gateway概述)
    - [8.1.1 Gateway是什么](#811-gateway是什么)
    - [8.1.2 Gateway能做什么](#812-gateway能做什么)
    - [8.1.3 微服务架构中网关在哪里](#813-微服务架构中网关在哪里)
    - [8.1.4 为什么选择Gateway](#814-为什么选择gateway)
      - [8.1.4.1 Zuul1.x模型](#8141-zuul1x模型)
      - [8.1.4.3 Gateway模型](#8143-gateway模型)
  - [8.2 三大核心概述](#82-三大核心概述)
    - [8.2.1 Route(路由)](#821-route路由)
    - [8.2.2 Predicate(断言)](#822-predicate断言)
    - [8.2.3 Filter(过滤)](#823-filter过滤)
    - [8.2.4 总体](#824-总体)
  - [8.3 Gateway工作流程](#83-gateway工作流程)
  - [8.4 Gateway入门配置](#84-gateway入门配置)
    - [8.4.1 创建gatewat-gateway9527模块](#841-创建gatewat-gateway9527模块)
    - [8.4.2 写POM](#842-写pom)
    - [8.4.3 写yml](#843-写yml)
    - [8.4.4 主启动类](#844-主启动类)
    - [8.4.5 网关如何做路由映射？](#845-网关如何做路由映射)
    - [8.4.6 启动测试](#846-启动测试)
    - [8.4.7 Gateway网关路由有两种配置方式](#847-gateway网关路由有两种配置方式)
  - [8.5 通过微服务名实现动态路由](#85-通过微服务名实现动态路由)
  - [8.6 Predicate的使用](#86-predicate的使用)
    - [8.6.3 常见的Route Rredicate](#863-常见的route-rredicate)
  - [8.7 Filter的使用](#87-filter的使用)
    - [8.7.1 什么时Filter](#871-什么时filter)
    - [8.7.2 Spring Cloud Gateway的Filter](#872-spring-cloud-gateway的filter)
      - [8.7.2.1 生命周期](#8721-生命周期)
      - [8.7.2.2 种类](#8722-种类)
    - [8.7.3 自定义过滤器](#873-自定义过滤器)
- [九、SpringCloud Config分布式配置中心](#九springcloud-config分布式配置中心)
  - [9.1 SpringCloud Config概述](#91-springcloud-config概述)
    - [9.1.1 分布式系统面临的配置问题](#911-分布式系统面临的配置问题)
    - [9.1.2 SpringCloud Config是什么](#912-springcloud-config是什么)
    - [9.1.3 SpringCloud Config能做什么](#913-springcloud-config能做什么)
    - [9.1.4 与Github整合配置](#914-与github整合配置)
  - [9.2 Config服务端配置与测试](#92-config服务端配置与测试)
    - [9.2.1 新建cloud-config-center-3344模块](#921-新建cloud-config-center-3344模块)
    - [9.2.2 POM](#922-pom)
    - [9.2.3 xml](#923-xml)
    - [9.2.4 主启动类](#924-主启动类)
    - [9.2.5 启动3344](#925-启动3344)
    - [9.3.6 配置读取规则](#936-配置读取规则)
  - [9.3 Config客户端配置与测试](#93-config客户端配置与测试)
    - [9.3.1 新建cloud-config-client-3355模块](#931-新建cloud-config-client-3355模块)
    - [9.3.2 POM](#932-pom)
    - [9.3.3 bootstrap.yml](#933-bootstrapyml)
    - [9.3.4 主启动类](#934-主启动类)
    - [9.3.5 业务类](#935-业务类)
    - [9.3.6 启动测试](#936-启动测试)
    - [9.3.7 小问题](#937-小问题)
  - [9.4 Config客户端之动态刷新](#94-config客户端之动态刷新)
    - [9.4.1 动态刷新](#941-动态刷新)
- [十、SpringCloud Bus消息总线](#十springcloud-bus消息总线)
  - [10.1 SpringCloud Bus概述](#101-springcloud-bus概述)
    - [10.1.1 SpringCloud Bus是什么](#1011-springcloud-bus是什么)
    - [10.1.2 SpringCloud Bus能做什么](#1012-springcloud-bus能做什么)
    - [10.1.3 为何被称为总线](#1013-为何被称为总线)
  - [10.2 RabbitMQ环境配置](#102-rabbitmq环境配置)
  - [10.3 SpringCloud Bus动态刷新全局广播](#103-springcloud-bus动态刷新全局广播)
    - [10.3.1 创建3366模块](#1031-创建3366模块)
    - [10.3.2 设计思想](#1032-设计思想)
    - [10.3.3 config-center-3344配置中心服务端添加消息总线支持](#1033-config-center-3344配置中心服务端添加消息总线支持)
    - [10.3.4 config-center-3355客户端添加消息总线支持](#1034-config-center-3355客户端添加消息总线支持)
    - [10.3.5 config-center-3366客户端添加消息总线支持](#1035-config-center-3366客户端添加消息总线支持)
    - [10.3.6 测试](#1036-测试)
  - [10.4 SpringCloud Bus动态刷新定点通知](#104-springcloud-bus动态刷新定点通知)
- [十一、SpringCloud Stream消息驱动](#十一springcloud-stream消息驱动)
  - [11.1 消息驱动概述](#111-消息驱动概述)
    - [11.1.1 消息驱动是什么](#1111-消息驱动是什么)
    - [11.1.2 消息驱动设计思想](#1112-消息驱动设计思想)
      - [11.1.2.1 标准MQ](#11121-标准mq)
      - [11.1.2.2 为什么用Cloud Stream](#11122-为什么用cloud-stream)
      - [11.1.2.3 Stream中的消息通信方式遵循了发布-订阅模式](#11123-stream中的消息通信方式遵循了发布-订阅模式)
    - [11.1.3 Spring Cloud Stream标准流程套路](#1113-spring-cloud-stream标准流程套路)
    - [11.1.4 编码API和常用注解](#1114-编码api和常用注解)
  - [11.2 案例说明](#112-案例说明)
  - [11.3 消息驱动之生产者](#113-消息驱动之生产者)
  - [11.4 消息驱动之消费者](#114-消息驱动之消费者)
  - [11.5 分组消费与持久化](#115-分组消费与持久化)
    - [11.5.1 运行后两个问题](#1151-运行后两个问题)
    - [11.5.2 消费](#1152-消费)
    - [11.5.3 分组](#1153-分组)
      - [11.5.3.1 自定义配置分组](#11531-自定义配置分组)
      - [11.5.3.2 自定义配置分为同一组](#11532-自定义配置分为同一组)
    - [11.5.4 持久化](#1154-持久化)
- [十二、SpringCloud Sleuth分布式请求链路追踪](#十二springcloud-sleuth分布式请求链路追踪)
  - [12.1 Sleuth概述](#121-sleuth概述)
    - [12.1.1 为什么会有这个技术？需要解决哪些问题?](#1211-为什么会有这个技术需要解决哪些问题)
    - [12.1.2 Sleuth是什么](#1212-sleuth是什么)
  - [12.2 搭建链路监控](#122-搭建链路监控)
    - [12.2.1 zipkin](#1221-zipkin)
    - [测试效果](#测试效果)
- [十三、SpringCloud Alibaba入门简介](#十三springcloud-alibaba入门简介)
  - [13.1 SpringCloud Alibaba概述](#131-springcloud-alibaba概述)
    - [13.1.1 SpringCloud Alibaba是什么](#1311-springcloud-alibaba是什么)
    - [13.1.2 SpringCloud Alibaba能干什么](#1312-springcloud-alibaba能干什么)
    - [13.1.3 SpringCloud Alibaba怎么用](#1313-springcloud-alibaba怎么用)
- [十四、SpringCloud Alibaba Nacos服务注册中心和配置中心](#十四springcloud-alibaba-nacos服务注册中心和配置中心)
  - [14.1 Nacos简介](#141-nacos简介)
    - [14.1.1 Nacos是什么](#1411-nacos是什么)
    - [14.1.2 Nacos能干什么](#1412-nacos能干什么)
    - [14.1.3 Nacos怎么用](#1413-nacos怎么用)
    - [14.1.4 各种注册中心比较](#1414-各种注册中心比较)
  - [14.2 安装并运行Nacos](#142-安装并运行nacos)
  - [14.3 Nacos作为服务注册中心演示](#143-nacos作为服务注册中心演示)
    - [14.3.1 基于Nacos的服务提供者](#1431-基于nacos的服务提供者)
    - [14.3.2 基于Nacos的服务消费者](#1432-基于nacos的服务消费者)
    - [14.3.3 服务注册中心对比](#1433-服务注册中心对比)
  - [14.4 Nacos作为服务配置中心演示](#144-nacos作为服务配置中心演示)
    - [14.4.1 Nacos作为配置中心-基础配置](#1441-nacos作为配置中心-基础配置)
      - [Nacos中添加配置信息](#nacos中添加配置信息)
      - [运行测试](#运行测试)
    - [14.4.2 Nacos作为配置中心-分类配置](#1442-nacos作为配置中心-分类配置)
      - [Namespace+Group+Data ID三者关系？为什么这样设计?](#namespacegroupdata-id三者关系为什么这样设计)
    - [Case](#case)
      - [DataID方案](#dataid方案)
      - [Group方案](#group方案)
      - [Namespace方案](#namespace方案)
  - [14.5 Nacos集群和持久化配置](#145-nacos集群和持久化配置)
    - [14.5.1官网说明](#1451官网说明)
    - [14.5.2 Nacos持久化配置解释](#1452-nacos持久化配置解释)
      - [derby到mysql切换配置步骤](#derby到mysql切换配置步骤)
    - [14.5.3 Linux版Nacos+MySQL生产环境配置](#1453-linux版nacosmysql生产环境配置)
      - [集群配置步骤](#集群配置步骤)
      - [测试](#测试)
      - [小总结](#小总结)
- [十五、SpringCloud Alibaba Sentinel实现熔断与限流](#十五springcloud-alibaba-sentinel实现熔断与限流)
  - [15.1 Sentinel概述](#151-sentinel概述)
    - [15.1 Sentinel是什么](#151-sentinel是什么)
    - [15.2 Sentinel能做什么](#152-sentinel能做什么)
    - [15.3 下载](#153-下载)
    - [15.4 怎么用](#154-怎么用)
  - [15.2 安装Sentinel控制台](#152-安装sentinel控制台)
  - [15.3 初始化演示工程](#153-初始化演示工程)
  - [15.4 流控规则](#154-流控规则)
    - [15.4.1 基本介绍](#1541-基本介绍)
    - [15.4.2 流控模式](#1542-流控模式)
      - [直接(默认)](#直接默认)
      - [关联](#关联)
      - [链路](#链路)
    - [15.4.3 流控效果](#1543-流控效果)
  - [15.5 降级规则](#155-降级规则)
    - [降级规则说明](#降级规则说明)
    - [降级策略实战](#降级策略实战)
      - [RT](#rt)
      - [异常比例](#异常比例)
      - [异常数](#异常数)
  - [15.6 热点key限流](#156-热点key限流)
  - [15.7 系统规则](#157-系统规则)
  - [15.8 @SentinelResource](#158-sentinelresource)
    - [15.8.1 按资源名称限流+后续处理](#1581-按资源名称限流后续处理)
    - [15.8.2 按照url地址限流+后续处理](#1582-按照url地址限流后续处理)
    - [15.8.3 上面兜底方法面临的问题](#1583-上面兜底方法面临的问题)
    - [15.8.4 客户自定义限流处理逻辑](#1584-客户自定义限流处理逻辑)
    - [15.8.5 更多注解属性说明](#1585-更多注解属性说明)
  - [15.9 服务熔断功能](#159-服务熔断功能)
    - [Ribbon系列](#ribbon系列)
    - [Feign系列](#feign系列)
    - [熔断框架比较](#熔断框架比较)
  - [15.10 规则持久化](#1510-规则持久化)
- [十六、SpringCloud Alibaba Seata处理分布式事务](#十六springcloud-alibaba-seata处理分布式事务)
  - [16.1 分布式事务问题](#161-分布式事务问题)
  - [16.2 Seata简介](#162-seata简介)
    - [16.2.1 Seata是什么](#1621-seata是什么)
    - [16.2.2 Seata能干嘛](#1622-seata能干嘛)
    - [16.2.3 Seata怎么用](#1623-seata怎么用)
  - [16.3 Seata-Server安装](#163-seata-server安装)
  - [16.4 订单/库存/账户业务数据库准备](#164-订单库存账户业务数据库准备)
    - [创建业务数据库](#创建业务数据库)
  - [16.5 订单/库存/账户业务微服务准备](#165-订单库存账户业务微服务准备)
    - [新建订单Order-Module](#新建订单order-module)
    - [新建库存Storage-Module](#新建库存storage-module)
    - [新建账户Account-Module](#新建账户account-module)
  - [16.6 Test](#166-test)
    - [超时异常，没加@GlobalTransactional](#超时异常没加globaltransactional)
    - [超时异常，添加@GlobalTransactional](#超时异常添加globaltransactional)
  - [16.7 Seata之原理简介](#167-seata之原理简介)
    - [Seata](#seata)
    - [再看TC/TM/RM三大组件](#再看tctmrm三大组件)
    - [AT模式如何做到对业务的无侵入](#at模式如何做到对业务的无侵入)
      - [整体机制](#整体机制)
      - [一阶段加载](#一阶段加载)
      - [二阶段提交](#二阶段提交)
      - [二阶段回滚](#二阶段回滚)
    - [补充](#补充)

# 一、微服务架构编码构建
## 1.1、IDEA新建project工作空间
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125171837.png)

### 1.1.2、导入pom
```xml
  <!-- 统一管理jar包版本 -->  
 <properties>  
 <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>  
 <maven.compiler.source>1.8</maven.compiler.source>  
 <maven.compiler.target>1.8</maven.compiler.target>  
 <junit.version>4.12</junit.version>  
 <log4j.version>1.2.17</log4j.version>  
 <lombok.version>1.18.22</lombok.version>  
 <mysql.version>5.1.47</mysql.version>  
 <druid.version>1.2.5</druid.version>  
 <mybatis.spring.boot.version>1.3.2</mybatis.spring.boot.version>  
 </properties>  
  
 <!-- 子模块继承之后，提供作用：锁定版本+子modlue不用写groupId和version  -->  
 <dependencyManagement>  
 <dependencies>  
 <!--spring boot 2.2.2-->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-dependencies</artifactId>  
 <version>2.2.2.RELEASE</version>  
 <type>pom</type>  
 <scope>import</scope>  
 </dependency>  
 <!--spring cloud Hoxton.SR1-->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-dependencies</artifactId>  
 <version>Hoxton.SR1</version>  
 <type>pom</type>  
 <scope>import</scope>  
 </dependency>  
 <!--spring cloud alibaba 2.1.0.RELEASE-->  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-alibaba-dependencies</artifactId>  
 <version>2.1.0.RELEASE</version>  
 <type>pom</type>  
 <scope>import</scope>  
 </dependency>  
  
 <dependency>  
 <groupId>mysql</groupId>  
 <artifactId>mysql-connector-java</artifactId>  
 <version>${mysql.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>com.alibaba</groupId>  
 <artifactId>druid</artifactId>  
 <version>${druid.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>org.mybatis.spring.boot</groupId>  
 <artifactId>mybatis-spring-boot-starter</artifactId>  
 <version>${mybatis.spring.boot.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>junit</groupId>  
 <artifactId>junit</artifactId>  
 <version>${junit.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>log4j</groupId>  
 <artifactId>log4j</artifactId>  
 <version>${log4j.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <version>${lombok.version}</version>  
 <optional>true</optional>  
 </dependency>  
 </dependencies>  
 </dependencyManagement>  
  
 <build>  
 <plugins>  
 <plugin>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-maven-plugin</artifactId>  
 <configuration>  
 <fork>true</fork>  
 <addResources>true</addResources>  
 </configuration>  
 </plugin>  
 </plugins>  
 </build>  
  
</project>
```

> **dependencyManagement与dependencies区别？**
> 使用pom.xml中的dependencyManagement元素能让所有子项目中引用一个依赖，而不用显示的列出版本号
> Maven会沿着父子层次向上走，直到找到一个拥有dependencyManagement元素的项目，然后他就会使用这个dependencyManagement元素中指定的版本号
> 这样做的好处就是：如果有多个子项目都引用同一样依赖，则可以避免在每个使用的子项目里都声明一个版本号，这样当想升级或切换到另一个版本时，只需要在顶层父容器里更新，而不需要一个一个项目的修改；另外如果某个子项目需要另外的版本，只需要声明version就可。

## 1.2、Rest微服务工程构建
### 1.2.1、新建provider-payment8001子项目
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125180239.png)
### 1.2.2、修改子项目的pom
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-provider-payment8001</artifactId>  
  
 <properties>  
 <maven.compiler.source>8</maven.compiler.source>  
 <maven.compiler.target>8</maven.compiler.target>  
 </properties>  
  
 <dependencies>  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.mybatis.spring.boot</groupId>  
 <artifactId>mybatis-spring-boot-starter</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->  
 <dependency>  
 <groupId>com.alibaba</groupId>  
 <artifactId>druid-spring-boot-starter</artifactId>  
 <version>1.1.10</version>  
 </dependency>  
 <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->  
 <dependency>  
 <groupId>mysql</groupId>  
 <artifactId>mysql-connector-java</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jdbc -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-jdbc</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
  
 </dependencies>  
  
</project>
```
### 1.2.3、写yml配置
```yml
server:  
  port: 8001  
  
spring:  
  application:  
    name: cloud-payment-service  
  datasource:  
    type: com.alibaba.druid.pool.DruidDataSource # 当前数据源操作类型  
 driver-class-name: org.gjt.mm.mysql.Driver # mysql驱动  
 url: jdbc:mysql://localhost:9911/db2019?useUnicode=true&characterEncoding=utf-8&useSSL=false  
    username: root  
    password: password  
  
mybatis:  
  mapperLocations: classpath:mapper/*.xml  
  type-aliases-package: com.atguigu.springcloud.entities
```
### 1.2.4、主启动类
```java
public class PaymentMain8001 {  
 public static void main(String[] args) {  
 SpringApplication.run(PaymentMain8001.class,args);  
 }  
}```
### 1.2.5、创建数据库
```sql
create table payment
        (
            id     bigint auto_increment comment 'id',
            serial varchar(200) null,
            constraint payment_pk
                primary key (id)
        )
```
### 1.2.6、创建实体类
在该工程下entities包下创建两个实体类
第一个数据库对应的实体类
```java
@Data  
@AllArgsConstructor  
@NoArgsConstructor  
public class Payment implements Serializable {  
 private Long id;  
 private String serial;  
}
```
第二个CommonResult实体类
```java
@Data  
@AllArgsConstructor  
@NoArgsConstructor  
public class CommonResult <T>{  
  
 private Integer code;  
 private String message;  
 private T data;  
  
 public CommonResult(Integer code,String message){  
 this(code,message,null);  
 }  
}
```
### 1.2.7、创建DAO
```java
@Mapper  
public interface PaymentDao {  
 public int create(Payment payment);  
  
 public Payment getPaymentById(@Param("id") Long id);  
}
```
### 1.2.8、创建mapper
创建PaymentMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>  
<!DOCTYPE mapper  
 PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">  
  
<mapper namespace="com.mrlqq.springcloud.dao.PaymentDao">  
  
 <insert id="create" parameterType="Payment" useGeneratedKeys="true" keyProperty="id">  
 insert into payment(serial) values (#{serial})  
 </insert>  
  
 <resultMap id="BaseResultMap" type="com.mrlqq.springcloud.entities.Payment">  
 <id column="id" property="id" jdbcType="BIGINT"/>  
 <id column="serial" property="serial" jdbcType="VARCHAR"/>  
 </resultMap>  
 <select id="getPaymentById" resultMap="BaseResultMap" parameterType="Long">  
 select * from payment where id=#{id};  
  
 </select>  
</mapper>
```
### 1.2.9、接口PaymentService
PaymentService接口
```java
public interface PaymentService {  
  
 public int create(Payment payment);  
  
 public Payment getPaymentById(@Param("id") Long id);  
}
```
PaymentServiceImpl实现类
```java
@Service  
public class PaymentServiceImpl implements PaymentService {  
  
 @Resource  
 private PaymentDao paymentDao;  
  
 @Override  
 public int create(Payment payment) {  
 return paymentDao.create(payment);  
 }  
  
 @Override  
 public Payment getPaymentById(@Param("id") Long id) {  
 return paymentDao.getPaymentById(id);  
 }  
}
```
### 1.2.10、编写controller
```java
@RestController  
@Slf4j  
public class PaymentController {  
  
 @Resource  
 private PaymentService paymentService;  
  
 @PostMapping("/payment/create")  
 public CommonResult create(@RequestBody Payment payment){  
  
 int result = paymentService.create(payment);  
 log.info("*****插入结果：" + result);  
  
 if (result > 0){  
 return new CommonResult(200,"插入数据库成功",result);  
 }else {  
 return new CommonResult(444,"插入数据库失败",null);  
 }  
 }  
 @GetMapping("/payment/get/{id}")  
 public CommonResult getPaymentById(@PathVariable("id") Long id){  
  
 Payment payment = paymentService.getPaymentById(id);  
 log.info("*****查询结果：" + payment);  
  
 if (payment != null){  
 return new CommonResult(200,"查询成功",payment);  
 }else {  
 return new CommonResult(444,"没有对应记录，查询id：" + id,null);  
 }  
 }}
```
### 1.2.11、运行测试

![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125214159.png)

![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125214121.png)

## 1.3、DevTools热部署
### 1.3.1、添加依赖
```xml
<dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
</dependency>
```
### 1.3.2、在父类pom里添加build
```xml
<build>  
 <plugins>  
 <plugin>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-maven-plugin</artifactId>  
 <configuration>  
 <fork>true</fork>  
 <addResources>true</addResources>  
 </configuration>  
 </plugin>  
 </plugins>  
</build>
```
### 1.3.3、开启自动构建
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125215040.png)
### 1.3.4、重启IDEA

## 1.4、创建consumer-order80项目
### 1.4.1、创建项目
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125220228.png)
### 1.4.2、改pom
```xml
<dependencies>  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web  -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
</dependencies>
```
### 1.4.3、写yml
```yml
server:  
  port: 80
```
### 1.4.4、主方法
```java
@SpringBootApplication  
public class OrderMain80 {  
 public static void main(String[] args) {  
 SpringApplication.run(OrderMain80.class,args);  
 }  
}
```
### 1.4.5、创建实体类
创建CommonResult和Payment实体类，可以将provider-payment8001项目中的实体类复制过来
### 1.4.6 、创建ApplicationContextConfig
将RestTemplate注入到容器
```java
@Configuration  
public class ApplicationContextConfig {  
 @Bean  
 public RestTemplate getRestTemplate(){  
 return new RestTemplate();  
 }  
}

```
### 1.4.7、写OrderController
 ```java
@RestController  
@Slf4j  
public class OrderController {  
  
 public static final String PAYMENT_URL = "http://loacalhost:8001";  
  
 @Resource  
 private RestTemplate restTemplate;  
  
 @GetMapping("/consumer/payment/create")  
 public CommonResult<Payment> create(Payment payment){  
 return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);  
 }  
  
 @GetMapping("/consumer/payment/get/{id}")  
 public CommonResult<Payment> getPayment(@PathVariable("id") Long id){  
 return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);  
 }  
}
 ```
### 1.4.8、启动测试
同时启动 8001提供者 和 80消费者
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125222347.png)
访问上文中服务提供者的`localhost:8001/payment/get/1`可以得到数据，访问服务消费者的`localhost/consumer/payment/get/1`同样也可以得到数据
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125223002.png)

>不要忘记咋8001的controller中，create方法参数上加上`@RequestBody`注解

如果忘记添加了那么消费者在访问`localhost/consumer/payment/create?serial=111`的时候，即使页面返回错误信息，显示"插入成功"，数据库中也仍然不会插入数据，数据显示`NULL`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125223818.png)
添加了注解后
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125223905.png)

## 1.5、工程重构
观察项目，发现系统中有重复部分，服务提供者8001和服务消费者80都使用`entities`，所以要进行重构，避免代码冗余
### 1.5.1、新建api-commons项目
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125225017.png)
### 1.5.2、改pom
```xml
<dependencies>  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/cn.hutool/hutool-all -->  
 <dependency>  
 <groupId>cn.hutool</groupId>  
 <artifactId>hutool-all</artifactId>  
 <version>5.1.0</version>  
 </dependency>  
</dependencies>
```
### 1.5.3、提取冗余代码
提取公共的`entites`代码到`api-commons`项目下
### 1.5.4、上传本地库
选择IDEA的`Maven`工具，点击`刷新`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125230525.png)
选择`api-commons`项目`Lifecycle`--`clean`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125230623.png)
选择`install`，安装到本地仓库，以供其他子项目使用
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220125230658.png)
### 1.5.5、修改其余项目
分别删除8001和80项目中的`entites`，然后修改pom文件，引入`api-commons`依赖的坐标
```xml
<!-- 引入自己自定义的api通用包，可以使用Payment支付Entity -->  
<dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
</dependency>
```

# 二、Eureka服务注册与发现
## 2.1、Eureka基础知识
### 2.1.1、什么是服务治理
> Spring Cloud 封装了Netflix公司开发的Eureka模块来==实现服务治理==

在传统的rpc远程调用框架中，管理每个服务于服务之间依赖关系比较复杂，管理比较复杂，所以需要使用服务治理，管理服务与服务之间依赖关系，可以实现服务调用、负载均衡、容错等，实现服务发现与注册。
### 2.1.2、什么是服务注册
>什么是服务注册与发现

Eureka采用了CS的设计架构，Eureka Server 作为服务注册功能的服务器，他是服务注册中心。而系统中的其他微服务，使用Eureka的客户端连接到Eureka Server并位置心跳连接。这样系统的维护人员就可以通过Eureka Server来监控系统中各个微服务是否正常运行。
在服务注册与发现中，有一个注册中心。当服务器启动的时候，会把当前自己服务器的信息，比如服务地址通讯地址等以别名方式注册到注册中心上。另一方（消费者|服务提供者），以该别名的方式去注册中心上获取到实际的服务通讯地址，然后再实现本地RPC调用，RPC远程调用框架核心设计思想：在于注册中心，因为使用注册中心管理每个服务与服务之间的一个依赖关系（服务治理概念）。在任何RPC远程框架中，都会有一个注册中心（存放服务地址相关信息（接口地址））
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126145319.png)
### 2.1.3、Eureka两个组件
**Eureka包括两个组件：Eureka Server和Eureka Client**
Eureka Server提供服务注册服务：
各个微服务节点通过配置启动后，会在Eureka Server中进行注册，这样EurekaServer中的服务注册表中会将存储所有可用的服务节点的信息，服务节点的信息可以在界面中直观看到。
Eureka Client通过注册中心进行访问:
是一个Java客户端，用于简化Eureka Server的交互，客户端同时也具备一个内置的、使用轮询（round-robin）负载算法的负载均衡器。在应用启动后，将会向Eureka Server发送心跳（默认周期为30秒）。如果Eureka Server在多个心跳周期内没有接收到某个节点的心跳，Eureka Server将会从服务注册表总把这个服务节点移除（默认90秒）
## 2.2、单机Eureka构建步骤
### 2.1.1 生成EurekaServer端服务注册中心
#### 2.1.1.1 创建eureka-server7001模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126150556.png)
#### 2.1.1.2 改POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-eureka-server7001</artifactId>  
  
 <dependencies>  
 <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-eureka-server -->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>1.0-SNAPSHOT</version>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web  -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 <dependency>  
 <groupId>junit</groupId>  
 <artifactId>junit</artifactId>  
 </dependency>  
  
 </dependencies>  
</project>
```
#### 2.1.1.3 写yml
```xml
server:  
  port: 7001  
  
eureka:  
  instance:  
    hostname: localhost  #eureka服务端的实例名字  
 client:  
    register-with-eureka: false #表示不向注册中心注册自己  
 fetch-registry: false #表示自己就是注册中心，职责是维护服务实例，并不需要去检索服务  
 service-url:  
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/    #设置与eureka server交互的地址查询服务和注册服务都需要依赖这个地址
```
#### 2.1.1.4 启动类
```java
@SpringBootApplication 
@EnableEurekaServer
public class EurekaMain7001 {  
 public static void main(String[] args) {  
 SpringApplication.run(EurekaMain7001.class,args);  
 }  
}
```
#### 2.1.1.5 启动测试
启动7001访问`localhost:7001`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126152054.png)
EurekaServer配置成功！
### 2.1.2 注册provider-payment8001
#### 2.1.2.1 改POM
添加Eureka依赖
```xml
 <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-eureka-server -->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>  
 </dependency>  
```
#### 2.1.2.2 写yml
新增eureka配置
```yml
eureka:
  client:
    register-with-eureka: true
    fetchRegistry: true
    service-url:
      defaultZone: http://localhost:7001/eureka

```
#### 2.1.2.3 改主启动类
添加`@EnableEurekaClient`注解
```java
@SpringBootApplication  
@EnableEurekaClient  
public class PaymentMain8001 {  
 public static void main(String[] args) {  
 SpringApplication.run(PaymentMain8001.class,args);  
 }  
}
```
#### 2.1.2.4 启动测试
先启动Eureka Server7001，在启动8001，然后访问`localhost:7001`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126153253.png)
注册成功
### 2.1.3 注册consumer-order
#### 2.1.3.1 改POM
添加Eureka依赖
```xml
 <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-eureka-server -->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>  
 </dependency>  
```
#### 2.1.3.2 写yml
新增eureka配置
```yml 
spring:  
  application:  
    name: cloud-order-service  
      
eureka:  
  client:  
    fetch-registry: true  
 register-with-eureka: true  
 service-url:  
      defaultZone: http://localhost:7001/eureka

```
#### 2.1.3.3 改主启动类
添加`@EnableEurekaClient`注解
```java
@SpringBootApplication  
@EnableEurekaClient  
public class OrderMain80 {  
 public static void main(String[] args) {  
 SpringApplication.run(OrderMain80.class,args);  
 }  
}
```
#### 2.1.3.4 启动测试
先启动Eureka Server7001，在启动80，然后访问`localhost:7001`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126153824.png)
两个都成功注册！
## 2.3、集群Eureka构建步骤
### 2.3.1 Eureka集群原理说明
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126154710.png)
### 2.3.2 Eureka Server集群环境构建步骤
#### 2.3.2.1 新建eureka-server7002模块
参考eureka-server7001进行创建
#### 2.3.2.2 修改本机host文件
windows修改`C:\Windows\System32\drivers\etc\host`文件，向其添加
```bash
127.0.0.1 eureka7001.com
127.0.0.1 eureka7002.com
```
#### 2.3.2.3 相互注册Eureka Server
修改7001的yml文件
```yml
server:  
  port: 7001  
  
eureka:  
  instance:  
    hostname: eureka7001.com  #eureka服务端的实例名字  
 client:  
    register-with-eureka: false #表示不向注册中心注册自己  
 fetch-registry: false #表示自己就是注册中心，职责是维护服务实例，并不需要去检索服务  
 service-url:  
      defaultZone: http://eureka7002.com:7002/eureka/
```
修改7002的yml文件
```yml
server:  
  port: 7002  
  
eureka:  
  instance:  
    hostname: eureka7002.com  #eureka服务端的实例名字  
 client:  
    register-with-eureka: false #表示不向注册中心注册自己  
 fetch-registry: false #表示自己就是注册中心，职责是维护服务实例，并不需要去检索服务  
 service-url:  
      defaultZone: http://eureka7001.com:7001/eureka/
```
#### 2.3.2.4 启动测试
分别启动7001，7002
分别访问`eureka7001.com:7001`和`eureka7002.com:7002`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126161446.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126161502.png)
两个eureka server互相注册成功！
### 2.3.3 将服务提供者与消费者发布到euerka集群中
#### 2.3.3.1 修改服务提供者8001与消费者80的yml文件
修改eureka 发布地址为两个eureka server的地址
```yml
service-url:
  defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka  #集群版
```
#### 2.3.3.2 启动测试
先启动eureka集群7001，7002，再启动服务提供者8001，然后启动消费者80
分别访问eureka server
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126162820.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126162846.png)
服务注册成功！！
### 2.3.4 服务提供者集群环境构建
#### 2.3.4.1 新建provider-payment8002模块
参考provider-payment8001创建provider-payment8002模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126163229.png)
复制8001的代码，进行微调，修改8002模块的端口为`8002`
#### 2.3.4.2 启动测试
依次启动 7001、7002、8001、8002、80
访问eureka server
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126165147.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126165203.png)
服务提供者成功发布到eureka集群！
### 2.3.5 负载均衡
当我们访问服务消费者80获取数据的时候，会发现返回的结果都是从8001端口发出的，是因为我们消费者将服务请求地址写为固定了，所以无法实现负载均衡的效果。
#### 2.3.5.1 修改服务消费者80的controller
修改OrderController，把`PAYMENT_URL`改成`http://CLOUD-PAYMENT-SERVICE`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126165908.png)
由于原来的`PAYMENT_URL`是固定的，将导致消费者之只能访问8001，所以需要把地址服务地址修改为eureka提供的微服务地址。
#### 2.3.5.2 添加@LoadBalanced注解
再服务消费者80的`ApplicationContextConfig`中，在`RestTemplate`上添加`@LoadBalanced`注解
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126170451.png)
>使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
#### 2.3.5.3 运行测试
当我们再次通过`http://localhost/consumer/payment/get/{id}`访问服务的时候，则会发现Eureka会帮我们自动的分配服务，可能是8001，也可能是8002
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126170934.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126170952.png)
## 2.4、actuator微服务信息完善
eureka管理页面的微服务没有ip提示，不便于后期的错误查找
### 2.4.1 主机名称的修改
**分别修改provider-payment8001和8002的yml**
向其中新增
```yml
eureka:
  instance:  
    instance-id: payment8001
```
### 2.4.2 访问路径显示ip
**分别修改provider-payment8001和8002的yml**
向其中新增
```
eureka:
  instance:
    prefer-ip-address: true
```
## 2.5、服务发现Discovery
>对于注册进Eureka里面的微服务，可以通过服务发现来获得该服务的信息

### 2.5.1 修改provider-payment8001的Controller
修改PaymentController，添加如下内容
```java
@Resource  
private DiscoveryClient discoveryClient;

@GetMapping("/payment/discovery")  
public Object discovery(){  
 List<String> services = discoveryClient.getServices();  
 for (String element : services) {  
 log.info("*****element:" + element);  
 }  
  
 List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");  
 for (ServiceInstance instance : instances) {  
 log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getUri());  
 }  
  
 return this.discoveryClient;  
}
```
在主启动类添加`@EnableDiscoveryClient`注解
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126185706.png)
访问`http://localhost:8001/payment/discovery`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126185337.png)
查看控制台输出日志
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126185427.png)
可以显示或输出eureka中的微服务信息
## 2.6、Eureka自我保护
### 2.6.1 故障现象
保护模式主要用于一组客户端和Eureka Server之间存在网络分布场景下的保护。一旦进入保护模式，==Eureka Server将会尝试保护其服务注册表中的信息，不再删除服务注册表中的数据，也就是不会注销任何微服务。==
如果Eureka Server的首页看到以下这段提示，则说明Eureka进入了保护模式：
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126195744.png)
### 2.6.2 导致原因
>某时刻某一个微服务不可用了，Eureka不会立刻清理，依旧会对该微服务的消息进行保存

**为什么会产生Eureka自我保护机制？**
为了防止EurekaClient可以正常运行，但是与EurekaServer网络不通情况下，EurekaServer==不会立刻==将EurekaClient服务剔除

**什么是自我保护模式？**
默认情况下，如果EurekaServer在一定时间内没有接收到某个微服务实例的心跳，EurekaServer将会注销该实例（默认90秒）。但服务本身其实是健康的，==此时本不应该注销这个微服务==，Eureka通过“自我保护模式”来解决这个问题——当EurekaServer节点再短时间内丢失过多客户端时（可能发生了网络分区故障），那么这个节点就会进入自我保护模式。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126200709.png)
==在自我保护模式中，EurekaServer会保护服务注册表中的信息，不在注销任何服务实例。==
他的设计哲学就是宁可保留错误的服务注册信息，也不盲目注销任何可能健康的服务实例。
综上，自我保护模式是一种对应网络异常的安全保护措施。他的自我保护模式，可以让Eureka集群更加健壮、稳定。
### 2.6.3 怎么禁止自我保护（一般生产环境中不会禁止自我保护）
#### 2.6.3.1 注册中心EurekaServer端7001
自我保护机制时默认开启的`eureka.server.enable-self-preservation = true`
修改yml，添加如下配置
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126201604.png)
关闭效果
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126201707.png)
#### 2.6.3.2 生产者eurekaClient端8001
eurekaClient默认设置的是
`eureka.instance.lease-renewal-interval-in-seconds=30`
`eureka.instance.lease-expiration-duration-in-seconds=90`
修改8001的xml,添加如下内容
```xml
#eureka客户端向服务端发心跳的时间间隔，单位为秒（默认是30秒）  
eureka.instance.lease-renewal-interval-in-seconds: 1  

#eureka服务端在收到最后一次心跳后等待时间上限，单位为秒（默认是90秒），超时将剔除服务  
eureka.instance.lease-expiration-duration-in-seconds: 2
```
**启动测试**：
7001和8001都配置完成后依次启动
当关闭8001时，7001将会立刻删除8001的服务信息。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220126202531.png)

# 三、Zookeeper服务注册与发现
>**SpringCloud整合Zookeeper代替Eureka**

## 3.1 安装Zookepper
在centos安装Zookepper
## 3.2 服务提供者
### 3.2.1 创建provider-payment8004模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130111533.png)
### 3.2.2 创建POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-provider-payment8004</artifactId>  
  
 <dependencies>  
  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-zookeeper-discovery -->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
  
  
 </dependencies>  
  
</project>
```
### 3.2.3 创建yml
```yml
server:  
  port: 8004  
  
spring:  
  application:  
    name: cloud-provider-payment  
  cloud:  
    zookeeper:  
      connect-string: 192.168.136.140:2181
```
### 3.2.4 主启动类
```java
@SpringBootApplication  
@EnableDiscoveryClient // 该注解用于向使用consule或者zookeeper作为注册中心是注册服务  
public class PaymentMain8004 {  
 public static void main(String[] args) {  
 SpringApplication.run(PaymentMain8004.class,args);  
 }  
}
```
### 3.2.5 写Controller
创建PaymentController
```java
@RestController  
@Slf4j  
public class PaymentController {  
  
 @Value("${server.port}")  
 private String serverPort;  
  
 @GetMapping(value = "/payment/zk")  
 public String paymentzk(){  
 return "springcloud with zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();  
 }  
  
}
```
### 3.2.6 启动zookeeper服务j
进入`zookeeper`的`bin`目录下，运行
`./zkCli.sh`等待启动成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130113015.png)
### 3.2.7 启动微服务测试
启动发现jar包冲突，服务器zookeeper为3.4.9，而引入的依赖是3.5.9
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130113455.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130113823.png)

需要进行依赖排除
```xml
 <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-zookeeper-discovery -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
            <!--排除zk3.5.3-->
            <exclusions>
                <exclusion>
                    <groupId>org.apache.zookeeper</groupId>
                    <artifactId>zookeeper</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
            <!--添加zk 3.4,9版本-->
        <!-- https://mvnrepository.com/artifact/org.apache.zookeeper/zookeeper -->
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.9</version>
        </dependency>

```
再次启动后，无报错，在服务器上查看zookeeper
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130125527.png)

访问`http://localhost:8004/payment/zk`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130125639.png)
查看zookeeper注册信息
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130125922.png)
json格式化后的信息
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130130214.png)
### 3.2.8 Zookeeper是临时节点
当服务失效后，超过了Zookeeper的心跳时间，会删除失效节点
## 3.3 服务消费者
### 3.3.1 创建consumerzk-order80模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130131401.png)
### 3.3.2 写POM
```xml

    <dependencies>

        <dependency>
            <groupId>com.mrlqq.springcloud</groupId>
            <artifactId>cloud-api-commons</artifactId>
            <version>${project.version}</version>
        </dependency>


        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-zookeeper-discovery -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zookeeper-discovery</artifactId>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>


    </dependencies>

```
### 3.3.3 写yml
```yml
server:  
  port: 80  
  
spring:  
  application:  
    name: cloud-consumer-order  
  cloud:  
    zookeeper:  
      connect-string: 8.136.9.12:2181
```
### 3.3.4 主启动类
```java
@SpringBootApplication  
@EnableDiscoveryClient  
public class OrderZKMaini80 {  
 public static void main(String[] args) {  
 SpringApplication.run(OrderZKMaini80.class,args);  
 }  
}
```
### 3.3.5 写ApplicationContextConfig
```java
@Configuration  
public class ApplicationContextConfig {  
  
 @Bean  
 @LoadBalanced public RestTemplate getRestTemplate(){  
 return new RestTemplate();  
 }  
}
```
### 3.3.6 写OrderZKController
```java
@RestController  
public class OrderZKController {  
 public static final String INVOKE_URL = "http://clooud-proveder-payment";  
  
 @Resource  
 RestTemplate restTemplatel;  
  
 @GetMapping("/consumer/payment/zk")  
 public String paymentInfo(){  
 String result  = restTemplatel.getForObject(INVOKE_URL + "/payment/zk", String.class);  
 return result;  
 }  
}
```
### 3.3.7 启动测试
无报错，在服务端查看zookeeper节点
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130133726.png)
访问`localhost/consumer/payment/zk`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130133953.png)
同样可以注入

# 四、Consul服务注册与发现
## 4.1 Consul简介
### 4.1.1 Consul是什么
Consul是一套开源的分布式服务发现和配置管理系统，由HashiCorp公司用Go语言开发。
提供了微服务系统中的服务治理、配置中心、控制总线等功能。这些功能中吗的每一个都可以根据于需要单独使用，也可以一起使用以构建全方位的服务网络，总之Consul提供了一种完整的服务网格解决方案。
**它具有很多优点**：基于raft协议，比较简洁；支持健康检查，同时支持HTTP和DNS协议，支持跨数据中心的WAN集群，提供图形界面，跨平台，支持Linux、Mac、Windows
### 4.1.2 Consul能做什么
* 服务发现：提供HTTP和DNS两种发现方式
* 健康监测：支持多种协议，http、tcp、Docker、shell脚本定制化
* KV存储：key，Value的存储方式
* 多数据中心：Consul支持多数据中心
* 可视化Web界面
## 4.2 安装并运行Consul
官网下载Consul
[Downloads | Consul by HashiCorp](https://www.consul.io/downloads)
解压后双击exe运行
执行`consul agent -dev`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130234021.png)
访问`localhost:8500`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220130234049.png)
## 4.3 服务提供者
### 4.3.1 创建providerconsul-payment8006模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220131185301.png)
### 4.3.2 修改pom
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-providerconsul-payment8006</artifactId>  
  
 <dependencies>  
 <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-consul-discovery -->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-consul-discovery</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
   
 </dependencies>  
  
</project>
```
### 4.3.3 写下xml
```xml
# consul服务端口  
server:  
  port: 80  
  
spring:  
  application:  
    name: consul-consumer-order  
  # consul注册中心地址  
 cloud:  
    consul:  
      host: localhost  
      port: 8500  
 discovery:  
        service-name: ${spring.application.name}
```
### 4.3.4 主启动类
```java
@SpringBootApplication  
@EnableDiscoveryClient  
public class PaymentMain8006 {  
 public static void main(String[] args) {  
 SpringApplication.run(PaymentMain8006.class,args);  
 }  }### 4.3.5 写PaymentController
```
### 4.3.5 编写PaymentController
```java
@RestController  
@Slf4j  
public class PaymentController {  
  
 @Value("${server.port")  
 private String serverPort;  
  
 @RequestMapping("/payment/consul")  
 public String paymentConsul(){  
 return "springcloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();  
 }  
  
}
```
### 4.3.6 运行测试
启动`PaymentMain8006`
访问`localhost:8500`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220131192441.png)

访问`localhsot:8006/payment/consul`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220131190840.png)

## 4.4 服务消费者
### 4.4.1 创建consumerconsul-order80模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220131191105.png)
### 4.4.2 写POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-consumerconsul-order80</artifactId>  
  
 <dependencies>  
 <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-consul-discovery -->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-consul-discovery</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>1.0-SNAPSHOT</version>  
 </dependency>  
  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
   
 </dependencies>  

</project>
```
### 4.4.3 写xml
```yml
server:  
  port: 80  
  
spring:  
  application:  
    name: consul-consumer-order  
  cloud:  
    consul:  
      host: localhost  
      port: 8500  
 discovery:  
        service-name: ${spring.application.name}
```
### 4.4.4 主启动类
```java
@SpringBootApplication  
@EnableDiscoveryClient  
public class OrderConsulMain80 {  
 public static void main(String[] args) {  
 SpringApplication.run(OrderConsulMain80.class, args);  
 }  
}
```
### 4.4.5 写ApplicationContextConfig配置类
```java
@Configuration  
public class ApplicationContextConfig {  
  
 @LoadBalanced  
 @Bean public RestTemplate getRestTemplate(){  
 return new RestTemplate();  
 }  
}
```
### 4.4.6 写Controller
```java
@RestController  
@Slf4j  
public class OrderConsulController {  
  
 public static final String INVOKE_URL = "http://consul-provider-payment";  
  
 @Resource  
 RestTemplate restTemplate;  
  
 @GetMapping("/consumer/consul")  
 public String paymentInfo(){  
 String result = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);  
 return result;  
 }  
}
```
### 4.4.7 启动测试
启动`OrderConsulMain80`
访问`localhost:8500`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220131192409.png)
访问`http://localhost/consumer/payment/consul`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220131192612.png)
测试通过
## 4.5 三个注册中心异同点
**CAP**
> **C:Consistency(强一致性)**
> **A:Availability(可用性)**
> **P:Partition tolerance(分区容错)**
==CAP理论关注粒度是数据，而不是整体系统设计的策略==

CAP理论的核心是：==一个分布式系统不可能同时很好的满足一致性，可用性和分区容错性这三个需求==
最多只能同时较好的满足两个。
因此，根据CAP原理将NoSQL数据库分为了满足CA原则、满足CP原则和满足AP原则三大类：
* CA-单点集群，满足一致性，可用性的系统，通常在可扩展性上不太强大
* CP-满足一致性，分区容忍性的系统，通常性能不是特别高；
* AP-满足可用性，分区容忍性的系统，通常可能对一致性要求低一些。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220131193318.png)
| 组件名    | 语言 | CAP | 服务健康检查 | 对外暴露接口 | Spring Cloud集成 |
| --------- | ---- | --- | ------------ | ------------ | ---------------- |
| Eureka    | Java | AP  | 可配支持     | HTTP         | 已集成           |
| Consul    | Go   | CP  | 支持         | HTTP/DNS     | 已集成           |
| Zookeeper | Java | CP  | 支持         | 客户端       | 已集成           |      |

Eureka 有自我保护机制，高可用数据AP
Consule和Zookeeper，属于CP

# 五、Ribbon负载均衡服务调用
## 5.1 Ribbon概述
### 5.1.1 什么是Ribbon
Spring Cloud Ribbon是居于Netflix Ribbon实现的一套==客户端 负载均衡的工具==
简单的说，Ribbon是Netflix发布的开源项目，主要功能是提供==客户端软件负载均衡算法和服务调用==。Ribbon客户端组件提供一系列完善的配置项如连接超时，重试等。简单的说，就是配置文件中列出Load Balanceer(简称LB)后面所有的机器，Ribbon会自动帮助你基于某种规则（如简单轮询，随即链接等）去连接这些机器。我们很容易使用Ribbon实现自定义的负载均衡算法。
### 5.1.2 Ribbon能做什么
**LB负载均衡（Load Balance）是什么**
简单地说就是将用户的请求平摊的分配到多个服务上，从而达到系统的HA（高可用）。
常见的负载均衡软件有Nginx，LVS，硬件F5等。

**Ribbon本地负载均衡客户端 VS Nginx服务端负载均衡区别**
Nginx是服务器负载均衡，客户端所有请求都会交给nginx，然后又nginx实现转发请求。即负载均衡是由服务器实现的。
Ribbon本地负载均衡，在调用微服务接口的时候，会在注册中心上获取注册信息服务列表之后缓存到JVM本地，从而在本地实现RPC远程服务调用技术。

**集中式LB**
即在服务的消费方和提供方之间使用独立的LB设施（可以是硬件，如F5，也可以是软件，如nginx），又该设置负责把访问请求通过某种策略转发至服务的提供方。

**进程内LB**
将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，然后自己再从这些地址中选择出一个合适的服务器。
==Ribbon就属于进程内LB==，他只是一个类库，集成于消费方进程，消费方通过它来获取到服务为提供方的地址。

## 5.2 Ribbon负载较均衡演示
我们之前在引入`spring-cloud-netflix-eureka-client`的时候，其自带了`spring-cloud-starter-ribbon`引用，所以我们项目本身就存在了ribbon负载均衡，当我们访问80服务的时候，会帮我们自动切换8001和8002服务。实现了负载均衡。==默认使用**轮询**的负载均衡方式==
### 5.2.1 getForObject方法/getForEntity方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202151654.png)

## 5.3 Ribbon核心组件IRule
> Ribbon 默认使用轮询的负载均衡方式，当我们想要使用其他的负载均衡方式该怎么做？
我们可以是使用IRule来实现不同的选取方式。
==IRule：根据特定算法从服务列表中选取一个访问的服务==

![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202152110.png)
IRule为我们提供了以下几种负载均衡方式
| 轮询方式                                | 功能效果                                                                           |
| --------------------------------------- | ---------------------------------------------------------------------------------- |
| com.netflix.loadbalancer.RoundRobinRule | 轮询                                                                               |
| com.netflix.loadbalancer.RandomRule     | 随机                                                                               |
| com.netflix.loadbalancer.RetryRule      | 先按照RoundRobinRule的策略获取服务，<br>如果失败则会在指定时间内进行重试           |
| WeightedResponseTimeRule                | 对RoundRobinRule的扩展，响应速度越快的实例选择权重越大，越容易被选择               |
| BestAvailableRule                       | 会先过滤掉由于多次访问故障而处于断路器跳闸状态的服务，然后选择一个并发量最小的服务 |
| AbailabilityFileringRule                | 会先过滤掉故障实例，在选择并发较小的实例                                           |
| ZoneAvoidanceRule                       | 默认规则，服务判断Server所在区域的性能和server的可用性选择服务器                   |

### 5.3.1 替换负载均衡方式
需要修改`consumer-order80`，在修改前我们需要注意
官方文档明确给出了警告：这个定义配置类(负载均衡配置类)不能放在`@ComponentScan`所扫描的当前包下以及子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，达不到特殊定制的目的了。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202153632.png)

由于不能再当前包下创建，所以我们应该新建一个包，在进行写配置类
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202153904.png)
创建MyselfRule配置类，更改IRule的选择方式
```java
@Configuration  
public class MySelfRule {  
  
 @Bean  
 public IRule myRule(){  
 // 定义随机选择  
 return new RandomRule();  
 }  
}
```
在启动类上添加`@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)`注解
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202154330.png)
其中`name`表示当前80服务要访问名字为`CLOUD-PAYMENT-SERVICE`的微服务(对应该项目中的8001和8002)，`configuration`表示服务选取的策略，为我们自定义的`MySelfRule.class`

**运行测试**
访问`http://localhost/consumer/payment/get/3`，发现返回的结果，是在8001和8002之间随机选择的。而不是原本默认的轮询。
### 5.3.2 Ribbon负载均衡算法
> ==**轮询算法：rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标，每次服务重启后rest接口计数从1开始。**==

举例：
当前项目有两个微服务，8001和8002，所以总数是2
list = 2 instance
第一次请求：1 % 2 = 1 ==> index =1  list.get(index);
第二次请求：2 % 2 = 0 ==> index =0  list.get(index);
第三次请求：3 % 2 = 1 ==> index =1  list.get(index);
。。。。
如何服务重启了，请求数则从1开始，如第一次请求一样。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202160221.png)

### 5.3.4 自己写负载均衡算法
启动7001/7002集群
#### 5.3.4.1 改造8001/8002微服务
修改8001/8002服务的Controller，向`PaymentController`中添加如下方法
```java
@GetMapping(value = "/payment/lb")
public String getPaymentLB(){
    return serverPort;
}
```

#### 5.3.4.2 改造80订单微服务
第一步：去掉`ApplicationContextBean`上的`@LoadBalanced`注解
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202163509.png)
第二步：写LoadBalancer接口
		创建lb包（启动类同包下），新建`LoadBalancer`接口
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202163914.png)
第三步：创建MyLB，实现LoadBalancer接口
```java
@Component  
public class MyLB implements LoadBalancer{  
  
 private AtomicInteger atomicInteger = new AtomicInteger(0);  
  
 public final int getAndIncrement(){  
 int current;  
 int next;  
 do {  
 current = this.atomicInteger.get();  
 next = current >= Integer.MAX_VALUE ? 0 : current + 1;  
  
 }while (!this.atomicInteger.compareAndSet(current,next));  
 System.out.println("*****第几次访问，次数next:" + next);  
 return next;  
 }  
  
 @Override  
 public ServiceInstance instances(List<ServiceInstance> serviceInstances) {  
  
 int index = getAndIncrement() % serviceInstances.size();  
 return serviceInstances.get(index);  
 }  
}
```
第四步：OrderController使用策略
在80服务中OrderController下新增如下内容
```java
@Resource  
private LoadBalancer loadBalancer;  
  
@Resource  
private DiscoveryClient discoveryClient;

@GetMapping("/payment/lb")  
public String getPaymentLB(){  
 List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");  
 if (instances == null || instances.size() <= 0){  
 return null;  
 }  
  
 ServiceInstance serviceInstance = loadBalancer.instances(instances);  
 URI uri = serviceInstance.getUri();  
  
 return restTemplate.getForObject(uri + "/payment/lb",String.class);  
}
```
第五步：运行测试
访问`localhost/consumer/payment/lb`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202171106.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202170855.png)
自己手写的轮询方法实现成功。

# 六、OpenFeign服务接口调用
## 6.1 OpenFeign概述
### 6.1.1 OpenFeign是什么
> Feign是一个声明式的web服务客户端，让编写web服务客户端变得非常容易，
> 只需要创建一个接口并在接口上添加注解即可

Github：[GitHub - spring-cloud/spring-cloud-openfeign: Support for using OpenFeign in Spring Cloud apps](https://github.com/spring-cloud/spring-cloud-openfeign)
官网：[spring-cloud-openfeign](https://cloud.spring.io/spring-cloud-static/Hoxton.SR1/reference/htmlsingle/#spring-cloud-openfeign)


Feign是一个声明式的WebService客户端。使用Feign能让编写Web Service客户端更加简单。
它的使用方法是==定义一个服务接口然后在上面添加注解。==Feign也支持可拔插式的编码器和解码器。Spring Cloud对Feign进行了封装，使其支持了Spring MVC标准注解和HttpMessageConverters。Feign可以与Eureka和Ribbon组合使用以支持负载均衡。

### 6.1.2 OpenFeign能干什么
Feign旨在使编写Java Http客户端变得共容易。
前面使用Ribbon+RestTemplate时，利用RestTemplate对http请求的封装处理，形成了一套模板化的调用方法。但是在实际开发中，由于对服务依赖的调用可能不止一处，==往往一个接口会被多处调用，所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用。==所以Feign在此基础上做了进一步封装，由他来帮助我们定义和实现依赖服务接口的定义。在Feign的实现下，==我们只需创建一个接口并使用注解的方式来配置它（以前是Dao接口上面标注Mapper注解，现在是一个微服务接口上面标注一个Feign注解即可）==，即可完成对服务提供方的接口绑定，简化了使用Spring Cloud Ribbon时，自动封装服务调用客户端的开发了
**Feign集成了Ribbon**
利用Ribbon维护了Payment的服务列表信息，并且通过轮询实现了客户端的负载均衡。而与Ribbon不同的是，==通过Feign只需要定义服务绑定接口且以声明式的方法==，优雅而简单的实现了服务调用
### 6.1.3 Feign和Open Feign两者区别
| Feign                                                        | OpenFeign                                                    |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| Feign是Spring Cloud组件中的一个轻量级RESTful的HTTP服务客户端，<br>Feign内置了Ribbon，用来做客户端负载均衡，去调用服务注册中心的服务。<br>Feign的使用方式是：使用Feign的注解定义接口，调用这个接口，<br>就可以调用服务注册中心的服务 | OpenFeign是Spring Cloud在Feign的基础上支持了SpringMCV的注解，<br>如`@RequesMapping`等等。OpenFeign的`@FeignClient`可以解析<br>SpringMVC的`@RequestMapping`注解下的接口，并通过动态代理的方式<br>产生实现类，实现类中做出负载均衡并调用其他的服务。 |
| \<dependency><br/>            \<groupId>org.springframework.cloud\</groupId><br/>            \<artifactId>spring-cloud-starter-==feign==\</artifactId><br/>\</dependency> | \<dependency><br/>            \<groupId>org.springframework.cloud\</groupId><br/>            \<artifactId>spring-cloud-starter-==openfeign==\</artifactId><br/>\</dependency> |
## 6.2 OpenFeign使用步骤
微服务调用接口+`@FeignClient`

### 6.2.1 新建consumer-feign-order80模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202220740.png)
### 6.2.2 写POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-consumer-feign-order80</artifactId>  
  
 <!--openfeign-->  
 <dependencies>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-openfeign</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
</project>
```
### 6.2.3 写yml
```yml
server:  
  port: 80  
eureka:  
  client:  
    register-with-eureka: false  
 service-url:  
      defaultZone: http://eureka7001.com:7001/eureka, http://eureka7002.com:7002/eureka
```
### 6.2.4 主启动类
主启动类上添加`@EnableFeignClients`，开启Feign
```java
@SpringBootApplication  
@EnableFeignClients  
public class OrderFeignMain80 {  
 public static void main(String[] args) {  
 SpringApplication.run(OrderFeignMain80.class, args);  
 }  
}
```
### 6.2.5 业务类
创建`PaymentFeignService`接口
```java
@Component  
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")  
public interface PaymentFeignService {  
  
 @GetMapping("/payment/get/{id}")  
 CommonResult getPaymentById(@PathVariable("id") Long id);  
}
```
创建`OrderFeignController`
```java
@RestController  
@Slf4j  
public class OrderFeignController {  
  
 @Resource  
 private PaymentFeignService paymentFeignService;  
  
 @GetMapping("/consumer/payment/get/{id}")  
 public CommonResult getPaymentById(@PathVariable("id") Long id){  
 return paymentFeignService.getPaymentById(id);  
 }  
}
```
### 6.2.6 启动测试
先启动2个eureka集群7001/7002
在启动2个微服务8001/8002
启动OpenFeign80
访问`localhost/consumer/payment/get/3`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202223145.png)
访问成功，OpenFign服务调用成功
==**Feign自带负载均衡配置项**==
可以通过yml配置更改负载均衡策略
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202234808.png)
也可以通过上文的`IRule`方式更改策略

## 6.3 OpenFeign超时控制
### 6.3.1 超时设置
故意设置超时，演示出错情况
在服务体提供方8001故意写暂停程序
```java
@GetMapping( "/payment/feign/timeout")  
public String paymentFeignTimeout(){  
 // 暂停几秒钟线程  
 try{  
 TimeUnit.SECONDS.sleep(3);  
 }catch (InterruptedException e){  
 e.printStackTrace();  
 }  
 return serverPort;  
}
```
在服务消费方80`PaymentFeignService`中添加超时方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202231154.png)
在服务消费方80`OrderFeignController`中添加超时方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202231628.png)
启动测试
访问`http://localhost/consumer/payment/feign/timeout`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202231959.png)
发现请求超时，由于OpenFeign默认等待1秒钟，而我们故意是程序暂停3秒钟，引发报错
### 6.3.2 什么是OpenFeign超时控制
默认Feign客户端只等待一秒钟，但是服务端处理需要超过1秒钟，导致Feign客户端不想等待了，直接返回报错。
为了避免这种情况，有时候我们需要设置feign客户端的超时控制。
### 6.3.3 修改Feign超时控制
在80端的yml添加内容
```yml
CLOUD-PAYMENT-SERVICE: # 这个是指服务提供者spring.application.name  
 # 设置feign客户端超时时间(OpenFeign默认支持Ribbon)  
 ribbon:  
  # 配置负载均衡规则 随机  
 NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule  
  # 指的是建立连接后服务器读取到可用资源所用的时间  
 ReadTimeout: 5000  
  # 指的是建立连接所用的时间，适用于网络状况正常的情况下，两端连接所用的时间  
 ConnectTimeout: 5000
```
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202235021.png)

再次访问`http://localhost/consumer/payment/feign/timeout`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220202233429.png)
Feign会等待程序执行，就不会报超时错误了
## 6.4 OpenFeign日志打印功能
### 6.4.1 什么是日志打印功能
Feign提供了日志打印功能，我们可以通过配置来调整日志级别，从而了解Feign中http请求的细节。
说白了就是==对Feign接口的调用情况进行监控和输出==
### 6.4.2 日志级别
* NONE：默认的，不显示任何日志；
* BASIC：仅记录请求方法、URL、响应状态码及执行时间；
* HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息；
* FULL：除了HEADERS中定义的信息之外，好友请求和响应的正文及元数据。
### 6.4.3 配置日志bean
创建`FeignConfig`配置类
```java
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
 

```
### 6.4.4 配置yml
在yml文件中开启日志Feigb客户端
```yml
logging:  
  level:  
    # feign日志以什么级别监控哪个接口  
 com.mrlqq.springcloud.service.PaymentFeignService: debug
```
重启服务，发出请求后，会在控制台中看到详细的信息
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220203000321.png)

# 七、Hystrix断路器
## 7.1 Hystrix概述
### 7.1.1 分布式系统面临的问题
==复杂分布式体系结构中的应用程序有数十个依赖关系，每个依赖关系在某些时候将不可避免地失败==
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220203220056.png)
**服务雪崩**
多个微服务之间调用的时候，假设微服务A调用微服务B和微服务C，微服务B和微服务C有调用其他的微服务，这就是所谓的==“扇出”==。如果扇出链路上某个微服务的调用响应时间过长或者不可用，对微服务A的调用就会占用越来越多的系统资源，从而引起系统崩溃，所谓的“雪崩效应”。
对于高流量的应用来说，单一的后端依赖可能会导致所有服务器上的所有资源都在几秒钟内饱和。比失败更糟糕的是，这些应用程序还可能导致服务之间的延迟增加，备份队列，线程 和其他系统资源紧张，导致整个系统发生更多的级联故障。这些都表示需要对故障和延迟进行隔离和管理，以便单个依赖关系的失败，不能取消整个应用程序或系统。
通常当你发现一个模块下的某个实力失败后，这时候这个模块依然还会接收流量，然后这个有问题的模块还调用了其他的模块，这样就会发生级联故障，或者叫雪崩。

### 7.1.2 Hystrix是什么
Hystrix是一个用于处理分布式系统的==延时==和==容错==的开源库，在分布式系统里，许多依赖不可避免地会调用失败，比如超时、异常等，Hystrix能够保证在一个依赖出问题的情况下，==不会导致整体服务失败，避免级联故障，以提高分布式系统的弹性。==
“断路器”本身是一种开关装置，当某个服务单元发生故障之后，通过断路器的故障监控（类似熔断保险丝），==向调用方返回一个服务预期的、可处理的备选响应（FallBack），而不是长时间的等待或者抛出调用方无法处理的异常==，这样就保证了服务调用方的线程不会被长时间、不必要地占用，从而避免了故障在分布式系统中地蔓延，乃至雪崩。
### 7.1.3 Hystrix能做什么
* 服务降级
* 服务熔断
* 接近实时的监控
* 。。。
官网资料：[How To Use · Netflix/Hystrix Wiki · GitHub](https://github.com/Netflix/Hystrix/wiki/How-To-Use)
## 7.2 Hystrix重要概念
### 7.2.1 服务降级 fallback
> 服务器忙，请稍后再试，不让客户端等待并立刻返回一个友好提示，fallback

#### 7.2.1.1 哪些情况会触发降级？
* 程序运行异常
* 超时
* 服务熔断出发服务降级
* 线程池/信号量打满也会导致服务降级
### 7.2.2 服务熔断 break
> 类比保险丝达到最大服务访问后，直接拒绝访问，拉闸限电，然后调用服务降级地方法并返回友好提示
### 7.2.3 服务限流 flowlimit
> 秒杀并发等操作，严谨一窝蜂地过来拥挤，大家排队，一秒钟N个，有序进行
## 7.3 Hystrix案例
### 7.3.1 构建
#### 7.3.1.1 创建provider-hystrix-payment8001模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220203224812.png)
#### 7.3.1.2 写POM
```java
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-provider-hystrix-payment8001</artifactId>  
  
 <dependencies>  
 <!--新增hystrix-->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>  
 </dependency>  
  
  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
</project>
```
#### 7.3.1.3 写yml
```yml
server:  
  port: 8001  
  
spring:  
  application:  
    name: cloud-provider-hystrix-payment  
  
eureka:  
  client:  
    register-with-eureka: true #表识不向注册中心注册自己  
 fetch-registry: true #表示自己就是注册中心，职责是维护服务实例，并不需要去检索服务  
 service-url:  
      # defaultZone: http://eureka7002.com:7002/eureka/    #设置与eureka server交互的地址查询服务和注册服务都需要依赖这个地址  
 defaultZone: http://eureka7001.com:7001/eureka/
```
#### 7.3.1.4 主启动类
```java
@SpringBootApplication  
@EnableEurekaClient  
public class PaymentHystrixMain8001 {  
 public static void main(String[] args) {  
 SpringApplication.run(PaymentHystrixMain8001.class,args);  
 }  
}
```
#### 7.3.1.5 业务类
创建一个服务类`PaymentService
```java
@Service  
public class PaymentService {  
  
 /**  
 * 可正常访问的  
 * @param id  
 * @return  
 */  
 public String PaymentInfo_OK(Integer id){  
 return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_OK,id:" + id + "\t";  
 }  
  
 /**  
 * * @param id  
 * @return  
 */  
 public String PaymentInfo_TimeOut(Integer id){  
 int timeNumber = 3;  
 // 暂停几秒钟线程，模拟业务复杂，花费时间
 try{  
 TimeUnit.SECONDS.sleep(timeNumber);  
 }catch (InterruptedException e){  
 e.printStackTrace();  
 }  
 return "线程池：" + Thread.currentThread().getName() + "  PaymentInfo_TimeOut,id:" + id + "\t" + " 耗时(秒):" + timeNumber;  
 }  
}
```
创建一个`PaymentController`
```java
@RestController  
@Slf4j  
public class PaymentController {  
  
 @Resource  
 private PaymentService paymentService;  
  
 @Value("${server.port}")  
 private String serverPort;  
  
 @GetMapping("/payment/hystrix/ok/{id}")  
 public String paymentInfo_OK(@PathVariable("id") Integer id){  
 String result = paymentService.PaymentInfo_OK(id);  
 log.info("*****result: " + result);  
 return result;  
 }  
  
 @GetMapping("/payment/hystrix/timeout/{id}")  
 public String paymentInfo_TimeOut(@PathVariable("id") Integer id){  
 String result = paymentService.PaymentInfo_TimeOut(id);  
 log.info("*****result: " + result);  
 return result;  
 }  
}
```
#### 7.3.1.6 启动测试
启动`eureka7001`和`provider-hystrix-payment8001`
访问`localhost:8001/payment/hystrix/ok/3`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220203231405.png)
访问`localhost:8001/payment/hystrix/timeout/3`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220203231439.png)
发现ok请求和timeout请求都可以正常，只不过由于我们模拟了业务暂停，timeout需要花费几秒才会有响应结果。
以此为基础，之后学习Hystrix地具体使用
### 7.3.2 高并发测试
> 上面地模拟测试，在非高并发情况下，勉强可用，但如果访问的线程非常多会出现什么情况呢？
#### 7.3.2.1 Jmeter压力测试
使用Jmeter先测20000个请求
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220203234633.png)
当我们再次手动发出请求时，发现两个响应结果都变慢了，原本秒回的ok请求也变慢了，所以在高并发下会影响微服务的可靠性，二者只是在两万个并发下，
**测试结论**
上面还是服务提供者8001自己测试，假如此时外部的消费者80也来访问，那消费者只能干等，最终导致消费端80不满意，服务端8001直接被拖死

#### 7.3.2.2 创建consumer-feign-hystrix-order80模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220203235157.png)
**写POM**
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-consumer-feign-hystrix-order80</artifactId>  
  
 <dependencies>  
 <!--新增hystrix-->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>  
 </dependency> <dependency> <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-openfeign</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency> </dependencies>  
</project>
```
**写yml**
```yml
server:  
  port: 80  
  
eureka:  
  client:  
    register-with-eureka: false  
 service-url:  
      defaultZone: http://eureka7001.com:7001/eureka/
```
**主启动类**
```java
@SpringBootApplication  
@EnableFeignClients  
public class PaymentHystrixMain8001 {  
 public static void main(String[] args) {  
 SpringApplication.run(PaymentHystrixMain8001.class,args);  
 }  
}
```
**业务类**
创建`PaymentHystrixService`
```java
@Component  
@FeignClient("CLOUD-PROVIDER-HYSTRIX-PAYMENT")  
public interface PaymentHystrixService {  
  
 @GetMapping("/payment/hystrix/ok/{id}")  
 String paymentInfo_OK(@PathVariable("id") Integer id);  
  
 @GetMapping("/payment/hystrix/timeout/{id}")  
 String paymentInfo_TimeOut(@PathVariable("id") Integer id);  
}
```
创建`OrderHystrixController`
```java
@RestController  
@Slf4j  
public class OrderHystrixController {  
  
 @Resource  
 private PaymentHystrixService paymentHystrixService;  
  
 @Value("${server.port}")  
 private String serverPort;  
  
 @GetMapping("/consumer/payment/hystrix/ok/{id}")  
 public String paymentInfo_OK(@PathVariable("id") Integer id){  
 String result = paymentHystrixService.paymentInfo_OK(id);  
 log.info("*******result:"+result);  
 return result;  
 }  
 @GetMapping("/consumer/payment/hystrix/timeout/{id}")  
 public String paymentInfo_TimeOut(@PathVariable("id") Integer id){  
 String result = paymentHystrixService.paymentInfo_TimeOut(id);  
 log.info("*******result:"+result);  
 return result;  
 }  
}
```
**启动OrderHystrixMain80**
访问`localhost/consumer/payment/hystrix/ok/3`和`localhost/consumer/payment/hystrix/timeout/3`可以正常访问

**再次使用JMeter向8001发2W个请求**
此时当我们通过80消费者再次访问`localhost/consumer/payment/hystrix/timeout/3`可能会出现超时错误
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204002827.png)
### 7.3.3 故障现象和导致原因
8001同一层次的其他接口服务被困死，因为tomcat线程里面的工作线程已经被挤占完毕，
80此时调用8001，客户端访问响应缓慢，转圈圈
**结论**：正因为由上述故障或不佳表现，才有我们的降级/容错/限流等技术诞生
### 7.3.4 如何解决
超时导致服务器变慢(转圈)     ==> 超时不再等待
出错(宕机或者程序运行出错) ==> 出错要有fallback
**解决**：
对方服务(8001)超时了，调用者(80)不能一直卡死等待，必须有服务降级。
对方服务(8001)宕机了，调用者(80)蹦年一直卡死等待，必须有服务降级。
对方服务(8001)OK，调用者(80)自己出现故障或有自我要求(自己的等待时间小于服务提供者)，自己处理降级。
### 7.3.5 服务降级 
**降级配置`@HystrixCommand`**
**1. 8001先从自身找问题**
	设置自身调用超时时间的峰值，峰值内可以正常运行
	超过了需要有兜底的方法处理，作服务降级fallback
**2. 8001 fallback**
	使用`@HystrixCommand`设置报异常后如何处理
	![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204005144.png)
一旦调用方法失败并且抛出了错误信息后，会自动调用`@HystrixCommand`标注好的`fallbackMethod`调用类中的指定方法
在在启动类上加上`@EnableCircuitBreaker`注解开启断路器
为了测试降级是否有效，我们需要在`@HystrixCommand`注解上在添加上`commandProperties = {  @HystrixProperty(name ="execution.isolation.thread.timeoutInMilliseconds",value = "3000") }`属性来设置服务超时时间为3秒钟，并且估值设置timeout方法暂停5秒钟，模拟超时任务，以观察Hystrix服务降级是否有效
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204012653.png)

启动测试，访问`localhost:8001/payment/hystrix/timeout/3`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204012153.png)
发现业务超时或者异常后，会自动调用我们写的fallback方法
**3. 80 fallback**
首先在80端，先在xml中开启hystrix
```yml
# 开启hystrix  
feign:  
  hystrix:  
    enabled: true
```
然后在80的启动类上添加`@EnableHystrix`注解启动Hystrix
最后在80的`OrderHystrixController`需要的请求上添加`@HystrixCommand(配置)`注解，并写对应的fallback方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204014243.png)
根据上文，我们修改8001的超时时间为5秒钟，程序暂停3秒钟，对于8001而言，服务依然是可用的，因为程序运行时间时3秒钟，没有超过设置的5秒钟。但是对于80而言就不同了，通过我们上面对80修改完成后的情况来看，只要我们通过80调用8001的服务，即使8001程序运行3秒钟对于其本身而言时可用的，但对于80来说已经超过了设置的1.5秒的超时时间。所以80会调用fallback。运行测试，访问`localhost/consumer/payment/hystrix/timeout/3`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204014903.png)
同上面分析的一样，80只会等待1.5秒钟，超时就调用fallback
**4. 目前问题**
* 每个业务方法对应一个fallback方法，导致代码膨胀
* 统一和定义的分开
**5. 解决问题**
*==每个方法配置一个fallback，导致代码膨胀==*
`@DefaultProperties(defaultFallback = "")`
每个方法配置一个服务降级方法，技术上可以，但是很没有必要。
正确的方式是除了个别重要核心业务有专属，其他普通的可以通过`@DefaultProperties(defaultFallback = "")`同意跳转到统一处理结果也没
通用和独享的各自分开，避免了代码膨胀，合理减少了代码量
我们在80消费者的controller上进行配置
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204021123.png)
启动测试，访问`localhost/consumer/payment/hystrix/timeout/3`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204021201.png)
虽然我们没有指定fallback，但是当业务出错后，会自动调用全局默认的fallback方法。

*==fallback和业务逻辑混在一起，导致代码混乱==*
本次案例服务降级处理是在客户端80实现完成的，与服务端8001没有关系，只需要为Feign客户端定义的接口添加一个服务降级处理的实现类即可实现解耦
我们未来要面对的异常：**运行异常、超时异常、服务器宕机**
提出另一种可能：服务降级，客户端调用服务端，碰上服务器宕机或关闭
根据上面提出的可能我们开修改consumer-feign-hystrix-order80，在80已有的`PaymentHystrixService`接口，重新新建一个`PaymentFallbackService`是实现该接口，统一为接口里面的方法进行异常处理
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204022504.png)
然后在`PaymentHystrixService`接口的`@FeignClient`注解中添加`fallback`参数，指定刚才用来实现接口而创建的`PaymentFallbackService.class`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204022629.png)
启动8001和80进行测试
先正常访问`localhost/consumer/payment/hystrix/ok/3`，这个请求没有错误后。我们关闭8001服务模拟服务宕机，然后刷新请求
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204023139.png)
发现8001服务宕机后，80自动的调用了我们刚才通过实现FeignClient接口而写的fallback方法。
在上文中我们没有对controller做任何修改，在日后中如果业务较多我们完全可以按照这种方式调用服务降级fallback，在controller中通过指定一个`@DefaultProperties`指定全局默认fallback，通过实现feignClient接口来指定自己的fallback
### 7.3.6 服务熔断
#### 7.3.6.1 什么是熔断
熔断机制是对应雪崩效应的一红微服务链路保护机制。当扇出链路的某个微服务出错不可用或者响应时间太长时候，会进行服务的降级，进而熔断该节点微服务的调用，快速返回错误的响应信息。
==当检测到该节点微服务调用响应正常后，恢复调用链路==
在Spring Cloud框架中，熔断机制通过Hystrix实现，Hystrix会监控微服务间调用的状况，当失败的调用到一定阈值，缺省是5秒内20次调用失败，就会启动熔断机制。熔断机制的注解是`@HystrixCommand`。

论文：[CircuitBreaker](https://martinfowler.com/bliki/CircuitBreaker.html)

#### 7.3.6.2 实际操作
在服务提供者provider-hystrix-payment8001进行修改
修改8001的`PaymentService`
在需要进行服务熔断的业务上添加`@HystrixCommand`注解，并添加具体的`@HystrixProperty`配置内容
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204170753.png)
修改8001的`PaymentController`
在controller中 写一个GetMapping调用刚才的写的paymentCircuitBreaker业务
**启动测试**，访问`http://localhost:8001/payment/circuit/3`，正常返回
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204173300.png)
访问`http://localhost:8001/payment/circuit/-3`时，id变成了负数，根据刚才的业务逻辑，会调用fallback
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204173402.png)
当我们多次发出id为正数的请求时，当错误率超过了我们上文设置的60%，那么hystrix就会熔断服务，此时我们即便是发出id为正数请求，也会走fallback方法，熔断后一定时间后（默认5秒，我们设置了10秒），将再次重试调用run()方法，检测是否需要闭合调用链路，Hystrix会放我们恢复服务，出现正确的响应。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204174137.png)
#### 7.3.6.3 原理(总结)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204174323.png)
**熔断类型：**
* 熔断打开：请求不再进行调用当前服务，内部设置时钟一般为MTTR(平均故障处理时间)，当打开时长达到所设时钟则进入熔断状态
* 熔断关闭：熔断关闭不会对服务进行熔断
* 熔断半开：部分请求根据规则调用当前服务，如果请求成功且符合规则则认为当前服务恢复正常，关闭熔断
**断路器在什么情况下开始起作用**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204180115.png)
涉及到熔断器的三个重要参数:==快照时间窗、请求总数阈值、错误百分比阈值==
1、快照时间窗：断路器确定是否打开需要统计一些请求和错误数据，而统计的时间范围就是快照时间窗，默认5秒。
2、请求总数阈值：在快照时间窗内，必须满足请求总数阈值才有资格熔断。默认为20，意味着在10秒内，如果该Hystrix命令的调用次数不足20次，即使所有的请求都超时或者其他原因失败，断路器都不会打开。
3、错误百分比阈值：当请求总数在快照时间窗内超过了阈值，比如发生了30次调用，如果在这30次调用中，有15次发生了异常，也就是超过了50%的错误百分比，在默认设定50%阈值情况下，这时候就会将断路器打开。
*一段时间之后（默认5秒钟），这个时候断路器时半开状态，会让其中一个请求进行转发。如果成功，断路器就会关闭，若失败，继续开启。*
**断路器打开之后**
1、再有请求调用的时候，将不会调用主逻辑，而是直接调用降级fallback。通过断路器，实现了自动地发现错误并将降级逻辑切换为主逻辑，减少相应延迟地效果。
2、原来的主要逻辑要如果恢复呢？
对于这一问题，hystrix也为我们实现了自动恢复功能。
当断路器打开，对主逻辑进行熔断之后，hystrix会启动一个休眠地时间窗，在这个时间窗内，降级逻辑是临时地称为主逻辑，
当休眠时间窗到期，熔断器将进入半开状态，释放一次请求到原来的主逻辑上，如果此次请求正常返回，那么熔断器将继续闭合，
主逻辑恢复，如果这次请求依然有问题，断路器将继续进入打开状态，休眠时间窗重新计时。

**All配置**
```java
@HystrixCommand(fallbackMethod = "fallbackMethod", 
                groupKey = "strGroupCommand", 
                commandKey = "strCommand", 
                threadPoolKey = "strThreadPool",
                
                commandProperties = {
                    // 设置隔离策略，THREAD 表示线程池 SEMAPHORE：信号池隔离
                    @HystrixProperty(name = "execution.isolation.strategy", value = "THREAD"),
                    // 当隔离策略选择信号池隔离的时候，用来设置信号池的大小（最大并发数）
                    @HystrixProperty(name = "execution.isolation.semaphore.maxConcurrentRequests", value = "10"),
                    // 配置命令执行的超时时间
                    @HystrixProperty(name = "execution.isolation.thread.timeoutinMilliseconds", value = "10"),
                    // 是否启用超时时间
                    @HystrixProperty(name = "execution.timeout.enabled", value = "true"),
                    // 执行超时的时候是否中断
                    @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "true"),
                    
                    // 执行被取消的时候是否中断
                    @HystrixProperty(name = "execution.isolation.thread.interruptOnCancel", value = "true"),
                    // 允许回调方法执行的最大并发数
                    @HystrixProperty(name = "fallback.isolation.semaphore.maxConcurrentRequests", value = "10"),
                    // 服务降级是否启用，是否执行回调函数
                    @HystrixProperty(name = "fallback.enabled", value = "true"),
                    // 是否启用断路器
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    // 该属性用来设置在滚动时间窗中，断路器熔断的最小请求数。例如，默认该值为 20 的时候，如果滚动时间窗（默认10秒）内仅收到了19个请求， 即使这19个请求都失败了，断路器也不会打开。
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
                    
                    // 该属性用来设置在滚动时间窗中，表示在滚动时间窗中，在请求数量超过 circuitBreaker.requestVolumeThreshold 的情况下，如果错误请求数的百分比超过50, 就把断路器设置为 "打开" 状态，否则就设置为 "关闭" 状态。
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
                    // 该属性用来设置当断路器打开之后的休眠时间窗。 休眠时间窗结束之后，会将断路器置为 "半开" 状态，尝试熔断的请求命令，如果依然失败就将断路器继续设置为 "打开" 状态，如果成功就设置为 "关闭" 状态。
                    @HystrixProperty(name = "circuitBreaker.sleepWindowinMilliseconds", value = "5000"),
                    // 断路器强制打开
                    @HystrixProperty(name = "circuitBreaker.forceOpen", value = "false"),
                    // 断路器强制关闭
                    @HystrixProperty(name = "circuitBreaker.forceClosed", value = "false"),
                    // 滚动时间窗设置，该时间用于断路器判断健康度时需要收集信息的持续时间
                    @HystrixProperty(name = "metrics.rollingStats.timeinMilliseconds", value = "10000"),
                    
                    // 该属性用来设置滚动时间窗统计指标信息时划分"桶"的数量，断路器在收集指标信息的时候会根据设置的时间窗长度拆分成多个 "桶" 来累计各度量值，每个"桶"记录了一段时间内的采集指标。
                    // 比如 10 秒内拆分成 10 个"桶"收集这样，所以 timeinMilliseconds 必须能被 numBuckets 整除。否则会抛异常
                    @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "10"),
                    // 该属性用来设置对命令执行的延迟是否使用百分位数来跟踪和计算。如果设置为 false, 那么所有的概要统计都将返回 -1。
                    @HystrixProperty(name = "metrics.rollingPercentile.enabled", value = "false"),
                    // 该属性用来设置百分位统计的滚动窗口的持续时间，单位为毫秒。
                    @HystrixProperty(name = "metrics.rollingPercentile.timeInMilliseconds", value = "60000"),
                    // 该属性用来设置百分位统计滚动窗口中使用 “ 桶 ”的数量。
                    @HystrixProperty(name = "metrics.rollingPercentile.numBuckets", value = "60000"),
                    // 该属性用来设置在执行过程中每个 “桶” 中保留的最大执行次数。如果在滚动时间窗内发生超过该设定值的执行次数，
                    // 就从最初的位置开始重写。例如，将该值设置为100, 滚动窗口为10秒，若在10秒内一个 “桶 ”中发生了500次执行，
                    // 那么该 “桶” 中只保留 最后的100次执行的统计。另外，增加该值的大小将会增加内存量的消耗，并增加排序百分位数所需的计算时间。
                    @HystrixProperty(name = "metrics.rollingPercentile.bucketSize", value = "100"),
                    
                    // 该属性用来设置采集影响断路器状态的健康快照（请求的成功、 错误百分比）的间隔等待时间。
                    @HystrixProperty(name = "metrics.healthSnapshot.intervalinMilliseconds", value = "500"),
                    // 是否开启请求缓存
                    @HystrixProperty(name = "requestCache.enabled", value = "true"),
                    // HystrixCommand的执行和事件是否打印日志到 HystrixRequestLog 中
                    @HystrixProperty(name = "requestLog.enabled", value = "true"),

                },
                threadPoolProperties = {
                    // 该参数用来设置执行命令线程池的核心线程数，该值也就是命令执行的最大并发量
                    @HystrixProperty(name = "coreSize", value = "10"),
                    // 该参数用来设置线程池的最大队列大小。当设置为 -1 时，线程池将使用 SynchronousQueue 实现的队列，否则将使用 LinkedBlockingQueue 实现的队列。
                    @HystrixProperty(name = "maxQueueSize", value = "-1"),
                    // 该参数用来为队列设置拒绝阈值。 通过该参数， 即使队列没有达到最大值也能拒绝请求。
                    // 该参数主要是对 LinkedBlockingQueue 队列的补充,因为 LinkedBlockingQueue 队列不能动态修改它的对象大小，而通过该属性就可以调整拒绝请求的队列大小了。
                    @HystrixProperty(name = "queueSizeRejectionThreshold", value = "5"),
                }
               )
public String doSomething() {
	...
}
```

### 7.3.7 服务限流 
后面在alibaba的Sentinel进行详细说明

## 7.4 Hystrix工作流程
1. 创建HystrixCommand （用在依赖的服务返回单个操作结果的时候）或HystrixObserableCommand（用在依赖的服务返回多个操作结果的时候）对象。
2. 命令执行
3. 其中 HystrixCommand实现了下面前两种执行方式
	1. execute()：同步执行，从依赖的服务返回一个单一的结果对象或是在发生错误的时候抛出异常。
	2. queue()：异步执行，直接返回一个Future对象，其中包含了服务执行结束时要返回的单一结果对象。
4. 而 HystrixObservableCommand实现了后两种执行方式：
	1. obseve()：返回Observable对象，它代表了操作的多个统果，它是一个Hot Observable （不论“事件源”是否有“订阅者”，都会在创建后对事件进行发布，所以对于Hot Observable的每一个“订阅者”都有可能是从“事件源”的中途开始的，并可能只是看到了整个操作的局部过程）。
	2. toObservable()：同样会返回Observable对象，也代表了操作的多个结果，但它返回的是一个Cold Observable（没有“订间者”的时候并不会发布事件，而是进行等待，直到有“订阅者"之后才发布事件，所以对于Cold Observable 的订阅者，它可以保证从一开始看到整个操作的全部过程）。
 5. 若当前命令的请求缓存功能是被启用的，并且该命令缓存命中，那么缓存的结果会立即以Observable对象的形式返回。
 6. 检查断路器是否为打开状态。如果断路器是打开的，那么Hystrix不会执行命令，而是转接到fallback处理逻辑(第8步)；如果断路器是关闭的，检查是否有可用资源来执行命令(第5步)。
 7. 线程池/请求队列信号量是否占满。如果命令依赖服务的专有线程地和请求队列，或者信号量（不使用线程的时候）已经被占满，那么Hystrix也不会执行命令，而是转接到fallback处理理辑(第8步) 。
 8. Hystrix会根据我们编写的方法来决定采取什么样的方式去请求依赖服务。
	 1. HystrixCommand.run()：返回一个单一的结果，或者抛出异常。
	 2. HystrixObservableCommand.construct()：返回一个Observable对象来发射多个结果，或通过onError发送错误通知。
9. Hystix会将“成功”、“失败”、“拒绝”、“超时” 等信息报告给断路器，而断路器会维护一组计数器来统计这些数据。断路器会使用这些统计数据来决定是否要将断路器打开，来对某个依赖服务的请求进行"熔断/短路"。
10. 当命令执行失败的时候，Hystix会进入fallback尝试回退处理，我们通常也称波操作为“服务降级”。而能够引起服务降级处理的情况有下面几种：
	1. 第4步∶当前命令处于“熔断/短路”状态，断洛器是打开的时候。
	2. 第5步∶当前命令的钱程池、请求队列或者信号量被占满的时候。
	3. 第6步∶HystrixObsevableCommand.construct()或HytrixCommand.run()抛出异常的时候。
11. 当Hystrix命令执行成功之后，它会将处理结果直接返回或是以Observable的形式返回。
---
**tips**：如果我们没有为命令实现降级逻辑或者在降级处理逻辑中抛出了异常，Hystrix依然会运回一个Obsevable对象，但是它不会发射任结果数惯，而是通过onError方法通知命令立即中断请求，并通过onError方法将引起命令失败的异常发送给调用者。
## 7.5 HysstrixDashboard服务监控
除了隔离依赖服务的调用以外，Hystrix还提供了`准实时的调用监控（HystrixDashboard）`，Hystrix会持续地记录所有通过Hystrix发起地请求地执行信息，并以统计报表和图形地形式展示给用户，包括每秒执行多少请求多少成功，多少失败等。Netflix通过hystrix-metrics-event-stream项目实现了对以上指标的监控。Spring Cloud也提供了Hystrix Dashboard的整合，对监控内容转化成可视化界面
### 7.5.1 搭建HysstrixDashboard
创建consumer-hystrix-dashboard9001模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204191720.png)
写pom
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-consumer-hystrix-dashboard9001</artifactId>  
  
  
 <dependencies>  
 <!--新增hystrix dashboard-->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
</project>
```
写xml
```yml
server:
  port: 9001
```
主启动类
```java
@SpringBootApplication  
@EnableHystrixDashboard  
public class HystrixDashboardMain9001 {  
 public static void main(String[] args) {  
 SpringApplication.run(HystrixDashboardMain9001.class,args);  
 }  
}
```
==所有Provider微服务提供类（8001/8002/8003）都需要监控依赖配置==
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
启动cloud-consumer-hystrix-dashboard9001该微服务后续将监控微服务8001
访问`http://localhost:9001/hystrix`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204192259.png)
搭建成功
### 7.5.2 使用HysstrixDashboard
**断路器演示(监控8001)**
修改cloud-provider-hystrix-payment8001
==注意：新版本Hystrix需要在主启动类MainAppHystrix8001中指定监控路径==
```java
/**  
 * 此配置是为了服务监控而配置的，与服务容错本身无关，spring cloud升级后的坑  
 * ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"，  
 * 只要在自己的项目里配置上下面的servlet就可以了  
 */
@Bean  
public ServletRegistrationBean getServlet(){  
 HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();  
 ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);  
 registrationBean.setLoadOnStartup(1);  
 registrationBean.addUrlMappings("/hystrix.stream");  
 registrationBean.setName("HystrixMetricsStreamServlet");  
 return registrationBean;  
}
```
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204192940.png)
而且还要在9001的yml中添加配置
```yml
hystrix:  
  dashboard:  
    proxy-stream-allow-list: "*"
```
**监控8001**
填写监控地址`http://localhost:8001/hystrix.stream`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204193137.png)
点击监控进入监控界面
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204194151.png)
**如何看图**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204223242.png)
有七种颜色，对应七种数据：
成功数、熔断数、错误请求数、超时数、线程池拒绝数、失败/异常数、错误百分比
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204223411.png)
实心圆：共有两种含义。它通过颜色的变化代表了实例的健康程度，它的健康度从绿色-黄色-橙色-红色递减。
该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化，流量越大该实心圆越大。所以通过该实心圆的展示，就可以在大量的实例中快速的发现==故障实例和高压力实例。==
曲线：用来记录2分钟内流量的相对变化，可以通过过它观察到流量的上升和下降趋势。

![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204223303.png)
看懂一个复杂的图
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204224239.png)

# 八、Gateway新一代网关
## 8.1 Gateway概述
Gateway官网：[Spring Cloud Gateway](https://cloud.spring.io/spring-cloud-static/spring-cloud-gateway/2.2.1.RELEASE/reference/html/)
### 8.1.1 Gateway是什么
Cloud全家桶中有个很重要的组件就是网关，在1.x版本中都是采用的Zuul网关;
但在2.x版本中，zuul的升级一直跳票，SpringCloud最后自己研发了一个网关替代Zuul，那就是SpringCloud Gateway—句话：gateway是原zuul1.x版的替代
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204230419.png)
Gateway是在Spring生态系统之上构建的API网关服务，基于Spring 5，Spring Boot 2和Project Reactor等技术。
Gateway旨在提供一种简单而有效的方式来对API进行路由，以及提供一些强大的过滤器功能，例如:熔断、限流、重试等。
SpringCloud Gateway是Spring Cloud的一个全新项目，基于Spring 5.0+Spring Boot 2.0和Project Reactor等技术开发的网关，它旨在为微服务架构提供—种简单有效的统一的API路由管理方式。
SpringCloud Gateway作为Spring Cloud 生态系统中的网关，目标是替代Zuul，在Spring Cloud 2.0以上版本中，没有对新版本的Zul 2.0以上最新高性能版本进行集成，仍然还是使用的Zuul 1.x非Reactor模式的老版本。而为了提升网关的性能，==SpringCloud Gateway是基于WebFlux框架实现的，而WebFlux框架底层则使用了高性能的Reactor模式通信框架Netty。==
Spring Cloud Gateway的目标提供统一的路由方式且基于 Filter链的方式提供了网关基本的功能，例如:安全，监控/指标，和限流。
### 8.1.2 Gateway能做什么
反向代理、鉴权、流量控制、熔断、日志监控。。。
### 8.1.3 微服务架构中网关在哪里
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204231544.png)
### 8.1.4 为什么选择Gateway
我们为什么选择Gateway？
1. netflix不太靠谱，zuul2.0一直跳票，迟迟不发布。
	1. 一方面因为Zuul1.0已经进入了维护阶段，而且Gateway是SpringCloud团队研发的，是亲儿子产品，值得信赖。而且很多功能Zuul都没有用起来也非常的简单便捷。
	2. Gateway是==基于异步非阻塞模型==上进行开发的，性能方面不需要担心。虽然Netflix早就发布了最新的Zuul 2.x，但Spring Cloud貌似没有整合计划。而且Netflix相关组件都宣布进入维护期；不知前景如何?
	3. 多方面综合考虑Gateway是很理想的网关选择。
2. SpringCloud Gateway具有如下特性
	1. 基于Spring Framework 5，Project Reactor和Spring Boot 2.0进行构建；
	2. 动态路由：能够匹配任何请求属性；
	3. 可以对路由指定Predicate (断言)和Filter(过滤器)；
	4. 集成Hystrix的断路器功能；
	5. 集成Spring Cloud 服务发现功能；
	6. 易于编写的Predicate (断言)和Filter (过滤器)；
	7. 请求限流功能；
	8. 支持路径重写。
3. SpringCloud Gateway与Zuul的区别
	在SpringCloud Finchley正式版之前，Spring Cloud推荐的网关是Netflix提供的Zuul。
	1. Zuul 1.x，是一个基于阻塞I/O的API Gateway。
	2. Zuul 1.x基==于Servlet 2.5使用阻塞架构==它不支持任何长连接(如WebSocket)Zuul的设计模式和Nginx较像，每次I/О操作都是从工作线程中选择一个执行，请求线程被阻塞到工作线程完成，但是差别是Nginx用C++实现，Zuul用Java实现，而JVM本身会有第一次加载较慢的情况，使得Zuul的性能相对较差。
	3. Zuul 2.x理念更先进，想基于Netty非阻塞和支持长连接，但SpringCloud目前还没有整合。Zuul .x的性能较Zuul 1.x有较大提升。在性能方面，根据官方提供的基准测试,Spring Cloud Gateway的RPS(每秒请求数)是Zuul的1.6倍。
	4. Spring Cloud Gateway建立在Spring Framework 5、Project Reactor和Spring Boot2之上，使用非阻塞API。
	5. Spring Cloud Gateway还支持WebSocket，并且与Spring紧密集成拥有更好的开发体验
#### 8.1.4.1 Zuul1.x模型
Springcloud中所集成的Zuul版本，采用的是Tomcat容器，使用的是传统的Serviet IO处理模型。
Servlet的生命周期？servlet由servlet container进行生命周期管理。
* container启动时构造servlet对象并调用servlet init()进行初始化；
* container运行时接受请求，并为每个请求分配一个线程（一般从线程池中获取空闲线程）然后调用service)；
* container关闭时调用servlet destory()销毁servlet。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204232008.png)
上述模式的缺点：
Servlet是一个简单的网络IO模型，当请求进入Servlet container时，Servlet container就会为其绑定一个线程，在并发不高的场景下这种模型是适用的。但是一旦高并发(如抽风用Jmeter压)，线程数量就会上涨，而线程资源代价是昂贵的（上线文切换，内存消耗大）严重影响请求的处理时间。在一些简单业务场景下，不希望为每个request分配一个线程，只需要1个或几个线程就能应对极大并发的请求，这种业务场景下servlet模型没有优势。
所以Zuul 1.X是基于servlet之上的一个阻塞式处理模型，即Spring实现了处理所有request请求的一个servlet (DispatcherServlet)并由该servlet阻塞式处理处理。所以SpringCloud Zuul无法摆脱servlet模型的弊端。
#### 8.1.4.3 Gateway模型
WebFlux是什么？[官方文档](https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#spring-webflux)
传统的Web框架，比如说: Struts2，SpringMVC等都是基于Servlet APl与Servlet容器基础之上运行的。
但是==在Servlet3.1之后有了异步非阻塞的支持==。而WebFlux是一个典型非阻塞异步的框架，它的核心是基于Reactor的相关API实现的。相对于传统的web框架来说，它可以运行在诸如Netty，Undertow及支持Servlet3.1的容器上。非阻塞式+函数式编程(Spring 5必须让你使用Java 8)。
Spring WebFlux是Spring 5.0 引入的新的响应式框架，区别于Spring MVC，它不需要依赖Servlet APl，它是完全异步非阻塞的，并且基于Reactor来实现响应式流规范。
## 8.2 三大核心概述
### 8.2.1 Route(路由)
路由是构建网关的基本模块，它由ID，目标URI，一系列的断言和过滤器组成，如果断言为true则匹配该路由
### 8.2.2 Predicate(断言)
参考的是java8的java.util.function.Predicate开发人员可以匹配HTTP请求中的所有内容（例如请求头或请求参数），如果请求与断言相匹配则进行路由
### 8.2.3 Filter(过滤)
指的是Spring框架中GatewayFilter的实例，使用过滤器，可以在请求被路由前或者之后对请求进行修改。
### 8.2.4 总体
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204234436.png)
## 8.3 Gateway工作流程
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220204234451.png)
客户端向Spring Cloud Gateway发出请求。然后再Gateway Handler Mapping中找到与请求相匹配的路由，将其发送给Gateway Web Handler。

Handler再通过指定的过滤链来将请求发送到我们实际的服务执行业务逻辑，然后返回。
过滤器之间用虚线分来是因为过滤器可能会在发送代理请求之前("pre")或之后("post")执行业务逻辑。

Filter在"pre"类型的过滤器可以做参数校验、权限校验，流量监控、日志输出、协议转换等，
在"post"类型的过滤器中可以做响应内容、响应头的修改、日志的输出、流量监控等有着非常重要的作用。
## 8.4 Gateway入门配置
### 8.4.1 创建gatewat-gateway9527模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206114940.png)
### 8.4.2 写POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-gateway-gateway9527</artifactId>  
  
 <dependencies>  
 <!--新增gateway-->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-gateway</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>1.0-SNAPSHOT</version>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
  
 </dependencies>   
</project>
```
### 8.4.3 写yml
```yml
server:  
  port: 9527  
  spring:  
  application:  
    name: cloud-gateway  
  
eureka:  
  instance:  
    hostname: cloud-gateway-service  
  client:  
    service-url:  
      register-with-eureka: true  
      fetch-registry: true  
      defaultZone: http://eureka7001.com:7001/eureka
```
### 8.4.4 主启动类
```java
@SpringBootApplication  
@EnableEurekaClient  
public class GateWayMain9527 {  
 public static void main(String[] args) {  
 SpringApplication.run( GateWayMain9527.class,args);  
 }  
}
```
### 8.4.5 网关如何做路由映射？
此时我们想要映射`provider-payment8001`服务，
我们观察8001服务下的controller，计划映射`/payment/get/{id}`和`/payment/lb`请求
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206121509.png)
那么我们需要在网关的配置文件中写如下配置
```yml
spring:  
  application:  
    name: cloud-gateway  
  cloud:  
    gateway:  
      routes:  
        - id: payment_routh #路由的ID，没有固定规则但要求唯一，建议配合服务名  
 uri: http://localhost:8001   #匹配后提供服务的路由地址  
 predicates:  
            - Path=/payment/get/**   #断言,路径相匹配的进行路由  
  
 - id: payment_routh2  
          uri: http://localhost:8001  
          predicates:  
            - Path=/payment/lb/**   #断言,路径相匹配的进行路由
```
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206121048.png)
### 8.4.6 启动测试
依次启动eureka7001、provider-payment8001、gateway9527
访问`eureka7001.com:7001`，确认8001服务和网关已注册进来
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206122213.png)
访问`localhost:8001/payment/get/3`，可以正常访问
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206122452.png)
当我们通过网关访问服务`localhost:9527/payment/get/3`，同样可以正常访问
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206122615.png)
**总结访问说明**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206122838.png)
### 8.4.7 Gateway网关路由有两种配置方式
第一种在配置文件yml中配置，如上文实例所展示的那样
第二种是在代码中注入`RouteLocator的Bean`
我们尝试做个例子，通过手动配置gateway，访问百度`http://news.baidu.com/guonei`
1、在9527下创建`GateWayConfig`配置类
```java
@Configuration  
public class GateWayConfig {  
 @Bean  
 public RouteLocator customRouterLocator(RouteLocatorBuilder routeLocatorBuilder){  
 RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();  
  
 // 映射http://news.baidu.com/guonei  
 routes.route("path_route_mrlqq", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();  
  
 return routes.build();  
 }  
}
```
2、重新启动9527服务，访问测试`http://localhost:9527/guonei`
发现可以跳转到百度新闻页面
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206124826.png)
## 8.5 通过微服务名实现动态路由
默认情况下Gateway会根据注册中心的服务列表，以注册中心上微服务名为路径创建==动态路由进行转发，从而实现动态路由的功能==
启动：一个eureka7001+两个服务提供者8001/8002
在Gateway9527的配置文件中添加如下配置
```xml
spring：
  cloud：
    gateway：
      locator：
        enabled: true # 开启从注册中心动态创建路由功能，利用微服务名进行路由
	routes：
	  - id: payment_routh
	  url: lb://cloud-payment-service # 匹配后提供服务的路由地址
```
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206144129.png)
启动测试，访问`http://localhost:9527/payment/lb`，就可以发现gateway会帮我们在8001/8002之间自动选择，实现负载均衡。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206144324.png)
## 8.6 Predicate的使用
当启动我们的gateway9527的时候，会发现控制台会输出如下信息：
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206144539.png)
我们之家在9527配置的时候，在配置项中写了关于preducates的配置，用于断言匹配我们要映射的请求。其中是使用`Path`路径的匹配方式
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206144919.png)
Spring Cloud Gateway常见Route对象时，使用RoutePredicateFactory擦黄阿金Predicate对象，Predicate对象可以赋值给Route。Spring Cloud Gateway包含许多内置的Route Predicate Factories。
一共提供了11个：
`After`、`Before`、`Between`、`Cookie`、`Header`、`Host`、`Method`、`Path`、`Query`、`RemoteAddr`、`Weight`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206145609.png)

### 8.6.3 常见的Route Rredicate
**1.After Route Predicate**
用来限定时间的，在Ater规定的时间之后访问的请求，才被路由
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206151002.png)
我们可以通过`ZonedDateTime.now();`方法获取跟上面的结构格式一样的时间戳
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206151148.png)
我们修改时间，测试在还没到规定时间的时候，访问是什么效果
在未到规定时间就访问的时候将无法路由，会报错。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206151400.png)

**2.Before Route Predicate**
跟上面的同理，在规定的时间之前访问才有效。超过规定时间将不再路由
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206151711.png)

**3.Between Route Predicate**
在规定的两个时间之间才进行路由，规定时间之外的请求不进行路由
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206151859.png)

**4. Cookie Route Predicate**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206152218.png)
Cookie Route Predicate需要两个参数，一个是Cookie name，一个是正则表达式。
路由规则会通过获取对应的Cookie name值和正则表达式去匹配，如果匹配上就会执行路由，如果没有匹配上则不执行。
我们在9527配置中加入 Cookie 断言
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206152417.png)
我们使用`curl`命令行工具测试`curl http://localhost:9527/payment/get/3`，此时我们没有按照要求写cookie，一定会出错，我们看一下执行结果：
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206152655.png)
当我们在curl语句后跟上了`--cookie "username=zzyy"`后，请求响应成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206153245.png)

**5. Header Route Predicate**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206154136.png)
跟上面的cookie类似，需要两个参数：一个属性名称，一个正则表达式，这个属性值和正则表达式匹配则执行。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206154350.png)
所以我们通过curl访问的时候后面应该跟上`-H "X-Request-Id:123"`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206154544.png)

**6.Host Route Predicate**
类似，需要再请求时添加上关于Host的相关内容
比如说`-Host=**.mrlqq.com`，意思就是需要我们在访问的时候必须要有`**.mrlqq.com`的host，`**`表示任意字符串，123.mrlqq.com、hao.mrlqq.com、…… 
所以在curl中需要加上`-H "Host:123.mrlqq.com"`
**7.Method Route Predicate**
添加 ` - Method=GET`
发GET的请求才进行路由
**8.Path Route Predicate**
最基本的，匹配路径
**9. Query Route Predicate**
两个参数：参数名，正则表达式
`  - Query=username, \d+ #要有参数名称并且是正整数才能路由`
访问的时候需要加上参数，例如`http://localhost:9527/payment/get/3?username=2`
**10.小总结**
说白了，Predicate就是为了实现一组匹配规则，让请求过来找到对应的Route进行处理

## 8.7 Filter的使用
### 8.7.1 什么时Filter
路由过滤器可以用于修改进入的HTTP请求和返回的HTTP响应，路由过滤器只能指定路由进行使用。
Spring Cloud Gateway内置了多种路由过滤器，他们都由GatewayFilter的工厂类来产生。

### 8.7.2 Spring Cloud Gateway的Filter
#### 8.7.2.1 生命周期
**pre**：在业务逻辑之前
**post**：在业务逻辑之后
#### 8.7.2.2 种类
**GatewayFilter单一**,官网31种之多
**GlobalFilter全局**，官网10个

### 8.7.3 自定义过滤器
主要实现两接口，`GlobalFilter`,`Ordered`
在9527下创建要给`MyLogGateWayFilter`过滤器
```java
@Component  
@Slf4j  
public class MyLogGateWayFilter implements GlobalFilter, Ordered {  
  
 /**  
 * 过滤请求，查看请求中的uname是否有效  
 * @param exchange  
 * @param chain  
 * @return  
 */  
 @Override  
 public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {  
 log.info("******come in MyLogGateWayFIlter:" + new Date());  
 String uname = exchange.getRequest().getQueryParams().getFirst("uname");  
 if (uname == null){  
 log.info("*****用户名为null，非法用户");  
 exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);  
 return exchange.getResponse().setComplete();  
 }  
 return chain.filter(exchange);  
 }  
  
 /**  
 * getOrder表示加载过滤器的顺序，越小优先级越高  
 */  
 @Override  
 public int getOrder() {  
 return 0;  
 }  
}
```
启动测试访问`localhost:9527/payment/get/3?uname=123`，发现访问成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206163443.png)
`localhost:9527/payment/lb?uname=34534`，发现访问成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206163527.png)
但是如果我访问的时候没有加uname请求参数的时候不会报错，
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206163648.png)
控制台也会根据我们是否写有效参数而打印出不同的日志
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206163749.png)

# 九、SpringCloud Config分布式配置中心
## 9.1 SpringCloud Config概述
官网：[Spring Cloud Config](https://cloud.spring.io/spring-cloud-static/spring-cloud-config/2.2.1.RELEASE/reference/html/)
### 9.1.1 分布式系统面临的配置问题
微服务意味着要将单体应用中的业务拆分成一个个子服务，每个服务的粒度相对较小，依次系统中会出现大量的服务。由于每个服务都需要必要的配置信息才能运行，所以一套集中式的、动态的配置管理设施是必不可少的。
SpringCloud提供了ConfigServer来解决这个问题，我们每一个微服务自己带着要给application.yml，上百个配置文件的管理会很费时。
### 9.1.2 SpringCloud Config是什么
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206170100.png)
SpringCloud Config微服务架构中的微服务提供集中化的配置支持，配置服务器为==各个不同微服务应用==的所有环境做出一个==中心化的外部配置==。
SpringCloud Config 分为==服务端==和==客户端==两部分
服务端也成为==分布式配置中心，它是一个独立的微服务应用，==用来连接配置服务器并为客户端提供获取配置信息，加密/解密信息等访问接口
客户端则是通过指定的配置中心来管理配置应用资源，以及与业务相关的配置内容，并在启动的时候从配置中心获取和加载配置信息，配置服务器默认采用git来存储配置信息，这样就有助于对环境配置进行版本管理，并且可以通过git客户端工具来方便的管理和访问配置内容。
### 9.1.3 SpringCloud Config能做什么
- 集中管理配置文件
- 不同环境不同配置，动态化的配置更新，分环境部署比如dev/test/prod/beta/release
- 运行期间动态调整配置，不再需要在每个服务部署的机器上编写配置文件，服务会向配置中心统一拉取配置自己的信息
- 当配置发生改变时，服务不需要重启即可感知到配置的变化并应用新的配置
- 将配置信息以REST接口的形式暴露，post、curl访问刷新均可...
### 9.1.4 与Github整合配置
由于SpringCloud Config默认使用Git来存储配置文件（也有其它方式，比如支持svn和本地文件，但最推荐的还是Git，而且使用的是http/https访问的形式）
## 9.2 Config服务端配置与测试
在github上创建一个`springcloud-config`仓库
然后clone到本地 
### 9.2.1 新建cloud-config-center-3344模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206172145.png)
### 9.2.2 POM
```
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-config-center-3344</artifactId>  
  
 <dependencies>  
  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-config-server</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
  
</project>
```
### 9.2.3 xml
```
server:  
  port: 3344  
spring:  
  application:  
    name: cloud-config-center #注册金eureka服务器的微服务名字  
 cloud:  
    config:  
      server:  
        git:  
          uri: https://github.com/MrLQQ/springcloud-config.git #Github上面的仓库地址  
 # 搜索目录  
 search-paths:  
            - springcloud-config  
      # 读取分支  
 label: master  
        
# 服务注册到eureka地址  
eureka:  
  client:  
    service-url:  
      defaultZone:  http://localhost:7001/eureka
```
### 9.2.4 主启动类
```java
@SpringBootApplication  
@EnableConfigServer  
public class ConfigCenterMain3344 {  
 public static void main(String[] args) {  
 SpringApplication.run(ConfigCenterMain3344.class, args);  
 }  
}
```
### 9.2.5 启动3344
注意修改window的host文件，加上`127.0.0.1 cibfug-3344.com`
访问`config-3344.com/master/config-div.yml`，访问成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206174709.png)
### 9.3.6 配置读取规则
官网提供了五种，但都大同小异，这里是简单的介绍三种
**第一种：/{label}/{application}-{profile}.yml（最推荐使用这种方式）**
*master分支：*
`http://config-3344.com:3344/master/config-dev.yml`
`http://config-3344.com:3344/master/config-test.yml`
`http://config-3344.com:3344/master/config-prod.yml`
*dev分支：*
`http://config-3344.com:3344/dev/config-dev.yml`
`http://config-3344.com:3344/dev/config-test.yml`
`http://config-3344.com:3344/dev/config-prod.yml`
**第二种：/{application}-{profile}.yml**
`http://config-3344.com:3344/config-dev.yml`
`http://config-3344.com:3344/config-test.yml`
`http://config-3344.com:3344/config-prod.yml`
`config-3344.com:3344/config-xxxx.yml(不存在的配置)`
**第三种：/{application}-{profile}[/{label}]**
`(http://config-3344.com:3344/config/dev/master`
`(http://config-3344.com:3344/config/test/master`
`(http://config-3344.com:3344/config/prod/master`
**重要配置细节总结**
```bash
/{name}-{profiles}.yml
/{label}-{name}-{profiles}.yml

label:分支(branch)
name:服务名
profiles:环境(dev/test/prod)
```
## 9.3 Config客户端配置与测试
### 9.3.1 新建cloud-config-client-3355模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206180034.png)
### 9.3.2 POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-config-client-3355</artifactId>  
  
 <dependencies>  
  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-config</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
</project>
```
### 9.3.3 bootstrap.yml
application.yml是用户级的资源配置项
bootstrap.yml是系统级的，==优先级更加高==

SpringCloud会创建一个`Bootstrap Context`，作为Spring应用的`Application Context`的==父上下文==。初始化的时候，`Bootstrap Context`负责从==外部源==加载配置属性并解析配置。这两个上下文共享一个从外部获取的`Environment`。
Bootstrap属性由高优先级，默认情况下，他们不会被本地配置覆盖。Bootstrap Context和Application Context有着不同的约定，所以新增了一个bootstrap.yml文件，保证Bootstrap Context和Application Context配置的分离。
==要将Client模块下的application.yml文件改为bootstrap.yml这是很关键的==，因为bootstrap.yml比application.yml先加载，bootstrap.yml优先级高于application.yml
```yml
server:  
  port: 3355  
  
spring:  
  application:  
    name: config-client  
  cloud:  
    # config客户但配置  
 config:  
      label: master # 分支名称  
 name: config  # 配置文件名称  
 profile: dev  # 读取后缀名名称 综合上述3个会读取config-dev.yml  
 uri: http://localhost:3344  # 配置中心地址  
eureka:  
  client:  
    service-url:  
      defaultZone: http://eureka7001.com:7001/eureka
```
### 9.3.4 主启动类
```java
@SpringBootApplication  
public class ConfigClientMain3355 {  
 public static void main(String[] args) {  
 SpringApplication.run(ConfigClientMain3355.class,args);  
 }  
}
```
### 9.3.5 业务类
```java]
@RestController  
public class ConfigClientController {  
  
 @Value("$(config.info)")  
 private String configInfo;  
  
 @GetMapping("/configInfo")  
 public String getConfigInfo() {  
 return configInfo;  
 }  
}
```
### 9.3.6 启动测试
通过3344访问`config-3344.com:3344/master/config-prod.yml`可以正常访问
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206182347.png)
现在通过3355客户端访问`localhost:3355/configinfo`，也可以正常访问
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206182821.png)
成功实现了客户端3355访问SpringCloud Config3344通过GitHub获取配置信息

### 9.3.7 小问题
Linux运维修改GitHub上的配置文件内容做调整
刷新3344，发现ConfigServer配置中心立刻响应
刷新3355，发现ConfigServer客户端没有任何响应
3355没有变化除非自己重启或者重新加载
难道每次运维修改配置文件，客户端都需要重启？？
## 9.4 Config客户端之动态刷新
避免每次更新配置都要重启客户端微服务3355
### 9.4.1 动态刷新
**修改3355模块**
1、POM引入actuator监控
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
2、修改xml，暴露监控端口
添加如下配置
```yml
management:  
  endpoints:  
    web:  
      exposure:  
        include: "*"
```
3、在业务类Controller上添加`@RefreshScope`注解
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206183920.png)

修改github上的配置，然后观察3344和3355是否更新
发现还没有更新…………
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206184849.png)

**怎么办?**
更改git后，需要发送Post请求`http://localhost:3355/actuator/refresh`
==需要运维人员发送Post请求刷新3355==（什么工具都可以只要能发POST请求就行）
可以使用curl工具`curl -X POST "http://localhost:3355/actuator/refresh"`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206194008.png)
我们再次访问`localhost:3355/configInfo`，就发现配置更新成功了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206194103.png)

> 假如有多个微服务客户端3355/3366/3377……，每个微服务都要执行一次post请求，手动刷新？可否广播，一次通知，处处生效？我们想大范围的自动刷新
> 那么就需要使用==**SpringCloud Bus消息总线**==
# 十、SpringCloud Bus消息总线
## 10.1 SpringCloud Bus概述
分布式自动刷新配置功能
Spring Cloud Bus配合Spring Cloud Config使用可以实现配置的动态刷新
### 10.1.1 SpringCloud Bus是什么
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206235001.png)
Spring Cloud Bus是用来将分布式系统的节点与轻量级信息系统链接起来的框架，
==它整合了Java的事件处理机制和消息中间件的功能。==
Spring Cloud Bus目前支持RabbitMQ和Kafka
### 10.1.2 SpringCloud Bus能做什么
Spring Cloud Bus能管理和传播分布式系统间的消息，就像一个分布式执行器，可用于广播状态更改、时间推送等，也可以当作微服务间的通信通道
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220206235218.png)
### 10.1.3 为何被称为总线
**什么是总线?**
在微服务架构的系统中，通常会使用==轻量级的消息代理==来构建一个==共用的消息主题==，并让系统中所有微服务实例都连接上来。由于==该主题中产生的消息会被所有实例监听和消费，所以称它为消息总线。==在消息总线的各个实例，都可以方便的广播一些需要让其他连接在该主题的实例都值得消息。

**基本原理**
ConfigClient实例都监听MQ中同一个topic(默认是SpringCloudBus)。当一个服务器刷新数据的时候，他会把这个信息放到Topic中，这样其他监听同一个Topic的服务就能得到通知，然后去更新自身的配置。

## 10.2 RabbitMQ环境配置
关于RabbitMQ的相关教程，欢迎访问我的个人博客：[RabbitMQ学习笔记 - MrLQQ's Blog](http://mrlqq.top/index.php/archives/rabbitmq.html)
安装成功后启动
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207003249.png)
## 10.3 SpringCloud Bus动态刷新全局广播
### 10.3.1 创建3366模块
为了延时广播效果，怎加复杂度，再以3355为模板再制作一个3366
创建cloud-config-client-3366模块
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207003511.png)
**pom**
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-config-client-3366</artifactId>  
  
 <dependencies>  
  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-config</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
</project>
```
**yml**
```yml
server:  
  port: 3366  
  
spring:  
  application:  
    name: config-client  
  cloud:  
    config:  
      label: master  
      name: config  
      profile: dev  
      uri: http://localhost:3344  
eureka:  
  client:  
    service-url:  
      defaultZone: http://eureka7001.com:7001/eureka  
management:  
  endpoints:  
    web:  
      exposure:  
        include: "*"
```
**主启动类**
```java
@SpringBootApplication  
@EnableEurekaClient
public class ConfigClientMain3366 {  
 public static void main(String[] args) {  
 SpringApplication.run( ConfigClientMain3366.class,args);  
 }  
}
```
**业务类**
```java
@RestController  
@RefreshScope  
public class ConfigClientController {  
  
 @Value("${server.port}")  
 private String serverPort;  
  
 @Value("${config.info}")  
 private String configInfo;  
  
 @GetMapping("/configInfo")  
 public String getConfigInfo(){  
 return "serverPort:"+serverPort+"\t\n\n configInfo: "+configInfo;  
 }  
}
```
### 10.3.2 设计思想
1、利用消息总线触发一个客户端/bus/refresh，而刷新所有客户端的配置
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207004832.png)

2、利用消息总线触发一个服务端ConfigServer的/bus/refresh端点，而刷新所有客户端的配置(更加推荐)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207005207.png)

**第二个架构显然更合适**
打破了微服务的职责单一性，因为微服务本身是业务模块，它本不应该承担配置刷新职责；
破坏了微服务各节点的对等性；
有一定的局限性。例如，微服务在迁移时，它的网络地址常常会发生变化，此时如果想要做到自动刷新，那就会增加更多的修改；
### 10.3.3 config-center-3344配置中心服务端添加消息总线支持
**在3344新增POM**
```xml
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207005548.png)
**在3344新增yml配置**
```yml
spring:  
  rabbitmq:  
    host: 8.126.9.12  
    port: 5672  
    username: guest  
    password: guest
  cloud:  
    stream:  
    # 在此处配置要绑定的rabbitmq的服务信息；  
      binders:  
        defaultRabbit: # 表示定义的名称，用于于binding整合  
          type: rabbit  # 消息组件类型  
      bindings: # 服务的整合处理  
        output: # 这个名字是一个通道的名称  
          destination: busExchange  # 表示要使用的Exchange名称定义  
          content-type: application/json  # 设置消息类型，本次为json  
          binder: defaultRabbit   # 设置要兵的消息服务的具体设置

management:
  endpoints:
    web:
      exposure:
        include: 'bus-refresh'
```
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207020048.png)
### 10.3.4 config-center-3355客户端添加消息总线支持
**在3355新增POM**
```xml
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```
**在3355新增yml配置**
```yml
spring:  
  rabbitmq:  
    host: 8.126.9.12  
    port: 5672  
    username: guest  
    password: guest
  cloud:  
    stream:  
    # 在此处配置要绑定的rabbitmq的服务信息；  
      binders:  
        defaultRabbit: # 表示定义的名称，用于于binding整合  
          type: rabbit  # 消息组件类型  
      bindings: # 服务的整合处理  
        output: # 这个名字是一个通道的名称  
          destination: busExchange  # 表示要使用的Exchange名称定义  
          content-type: application/json  # 设置消息类型，本次为json  
          binder: defaultRabbit   # 设置要兵的消息服务的具体设置
```
### 10.3.5 config-center-3366客户端添加消息总线支持
**在3366新增POM**
```xml
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```
**在3366新增yml配置**
```yml
spring:  
  rabbitmq:  
    host: 8.126.9.12  
    port: 5672  
    username: guest  
    password: guest
  cloud:  
    stream:  
    # 在此处配置要绑定的rabbitmq的服务信息；  
      binders:  
        defaultRabbit: # 表示定义的名称，用于于binding整合  
          type: rabbit  # 消息组件类型  
      bindings: # 服务的整合处理  
        output: # 这个名字是一个通道的名称  
          destination: busExchange  # 表示要使用的Exchange名称定义  
          content-type: application/json  # 设置消息类型，本次为json  
          binder: defaultRabbit   # 设置要兵的消息服务的具体设置

management:  
  endpoints:  
    web:  
      exposure:  
        include: "*"
```
### 10.3.6 测试
依次启动7001，3344，3355，3366
访问eureka7001查看是否全部注册成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207011507.png)

首先 修改Github上配置文件增加版本号
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207011649.png)

访问`config-3344.com:3344/master/config-dev.yml`，发现3344ConfigServer更改成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207011639.png)
访问`http://localhost:3355/configInfo`和`http://localhost:3366/configInfo`，发现没有变化，还是原来的版本号
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207011930.png)
最后我们只需要向3344发送POST请求`curl -X POST 'http://localhost:3344/actuator/bus-refresh'`，使3334做一次刷新，那么3344作为ConfigServer会使用SpringCloud Bus消息总线向3355、3366广播更新后的配置，来完成一处发送，处处更新的效果
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207015602.png)
发送POST请求后，重新刷新3355、3366页面，就会发现都更新成功了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207015733.png)

## 10.4 SpringCloud Bus动态刷新定点通知
如果不像全部通知，只想要顶点通知
比如*只通知3355，不通知3366*

>指定具体某一个实例生效而不是全部
==公式：http://localhost:配置中心的端口号/actuator/bus-refresh/{destination}==
/bus/refresh请求不再发送到具体的服务实例上，而是发给config server并通过destination参数类指定需要更新配置的服务或实例

**测试：只通知3355，不通知3366**
首先更改github的版本
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207020729.png)
访问`config-3344.com:3344/master/config-dev.yml`，发现3344ConfigServer更改成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207020831.png)
访问3355、3366，肯定都没成功，因为我们还没对3344发送POST请求
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207020956.png)
此时我们向3344发送POST请求`http://localhost:3344/actuator/bus-refresh/config-client:3355`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207021144.png)
发送完毕后，刷新请求页面，会发现3355更新了，而3366并没有变化
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207021316.png)
测试成功

**通知总结**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207021406.png)

# 十一、SpringCloud Stream消息驱动
## 11.1 消息驱动概述
官网:
[Spring Cloud Stream](https://spring.io/projects/spring-cloud-stream#overview)
[Spring Cloud Stream Reference Documentation](https://cloud.spring.io/spring-cloud-static/spring-cloud-stream/3.0.1.RELEASE/reference/html/)
[Spring Cloud Stream中文指导手册](https://m.wang1314.com/doc/webapp/topic/20971999.html)
### 11.1.1 消息驱动是什么
> 屏蔽底层消息中间件的差异，降低切换成本，统一消息的编程模型

官方定义Spring Cloud Stream是一个构建消息驱动微服务的框架.
应用程序通过inputs或者outputs来与Spring Cloud Stream中binder对象交互.
通过我们配置来binding(绑定),而Spring Cloud Stream的binder对象负责与消息中间件交互.
所以,我们只需要搞清楚如何与Spring Cloud Stream交互就可以方便使用消息驱动的方式.

通过使用Spring Integration来连接消息代理中间件以实现消息事件驱动.
Spring Cloud Stream为一些供应商的消息中间件产品提供了个性化的自动化配置实现,引入了发布-订阅,消费组,分区的三个核心概念.
### 11.1.2 消息驱动设计思想
#### 11.1.2.1 标准MQ
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207144015.png)
生产者/消费者之间靠消息媒介传递信息内容  =>  Message
消息必须走特定的通道  =>  消息通道MessageChannel
消息通道里的消息如何被消费呢，谁负责收发处理  =>  消息通道MessageChannel的子接口SubscribableChannel,由MessageHandler消息处理器订阅
#### 11.1.2.2 为什么用Cloud Stream
比方说我们用到了RabbitMQ和Kafka,由于这两个消息中间件的架构上的不同,
像RabbitMQ由exchange,kafka由Topic和Partitions分区
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207151941.png)
这些中间件的差异性导致我们实际项目开发给我们造成了一定困扰,我们如果用了两个消息队列的其中一种,后面的业务需求,我想往另外一种消息队列进行迁移,这时候无疑就是一个灾难性的,==一大堆东西都要推到重新做==,因为它跟我们的系统耦合了,这时候spring cloud stream给我们提供了一种解耦合的方式.

**stream凭什么可以统一底层差异**
在没有绑定器这个概念的情况下,我们的spring boot应用要直接与消息中间件进行信息交互的时候,
由于各消息中间件构建的初衷不同,他们的实现细节上会有较大的差异性
通过定义绑定器作为中间层,完美地是实现了==应用程序与消息中间件细节之间的隔离.==
通过向应用程序暴露统一的Channel通道,使得应用程序不需要在考虑各种不同的消息中间件实现.
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207152415.png)

**Binder**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207152821.png)
通过定义绑定器Binder作为中间层,实现了应用程序与消息中间件细节之间的隔离
==INPUT对应消费者==
==OUTPUT对应生产者==
#### 11.1.2.3 Stream中的消息通信方式遵循了发布-订阅模式
Topic主题进行广播
Topic在RabbitMQ种就是Exchange,在kafka种就是Topic
### 11.1.3 Spring Cloud Stream标准流程套路
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207153131.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207153137.png)

**Binder**
很方便的连接中间件，屏蔽差异
**Channel**
通道，是队列Queue的一种抽象，在消息通讯系统中就是实现存储和转发的媒介，通过对Channel对队列进行配置
**Source和Sink**
简单的可理解为参照对象是Spring Cloud Stream自身，从Stream发布消息就是输出，接受消息就是输入
### 11.1.4 编码API和常用注解
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207153611.png)

## 11.2 案例说明
首先需要 RabbitMQ环境已经安装配置好
之后创建三个模块:
cloud-stream-rabbitmq-provider8801,作为生产者进行发消息模块
cloud-stream-rabbitmq-consumer8802,作为消息接收模块
cloud-stream-rabbitmq-consumer8803,作为消息接收模块
## 11.3 消息驱动之生产者
新建cloud-stream-rabbitmq-provider8801模块
导出POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloud-stream-rabbitmq-provider8801</artifactId>  
  
 <dependencies>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-stream-rabbit</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-eureka-server -->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
  
 <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 
 </dependencies>  
  
</project>
```
写yml
```yml
server:
  port: 8801

spring:
  application:
    name: cloud-stream-provider
  cloud:
    stream:
      binders: # 在此处配置要绑定的rabbitmq的服务信息；
        defaultRabbit: # 表示定义的名称，用于于binding整合
          type: rabbit # 消息组件类型
          environment: # 设置rabbitmq的相关的环境配置
            spring:
              rabbitmq:
                host: localhost
                port: 5672
                username: guest
                password: guest
      bindings: # 服务的整合处理
        output: # 这个名字是一个通道的名称
          destination: studyExchange # 表示要使用的Exchange名称定义
          content-type: application/json # 设置消息类型，本次为json，文本则设置“text/plain”
          binder: defaultRabbit  # 设置要绑定的消息服务的具体设置

eureka:
  client: # 客户端进行Eureka注册的配置
    service-url:
      defaultZone: http://localhost:7001/eureka
  instance:
    lease-renewal-interval-in-seconds: 2 # 设置心跳的时间间隔（默认是30秒）
    lease-expiration-duration-in-seconds: 5 # 如果现在超过了5秒的间隔（默认是90秒）
    instance-id: send-8801.com  # 在信息列表时显示主机名称
    prefer-ip-address: true     # 访问的路径变为IP地址

```
主启动类 
业务类
创建一个`IMessageProvider`接口
```java
public interface IMessageProvider {  
 public String send();  
}
```
通过`MessageProviderImpl`实现该接口
```java
@EnableBinding(Source.class) //定义消息的推送管道  
public class MessageProviderImpl implements IMessageProvider {  
  
 /**  
 * 消息推送管道  
 */  
 @Resource  
 private MessageChannel output;  
  
 @Override  
 public String send() {  
 String serial = UUID.randomUUID().toString();  
 output.send(MessageBuilder.withPayload(serial).build());  
 System.out.println("*****serial:" + serial);  
 return null; }  
}
```
新建`SendMessageController`
```java
@RestController  
public class SendMessageController {  
  
 @Resource  
 private IMessageProvider messageProvider;  
  
 @GetMapping("/sendMessage")  
 public String sendMessage(){  
 return messageProvider.send();  
 }  
}
```
启动测试 
分别启动eureka7001、启动rabbitmq、启动8801
登录RabbitMQ`localhost:15672`，访问`localhost:8801/sendMessage`发送请求，会会发现控制台会输出信息，同时RabbitMQ也会显示
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207171254.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207171333.png)

## 11.4 消息驱动之消费者
新建cloud-stream-rabbitmq-consumer8802
写POM
写yml与上文都一样，注意需要更改端口号以及实例名称，还有bindings的名字，其余的都一样
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207171659.png)
主启动类
业务类
```java
@Component  
@EnableBinding(Sink.class)  
public class ReceiveMessageListenerController {  
  
 @Value("${server.port}")  
 private String serverPort;  
  
 @StreamListener(Sink.INPUT)  
 public void input(Message<String> message){  
 System.out.println("消费者1号，---->接收到的消息：" + message.getPayload() + "\t port:" + serverPort);  
 }  
}
```
启动8802测试
访问`localhost:8801/sendMessage`发送请求
观察8802控制台会发现已经接收到消息了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207173012.png)
同时查看RibbitMQ也发现又数据传送，同时也发现了绑定了新的通道
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207173056.png)

## 11.5 分组消费与持久化
复制8802出一个8803
启动运行
运行7001、8801、8802、8803
访问eureka查看是否注册注册功能
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207174702.png)
### 11.5.1 运行后两个问题
**出现重复消费问题**
**消息持久化问题**：消费者意外宕机又恢复后，会丢失未接受到数据
### 11.5.2 消费
发送`localhost:8801/sendMessage`请求后
发现8802/8803同时都收到了，存在重复消费问题
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207175021.png)
**说明**
比如在如下场景种，订单系统我们做集群部署，都会从RabbitMQ种获取订单信息，
那==如果一个订单同时被两个服务同时获取到==，那么就会造成数据错误，我们得避免这种情况。
这是==我们就可以使用Stream种的消息分组来解决==
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207175352.png)
注意在Stream中处于同一个group中的多个消费者是竞争关系，就能够保证消息只会被其中一个应用消费依次，
==*不同组是可以全面消费的(重复消费)=*=
==*同一组内会发生竞争关系，只有其中一个可以消费。*==
所以我们查看eureka会发现有两个通道，相当于两个分组，导致两个服务都会收到消息
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207175832.png)

### 11.5.3 分组
微服务应用放置于同一个group中，就能够保证消息只会被其中一个应用消费一次。不同的组是可以消费的，同一个组内会发生竞争关系，只有其中一个可以消费。
#### 11.5.3.1 自定义配置分组
分别修改8802为mrlqqA组、8803为mrlqqB组
修改8802yml
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207180549.png)
修改8803yml
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207180723.png)
重启服务之后，观察RibbitMQ的分组情况，发现已经分为了我们自定义的两个组了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207180844.png)
分布式微服务应用为了实现高可用和负载均衡，实际上都会部署多个实例
多数情况，生产者发送消息给某个具体微服务时只希望被消费一次，按照上面我们启动两个应用的例子，虽然他们同属于一个应用，但是这个消息出现了被重复消费两次的情况。为了解决这个问题，在Spirng Cloud Stream中提供了==消费组==的概念。
#### 11.5.3.2 自定义配置分为同一组
修改8002、8003到同一组（mrlqqA），修改yml
可以通过RabbitMQ看到A组有两个消费者
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207181455.png)
这次我们再次发送消息，观察是否存在重复消费。。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207181848.png)
我们发现了发出的消息，已经没有被重复消费了，而是被同一个组内的两个消费者轮询消费了！解决了上文中重复消费的问题！
### 11.5.4 持久化
如果我们没有配置分组，那么消费者宕机后又恢复后，就会丢失为被消费的消息。
我们做一个测试，我们将8802，8003的自定义分组配置删除，在8802、8803服务关闭的时候让8801发送消息，查看会发生什么效果？
消费者将什么也接收不到。因为我们没有配置自定分组的话，Stream会帮我们创建一个默认的分组，这个分组是一个临时分组，当服务器关闭后，那么RibbitMQ也将会删除这个分组
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207190931.png)

在配置分组的情况下意外宕机，RibbitMQ会保存我们这个分组，将消息存在队列中，待服务恢复后，再发给消费端，在重启服务后消费者依然会获取未消费的信息
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207185116.png)
所以要解决消息不持久化我们同样应该自定义分组配置，默认的分组是临时分组，宕机即删除。
# 十二、SpringCloud Sleuth分布式请求链路追踪
## 12.1 Sleuth概述
### 12.1.1 为什么会有这个技术？需要解决哪些问题?
在微服务框架中，一个由客户端发起的请求在后端系统中会经过多个不同的服务节点调用来协调产生最后的请求结果，每一个前端请求都会形成一个服务的分布式调用链路，链路中的任何一环出现高延时或错误都会引发整个请求最后的失败。
### 12.1.2 Sleuth是什么
[GitHub - spring-cloud/spring-cloud-sleuth: Distributed tracing for spring cloud](https://github.com/spring-cloud/spring-cloud-sleuth)
Spring Cloud Sleush提供了一套完整的服务跟踪的解决方案
在分布式系统中提供追踪解决方案并兼容在支持了zipkin
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207193555.png)

## 12.2 搭建链路监控
### 12.2.1 zipkin
SpringCloud从F版起已不需要自己构建Zipkin server了，只需要调用jar包即可
下载地址[zipkin-server-2.23.2-exec.jar](https://repo1.maven.org/maven2/io/zipkin/zipkin-server/2.23.2/zipkin-server-2.23.2-exec.jar)
下载成功后目录下执行`java -jar 文件名`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207194603.png)
运行成功后，访问控制台`http://localhost:9411/zipkin/`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207194740.png)
**完整调用链路**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207194831.png)
**上图简化**
一条链路通过Trace Id唯一标识，Span标识发起的请求信息，各span通过parent id关联起来
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207195017.png)
整个链路的依赖关系如下
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207195213.png)
Trace:类似于树结构的Span集合，表示一条调用链路，存在唯一标识
span:表示调用链路来源，通俗的理解span就是一次请求信息
### 测试效果
找到cloud-provider-payment8001，修改POM，添加zipkin依赖
```xml
<!--包含了sleuth+zipkin-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-zipkin</artifactId>
        </dependency>
```
添加一些yml配置
```yml
spring:  
  zipkin:  
    base-url: http://localhost:9411  
  sleuth:  
    sampler:  
      # 采样率值介于0-1之间，1则标识完全采集  
       probability: 1
```
业务类中添加一个简单的GetMapping
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207200420.png)
找到cloud-provider-payment8001，修改POM，添加zipkin依赖，与上文一样
修改yml，与上文相同
业务类中添加一个GetMapping
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207201124.png)
**启动测试**
启动7001，8001，80服务
访问`localhost/consumer/payment/zipkin`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207201325.png)
多次访问后开打zipkin的控制台`http://localhost:9411/zipkin/`查看是否有链路追踪信息
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207201635.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207201657.png)
已经追踪到了信息…………
# 十三、SpringCloud Alibaba入门简介
## 13.1 SpringCloud Alibaba概述
### 13.1.1 SpringCloud Alibaba是什么
官方文档：
[spring-cloud-alibaba/README-zh.md at 2.2.x · alibaba/spring-cloud-alibaba · GitHub](https://github.com/alibaba/spring-cloud-alibaba/blob/2.2.x/README-zh.md)
Spring Cloud Alibaba，他是有一些阿里巴巴的开源组件和云产品组成的。这个项目的是为了让大家所熟知的Spring框架，其优秀的设计模式和抽象理念，以给使用阿里巴巴产品的java开发者带来使用Spring Boot和Spring Cloud的更多便利。
### 13.1.2 SpringCloud Alibaba能干什么
- 服务降级限流：默认支持Servlet、Feign、RestTemplate、Dubbo和RocketMQ限流降级功能的接入，可以在运行时通过控制台实时修改限流降级规则，还支持查看限流降级Metrics监控。
- 服务注册与发现：适配Spring Cloud服务注册与发现标准，默认继承了Ribbon的支持
- 分布式配置管理：支持分布式系统中的外部化配置，配置更改时自动刷新。
- 消息驱动能力：基于Spring Cloud Stream为微服务应用构建消息驱动能力。
- 阿里云对象存储：阿里云提供的海量、安全、低成本、高可靠的云存储服务。支持在任何应用、任何事件、任何地点存储和访问任意类型的数据。
- 分布式任务调度：提供秒级、精准、高可靠、靠可用的定时（基于Cron表达式）任务调度服务。同时提供分布式的任务执行模型，比如网格任务。网格任务支持海量子任务均匀分配到所有Worker(schedulerx-clint)上执行。
### 13.1.3 SpringCloud Alibaba怎么用
- Sentinel：把流量作为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性。
- Nacos：一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。
- RocketMQ：一款开源的分布式消息系统，基于高可用分布式集群技术，提供低延时的、高可靠的消息发布与订阅服务。
- Dubbo：Apache Dubbo™ 是一款高性能 Java RPC 框架。
- Seata：阿里巴巴开源产品，一个易于使用的高性能微服务分布式事务解决方案。
- Alibaba Cloud ACM：一款在分布式架构环境中对应用配置进行集中管理和推送的应用配置中心产品。
- Alibaba Cloud OSS: 阿里云对象存储服务（Object Storage Service，简称 OSS），是阿里云提供的海量、安全、低成本、高可靠的云存储服务。您可以在任何应用、任何时间、任何地点存储和访问任意类型的数据。
- Alibaba Cloud SchedulerX: 阿里中间件团队开发的一款分布式任务调度产品，提供秒级、精准、高可靠、高可用的定时（基于 Cron 表达式）任务调度服务。
- Alibaba Cloud SMS: 覆盖全球的短信服务，友好、高效、智能的互联化通讯能力，帮助企业迅速搭建客户触达通道。

# 十四、SpringCloud Alibaba Nacos服务注册中心和配置中心
## 14.1 Nacos简介
前四个字母分别为Naming和Configuration的前两个字母，最后的s为Service
### 14.1.1 Nacos是什么
一个更易于构建云原生应用的动态服务发现，配置管理和服务管理中心
Nacos：Dynamic Naming and Configuration Service
Nacos就是注册中心+配置中心的组合
Nacos = Eureka+Config+Bus
### 14.1.2 Nacos能干什么
替代Eureka做服务注册中心
替代Config做服务配置中心
### 14.1.3 Nacos怎么用
[GitHub - alibaba/nacos](https://github.com/alibaba/Nacos)
官方文档：
[nacos.io](https://nacos.io/zh-cn/index.html)
[Spring Cloud Alibaba Reference Documentation](https://spring-cloud-alibaba-group.github.io/github-pages/greenwich/spring-cloud-alibaba.html#_spring_cloud_alibaba_nacos_discovery)
到官网下载Nacos

### 14.1.4 各种注册中心比较
| 服务注册与发现框架 | CAP模型 | 控制台管理 | 社区活跃度        |
| ------------------ | ------- | ---------- | ----------------- |
| Eureka             | AP      | 支持       | 底（2.x版本闭源） |
| Zookeeper          | CP      | 不支持     | 中                |
| Consul             | CP      | 支持       | 高                |
| Nacos              | AP      | 支持       | 高                |

据说Nacos在阿里云内部有超过10万的实例运行，已经过了类似双十一等各种大型流量的考验
## 14.2 安装并运行Nacos
本地Java8+Maven环境
先从官网现在Nacos,解压安装包
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207224314.png)
直接运行bin目录下的startup.cmd
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207224446.png)
启动服务出现`java.io.IOException: java.lang.IllegalArgumentException: db.num is null`报错的话，是由于nacos的启动脚本默认是集群的方式启动的。
需要使用单击方式启动
第一种方法：可以在启动时加上设置以实现单机启动`startup.cmd -m standalone`
第二种方法：需要修改`startup.cmd`脚本，将`set MODE="cluster"`修改为`set MODE="standalone"`，再次双击`startup.cmd`启动即可
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207225330.png)
两种方式哪一种都可以，最终启动成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207225436.png)
访问`http://127.0.0.1:8848/nacos`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207225506.png)
默认账户密码都是`nacos`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207225553.png)
## 14.3 Nacos作为服务注册中心演示
官方文档：[Spring Cloud Alibaba Reference Documentation](https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/en-us/index.html)
### 14.3.1 基于Nacos的服务提供者
新建cloudalibaba-provider-payment9001模块
写POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloudalibaba-provider-payment9001</artifactId>  
  
 <dependencies>  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
</project>
```
写yml
```yml
server:  
  port: 9001  
  
spring:  
  application:  
    name: nacos-payment-provider  
  cloud:  
    nacos:  
      discovery:  
        server-addr: localhost:8848 #配置Nacos地址  
  
management:  
  endpoints:  
    web:  
      exposure:  
        include: '*'
```
主启动类
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207231248.png)
业务类PaymentController
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207231256.png)
启动nacos8843、启动9001服务，查看nacos是否注册成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207231518.png)
服务注册成功

为了下一章节nacos的负载均衡，参照9001新建9002，然后启动9002注册进nacos
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207232338.png)
### 14.3.2 基于Nacos的服务消费者
新建cloudalibaba-consumer-nacos-order83模块
写POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloudalibaba-consumer-nacos-order83</artifactId>  
  
 <dependencies>  
 <!--SpringCloud ailibaba nacos -->  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
</project>
```
写yml
```yml
server:
  port: 83

spring:
  application:
    name: nacos-order-consumer
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
		
#消费者将要去访问的微服务名称(注册成功进nacos的微服务提供者)
service-url:
  nacos-user-service: http://nacos-payment-provider
```
主启动类
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207234126.png)
业务类（可以整合Feign）
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207234513.png)
**运行测试**
运行8848、9001、9002、83
访问`localhost:83/consumer/payment/nacos/3`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207234646.png)
多次刷新也可以看出nacos也为我们提供了负载均衡（轮询式）
### 14.3.3 服务注册中心对比
**各种注册中心对比**
- Nacos全景图所示
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207234946.png)
- Nacos和CAP
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207235003.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220207235010.png)
- Nacos切换AP模式和CP模式
C是所有节点在同一时间看到的数据是一致的，而A的定义是所有的请求都会收到响应。
*何时选择何种模式？*
一般来说，
如果不需要存储服务级别的信息且服务实例是通过nacos-client注册，并能够保持心跳上报，那么就可以选择AP模式。当前主流的服务如Spring Cloud和Dubbo服务，都是用于AP模式，AP模式为了服务的可能性而减弱了一致性，因此AP模式下只支持注册临时实例。
如果需要在服务级别编辑或者存储配置信息，那么CP是必须的，K8S服务和DNS服务则适用于CP模式。
CP模式下则支持注册持久化实例，此时则是以Raft协议为集群运行模式，该模式下注册实例之前必须先注册服务，如果服务不存在，则会返回错误。
`curl -X PUT '$NACOS_SERVER:8848/nacos/v1/ns/operator/switches?entry=serverMode&value=CP'`

## 14.4 Nacos作为服务配置中心演示
### 14.4.1 Nacos作为配置中心-基础配置
创建cloudalibaba-config-nacos-client3377模块
写POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloudalibaba-config-nacos-client3377</artifactId>  
  
 <dependencies>  
 <!--nacos-config-->  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>  
 </dependency>  
 <!--nacos-discovery-->  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>  
 </dependency>  
 <!--web + actuator-->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
 <!--一般基础配置-->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
</project>
```
写yml，创建两个配置文件，分别为application.yml、bootstrap.yml
因为Nocos同Spring Cloud Config一样，在项目初始化时，要保证先从配置中心进行配置拉取，拉取配置之后，才能保证项目的正常启动。
SpringBoot中配置文件的加载是存在优先级顺序的，bootstrap优先级高于application
bootstrap.yml
```yml
server:
  port: 3377

spring:
  application:
    name: nacos-config-client
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848 #服务注册中心地址
      config:
        server-addr: localhost:8848 #配置中心地址
        file-extension: yaml #指定yaml格式的配置

```
application.yml
```yml
spring:
  profiles:
    active: dev
```
主启动类
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208142449.png)
业务类,创建ConfigClientController
通过Spring Cloud原生注解`@RefreshScope`实现配置自动更新
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208142628.png)
#### Nacos中添加配置信息
Nacos中的配置规则：
Nacos中的dataid的组成格式与SpringBoot配置文件中的匹配规则
官网：[Nacos Spring Cloud 快速开始](https://nacos.io/zh-cn/docs/quick-start-spring-cloud.html)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208143108.png)
最后公式：`${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}`
所以通过上文我们yml中配置的信息从而拼接处需要的文件名`nacos-config-client-dev.yaml`
在Nacos中新增配置`nacos-config-client-dev.yaml`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208144047.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208144256.png)
**总结**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208144739.png)

#### 运行测试
启动3377，访问`localhost:3377/config/info`，已经能够从Nacos配置中心取得配置了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208144619.png)
此时修改以下Nacos中的yaml配置文件
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208144917.png)
再次刷新3377的请求，发现配置数据也同步更新了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208144940.png)
Nacos不需要我们重启服务，会动态刷新
### 14.4.2 Nacos作为配置中心-分类配置
**多环境多项目管理**
*问题1：*
实际开发中，通常一个系统会准备dev开发环境、test测试环境、prod生产环境。
如何保证指定环境启动时服务能正确读取到Nacos上对应环境的配置文件呢。
*问题2：*
一个大型分布式微服务系统会有很多为微服务子项目，每个微服务项目有都会有对应的开发环境、测试环境、预发环境、正式环境……
那怎样对这些微服务配置进行管理呢？
**Nacos的图形化管理界面**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208145410.png)
命名空间
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208145528.png)
#### Namespace+Group+Data ID三者关系？为什么这样设计?
1、是什么
分类设计思想类似于Java里面的package名和类名
最外层的namespace是可以用于分区部署环境的，Group和DataID逻辑上区分两个目标对象。
2、三者情况
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208145846.png)
==默认情况：Namespace=public，Group=DEFAULT_CROUP，默认Cluster是DEFAULT==
Nacos默认的命名空间是public，Namespace主要用来实现隔离。
比方说我们现在有三个环境：开发、测试、生产环境，我们就可以创建三个Namespace，不同的Namespace之间是隔离的。
Group默认是DEFAULT_GROUP，Group可以把不同的微服务划分到同一个分组里面去
Service就是微服务；一个Service可以包含多个Cluster（集群），
Nacos默认Cluster是DEFAULT，Cluster是对指定微服务的一个虚拟划分。
比方说为了容灾，将Service微服务分别部署在杭州机房和广州机房，这时就可以给杭州机房的Service微服务起一个集群名称（HZ），给广州机房的Service微服务起一个集群名称（GZ），还可以尽量让同一个机房的微服务互相调用，以提升性能。
最后是Instance，就是微服务的实例。
### Case
#### DataID方案
指定spring.profile.active和配置文件的DataID来使不同环境下读取不同的配置
默认空间+默认分组+新建dev和test两个DataID：
新建dev配置DataID和test配置DateID
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208151453.png)
通过spring.profile.active属性就能进行多环境下配置文件的的读取
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208152002.png)
重启测试，`http://localhost:3377/config/info`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208152123.png)

#### Group方案
通过Group实现环境区分
新建Group，`TEST_GROUP`和`DEV_GROUP`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208152421.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208152545.png)
在config下增加一条group的配置即可。可配置为DEV_GROUP或TEST_GROUP
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208152848.png)
重启测试，访问`http://localhost:3377/config/info`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208152921.png)
我们修改配置文件的分组为`DEV_GROUP`后再次重启访问，同样随配置发生了改变
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208153057.png)

#### Namespace方案
新建dev/test的Namespace
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208153251.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208153300.png)
回到服务管理-服务列表，发现刚才创建的两个命名空间都显示出来了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208153446.png)
按照域名配置填写
我们以dev命名空间为例，首先复制dev命名空间的id
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208153835.png)
然后在3377的bootstrap.yml配置文件名添加`spring.cloud.nacos.config.namespace`配置，以及applicaton.yml配置文件的`spring.profile.actives`为dev
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208153958.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208154115.png)
在nacos上==dev命名空间==下创建一个==默认分组==的新的==dev配置==
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208154347.png)
然后在nacos上==dev命名空间==下再创建一个==DEV_GROUP分组==的==dev配置==，和==TEST_GROUP分组==的==dev配置==
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208155002.png)
在相同的命名空间下创建了不同组的同名配置。
比如说我们要访问dev命名空间下DEV_GROUP分组中的dev环境就修改3377对应的配置信息
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208155353.png)
重启测试，访问`http://localhost:3377/config/info`，成功访问到目标的配置文件
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208155555.png)
访问其他命名空间的不同分组下的不同配置文件同理操作
## 14.5 Nacos集群和持久化配置
### 14.5.1官网说明
官网：[集群部署说明](https://nacos.io/zh-cn/docs/cluster-mode-quick-start.html)
官网架构图
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208155845.png)
实际情况
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208160203.png)
**说明**
默认Nacos使用嵌入式数据库实现数据的存储。所以，如果启动多个默认配置下的Nacos节点，数据存储是存在一致性问题的。
为了解决这个问题，Nacos采用了==集中式存储的方式来支持集群化部署，目前只支持MySQL的存储==
[Nacos支持三种部署模式](https://nacos.io/zh-cn/docs/deployment.html)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208161446.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208161639.png)

### 14.5.2 Nacos持久化配置解释
Nacos默认自带的是嵌入式数据库derby，可以通过查看Nacos源码中的POM证明
[nacos/pom.xml at develop · alibaba/nacos · GitHub](https://github.com/alibaba/nacos/blob/develop/config/pom.xml)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208161959.png)
#### derby到mysql切换配置步骤
再noacs服务服务下`\nacos\conf`目录下找到sql脚本`nacos-mysql.sql`
再mysql数据库中执行该脚本
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208162526.png)
然后`\nacos\conf`目录下找到application.properties，按照自己mysql数据库进行配置
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208163040.png)
然后重启Nacos，重新登录后，发现之前做过的一些配置全都消失了，因为我们原本的数据是存在Nacos内置的derby数据库中。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208163120.png)

### 14.5.3 Linux版Nacos+MySQL生产环境配置
需要一个nginx+3个nacos注册中心+1个mysql
首先下载Nacos下载linux版本：[nacos-server-1.4.3.tar.gz](https://github.com/alibaba/nacos/releases/download/1.4.3/nacos-server-1.4.3.tar.gz)
再linxu解压`tar -zxvf nacos-server-1.4.3.tar.gz`
#### 集群配置步骤
首先在服务器执行nacos为我们提供的sql脚本，我们在mysql中执行，得到一些nacos需要的用到的表
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208170633.png)
然后跟再windows中一样，修改properties文件，将数据库改正我们自己的mysql
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208171047.png)
在`cluster.conf`做3333，4444，5555集群配置
首先在linux上执行`hostname -i`获得本机的ip
然后再`cluster.conf`上进行相应的配置
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220208232404.png)
编辑Nacos的启动脚本startup.sh，`/mynacos/nacos/bin`目录下有`startup.sh`，
将启动的内存调小
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210195012.png)
Xms 是指设定程序启动时占用内存大小
Xmx 是指设定程序运行期间最大可占用的内存大小
Xmn 新生代的大小
我们调整一下三个值的大小，依次为64m、64m、40m，然后保存退出

之后返回nacos的上级目录，复制出三个nacos出来，便于之后启动三个nacos作为集群
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210195504.png)
启动三个nacos
然后，修改nginx，通过监听1111端口，代理到我们刚才启动的三台nacos上
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210200815.png)
`./nginx -s reload`重新加载nginx后，
我们访问`8.136.9.12:1111/nacos`，我们访问1111端口，nginx会自动帮我们代理到nacos集群中
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210201110.png)

我们在nacos集群中，创建一个简单的配置
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210201407.png)
然后在linux的mysql数据库中，查询nacos_config数据中的`config_info`表中是否存在我们刚在创建的配置文件
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210201540.png)
至此，我们全部的配置完成。

#### 测试
我们将cloudalibaba-provider-payment9002启动注册进nacos集群
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210201853.png)
看nacos1111的服务列表：
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210211458.png)
服务注册成功

#### 小总结
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210211745.png)

# 十五、SpringCloud Alibaba Sentinel实现熔断与限流
官网：[GitHub - alibaba/Sentinel: A powerful flow control component enabling reliability, resilience and monitoring for microservices. (面向云原生微服务的高可用流控防护组件)](https://github.com/alibaba/Sentinel)’’
中文：[介绍 · alibaba/Sentinel Wiki · GitHub](https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D)
## 15.1 Sentinel概述
### 15.1 Sentinel是什么
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210212531.png)
一句话解释，之前我们学的Hystrix
### 15.2 Sentinel能做什么
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210212744.png)
### 15.3 下载
下载：[Releases · alibaba/Sentinel · GitHub](https://github.com/alibaba/Sentinel/releases)
### 15.4 怎么用
[Spring Cloud Alibaba Reference Documentation](https://spring-cloud-alibaba-group.github.io/github-pages/greenwich/spring-cloud-alibaba.html#_spring_cloud_alibaba_sentinel)
**服务使用中的各种问题**
- 服务雪崩
- 服务降级
- 服务熔断
- 服务限流
## 15.2 安装Sentinel控制台
Sentinel组件由2部分组成：
- 核心库（Java客户端）不依赖任何框架/库，能够运行于所有java运行时环境，同时对Dubbo/Spring Cloud等框架也有较好的支持。
- 控制台（Dashboard）基于Spring Boot开发，打包后可以直接运行，不需要额外的Tomcat等应用容器。
**安装步骤**：
1、下载Sentinel的Jar包
2、保证java8环境ok，8080端口不能被占用，运行`java -jar sentinel.jaar`
3、访问Sentinel管理界面`localhost:8080`，默认用户名密码都是`sentinel`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210213950.png)
登录成功
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210214056.png)

## 15.3 初始化演示工程
启动Nacos8848
创建cloudalibaba-sentinel-service8401模块
POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloudalibaba-sentinel-service8401</artifactId>  
  
 <dependencies>  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>com.alibaba.csp</groupId>  
 <artifactId>sentinel-datasource-nacos</artifactId>  
 </dependency>  
 <dependency> <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>  
 </dependency>  
 <dependency> <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-openfeign</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>cn.hutool</groupId>  
 <artifactId>hutool-all</artifactId>  
 <version>4.6.3</version>  
 </dependency>  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
  
 </dependencies>  
  
</project>
```
写yml
```xml
server:
  port: 8401

spring:
  application:
    name: cloudalibaba-sentinel-service
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
    sentinel:
      transport:
        dashboard: localhost:8080
        port: 8719  #默认8719，假如被占用了会自动从8719开始依次+1扫描。直至找到未被占用的端口

management:
  endpoints:
    web:
      exposure:
        include: '*'
```
主启动类
```java
@EnableDiscoveryClient  
@SpringBootApplication  
public class MainApp8401  
{  
 public static void main(String[] args) {  
 SpringApplication.run(MainApp8401.class, args);  
 }  
}
```

启动8080 查看Sentinel，发现什么也没有
Sentinel采用的时懒加载，我们需要执行依次访问即可`localhost:8401/testA`、`localhost:8401/testB`
再次刷新Sentinel，就会发现服务了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210215607.png)

## 15.4 流控规则
### 15.4.1 基本介绍
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210220239.png)
- 资源名：唯一名称，默认请求路径
- 针对来源：Sentinel可以针对调用者进行限流，填写微服务名，默认default(不区分来源)
- 阈值类型/单击阈值：
	- QPS（每秒钟的请求数量）：当调用该api的QPS达到阈值的时候，进行限流
	- 线程数：当调用该api的线程数达到阈值时，进行限流。
- 是否集群：不需要集群
- 流控模式：
	- 直接：api达到了限流的条件时，直接限流
	- 关联：当关联的资源达到阈值时，就限流自己
	- 链路：只记录指定链路上的流量（指定资源从入口资源进来的流量，如果达到阈值，就进行限流）【api级别的针对来源】
- 流控效果：
	- 快速失败：直接失败，抛异常
	- Warm up：根据codeFactor(冷加载因子，默认3)的值，从阈值/codeFactor，经过预热时长，才达到设置的QPS阈值
	- 排队等待：匀速排队，让请求以均匀的速度通过，阈值类型必须设置为QPS，否则无效
### 15.4.2 流控模式
#### 直接(默认)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210221436.png)
表示`1`秒钟只能访问一次，当超过的时候，就`直接`限流。
所以当我们多次刷新`localhost:8401/testA`请求的时候，页面会显示
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210221801.png)
那么有没有fallback的方法呢？

#### 关联
当关联的资源达到阈值时，就限流自己
实现：当与A关联的资源B达到阈值后，就限流自己
**设置效果**
当/testB的QPS阈值超过1的时候，就限流/testA的REST访问地址
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210223122.png)
测试，启动postman，让postman循环发送testB请求
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210223626.png)
当postman运行后，我们访问testA请求，就会发现testA被限流了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210223738.png)

#### 链路


### 15.4.3 流控效果
1、直接->快速失败(默认的流控处理)
直接失败，抛出异常 `Blocked by Sentinel (flow limiting)`
源码`com.alibaba.csp.sentinel.slots.block.flow.controller.DefaultController`

2、预热
公式：阈值除以coldFactor(默认值3)，经过预热时长后才会达到阈值
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210225709.png)
默认coldFactor为3，即请求QPS从threshold/3开始，经预热时长逐渐升至设定的QPS阈值。
限流 冷启动：[Sentinel/wiki/限流---冷启动](https://github.com/alibaba/Sentinel/wiki/%E9%99%90%E6%B5%81---%E5%86%B7%E5%90%AF%E5%8A%A8)
源码`com.alibaba.csp.sentinel.slots.block.flow.controller.WarmUpController`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210230133.png)

WarmUp配置：
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210230210.png)
配置完成访问 testB时前几秒是没到10的QPS的，此时testB会返回限流
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210230547.png)
但当经过5秒后，QPS阈值达到了10，我们再次点击(频率在10次/秒以内)就不会显示限流
**应用场景**：
如：秒杀系统在开启的瞬间，会有很多流量上来，系统很可能会崩溃，预热方式就是为了保护系统，可以慢慢的把流量放进来，慢慢的把阈值增长到设置的阈值。

3、排队等待
匀速排队，阈值必须设置为QPS
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210230925.png)
这种方式主要用于处理突发的流量，例如消息队列。想象一下这样的场景，在某一秒有大量的请求到来，而接下来的几秒则处于空闲状态，我们希望系统能够在接下来的空闲期间逐渐处理这些请求，而不是在第一秒直接拒绝多余的请求。
源码：`com.alibaba.csp.sentinel.slots.block.flow.controller.RateLimiterController`
设置
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210231353.png)
在testB的GetMapping中打印一个日志，每当由请求进来，就打印一次，便于观察
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210231700.png)
用postman发出10个testB的请求，每秒一个，观察控制台输出
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210231751.png)

## 15.5 降级规则
### 降级规则说明
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210232445.png)
**RT(平均响应时间，秒级)**
	平均响应时间，超出阈值 且 在时间窗口内通过发请求>=5,两个条件同时满足后触发降级
	窗口期过后关闭断路器
	RT最大4900(更大的需要通过`-Dscp.sentinel.statistic.max.rt=XXX`，才能生效)
**异常比例（秒级）**
QPS>=5且异常比例(秒级统计)超过阈值时，触发降级；时间窗口结束后，关闭降级
**异常数（分钟级）**
异常数（分钟统计）超过阈值时，触发降级；时间窗口结束后，关闭降级。

Sentinel熔断降级会在调用链路中某个资源出现不稳定状态时（例如调用超时或异常比例升高），对这个资源的调用进行限制，让请求快速失败，避免影响到其他的资源而导致级联错误。
当资源被降级后，在接下来的时间窗口内，对该资源的调用都自动熔断(默认行是爆出DegradeException)。

==Sentinel的断路器是没有半开状态的==

### 降级策略实战
#### RT
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210233649.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210233604.png)
**代码**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210233928.png)
**配置**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210234219.png)
**测试**
我们用Jmter以10次/秒 循环向testD发送请求，此时我们访问testD请求就会发现被限流了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220210234802.png)

#### 异常比例
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211132202.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211132238.png)
在代码中故意设置异常代码
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211132445.png)
添加熔断规则
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211132535.png)
测试，使用jmeter向testD循环发送请求，然后手动访问testD请求，发现已经被熔断限流
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211132742.png)
然后停止jmeter，过一段时间，再次访问testD请求，发现断路器关闭了，正常访问了testD请求，但返回页面还是报错，是因为我们刚才故意更改了异常代码，所以正常访问一定会报错。

#### 异常数
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211133131.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211133138.png)
异常数是按照分钟统计的
在代码中写一个异常请求testE
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211133342.png)
设置熔断规则
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211133706.png)
测试，多次访问testE，当异常达到设置的阈值时，就会被熔断降级
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211133741.png)

## 15.6 热点key限流
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211133906.png)
官网：[Sentinel/wiki/热点参数限流](https://github.com/alibaba/Sentinel/wiki/热点参数限流)

之前由fallback的兜底方法，分为系统默认和客户自定义两种，
之前的case，限流出问题后，都是用sentinel系统默认的提示：blocked by Sentinel(flow limiting)
那么我们能不能自定义?类似Hystrix，某个方法出问题了，就找对应的兜底降级方法？

现在，我们可以使用`@SentinelResource`来替代`HystrixCommand`。
代码：
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211140426.png)
                                                                                                                                                                    
规则配置，参数索引是0，表示请求中的起一个参数，也就是p1，现在p1就变成了热点数据，p1数据请求达到阈值的时候，就会走我们上面写的兜底方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211135551.png)
测试，`testHotKey?p1=a`，后见跟上p1参数的请求，当访问没有达到设置的阈值的时候可以正常访问，一旦我们快速点击，访问频率超多了上面设置的阈值，就不会正常执行请求了，而是走我们的兜底方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211151221.png)
**特殊规则**
我们期望p1参数当它是某个特殊值时，它的限流值和平时不一样
假如当p1的值等于5时，它的阈值可以达到200
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211151829.png)
修改规则
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211151938.png)
测试，当我们testHotkey请求的p1参数为其他值的时候正常被限流
但当p1为5的时候则永远不被限流，正常通过
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211152130.png)

如果我们的代码里有异常，`@SentinelResource`则不会走都兜底方法
`@SentinelResource`处理的是Sentinel控制台配置的违规情况，有blockHandler方法配置的兜底处理。
`@SentinelResource主管配置出错，运行出错该走异常走异常`。

## 15.7 系统规则
官网：[Sentinel/wiki/系统自适应限流](https://github.com/alibaba/Sentinel/wiki/%E7%B3%BB%E7%BB%9F%E8%87%AA%E9%80%82%E5%BA%94%E9%99%90%E6%B5%81)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211152544.png)
-   **Load 自适应**（仅对 Linux/Unix-like 机器生效）：系统的 load1 作为启发指标，进行自适应系统保护。当系统 load1 超过设定的启发值，且系统当前的并发线程数超过估算的系统容量时才会触发系统保护（BBR 阶段）。系统容量由系统的 `maxQps * minRt` 估算得出。设定参考值一般是 `CPU cores * 2.5`。
-   **CPU usage**（1.5.0+ 版本）：当系统 CPU 使用率超过阈值即触发系统保护（取值范围 0.0-1.0），比较灵敏。
-   **平均 RT**：当单台机器上所有入口流量的平均 RT 达到阈值即触发系统保护，单位是毫秒。
-   **并发线程数**：当单台机器上所有入口流量的并发线程数达到阈值即触发系统保护。
-   **入口 QPS**：当单台机器上所有入口流量的 QPS 达到阈值即触发系统保护。

配置全局QPS
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211153044.png)
此时配置完成后，我们服务中，不论哪一个请求，只要QPS达到阈值，就会被限流。
## 15.8 @SentinelResource
### 15.8.1 按资源名称限流+后续处理
启动Nacos、Sentinel
修改8401模块
添加新的业务类`RateLimitController`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211153812.png)
新增流控规则
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211154117.png)
byResource的请求QPS超过1就限流
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211154143.png)
那么此时关闭微服务8401会怎么样？
服务停止后，我们再次刷新Sentinel的流控规则页面，发现刚刚设置的流控规则消失了，证明是Sentinel流控规则是临时的不是持久的
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211154312.png)

### 15.8.2 按照url地址限流+后续处理
新增`RateLimitController`业务类的方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211154651.png)
Sentinel控制台配置
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211154851.png)
然后我们访问/rateLimit/byUrl请求，连续访问，超过QPS后，会自动限流，此时由于我们自己没有写自定义的兜底方法，所以走了系统默认的方法页面
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211154916.png)

### 15.8.3 上面兜底方法面临的问题
1、系统默认的方法，没有体现哦我们自己的业务要求
2、依照现有条件，我们自定义的处理方法又和业务代码耦合在一起，不直观。
3、每个业务都要添加一个兜底的方法，那代码膨胀加剧。
4、全局统一的处理方法没有体现。
### 15.8.4 客户自定义限流处理逻辑
创建一个`customerBlockHandler`类用来自定义限流处理逻辑
```java
public class CustomerBlockHandler {  
 public static CommonResult handlerException(BlockException exception){  
 return new CommonResult<>(444,"按客户自定义,global handlerException-----1");  
 }  
  
 public static CommonResult handlerException2(BlockException exception){  
 return new CommonResult<>(444,"按客户自定义,global handlerException-----2");  
 }  
  
}
```
在RateLimitController添加一个新方法，在方法的SentinelResource注解中，我们先不写兜底方法
```java
@GetMapping("/rateLimit/byUrCustomerBlockHandler")  
@SentinelResource(value = "CustomerBlockHandler")  
public CommonResult CustomerBlockHandler()  
{  
 return new CommonResult(200,"按客户自定义",new Payment(2020L,"serial002"));  
}
```
当我们的customerBlockHandler和创建完成后，我们就只需要在controller的`SentinelResource`注解中添加指定我们自定义的兜底方法了，首先使用`blockHandlerClass`属性来指定兜底方法来自于哪个类。然后使用`blockHandler`属性指定该类中的哪个方法。
比如说我们要使用customerBlockHandler类中handlerException2方法，就是这样
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211160524.png)
重启服务后先调用一次，然后在Sentinel控制台配置限流规则
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211160649.png)
然后测试请求超过QPS后，观察限流的兜底方法走到是哪一个
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211160706.png)
测试的出，兜底方法走的即使我们指定类中的指定方法。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211160818.png)
至此也将兜底方法和任务类进行了解耦

### 15.8.5 更多注解属性说明
> 注意：注解方式埋点不支持 private 方法。

`@SentinelResource` 用于定义资源，并提供可选的异常处理和 fallback 配置项。 `@SentinelResource` 注解包含以下属性：

-   `value`：资源名称，必需项（不能为空）
-   `entryType`：entry 类型，可选项（默认为 `EntryType.OUT`）
-   `blockHandler` / `blockHandlerClass`: `blockHandler` 对应处理 `BlockException` 的函数名称，可选项。blockHandler 函数访问范围需要是 `public`，返回类型需要与原方法相匹配，参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 `BlockException`。blockHandler 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 `blockHandlerClass` 为对应的类的 `Class` 对象，注意对应的函数必需为 static 函数，否则无法解析。
-   `fallback` / `fallbackClass`：fallback 函数名称，可选项，用于在抛出异常的时候提供 fallback 处理逻辑。fallback 函数可以针对所有类型的异常（除了 `exceptionsToIgnore` 里面排除掉的异常类型）进行处理。fallback 函数签名和位置要求：
    -   返回值类型必须与原函数返回值类型一致；
    -   方法参数列表需要和原函数一致，或者可以额外多一个 `Throwable` 类型的参数用于接收对应的异常。
    -   fallback 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 `fallbackClass` 为对应的类的 `Class` 对象，注意对应的函数必需为 static 函数，否则无法解析。
-   `defaultFallback`（since 1.6.0）：默认的 fallback 函数名称，可选项，通常用于通用的 fallback 逻辑（即可以用于很多服务或方法）。默认 fallback 函数可以针对所有类型的异常（除了 `exceptionsToIgnore` 里面排除掉的异常类型）进行处理。若同时配置了 fallback 和 defaultFallback，则只有 fallback 会生效。defaultFallback 函数签名要求：
    -   返回值类型必须与原函数返回值类型一致；
    -   方法参数列表需要为空，或者可以额外多一个 `Throwable` 类型的参数用于接收对应的异常。
    -   defaultFallback 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 `fallbackClass` 为对应的类的 `Class` 对象，注意对应的函数必需为 static 函数，否则无法解析。
-   `exceptionsToIgnore`（since 1.6.0）：用于指定哪些异常被排除掉，不会计入异常统计中，也不会进入 fallback 逻辑中，而是会原样抛出。

## 15.9 服务熔断功能
sentinel整合ribbon+openFeign+fallback
### Ribbon系列
启动Nacos和Sentinel
新建cloudalibaba-provider-payment9003/9004两个模块
POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloudalibaba-provider-payment9003</artifactId>  
  
 <dependencies>  
 <!--SpringCloud ailibaba nacos -->  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>  
 </dependency>  
 <dependency><!-- 引入自己定义的api通用包，可以使用Payment支付Entity -->  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>1.0-SNAPSHOT</version>  
 </dependency>  
 <!-- SpringBoot整合Web组件 -->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
 <!--日常通用jar包配置-->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
</project>
```
yml
```yml
server:  
  port: 9003  
  
spring:  
  application:  
    name: nacos-payment-provider  
  cloud:  
    nacos:  
      discovery:  
        server-addr: localhost:8848 #配置Nacos地址  
  
management:  
  endpoints:  
    web:  
      exposure:  
        include: '*'
```
主启动类
业务类PaymentController
```java
@RestController  
@Slf4j  
public class PaymentController {  
  
 @Value("${server.port}")  
 private String serverPort;  
  
 // 简单模仿一个DAO层数据库  
 public static HashMap<Long, Payment> hashMap = new HashMap<>();  
 static{  
 hashMap.put(1L,new Payment(1L,"28a8c1e3bc2742d8848569891fb42181"));  
 hashMap.put(2L,new Payment(2L,"bba8c1e3bc2742d8848569891ac32182"));  
 hashMap.put(3L,new Payment(3L,"6ua8c1e3bc2742d8848569891xt92183"));  
 }  
  
 @GetMapping(value = "/paymentSQL/{id}")  
 public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){  
 Payment payment = hashMap.get(id);  
 CommonResult<Payment> result = new CommonResult(200,"from mysql,serverPort:  "+serverPort,payment);  
 return result;  
 }  
}
```
9003、9004基本一致，除了端口号
启动9003、9004
测试`http://localhost:9003/paymentSQL/1`

创建消费者84 `cloudalibaba-consumer-nacos-order84`
POM
```xml
<?xml version="1.0" encoding="UTF-8"?>  
<project xmlns="http://maven.apache.org/POM/4.0.0"  
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">  
 <parent>  
 <artifactId>cloud2020</artifactId>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <version>1.0-SNAPSHOT</version>  
 </parent>  
 <modelVersion>4.0.0</modelVersion>  
  
 <artifactId>cloudalibaba-consumer-nacos-order84</artifactId>  
  
 <dependencies>  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-openfeign</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>com.mrlqq.springcloud</groupId>  
 <artifactId>cloud-api-commons</artifactId>  
 <version>${project.version}</version>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-devtools</artifactId>  
 <scope>runtime</scope>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 </dependencies>  
  
  
</project>
```
yml
```yml
server:  
  port: 84  
  
spring:  
  application:  
    name: nacos-order-consumer  
  cloud:  
    nacos:  
      discovery:  
        server-addr: localhost:8848  
    sentinel:  
      transport:  
        dashboard: localhost:8080  
        port: 8719  
  
service-url:  
  nacos-user-service: http://nacos-payment-provider
```
主启动类
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211163621.png)
业务类
PaymentFeignService
```java
@Component  
@FeignClient("nacos-payment-provider")  
public interface PaymentFeignService {  
 @GetMapping(value = "/paymentSQL/{id}")  
 CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);  
}
```
CircleBreakerController 
```java
@RestController  
@Slf4j  
public class CircleBreakerController {  
  
 @Resource  
 PaymentFeignService paymentFeignService;  
  
 @GetMapping(value = "/consumer/fallback/{id}")  
 @SentinelResource("fallback")
 public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){  
  
 CommonResult<Payment> result = paymentFeignService.paymentSQL(id);  
 if (id == 4) {  
 throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");  
 }else if (result.getData() == null) {  
 throw new NullPointerException ("NullPointerException,该ID没有对应记录,空指针异常");  
 }  
 return result;  
 }  
}
```
启动84服务，先测试与84服务于9003、9004是否能进行交互
访问`localhost:84/consumer/fallback/1`，自动负载均衡了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211165358.png)

我们的84服务controller中的SentinelResource没有配置任何fallback方法，出现异常或者错误，就直接返回给客户error页面，非常不友好
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211165822.png)
所以我们要配置一个fallback方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211165958.png)
此时，如果我们的程序运行过程中出错了，就会走fallback方法，就不会单纯的返回一个error页面
再次测试出现异常后会返回什么页面
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211170237.png)

我们把fallback注释掉，那如果我们只配置blockHandler会怎么样呢
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211170623.png)
配置sentinel降级规则
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211170843.png)
再次测试，当我们的请求出现异常达到规则的阈值时，会返回什么界面
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211170943.png)
那我们就总结出了fallback接管程序异常，而blockhandler接管控制台配置异常。

那如果我们fallback 和 blockhandler都配置了会返回哪个界面呢?
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211171522.png)
重启服务，重新在sentinel上配置流控规则。阈值为1
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211171807.png)
此时访问请求，并且QPS超过阈值，会发现返回的是blockhandler方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211171842.png)
那如果我们访问请求，加上非法参数的时候，就会返回fallback方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211171953.png)
但QPS超过了阈值，则也会走blcokhandler方法
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211172046.png)

**忽略属性**
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211172234.png)
加上`exceptionsToIgnore`属性后，如果出现属性只当的异常后，则忽略该异常，不会走fallback方法。
比如说上面，我们程序中原本存在两个异常“非法参数异常”和“空指针异常”，如果程序中出现了异常则走fallbcak方法，那么现在我们排除了“非法参数异常”后，当程序出现了“非法参数异常”就会被fallback方法忽略，不走fallback，我们的页面就会返回很不友好的异常报错。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211172925.png)

### Feign系列
yml
```yml
#对Feign的支持  
feign:  
  sentinel:  
    enabled: true
```
PaymentService接口 使用Feign
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211173829.png)
实现类
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211174003.png)
完善fallback
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211174046.png)

修改controller
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211174319.png)
启动测试 `localhost:84/consumer/openfeign/1`能够正常返回结果

此时我们停止9003 看看会发生什么
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211175156.png)
返回的是我们在Feign中写的兜底方法。

### 熔断框架比较
| 功能           | Sentinel                                                   | Hystrix                | reillience4j                     |
| -------------- | ---------------------------------------------------------- | ---------------------- | -------------------------------- |
| 隔离策略       | 信号量隔离（并发线程限流）                                 | 线程池隔离/信号量隔离  | 信号量隔离                       |
| 熔断降级策略   | 基于响应时间、异常比例、异常数                             | 基于异常比例           | 基于异常比例、响应时间           |
| 实时统计实现   | 滑动窗口（LeapArray）                                      | 滑动窗口（基于RxJava） | Ring Bit Buffer                  |
| 动态规划配置   | 支持多种数据源                                             | 支持多种数据源         | 有限支持                         |
| 扩展性         | 多个扩展点                                                 | 插件的形式             | 接口的形式                       |
| 基于注解的支持 | 支持                                                       | 支持                   | 支持                             |
| 限流           | 基于QPS、支持基于调用关系的限流                            | 有限的支持             | Rate Limiter                     |
| 流量整形       | 支持预热模式、匀速器模式、预热排队模式                     | 不支持                 | 简单的Rate Limiter               |
| 系统自适应保护 | 支持                                                       | 不支持                 | 不支持                           |
| 控制台         | 提供开箱即用的控制台，可配置规则、查看秒级监控、机器发现等 | 简单的监控查看         | 不提供控制台，可对接其他监控系统 |


## 15.10 规则持久化
一旦我们重启应用，Sentinel规则将消失，生产环境需要将配置规则进行持久化

将限流配置规则持久化进Nacos保存，只要刷新8401某个rest地址，sentinel控制台的流控规则就能看到，只要Nacos里面的配置不删除，针对8401上Sentinel上的流控规则持续有效

修改8401服务
POM中添加sentinel持久化依赖
```
<dependency>
    <groupId>com.alibaba.csp</groupId>
    <artifactId>sentinel-datasource-nacos</artifactId>
</dependency>
```
添加yml配置
```yml
spring:  
  cloud:  
    sentinel:   
		 datasource:  
		        ds1:  
		          nacos:  
		            server-addr: localhost:8848  
		            dataId: cloudalibaba-sentinel-service  
		            groupId: DEFAULT_GROUP  
		            data-type: json  
		            rule-type: flow
```
在nacos中添加规则配置

```json
[
	{
		"resource": "rateLimit/byUrl",
		"limitApp": "default",
		"grade": 1,
		"count": 1,
		"strategy": 0,
		"controlBehavior": 0,
		"clusterMode": false
	}
]
```
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211182238.png)
- resource：资源名称
- limitApp：来源应用
- grade：阈值类型，0表示线程，1表示QPS
- count：单击阈值
- strategy：流控模式，0表示直接，1表示关联，2表示链路
- controlBehavior：流控效果，0表示快速失败，1表示Warm Up，2表示排队等待
- clusterMode：是否集群

配置好后启动8401，刷新sentinel发现业务规则有了
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211182948.png)
测试限流规则，发现已经生效
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211183317.png)

# 十六、SpringCloud Alibaba Seata处理分布式事务
## 16.1 分布式事务问题
分布式前：单击单库没这个问题，从1:1 -> 1:N -> N:N
分布式之后：单体应用被拆分成微服务应用，原来的三个模块被拆分成三个独立的应用，分别使用三个独立的数据源，
业务操作需要调用三个服务来完成。此时每个服务内部的数据一致性有本地事务来保证，但是全局的数据一致性问题没法保证。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211184159.png)

一次业务操作需要跨多个数据源或需要跨多个系统进行远程调用，就会产生分布式事务问题
## 16.2 Seata简介
### 16.2.1 Seata是什么
Seata是一款开源的分布式事务解决方案，致力于在微服务架构下提供高性能和简单易用的分布式事务服务
官网：[Seata](http://seata.io/zh-cn/)

### 16.2.2 Seata能干嘛
一个典型的分布式事务过程
分布式事务处理过程的：ID+三组件模型
Transaction ID XID 全局唯一的事务ID
3组件概念：
- TC (Transaction Coordinator) - 事务协调者
	维护全局和分支事务的状态，驱动全局事务提交或回滚。
- TM (Transaction Manager) - 事务管理器
	定义全局事务的范围：开始全局事务、提交或回滚全局事务。
- RM (Resource Manager) - 资源管理器
	管理分支事务处理的资源，与TC交谈以注册分支事务和报告分支事务的状态，并驱动分支事务提交或回滚。

处理过程：
1、TM向TC申请开启一个全局事务，全局事务创建成功并生成一个全局唯一的XID
2、XID在微服务调用链路的上下文中传播
3、RM向TC注册分支事务，将其纳入XID对应全局事务的管辖
4、TM向TC发起针对XID的全局提交或回滚的决议
5、TC调度XID下管辖的全部分支事务完成提交或回滚请求
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211185136.png)

### 16.2.3 Seata怎么用
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211202501.png)

## 16.3 Seata-Server安装
官网下载：[下载中心](https://seata.io/zh-cn/blog/download.html)
下载压缩包，解压，修改conf目录下的file.com配置文件
主要修改：自定义事务组名称+事务日志存储模式为db+数据库连接信息
(注意修改mysql5 和 mysql8 的驱动不一样，根据自己的mysql版本修改)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211203146.png)
在自己的数据库中创建一个seata库，然后使用[seata/mysql.sql at develop · seata/seata · GitHub](https://github.com/seata/seata/blob/develop/script/server/db/mysql.sql)官网提供的sql脚本建表

修改conf目录下的registry.conf配置文件,使用nacos注册
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211203948.png)

先启动nacos8848，在启动seata-server.bat

## 16.4 订单/库存/账户业务数据库准备
业务说明：
这里我们会创建三个服务，一个订单服务，一个库存服务，一个账户服务。

	当用户下单时，会在订单服务中创建一个订单，然后通过远程调用库存服务来扣减下单商品的库存，
	再通过远程调用远程账户服务来扣减用户账户里面的余额，
	最后在订单服务中修改订单为已完成状态。
下订单-->扣库存-->减账户（余额）

改操作跨越三个数据库，有两次远程调用，很明显会有分布式事务问题。
### 创建业务数据库
seata_order: 存储订单的数据库
seata_storage:存储库存的数据库
seata_account: 存储账户信息的数据库
```sql
CREATE DATABASE seata_order;  
CREATE DATABASE seata_storage;  
CREATE DATABASE seata_account;
```
seata_order库下建t_order表
```sql
CREATE TABLE t_order(  
 id BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,  
 user_id BIGINT(11) DEFAULT NULL COMMENT '用户id',  
 product_id BIGINT(11) DEFAULT NULL COMMENT '产品id',  
 count INT(11) DEFAULT NULL COMMENT '数量',  
 money DECIMAL(11,0) DEFAULT NULL COMMENT '金额',  
 status INT(1) DEFAULT NULL COMMENT '订单状态：0：创建中; 1：已完结'  
) ENGINE=INNODB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;  
  
SELECT * FROM t_order;
```
seata_storage库下建t_storage表
```sql
CREATE TABLE t_storage(  
 id BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,  
 product_id BIGINT(11) DEFAULT NULL COMMENT '产品id',  
 total INT(11) DEFAULT NULL COMMENT '总库存',  
 used INT(11) DEFAULT NULL COMMENT '已用库存',  
 residue INT(11) DEFAULT NULL COMMENT '剩余库存'  
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;  
  
INSERT INTO seata_storage.t_storage(id,product_id,total,used,residue)  
VALUES('1','1','100','0','100');  
SELECT * FROM t_storage;
```
seata_account库下建t_account表
```sql
CREATE TABLE t_account(  
 id BIGINT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'id',  
 user_id BIGINT(11) DEFAULT NULL COMMENT '用户id',  
 total DECIMAL(10,0) DEFAULT NULL COMMENT '总额度',  
 used DECIMAL(10,0) DEFAULT NULL COMMENT '已用余额',  
 residue DECIMAL(10,0) DEFAULT '0' COMMENT '剩余可用额度'  
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;  
  
INSERT INTO seata_account.t_account(id,user_id,total,used,residue) VALUES('1','1','1000','0','1000');  
  
SELECT * FROM t_account;
```

按照上述3库分别建对应的回滚日志表
复制官网提供的undo_log.sql脚本[seata/mysql.sql at develop · seata/seata · GitHub](https://github.com/seata/seata/blob/develop/script/client/at/db/mysql.sql)

最终效果：
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211211920.png)

## 16.5 订单/库存/账户业务微服务准备
下订单->减库存->扣余额->改（订单）状态
### 新建订单Order-Module
创建seata-order-service2001模块
POM
```xml
<dependencies>  
 <!--nacos-->  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>  
 </dependency>  
 <!--seata-->  
 <dependency>  
 <groupId>com.alibaba.cloud</groupId>  
 <artifactId>spring-cloud-starter-alibaba-seata</artifactId>  
 <exclusions>  
 <exclusion>  
 <artifactId>seata-all</artifactId>  
 <groupId>io.seata</groupId>  
 </exclusion>  
 </exclusions>  
 </dependency>  
 <dependency>  
 <groupId>io.seata</groupId>  
 <artifactId>seata-all</artifactId>  
 <version>1.4.1</version>  
 </dependency>  
 <!--feign-->  
 <dependency>  
 <groupId>org.springframework.cloud</groupId>  
 <artifactId>spring-cloud-starter-openfeign</artifactId>  
 </dependency>  
 <!--web-actuator-->  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-web</artifactId>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-actuator</artifactId>  
 </dependency>  
 <!--mysql-druid-->  
 <dependency>  
 <groupId>mysql</groupId>  
 <artifactId>mysql-connector-java</artifactId>  
 <version>8.0.25</version>  
 </dependency>  
 <dependency>  
 <groupId>com.alibaba</groupId>  
 <artifactId>druid-spring-boot-starter</artifactId>  
 <version>1.1.10</version>  
 </dependency>  
 <dependency>  
 <groupId>org.mybatis.spring.boot</groupId>  
 <artifactId>mybatis-spring-boot-starter</artifactId>  
 <version>2.0.0</version>  
 </dependency>  
 <dependency>  
 <groupId>org.springframework.boot</groupId>  
 <artifactId>spring-boot-starter-test</artifactId>  
 <scope>test</scope>  
 </dependency>  
 <dependency>  
 <groupId>org.projectlombok</groupId>  
 <artifactId>lombok</artifactId>  
 <optional>true</optional>  
 </dependency>  
</dependencies>
```
YML
```yml
server:  
  port: 2001  
  
spring:  
  application:  
    name: seata-order-service  
  cloud:  
    alibaba:  
      seata:  
        #自定义事务组名称需要与seata-server中的对应,没有就默认  
 tx-service-group: default  
    nacos:  
      discovery:  
        server-addr: localhost:8848  
  datasource:  
    driver-class-name: com.mysql.cj.jdbc.Driver  
    url: jdbc:mysql://localhost:9911/seata_order  
    username: root  
    password: passwrord  
  
feign:  
  hystrix:  
    enabled: false  
  
logging:  
  level:  
    io:  
      seata: info  
  
mybatis:  
  mapperLocations: classpath:mapper/*.xml
```
在resources目录下创建file.conf ，内容参照官网：[seata/file.conf at develop · seata/seata · GitHub]([seata/file.conf at develop · seata/seata · GitHub](https://github.com/seata/seata/blob/develop/script/client/conf/file.conf))
再创建registry.conf ，内容参照官网：[seata/registry.conf at develop · seata/seata · GitHub](https://github.com/seata/seata/blob/develop/script/client/conf/registry.conf)。。注意修改registry配置文件中的nacos
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211220045.png)
创建连个domain分别是Order、CommonResult
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220211220513.png)
此部分省略具体的图文说明，详细内容请参照github源代码
### 新建库存Storage-Module
此部分省略具体的图文说明，详细内容请参照github源代码
### 新建账户Account-Module
此部分省略具体的图文说明，详细内容请参照github源代码
## 16.6 Test
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212000821.png)

初始化数据库
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212000844.png)

正常下单：
`http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100`
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212010914.png)
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212001021.png)

### 超时异常，没加@GlobalTransactional
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212011520.png)
我们再次访问请求，发现报错了。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212011645.png)
控制台报了 read timed out超时异常
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212011704.png)
此时数据库也会出现问题，库存减少了，钱也扣了，但是订单却没有完成
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212011943.png)
**故障情况：**
当库存和账户余额扣减后，订单状态并没有设置为已经完成，没有从零改为1
而且由于feign的重试机制，账户余额还有可能被多次扣减
### 超时异常，添加@GlobalTransactional
我们再OrderServiceImpl里添加`@GlobalTransactional`注解
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212012444.png)
重启2001再次访问请求，查看结果
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212012549.png)
发现还是报错，但是我们此事查看数据库，发现订单并没有添加进来
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212012629.png)
下单后数据库数据并没有任何改变，记录都添加不进来，事务发现异常回滚了

## 16.7 Seata之原理简介
### Seata
2019年1月份蚂蚁金服和阿里巴巴共同开源的分布式事务解决方案
Simple Extensible Autonomous Transaction Architecture,简单可扩展自治事务框架
### 再看TC/TM/RM三大组件
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212013226.png)
分布式事务的执行流程
- TM开启分布式事务(TM向TC注册全局事务记录)
- 换业务场景，编排数据库，服务等事务内资源（RM向TC汇报资源准备状态）
- TM结束分布式事务，事务一阶段结束（TM通知TC提交/回滚分布式事务）
- TC汇总事务信息，决定分布式事务是提交还是回滚
- TC通知所有RM提交/回滚资源，事务二阶段结束。
### AT模式如何做到对业务的无侵入
#### 整体机制
两阶段提交协议的演变：
-   一阶段：业务数据和回滚日志记录在同一个本地事务中提交，释放本地锁和连接资源。
-   二阶段：
    -   提交异步化，非常快速地完成。
    -   回滚通过一阶段的回滚日志进行反向补偿。

#### 一阶段加载
在一阶段，Seata会拦截"业务SQL"
1、解析SQL语义，找到“业务SQL”要更新的业务数据，在业务数据被更新前，将其保存成“before image”
2、执行“业务SQL”更新业务数据，在业务数据更新之后
3、保存成“after image”，最后生成行锁
以上操作全部在一个数据库事务内完成，这样保证了一阶段操作的原子性。
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212014603.png)

#### 二阶段提交
二阶段如是顺利提交的话，
因为“业务SQL”在一阶段已经提交至数据库，所以Seata框架只需将==一阶段保存的快照数据和行锁删掉，完成数据清洗即可。==
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212015036.png)

#### 二阶段回滚
二阶段如果是回滚的话,
Seata就需要回滚一阶段已经执行的“业务SQL”，还原业务数据。
回滚方式便是用“before image”还原业务数据；但在还原前要首先校验脏读，对比“数据库当前业务数据”和“after image”，
如果两份数据完全一致就说明没有脏读，可以还原业务数据，如果不一致说明有脏读，出现脏读就需要转人工处理
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212015511.png)

### 补充
![](https://mrlqq-oss.oss-cn-beijing.aliyuncs.com/20220212023920.png)
[浅析MySQL事务中的redo与undo - 简书](https://www.jianshu.com/p/20e10ed721d0)
[GitHub - MrLQQ/SpringCloudAlibaba_Learn: SpringCloud Alibaba个人学习过程](https://github.com/MrLQQ/SpringCloudAlibaba_Learn)

