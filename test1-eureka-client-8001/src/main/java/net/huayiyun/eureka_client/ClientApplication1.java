package net.huayiyun.eureka_client;

import com.spring4all.mongodb.EnableMongoPlus;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月25日 18:58
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@SpringBootApplication
@EnableEurekaClient
@EnableMongoPlus
//net.huayiyun.*.*.mapper
@MapperScan(basePackages = {"net.huayiyun.*.mapper"})
public class ClientApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication1.class,args);
    }
}
