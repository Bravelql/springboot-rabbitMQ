package com.lql.rabbit.group3;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 16:02
 */
@Component
@RabbitListener(queues = "topic.message")
public class topicMessageReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }

}
