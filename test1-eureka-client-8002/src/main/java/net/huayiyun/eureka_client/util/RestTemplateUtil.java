package net.huayiyun.eureka_client.util;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.util
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月26日 9:54
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Configuration
public class RestTemplateUtil {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
