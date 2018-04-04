package com.lxl.feigndemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lxl lukas
 * @description Web层的controller层，对外暴露一个”/hi”的API接口，
 * 通过定义的Feign客户端SchedualServiceHi 来消费服务
 * @create 2018/1/21
 */
@RestController
public class FeignController {

    @Autowired
    SchedualServiceHi feignService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(String name){
        return feignService.sayHiFromClientOne(name);
    }
}
