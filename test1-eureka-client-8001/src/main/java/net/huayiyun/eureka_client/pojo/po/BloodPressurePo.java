package net.huayiyun.eureka_client.pojo.po;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.po
 * @Description : TODO
 * @Author : zhengbo
 * @Creation Date : 2018年05月09日 13:59
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class BloodPressurePo {
    private String bpId;//血压表ID
    private String patientId;//病人ID
    private int systolicBloodPressure;//高压\收缩压
    private int diastolicBloodPressure;//低压\舒张压
    private int pulsePressure;//脉压差
    private String operatorId;//操作人ID
    private String receiveTime; //检测时间
    private int isDel;//是否删除

    public String getBpId() {
        return bpId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public int getSystolicBloodPressure() {
        return systolicBloodPressure;
    }

    public void setSystolicBloodPressure(int systolicBloodPressure) {
        this.systolicBloodPressure = systolicBloodPressure;
    }

    public int getDiastolicBloodPressure() {
        return diastolicBloodPressure;
    }

    public void setDiastolicBloodPressure(int diastolicBloodPressure) {
        this.diastolicBloodPressure = diastolicBloodPressure;
    }

    public int getPulsePressure() {
        return pulsePressure;
    }

    public void setPulsePressure(int pulsePressure) {
        this.pulsePressure = pulsePressure;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }
}
