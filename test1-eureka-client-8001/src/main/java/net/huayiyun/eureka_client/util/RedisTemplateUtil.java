package net.huayiyun.eureka_client.util;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Project : eurekademo1
 * @Package Name : net.huayiyun.eureka_client.util
 * @Description : TODO
 * @Author : zlj
 * @Creation Date : 2019年06月27日 11:06
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Component
public class RedisTemplateUtil {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public <T> boolean set(String key ,T value){

        try {

            //任意类型转换成String
            String val = beanToString(value);

            if(val==null||val.length()<=0){
                return false;
            }

            stringRedisTemplate.opsForValue().set(key,val);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public <T> T get(String key,Class<T> clazz){
        try {
            String value = stringRedisTemplate.opsForValue().get(key);

            return stringToBean(value,clazz);
        }catch (Exception e){
            return null ;
        }
    }

    @SuppressWarnings("unchecked")
    private <T> T stringToBean(String value, Class<T> clazz) {
        if(value==null||value.length()<=0||clazz==null){
            return null;
        }

        if(clazz ==int.class ||clazz==Integer.class){
            return (T)Integer.valueOf(value);
        }
        else if(clazz==long.class||clazz==Long.class){
            return (T)Long.valueOf(value);
        }
        else if(clazz==String.class){
            return (T)value;
        }else {
            return JSON.toJavaObject(JSON.parseObject(value),clazz);
        }
    }

    /**
     *
     * @param    value
     * @return String
     */
    private <T> String beanToString(T value) {

        if(value==null){
            return null;
        }
        Class <?> clazz = value.getClass();
        if(clazz==int.class||clazz==Integer.class){
            return ""+value;
        }
        else if(clazz==long.class||clazz==Long.class){
            return ""+value;
        }
        else if(clazz==String.class){
            return (String)value;
        }else {
            return JSON.toJSONString(value);
        }
    }

    /**
     * @Author zlj
     * @param
     * @return
     * @Description 删除单个数据
     * @creat_date 2019年06月27日
     * @creat_time 12:54:06
     */
    public boolean deleteById(String id){
        return stringRedisTemplate.delete(id);
    }

    /**
     * @Author zlj
     * @param
     * @return
     * @Description 删除集合数据
     * @creat_date 2019年06月27日
     * @creat_time 12:57:11
     */
    public Long delete(Collection keys){
        return stringRedisTemplate.delete(keys);
    }

}
