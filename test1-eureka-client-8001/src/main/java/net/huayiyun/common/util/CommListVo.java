package net.huayiyun.common.util;

import java.util.List;

/**
 * @Project : huayi-ncd
 * @Package Name : net.huayiyun.common
 * @Description : TODO
 * @Author : zhangshuai
 * @Creation Date : 2018年05月07日 14:42
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class CommListVo<T> {

    private Integer count; //总条数

    private List<T> list; //list数据

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
