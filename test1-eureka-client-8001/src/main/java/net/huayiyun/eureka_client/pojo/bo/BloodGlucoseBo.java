package net.huayiyun.eureka_client.pojo.bo;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.po
 * @Description : 血糖BO
 * @Author : zlj
 * @Creation Date : 2018年05月09日 15:44
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class BloodGlucoseBo {

    private String bgId;//血糖id
    private String patientId; //病人ID
    private double booldGlucoseLevel; //血糖值
    private String receiveTime; //检测时间
    private String timePoint;//测量时间点
    private String operatorId;//操作人id
    private Integer bgIsDel;//是否删除

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

    public double getBooldGlucoseLevel() {
        return booldGlucoseLevel;
    }

    public void setBooldGlucoseLevel(double booldGlucoseLevel) {
        this.booldGlucoseLevel = booldGlucoseLevel;
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
}
