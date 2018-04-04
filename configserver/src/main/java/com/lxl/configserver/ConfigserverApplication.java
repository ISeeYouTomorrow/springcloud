package com.lxl.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 分布式服务中心 服务端测试
 * 在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。
 * 在Spring Cloud中，有分布式配置中心组件spring cloud config ，它支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库中。
 * 在spring cloud config 组件中，分两个角色，一是config server，二是config client。
 * 证明配置服务中心可以从远程程序获取配置信息。
 http请求地址和资源文件映射如下:

 /{application}/{profile}[/{label}]
 /{application}-{profile}.yml
 /{label}/{application}-{profile}.yml
 /{application}-{profile}.properties
 /{label}/{application}-{profile}.properties

 将配置服务注册到eureka,启动类添加@EnableDiscoveryClient激活对配置中心的支持
 可以修改配置文件port端口，多启动几个服务
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigserverApplication.class, args);
	}
}
