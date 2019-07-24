package net.huayiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年07月08日 16:30
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@SpringBootApplication
@EnableEurekaClient
public class OauthResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthResourceApplication.class,args);
    }
}
