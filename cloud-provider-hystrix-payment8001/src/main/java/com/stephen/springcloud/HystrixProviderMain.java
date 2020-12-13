package com.stephen.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * Created by ssc on 2020-12-12 18:59 .
 * Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker // Hystrix生效注解
public class HystrixProviderMain {

    public static void main(String[] args) {
        SpringApplication.run(HystrixProviderMain.class,args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，是Springcloud升级后的坑
     * ServletRegistrationBean因为Springboot的默认路径不是“/hystrix.stream”
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet servlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(servlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }



}
