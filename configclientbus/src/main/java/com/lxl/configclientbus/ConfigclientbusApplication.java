package com.lxl.configclientbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
public class ConfigclientbusApplication {

	@Autowired
	private Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(ConfigclientbusApplication.class, args);
	}

	@Value("${foo}")
	String foo;
	@Value("${message}")
	String message;

	@RequestMapping(value = "/hi")
	public String hi(){
		return foo+" , "+message;
	}

	@RequestMapping(value = "/send")
	public void mqSend(){
		sender.send();
	}
}
