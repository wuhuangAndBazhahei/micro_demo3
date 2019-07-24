package net.huayiyun.eureka_client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Project : eurekademo1
 * @Package Name : PACKAGE_NAME
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月27日 17:28
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test1() {
        RabbitAdmin bean = applicationContext.getBean(RabbitAdmin.class);
        System.out.println(bean);
    }

}
