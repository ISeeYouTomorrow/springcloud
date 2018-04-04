package com.lxl.ribbondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Ribbon (缎带) + RestTemplate 实现负载均衡
 * EnableHystrix 注解开启Hystrix(断路器)
 * EnableHystrixDashboard 注解开启断路器仪表盘
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class RibbondemoApplication {

	/**
	 * 注册一个bean：restTemplate，然后开启负载均衡
	 * @return RestTemplate
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(RibbondemoApplication.class, args);
	}
}
