package net.huayiyun.eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client
 * @Description : 启动类
 * @Author : zlj
 * @Creation Date : 2019年06月25日 11:33
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class RegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class,args);
    }
}
