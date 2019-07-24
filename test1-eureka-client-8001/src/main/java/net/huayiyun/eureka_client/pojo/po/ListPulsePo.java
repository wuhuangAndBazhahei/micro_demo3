package net.huayiyun.eureka_client.pojo.po;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.po
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2018年05月10日 18:06
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class ListPulsePo {

    private String pulseId;//id
    private String patientId;//绑定的用户id
    private Integer pulseRate;//脉搏
    private String operatorId;//操作者id
    private String receiveTime;//测量时间
    private boolean operationState; //是否可以操作

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

    public boolean isOperationState() {
        return operationState;
    }

    public void setOperationState(boolean operationState) {
        this.operationState = operationState;
    }
}
