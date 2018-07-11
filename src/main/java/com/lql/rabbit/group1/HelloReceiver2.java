package com.lql.rabbit.group1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 13:59
 *
 * 消费者
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiver2 {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver2:"+hello);
    }
}
