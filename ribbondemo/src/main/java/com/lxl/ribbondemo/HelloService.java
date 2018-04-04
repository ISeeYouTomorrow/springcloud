package com.lxl.ribbondemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lxl lukas
 * @description 服务消费测试类
 * @create 2018/1/20
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用分布式注册服务
     * 该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法，熔断方法直接返回了一个字符串
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "helloError")
    public String helloService(String name){
        return restTemplate.getForObject("http://eureka-service/hi?name="+name,String.class);
    }

    public String helloError(String name){
        return "hi,"+name+",sorry ,error!";
    }
}
