package net.huayiyun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年07月08日 17:51
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulAuthApplication.class,args);
    }
}
