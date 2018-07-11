package com.lql.rabbit.group2;

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
@RabbitListener(queues = "userQueue")
public class HelloReceiver {

    @RabbitHandler
    public void process(User user){
        System.out.println("Receiver:"+user.toString());
    }
}
