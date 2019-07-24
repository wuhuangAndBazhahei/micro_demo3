package net.huayiyun.eureka_client.pojo.qo;

import net.huayiyun.common.util.BaseQO;

import java.sql.Timestamp;

/**
 * @Project : huayi-ncd
 * @Package Name : com.huayi.ncd.datacenter.dto
 * @Description : 血糖Dto
 * @Author : zlj
 * @Creation Date : 2018年04月08日 13:36
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class BloodGlucoseQo extends BaseQO {
    private String bgId;//血糖数据id
    private String patientId;//病人id
    private String bglId;//血糖日志id
    private Double bloodGlucoseLevel;//血糖值
    private Timestamp receiveTime;//数据接收时间
    private Integer bgIsDel;//删除状态
    private String timePoint;//时间段
    private String operatorId;//操作人id
    private String operationType;//操作类型
    private String rawdataId;//原始数据id

    public String getBgId() {
        return bgId;
    }

    public void setBgId(String bgId) {
        this.bgId = bgId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBglId() {
        return bglId;
    }

    public void setBglId(String bglId) {
        this.bglId = bglId;
    }

    public Double getBloodGlucoseLevel() {
        return bloodGlucoseLevel;
    }

    public void setBloodGlucoseLevel(Double bloodGlucoseLevel) {
        this.bloodGlucoseLevel = bloodGlucoseLevel;
    }

    public Timestamp getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Timestamp receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getBgIsDel() {
        return bgIsDel;
    }

    public void setBgIsDel(Integer bgIsDel) {
        this.bgIsDel = bgIsDel;
    }

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getRawdataId() {
        return rawdataId;
    }

    public void setRawdataId(String rawdataId) {
        this.rawdataId = rawdataId;
    }
}


