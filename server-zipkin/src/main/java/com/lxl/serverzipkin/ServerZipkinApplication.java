package com.lxl.serverzipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * 服务链路追踪(Spring Cloud Sleuth)
 * 服务追踪组件zipkin，Spring Cloud Sleuth集成了zipkin组件
 * Spring Cloud Sleuth 主要功能就是在分布式系统中提供追踪解决方案，并且兼容支持了 zipkin
 * 在其程序入口类, 加上注解@EnableZipkinServer，开启ZipkinServer的功能
 */
@SpringBootApplication
@EnableZipkinServer
public class ServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerZipkinApplication.class, args);
	}
}
