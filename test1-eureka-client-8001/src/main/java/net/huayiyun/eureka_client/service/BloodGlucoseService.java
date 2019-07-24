package net.huayiyun.eureka_client.service;

import net.huayiyun.common.util.CommListVo;
import net.huayiyun.common.util.ObjectQO;
import net.huayiyun.eureka_client.pojo.qo.BloodGlucoseQo;
import org.springframework.stereotype.Service;

/**
 * @Project : huayi-ncd
 * @Package Name : com.huayi.ncd.datacenter.service
 * @Description : 接口--血糖数据业务处理
 * @Author : zlj
 * @Creation Date : 2018年04月08日 10:54
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */

public interface BloodGlucoseService {
    /**
     * @Author zlj
     * @param objectQO
     * @return void
     * @Description 插入血糖数据
     * @creat_date 2018年04月08日
     * @creat_time 15:13:54
     */
     void saveBloodGlucose(ObjectQO<BloodGlucoseQo> objectQO)throws Exception;

    /**
     * @Author zlj
     * @param objectQO
     * @return  List<BloodGlucoseVo>
     * @Description 查询血糖数据
     * @creat_date 2018年04月08日
     * @creat_time 16:47:50
     */
     CommListVo listBloodGlucose(ObjectQO<BloodGlucoseQo> objectQO) throws Exception;


}





