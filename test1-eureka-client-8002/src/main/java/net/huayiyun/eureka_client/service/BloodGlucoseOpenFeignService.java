package net.huayiyun.eureka_client.service;

import net.huayiyun.commom.util.ResultEntity;
import net.huayiyun.eureka_client.service.impl.BloodGlucoseOpenFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.service
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月28日 9:35
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@FeignClient(name = "test1-eureka-providersClient1" ,
        fallback = BloodGlucoseOpenFeignServiceImpl.class,
        path = "/bloodGlucose")
public interface BloodGlucoseOpenFeignService {

    @RequestMapping(value="/save",produces="application/json;charset=UTF-8")
    ResultEntity save8001(@RequestBody String data);

    @RequestMapping(value="/query",produces="application/json;charset=UTF-8")
    ResultEntity query8001(@RequestBody String data);

    @RequestMapping(value="/getIt",produces="application/json;charset=UTF-8")
    String getIt();

}
