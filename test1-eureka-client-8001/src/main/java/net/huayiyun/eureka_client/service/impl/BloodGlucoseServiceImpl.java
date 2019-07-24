package net.huayiyun.eureka_client.service.impl;

import net.huayiyun.common.util.CommListVo;
import net.huayiyun.common.util.CommUtil;
import net.huayiyun.common.util.ObjectQO;
import net.huayiyun.eureka_client.mapper.BloodGlucoseMapper;
import net.huayiyun.eureka_client.pojo.po.ListBloodGlucosePo;
import net.huayiyun.eureka_client.pojo.qo.BloodGlucoseQo;
import net.huayiyun.eureka_client.service.BloodGlucoseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.service.impl
 * @Description : 血糖service
 * @Author : zlj
 * @Creation Date : 2018年05月09日 17:41
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Service
public class BloodGlucoseServiceImpl implements BloodGlucoseService {

    @Resource
    BloodGlucoseMapper bloodGlucoseMapper;

    /**
     * @Author zlj
     * @param objectQO
     * @return  
     * @Description 添加血糖
     * @creat_date 2018年05月09日
     * @creat_time 17:42:04
     */
    @Override
    @Transactional
    public void saveBloodGlucose(ObjectQO<BloodGlucoseQo> objectQO) throws Exception {

        BloodGlucoseQo bloodGlucoseQo = objectQO.getData();
        bloodGlucoseQo.setBgId(CommUtil.getUUID());
        bloodGlucoseQo.setBgIsDel(0);
        String patientId = bloodGlucoseQo.getPatientId();
//        if (StringUtils.isNullOrEmpty(patientId)){
//            throw new BaseServiceErrorException("patientId为空！",CommonCodeEnum.PARAMETER_LOSE.getCode());
//        }
        Double bloodGlucoseLevel = bloodGlucoseQo.getBloodGlucoseLevel();
//        if (bloodGlucoseLevel ==null){
//            throw new BaseServiceErrorException("血糖为空！",CommonCodeEnum.PARAMETER_LOSE.getCode());
//        }else if (bloodGlucoseLevel<1.1 ||bloodGlucoseLevel >33.3){
//            throw new BaseServiceErrorException("血糖值超出范围！",CommonCodeEnum.PARAMETER_VALUE_WRONGFUL.getCode());
//        }
        if (bloodGlucoseQo.getReceiveTime()==null){
            bloodGlucoseQo.setReceiveTime(new Timestamp(new Date().getTime()));
        }
        //将当前用户id看作操作人id
        String userId = objectQO.getUserId();
//        if (StringUtils.isNullOrEmpty(userId)){
//            throw new BaseServiceErrorException("userId为空！",CommonCodeEnum.PARAMETER_LOSE.getCode());
//        }
        bloodGlucoseQo.setOperatorId(userId);
        //判断返回值，抛异常
        Integer reBloodGlucose = bloodGlucoseMapper.insertBloodGlucose(bloodGlucoseQo);
//        if (reBloodGlucose==0){
//            //回滚事物
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            throw new BaseServiceErrorException("添加血糖数据失败！",CommonCodeEnum.ERROR.getCode());
//        }
        //app极光推送

//        boolean result = DataCheckUtil.checkBloodGlucose(bloodGlucoseLevel);
//        String alert = "";
//        if (result){
//            alert = "您的血糖数据更新啦，请及时查看。";
//        }else {
//            alert = "您最近一次血糖测量偏高，请注意控制。";
//        }
//        List<String> list = new ArrayList<>();
//        list.add(patientId);
//        int send = JiGuangPushClientUtil.sendToRegistrationId(list, alert);
//        //亲友推送
//        List<String> listPatientGuardianId = guardianMapper.listPatientGuardianId(patientId);
//        if (listPatientGuardianId!=null && listPatientGuardianId.size()!=0){
//            String alert1 = "";
//            if (result){
//                alert1 = "您亲友的血糖数据更新啦，请及时查看。";
//            }else {
//                alert1 = "您亲友最近一次血糖测量偏高，请密切关注。";
//            }
//            List<String> list1 = new ArrayList<>(listPatientGuardianId);
//            int send1 = JiGuangPushClientUtil.sendToRegistrationId(list1, alert1);
//        }

//        bloodGlucoseQo.setBglId(CommUtil.getUUID());
//        bloodGlucoseQo.setRawdataId(bloodGlucoseQo.getBgId());
//        bloodGlucoseQo.setOperationType(CommonCodeEnum.OPERATION_INSERT);
//        Integer reBloodGlucoseLog =bloodGlucoseMapper.insertBloodGlucoseLog(bloodGlucoseQo);
//        //推送数据更新
//        PushDataBo pushDataBo=new PushDataBo();
//        pushDataBo.setPatientId(bloodGlucoseQo.getPatientId());
//        pushDataBo.setOperatorId(bloodGlucoseQo.getOperatorId());
//        pushService.pushDateUpdate(pushDataBo);
//        if (reBloodGlucoseLog ==0){
//            throw new BaseServiceErrorException("添加血糖日志失败！",CommonCodeEnum.ERROR.getCode());
//        }

        
    }

