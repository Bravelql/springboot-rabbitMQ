package com.lql.rabbit.group1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 13:56
 *
 * 生产者1
 */
@Component
public class HelloSender1 {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String sendMSG = "hello1:"+new Date();
        System.out.println("sender1:"+sendMSG);
        amqpTemplate.convertAndSend("helloQueue",sendMSG);
    }

    public void send(String msg) {
        String sendMsg = msg + new Date();
        System.out.println("Sender1 : " + sendMsg);
        amqpTemplate.convertAndSend("helloQueue", sendMsg);
    }
}
