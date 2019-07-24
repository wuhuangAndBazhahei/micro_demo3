package net.huayiyun.common.util;

import java.sql.Timestamp;

/**
 * 查询公共BO
 * @Project : huayi-ncd
 * @Package Name : com.huayi.ncd.common
 * @Description : 分页专用
 * @Author : zhangshuai
 * @Creation Date : 2018年04月08日 9:58
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class BaseQO {
    private int page=1; //第几页
    private int startNumber; //从多少开始
    private int rows=CommonCodeEnum.rows; //每页多少条（已经定死15条）
    private Timestamp startTime; //开始时间
    private Timestamp endTime; //结束时间
    private String loginUserId; //登陆用户ID
    private String loginUserRole; //登陆用户角色

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getStartNumber() {
        if(page==1 || page==0){
            return 0;
        }
        else{
            setStartNumber((page-1)* getRows());
        }

        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getLoginUserRole() {
        return loginUserRole;
    }

    public void setLoginUserRole(String loginUserRole) {
        this.loginUserRole = loginUserRole;
    }

}
