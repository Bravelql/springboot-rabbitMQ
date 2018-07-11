package com.lql.rabbit.group2;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 15:29
 *
 * 消息队列传递对象
 */

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String str) {
        User user=new User();
        user.setName("lql");
        user.setPass("123456789");
        System.out.println("send "+str+user.toString());
        this.rabbitTemplate.convertAndSend("userQueue", user);
    }

}
