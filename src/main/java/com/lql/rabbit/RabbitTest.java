package com.lql.rabbit;

import com.lql.rabbit.group1.HelloSender1;
import com.lql.rabbit.group1.HelloSender2;
import com.lql.rabbit.group2.UserSender;
import com.lql.rabbit.group3.TopicSender;
import com.lql.rabbit.group4.FanoutSender;
import com.lql.rabbit.group5.CallBackSender;
import jdk.nashorn.internal.codegen.CompilerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.dc.pr.PRError;

/**
 * Created by LiuQiulan
 *
 * @date 2018-7-10 14:03
 */

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender1 helloSender1;

    @Autowired
    private HelloSender2 helloSender2;

    @Autowired
    private UserSender userSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Autowired
    private CallBackSender callBackSender;
    /**
     * 单生产者-单消费者
     */
    @GetMapping("/hello")
    public void hello(){
        helloSender1.send();
    }

    /**
     * 单生产者-多消费者:
     *
     * 生产者生产的消息被消费者共同消费
     */
    @GetMapping("/onetomany")
    public void onetomany() {
        for (int i = 0; i < 10; i++) {
            helloSender1.send("hellomag:" + i + "-");
        }
    }

    /**
     * 多生产者-多消费者
     *
     *生产者生产的消息被消费者共同消费
     */
    @GetMapping("/manytomany")
    public void manytomany(){
        for (int i = 0; i < 10; i++) {
            helloSender1.send("hellomag1:"+i+"-");
            helloSender2.send("hellomag2:"+i+"-");
        }
    }

    /**
     * 实体类传输测试
     */
    @GetMapping("/userTest")
    public void userTest() {
        for (int i = 0; i < 2; i++) {
            userSender.send("user:"+i+"-");
        }
    }

    /**
     * topic exchange类型rabbitmq测试
     */
    @GetMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

    /**
     * fanout exchange类型rabbitmq测试
     */
    @GetMapping("/fanoutTest")
    public void fanoutTest() {
        fanoutSender.send();
    }

    /**
     * 带callback的消息发送
     */
    @GetMapping("/callback")
    public void callbak() {
        callBackSender.send();
    }
}
