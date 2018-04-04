package com.lxl.ribbondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxl lukas
 * @description 控制器测试方法，调用HelloService的方法测试负载均衡功能
 * @create 2018/1/20
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @RequestMapping(value = "/hi")
    public String hello(String name){
        return service.helloService(name);
    }
}
