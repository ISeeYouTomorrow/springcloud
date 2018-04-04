package com.lxl.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式服务中心 客户端测试
 * 程序的入口类，写一个API接口“／hi”，返回从配置中心读取的foo变量的值
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class ConfigclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigclientApplication.class, args);
	}

	@Value("${foo}")
	String foo;
	@Value("${message}")
	String message;

	@RequestMapping(value = "/hi")
	public String hi(){
		return foo+" , "+message;
	}
}
