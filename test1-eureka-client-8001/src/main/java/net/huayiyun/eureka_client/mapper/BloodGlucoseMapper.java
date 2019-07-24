package net.huayiyun.eureka_client.mapper;

import net.huayiyun.eureka_client.pojo.po.ListBloodGlucosePo;
import net.huayiyun.eureka_client.pojo.qo.BloodGlucoseQo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Project : huayi-ncd
 * @Package Name : com.huayi.ncd.datacenter.dao
 * @Description : 血糖数据Dao层
 * @Author : zlj
 * @Creation Date : 2018年04月08日 11:27
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Repository
@Mapper
public interface BloodGlucoseMapper {


    /**
     * @Author zlj
     * @param bloodGlucoseQo
     * @return
     * @Description 添加血糖数据
     * @creat_date 2018年04月13日
     * @creat_time 17:20:38
     */
     Integer insertBloodGlucose(BloodGlucoseQo bloodGlucoseQo);


    /**
     * @Author zlj
     * @param bloodGlucoseQo
     * @return
     * @Description 查询血糖数据列表
     * @creat_date 2018年04月13日
     * @creat_time 17:22:28
     */
     List<ListBloodGlucosePo> listBloodGlucose(BloodGlucoseQo bloodGlucoseQo);

    /**
     * @Author zlj
     * @param bloodGlucoseQo
     * @return
     * @Description 查询血糖数量
     * @creat_date 2018年04月13日
     * @creat_time 17:22:49
     */
     Integer countBloodGlucose(BloodGlucoseQo bloodGlucoseQo);

}
