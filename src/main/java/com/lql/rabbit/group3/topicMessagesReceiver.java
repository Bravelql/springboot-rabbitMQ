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
@RabbitListener(queues = "topic.messages")
public class topicMessagesReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessagesReceiver  : " +msg);
    }

}
