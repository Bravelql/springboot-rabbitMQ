package com.lql.rabbit.group4;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 16:27
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msgString="fanoutSender :hello i am lql";
        System.out.println(msgString);
        this.rabbitTemplate.convertAndSend("fanoutExchange","abcd.ee", msgString);
    }
}
