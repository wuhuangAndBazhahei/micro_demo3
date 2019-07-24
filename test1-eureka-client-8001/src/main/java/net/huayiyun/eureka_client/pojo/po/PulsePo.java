package net.huayiyun.eureka_client.pojo.po;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.po
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2018年05月10日 17:57
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class PulsePo {

    private String pulseId;//id
    private String patientId;//绑定的用户id
    private Integer pulseRate;//脉搏
    private String operatorId;//操作者id
    private String receiveTime;//测量时间
    private String gmtCreate;//创建日期
    private String gmtModified;//修改日期
    private String pulseIsDel;//是否删除

    public String getPulseId() {
        return pulseId;
    }

    public void setPulseId(String pulseId) {
        this.pulseId = pulseId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Integer getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getPulseIsDel() {
        return pulseIsDel;
    }

    public void setPulseIsDel(String pulseIsDel) {
        this.pulseIsDel = pulseIsDel;
    }
}
