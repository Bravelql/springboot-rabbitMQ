package com.lql.rabbit.group2;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 14:48
 */
@Configuration
public class RabbitConfig2 {

    @Bean
    public Queue Queue(){
        return new Queue("userQueue");
    }
}
