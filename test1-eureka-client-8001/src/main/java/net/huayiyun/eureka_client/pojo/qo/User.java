package net.huayiyun.eureka_client.pojo.qo;

import java.io.Serializable;
import java.util.List;

/**
 * @Project : commonSSM3
 * @Package Name : net.huayiyun.test.pojo
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年05月28日 17:14
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class User implements Serializable {

    private String name;
    private int age;
    private List<String> interest;


    public User() {
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getInterest() {
        return interest;
    }

    public void setInterest(List<String> interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", interest=" + interest +
                '}';
    }
}