    /**
     * @Author zlj
     * @param objectQO
     * @return
     * @Description 查询血糖列表
     * @creat_date 2018年05月09日
     * @creat_time 17:46:40
     */
    @Override
    public CommListVo listBloodGlucose(ObjectQO<BloodGlucoseQo> objectQO) throws Exception {
        //参数为空判断
//        if (judgeListBloodGlucoseIsNull(objectQO)){
//            throw new ValueIsNullException("查询血糖异常,传入的参数为空!");
//        }

        BloodGlucoseQo bloodGlucoseQo = objectQO.getData();
//        FollowAuthorityBo followAuthorityBo=new FollowAuthorityBo();
//        //转换实体
//        BeanUtils.copyProperties(bloodGlucoseQo,followAuthorityBo);
//        if (StringUtils.isNullOrEmpty(followAuthorityBo.getLoginUserId()) && StringUtils.isNullOrEmpty(followAuthorityBo.getLoginUserRole())){
//            //判断是否有权限
//            if(!followAuthorityService.employeeAuthority(followAuthorityBo)){
//                throw new NoAuthorityException("没有权限！");
//            }
//        }else {
//            //判断是否有权限
//            if(!followAuthorityService.followAuthority(followAuthorityBo)){
//                throw new NoAuthorityException("没有权限！");
//            }
//        }

        //将当前用户id看作操作人id
        bloodGlucoseQo.setOperatorId(objectQO.getUserId());

        CommListVo commListVo=new CommListVo();
        List<ListBloodGlucosePo> list = bloodGlucoseMapper.listBloodGlucose(bloodGlucoseQo);
        //如果没有数据,返回空集合
        if(list==null ||list.size()==0){
            commListVo.setCount(0);
            commListVo.setList(new ArrayList<ListBloodGlucosePo>());
        }

        //如果操作者ID等于病人ID,将是否可操作赋值为true
        if(bloodGlucoseQo.getOperatorId().equals(bloodGlucoseQo.getPatientId())){
            for(ListBloodGlucosePo listBloodGlucosePo:list){
                listBloodGlucosePo.setOperationState(true);
            }
        }
        else{
            for(ListBloodGlucosePo listBloodGlucosePo:list){
                //如果操作者ID等于数据中操作的ID，是否可操作赋值为true，否则赋值false
                if(listBloodGlucosePo.getOperatorId().equals(bloodGlucoseQo.getOperatorId())){
                    listBloodGlucosePo.setOperationState(true);
                }
                else{
                    listBloodGlucosePo.setOperationState(false);
                }
            }
        }
        commListVo.setCount(bloodGlucoseMapper.countBloodGlucose(bloodGlucoseQo));//总记录数
        commListVo.setList(list);
        return commListVo;
    }

}
