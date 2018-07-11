package com.lql.rabbit.group4;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 16:28
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {
    @RabbitHandler
    public void process(String msg) {
        System.out.println("FanoutReceiverB  : " + msg);
    }
}
