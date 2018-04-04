package com.lxl.configclientbus;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lxl lukas
 * @description 创建消息消费者
 * @create 2018/1/26
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(String msg){
        System.out.print("Receiver msg :"+msg);
    }

}
