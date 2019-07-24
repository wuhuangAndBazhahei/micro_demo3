package net.huayiyun.common.util;

/**
 *
 * @Project : ssm
 * @Package Name : net.huayiyun.ncd.common.ObjectQO
 * @Description : 框架级 的 传入 参数
 * @Author : zlj
 * @Creation Date : 2018年05月02日 17:08
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class ObjectQO<T> {
    private String userId;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
