package com.lxl.configclientbus;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lxl lukas
 * @description 创建消息生产者
 * @create 2018/1/26
 */
@Component
public class Sender {
    /**
     * 注入AmqpTemplate，然后利用AmqpTemplate向一个名为hello的消息队列中发送消息。
     */
    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;

    public void send(){
        String msg = "hello rabbitmq:"+new Date();
        System.out.println("Sender msg: "+msg);
        this.rabbitAmqpTemplate.convertAndSend("hello",msg);
    }

    public void send(String message){
        this.rabbitAmqpTemplate.convertAndSend("hello",message);
    }
}
