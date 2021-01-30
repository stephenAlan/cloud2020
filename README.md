# cloud2020
springcloud相关组件

## Nacos服务注册与发现
### 1. 引入nacos依赖
```
<!--Nacos服务注册与发现-->
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
</dependency>
```
### 2. 写配置文件
```
spring:
  application:
    name: nacos-payment-provider
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
management:
  endpoints:
    web:
      exposure:
        exclude: '*' # 暴露所有的
```

### 3. 添加注解@EnableDiscoveryClient
```
@SpringBootApplication
@EnableDiscoveryClient // 开启注册发现
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
```