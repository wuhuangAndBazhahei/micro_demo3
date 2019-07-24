package net.huayiyun.eureka_client.controller;

import net.huayiyun.commom.util.ResultEntity;
import net.huayiyun.eureka_client.service.BloodGlucoseOpenFeignService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Enumeration;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.controller
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月26日 9:56
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@RestController
@RequestMapping("/client2")
public class TestController2 {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Resource
    BloodGlucoseOpenFeignService bloodGlucoseOpenFeignService;

    @RequestMapping("/auth")
    public String auth(HttpServletRequest request){
        System.out.println("----------------header----------------");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            System.out.println(key + ": " + request.getHeader(key));
        }
        System.out.println("----------------header----------------");
        String body = restTemplate.getForEntity("http://TEST1-EUREKA-PROVIDERSCLIENT1/client/login",
                String.class).getBody();
        return body;
    }

    @RequestMapping("/rabbit/send")
    public void hello() {
        this.send();
    }

    /**
     * @Author zlj
     * @param
     * @return
     * @Description 发送消息
     * @creat_date 2019年06月27日
     * @creat_time 16:02:29
     */
    public void send() {
        String sendMsg = "hello1 " + LocalDate.now();
        System.out.println("Sender1 : " + sendMsg);
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }

    @RequestMapping(value="/openFeignSave",produces="application/json;charset=UTF-8")
    public ResultEntity openFeignSave(@RequestBody String data){
        return bloodGlucoseOpenFeignService.save8001(data);
    }

    @RequestMapping(value="/openFeignQuery",produces="application/json;charset=UTF-8")
    public ResultEntity openFeignQuery(@RequestBody String data){
        return bloodGlucoseOpenFeignService.query8001(data);
    }

    @RequestMapping("/openFeignGet")
    public String openFeignGet(HttpServletRequest request){
        System.out.println("----------------header----------------");
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            System.out.println(key + ": " + request.getHeader(key));
        }
        System.out.println("----------------header----------------");
        return bloodGlucoseOpenFeignService.getIt();
    }
}
