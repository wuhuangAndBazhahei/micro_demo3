package net.huayiyun.eureka_client.pojo.po;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.po
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2018年05月10日 10:02
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class ListBloodGlucosePo {
    private String bgId;//血糖id
    private String patientId; //病人ID
    private double bloodGlucoseLevel; //血糖值
    private String receiveTime; //检测时间
    private String timePoint;//测量时间点
    private String operatorId;//操作人id
    private Integer bgIsDel;//是否删除
    private String timePointValue;//测量时间点的value值
    private boolean operationState; //是否可以操作

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

    public double getBloodGlucoseLevel() {
        return bloodGlucoseLevel;
    }

    public void setBloodGlucoseLevel(double bloodGlucoseLevel) {
        this.bloodGlucoseLevel = bloodGlucoseLevel;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
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

    public Integer getBgIsDel() {
        return bgIsDel;
    }

    public void setBgIsDel(Integer bgIsDel) {
        this.bgIsDel = bgIsDel;
    }

    public String getTimePointValue() {
        return timePointValue;
    }

    public void setTimePointValue(String timePointValue) {
        this.timePointValue = timePointValue;
    }

    public boolean isOperationState() {
        return operationState;
    }

    public void setOperationState(boolean operationState) {
        this.operationState = operationState;
    }
}
