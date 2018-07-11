package com.lql.rabbit.group3;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 15:58
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg1 = "I am topic.mesaage msg======";
        System.out.println("sender1 : " + msg1);
        this.rabbitTemplate.convertAndSend("exchange", "topic.message", msg1);

        String msg2 = "I am topic.mesaages msg########";
        System.out.println("sender2 : " + msg2);
        this.rabbitTemplate.convertAndSend("exchange", "topic.messages", msg2);
    }

    /**
     *   sender1 : I am topic.mesaage msg======
         sender2 : I am topic.mesaages msg########
         topicMessageReceiver  : I am topic.mesaage msg======
         topicMessagesReceiver  : I am topic.mesaage msg====== ???
         topicMessagesReceiver  : I am topic.mesaages msg########

         生产者生产的消息应该是被消费者均匀消费，只产生了两个消息，
        为什么会有3个消息被接收？或者说消息被重复接收了？

     首先简单理解下交换机：
        AMQP协议中的核心思想就是生产者和消费者隔离，
        生产者从不直接将消息发送给队列。生产者通常不知道是否一个消息会被发送到队列中，
        只是将消息发送到一个交换机。

        当我们开发的时候还有时候会用到这样一种功能，就是当我发送一条消息，
        需要让几个queue都收到，那么怎么解决这个问题呢，难道我要给每一个queue发送一次消息？
        那岂不是浪费带宽又浪费资源，我们能想到什么办法呢，当然是我们发送给RabbitMQ服务器一次，
        然后让RabbitMQ服务器自己解析需要给哪个Queue发，那么Exchange就是干这件事的

        交换机有四种类型，详情参考：https://www.jianshu.com/p/469f4608ce5d

         但是我们给Exchange发消息，他怎么知道给哪个Queue发呢？这里就用到了RoutingKey和BindingKey

         BindingKey是Exchange和Queue绑定的规则描述，这个描述用来解析当Exchange接收到消息时，
        Exchange接收到的消息会带有RoutingKey这个字段，Exchange就是根据这个RoutingKey和当前Exchange
        所有绑定的BindingKey做匹配，如果满足要求，就往BindingKey所绑定的Queue发送消息，这样我们就解决
        了我们向RabbitMQ发送一次消息，可以分发到不同的Queue的过程

        RoutingKey：指定当前消息被谁接受

        BindingKey：指定当前Exchange下，什么样的RoutingKey会被下派到当前绑定的Queue中
     所以，理解以下代码含义：
     @Bean
     Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
         return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
        //将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     }



     *
     */
}
