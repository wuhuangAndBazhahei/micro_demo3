package net.huayiyun.eureka_client.pojo.vo;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.vo
 * @Description : 血压Vo
 * @Author : zhengbo
 * @Creation Date : 2018年05月09日 15:06
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class BloodPressureVo {
    private String bpId;//血压表ID
    private String patientId;//病人ID
    private int systolicBloodPressure;//高压\收缩压
    private int diastolicBloodPressure;//低压\舒张压
    private int pulsePressure;//脉压差
    private String receiveTime;//检测时间
    private boolean operationState; //是否可以操作

    public String getBpId() {
        return bpId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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
        if (systolicBloodPressure != 0 && diastolicBloodPressure != 0 ){
            pulsePressure =  systolicBloodPressure-diastolicBloodPressure;
        }
        return pulsePressure;
    }

    public void setPulsePressure(int pulsePressure) {
        this.pulsePressure = pulsePressure;
    }

    public boolean isOperationState() {
        return operationState;
    }

    public String getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(String receiveTime) {
        this.receiveTime = receiveTime;
    }

    public void setOperationState(boolean operationState) {
        this.operationState = operationState;
    }
}
