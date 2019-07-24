package net.huayiyun.eureka_client.pojo.vo;

import java.util.List;

/**
 * @Project : new_huayi
 * @Package Name : net.huayiyun.ncd.healthdata.pojo.vo
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2018年05月21日 15:36
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class SeriseVo {

    private String name; //名字
    private String type="line"; //类型
    private List data; //数据

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
