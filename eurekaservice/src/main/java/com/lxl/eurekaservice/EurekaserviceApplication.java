package com.lxl.eurekaservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务客户端，注册服务到eureka
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaserviceApplication {

	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(EurekaserviceApplication.class, args);
	}

	@RequestMapping("/hi")
	public String home(@RequestParam String name){
		return "hello "+name+" ,I am from port "+port;
	}
}
