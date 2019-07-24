package net.huayiyun.eureka_client.pojo.vo;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.vo
 * @Description : 查询最新数据的Vo
 * @Author : zhengbo
 * @Creation Date : 2018年05月15日 16:02
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class LatestDataVo {
    private String patientId;//病人ID
    private int systolicBloodPressure;//高压\收缩压
    private int diastolicBloodPressure;//低压\舒张压
    private Integer pulseRate;//脉搏
    private int pulsePressure;//脉压差
    private Double bloodGlucoseLevel;//血糖值
    private String bloodPressureReceiveTime;//血压检测时间
    private String bloodGlucoseLReceiveTime;//血糖检测时间
    private String pulseReceiveTime;//脉搏检测时间

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

    public Integer getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(Integer pulseRate) {
        this.pulseRate = pulseRate;
    }

    public int getPulsePressure() {
        return pulsePressure;
    }

    public void setPulsePressure(int pulsePressure) {
        this.pulsePressure = pulsePressure;
    }

    public Double getBloodGlucoseLevel() {
        return bloodGlucoseLevel;
    }

    public void setBloodGlucoseLevel(Double bloodGlucoseLevel) {
        this.bloodGlucoseLevel = bloodGlucoseLevel;
    }

    public String getBloodPressureReceiveTime() {
        return bloodPressureReceiveTime;
    }

    public void setBloodPressureReceiveTime(String bloodPressureReceiveTime) {
        this.bloodPressureReceiveTime = bloodPressureReceiveTime;
    }

    public String getBloodGlucoseLReceiveTime() {
        return bloodGlucoseLReceiveTime;
    }

    public void setBloodGlucoseLReceiveTime(String bloodGlucoseLReceiveTime) {
        this.bloodGlucoseLReceiveTime = bloodGlucoseLReceiveTime;
    }

    public String getPulseReceiveTime() {
        return pulseReceiveTime;
    }

    public void setPulseReceiveTime(String pulseReceiveTime) {
        this.pulseReceiveTime = pulseReceiveTime;
    }
}
