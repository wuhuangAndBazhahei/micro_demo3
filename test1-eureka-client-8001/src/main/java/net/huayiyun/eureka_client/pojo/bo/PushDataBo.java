package net.huayiyun.eureka_client.pojo.bo;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.bo
 * @Description : 数据更新推送
 * @Author : zhangshuai
 * @Creation Date : 2018年06月05日 11:25
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class PushDataBo {
    private String patientId; //病人ID
    private String operatorId; //操作人ID
    private int type=1; //1-过滤操作人，2-不过滤操作人

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
