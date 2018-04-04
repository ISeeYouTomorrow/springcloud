package com.lxl.serviceconsul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  spring cloud consul 组件，它是一个提供服务发现和配置的工具。consul具有分布式、高可用、高扩展性
 *   consul 具有以下性质：
 *   服务发现：consul通过http 方式注册服务，并且服务与服务之间相互感应。
	 服务健康监测
	 key/value 存储
	 多数据中心
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ServiceConsulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsulApplication.class, args);
	}

	@RequestMapping("/hi")
	public String home() {
		return "hi ,i'm miya";
	}
}
