package net.huayiyun.eureka_client.controller;

import com.alibaba.fastjson.JSONObject;
import net.huayiyun.common.util.*;
import net.huayiyun.eureka_client.pojo.qo.BloodGlucoseQo;
import net.huayiyun.eureka_client.service.BloodGlucoseService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.controller
 * @Description : 血糖controller
 * @Author : zlj
 * @Creation Date : 2018年05月10日 10:47
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@RestController("BloodGlucoseController")
@RequestMapping("/bloodGlucose")
@CrossOrigin(value = "*", allowCredentials = "true")
public class BloodGlucoseController {

    @Resource
    BloodGlucoseService bloodGlucoseService;

    /**
     * @Author zlj
     * @param data
     * @return
     * @Description 添加血糖数据
     * @creat_date 2018年05月10日
     * @creat_time 10:53:37
     */
    @RequestMapping(value="/save",produces="application/json;charset=UTF-8")
    public ResultEntity save(@RequestBody String data){
        StringBuffer debug = new StringBuffer();
        debug.append("调用添加血糖数据 方法/r/n");
        ResultEntity entity = new ResultEntity();
        try{

            ObjectQO<BloodGlucoseQo> parse = (ObjectQO<BloodGlucoseQo>) JSONObject.parseObject(data,ObjectQO.class);
            Object data1 = parse.getData();
            parse.setData((BloodGlucoseQo)JSONObject.parseObject(data1.toString(),BloodGlucoseQo.class));
            //System.out.println(parse);
            bloodGlucoseService.saveBloodGlucose(parse);
            entity.setStatus(ResultStausEnum.SUCCESS.getCode());
            entity.setCode(CommonCodeEnum.SUCCESS.getCode());
            entity.setMessage(CommonCodeEnum.SUCCESS.getMessage());
        }catch (Exception e){
            entity.setStatus(ResultStausEnum.SYSTEMERROR.getCode());
            entity.setCode(CommonCodeEnum.SYSTEM_EXCEPTION.getCode());
            entity.setMessage(CommonCodeEnum.SYSTEM_EXCEPTION.getMessage());
        }finally {
            debug.append("entity:" + entity + "/r/n");
            return entity;
        }
    }

    /**
     * @Author zlj
     * @param data
     * @return
     * @Description 查询血糖列表
     * @creat_date 2018年05月10日
     * @creat_time 11:46:09
     */
    @RequestMapping(value="/query",produces="application/json;charset=UTF-8")
    public ResultEntity query(@RequestBody String data){
        ResultEntity entity = new ResultEntity();
        StringBuffer debug = new StringBuffer();
        debug.append("调用查询血糖数据列表 方法/r/n");
        try{
            //System.out.println(data);
            ObjectQO<BloodGlucoseQo> parse = (ObjectQO<BloodGlucoseQo>) JSONObject.parseObject(data,ObjectQO.class);
            Object data1 = parse.getData();
            parse.setData((BloodGlucoseQo)JSONObject.parseObject(data1.toString(),BloodGlucoseQo.class));

            CommListVo list = bloodGlucoseService.listBloodGlucose(parse);
            entity.setStatus(ResultStausEnum.SUCCESS.getCode());
            entity.setCode(CommonCodeEnum.SUCCESS.getCode());
            entity.setMessage(CommonCodeEnum.SUCCESS.getMessage());
            entity.setData(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            debug.append("entity:" + entity + "/r/n");
            return entity;
        }
    }

    @RequestMapping("/getIt")
    public String getIt(){
        return new String("I get it！");
    }


}
