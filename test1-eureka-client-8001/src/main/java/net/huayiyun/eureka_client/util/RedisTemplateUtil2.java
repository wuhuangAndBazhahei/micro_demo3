package net.huayiyun.eureka_client.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Project : commonSSM
 * @Package Name : net.study.utils
 * @Description : TODO
 * @Author : zhangshuai
 * @Creation Date : 2018年06月19日 17:45
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */

@Component
public class RedisTemplateUtil2 {

    @Resource
    private RedisTemplate<String, Object> redisTemplate ; //注入RedisTemplate

    //操作List
    private ListOperations<String, Object> listOperations;

    //操作字符串
    private ValueOperations<String, Object> valueOperations;

    //操作哈希
    private HashOperations<String, Object, Object> hashOperations;

    public ListOperations<String, Object> getListOperations() {
        return redisTemplate.opsForList();
    }

    public ValueOperations<String, Object> getValueOperations() {
        return redisTemplate.opsForValue();
    }

    public HashOperations<String, Object, Object> getHashOperations() {
        return redisTemplate.opsForHash();
    }

    /**
     * 放入字符串
     */
    public void setString(String key, Object value) {
        getValueOperations().set(key, value);
    }

    /**
     * 获取字符串
     */
    public String getString(String key) {
        return (String) getValueOperations().get(key);
    }

    /**
     * 新增元素到List集合最后位
     */
    public void addList(String key, Object value) {
        getListOperations().rightPush(key, value);
    }

    /**
     * 新增元素到List集合最前位
     */
    public void inserList(String key, Object value){
        getListOperations().leftPush(key,value);
    }

    /**
     * 插入整个List集合
     */
    public void setFullList(String key,Collection<?> list){
        list.forEach(obj->{
            addList(key,obj);
        });
//
//        for(Object obj:list){
//            addList(key,obj);
//        }
    }

    /**
     * 截取List集合，从0开始，到哪结束。-1表示获取所有
     */
    public List getList(String key,long start,long end){
        return getListOperations().range(key,start,end);
    }

    /**
     * 获取整个List集合
     */
    public List getFullList(String key) {
       return getList(key,0,-1);
    }

    /**
     * 从List中移除某个元素
     */
    public long removeList(String key,Object object){
        return getListOperations().remove(key,1,object);
    }

    /**
     * 放入整个哈希
     */
    public void setFullHash(String key,Map<?,?> map){
        getHashOperations().putAll(key,map);
    }

    /**
     * 放入单个哈希
     */
    public void setHash(String key,Object hashKey,Object value) {
        getHashOperations().put(key,hashKey,value);
    }

    /**
     * 从哈希中移除某个元素
     */
    public void removeHash(String key,Object hashKey){
        getHashOperations().delete(key,hashKey);
    }

    /**
     * 判断某个哈希值是否存在
     */
    public boolean isHaveHash(String key,Object hashKey){
       return getHashOperations().hasKey(key,hashKey);
    }

    /**
     * 获取整个哈希
     */
    public Map getFullHash(String key) {
        return getHashOperations().entries(key);
    }

    /**
     * 获取单个哈希元素
     */
    public Object getHash(String key,Object hashKey){
        return getHashOperations().get(key,hashKey);
    }

    /**
     * 批量获取Hash值
     */
    public List batchGetHash(String key,List hashKeys){
        return getHashOperations().multiGet(key,hashKeys);
    }

    /**
     * 获取所有哈希中的key
     */
    public Set getHashKeys(String key){
        return getHashOperations().keys(key);
    }

    /**
     *删除Key
     */
    public void delete(String key) {
        //如果key存在，删除
        if(isHaveKey(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除key
     */
    public void batchDelete(String ... keys){
        for(String key:keys){
            delete(key);
        }
    }

    /**
     * 设置有效期 （小时）
     */
    public void setHour(String key,long time){
        redisTemplate.expire(key, time, TimeUnit.HOURS);
    }
    /**
     * 设置有效期 （分钟）
     */
    public void setMinute(String key,long time){ redisTemplate.expire(key, time, TimeUnit.MINUTES);}
    /**
     * 设置有效期 （秒）
     */
    public void setSecond(String key,long time){ redisTemplate.expire(key, time, TimeUnit.SECONDS);}

    /**
     *判断Key是否存在
     */
    public boolean isHaveKey(String key){
       return redisTemplate.hasKey(key);
    }
}
