package net.huayiyun.commom.util;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.common
 * @Description : 系统公共Enum
 * @Author : zhengbo
 * @Creation Date : 2018年05月09日 11:31
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public enum CommonCodeEnum {

    SUCCESS("10","请求成功"),
    NODATA("11","没有数据"),
    NO_LOGIN("12","未登录"),
    NO_AUTHORITY("13","没有权限"),
    DATA_ALREADY("14","数据已存在"),
    DATA_NOTHING("16","数据不存在"),
    DATA_ERROR("17","数据错误"),
    SAME_DATA("18","数据相同"),
    ERROR("20","请求失败"),
    SYSTEM_EXCEPTION("21","系统出现异常"),
    PARAMETER_LOSE("30","请求参数丢失"),
    PARAMETER_WRONGFUL("31","请求参数格式不合法"),
    PARAMETER_VALUE_WRONGFUL("32","请求参数值不合法"),
    JSON_ANALYSIS_ERROR("33","JSON无法解析"),
    API_SUSPEND_USED("40","请求功能暂停使用"),

    //数据库类型
    DATASOURCE1("dataSource1","hys"),

    DATASOURCE("dataSource","huayi");

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private CommonCodeEnum(String _code, String _message){
        this.code=_code;
        this.message=_message;
    }

    public static final String ROLE_USER="001"; //普通用户角色

    public static final String ROLE_DOCTOR="002"; //医生角色

    public static final String ROLE_DUL="003"; //多重身份角色

    public static final String ROLE_EXPERT="004"; //专家

    public static final String ROLE_ADVISER="005"; //健康顾问

    public static final String ROLE_COMMITTEE="006"; //卫计委

    public static final int rows=5; //每页多少条数据

    public static final String OPERATION_INSERT="insert"; //新增操作

    public static final String OPERATION_UPDATE="update"; //修改操作

    public static final String OPERATION_DELETE="delete"; //删除操作

    public static final int MESSAGE_OPERATION_AGREE=2; //消息操作同意

    public static final int MESSAGE_OPERATION_REFUSE=3; //消息操作拒绝

    public static final int ADMINSTATE_C_ADMIN_A=1; //被申请人管理申请人

    public static final int ADMINSTATE_A_ADMIN_C=2; //申请人管理被申请人

    public static final int ADMINSTATE_DUAL_ADMIN=3; //双向管理

    public static final String BLOOD_PRESSURE="001"; //血压

    public static final String BLOOD_GLUCOSE="002"; //血糖

    public static final String HEART_RATE="003"; //心率

    public static final Integer LEVEL_PROVINCE = 2 ;//等级--省/直辖市

    public static final Integer LEVEL_CITY = 3 ;//等级--市/市辖区

    public static final Integer LEVEL_COUNTY = 4 ;//等级--县/区

    public static final String BLOOD_PRESSURE_ID = "44aa36b647bc464f8fab96622d89005d";//血压id

    public static final String BLOOD_GLUCOSE_ID = "8c04be48ab184b2f837a0882a396c417";//血糖id

    public static final String GENERAL_PRACTITIONER_ID = "44aa36b647bc464f8fab96622d89005d," +
            "8c04be48ab184b2f837a0882a396c417";//全科医生主治范围

    public static final long PARAVALUE=1500; //OSS临时账号有效时间 （单位毫秒）

    public static final String bgDeviceId="2104a8dea829441e86075f6350fc037c"; //血糖仪id

    public static final String bpDeviceId="e72a8683f8d74b4ca155c019e3bc90c6"; //血压计id

    public static final String problemTypes01="使用问题";

    public static final String problemTypes02="意见建议";

    public static final String problemTypes03="其他";

//    public static final String problemTypes04="功能完善";
//
//    public static final String problemTypes05="需求变动";
//
//    public static final String problemTypes06="新需求";
//
//    public static final String problemTypes07="其他";

}
