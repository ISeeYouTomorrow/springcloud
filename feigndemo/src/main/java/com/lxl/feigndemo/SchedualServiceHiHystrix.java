package com.lxl.feigndemo;

import org.springframework.stereotype.Component;

/**
 * SchedualServiceHiHystric需要实现SchedualServiceHi 接口，并注入到Ioc容器中,断路器方法sayHiFromClientOne
 */
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi{

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry,error,"+name;
    }
}
