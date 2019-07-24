package net.huayiyun.common.util;

/**
 * 返回数据结果类
 * @Project : huayi-ncd
 * @Package Name : com.huayi.ncd.common
 * @Description : TODO
 * @Author : zhangshuai
 * @Creation Date : 2018年04月08日 9:58
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class ResultEntity<T> {
    private int status = ResultStausEnum.SYSTEMERROR.getCode(); //返回状态
    private String code;//业务code值
    private String message =ResultStausEnum.SYSTEMERROR.getContext(); //返回信息
    private T data; //返回数据

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
