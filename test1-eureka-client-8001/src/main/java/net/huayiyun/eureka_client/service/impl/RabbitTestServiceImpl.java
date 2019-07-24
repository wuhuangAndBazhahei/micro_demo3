package net.huayiyun.eureka_client.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.service.impl
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月27日 16:10
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Service
@RabbitListener(queues = "helloQueue")
public class RabbitTestServiceImpl {

    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }
}
