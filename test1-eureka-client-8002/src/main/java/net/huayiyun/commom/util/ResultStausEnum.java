package net.huayiyun.commom.util;

public enum ResultStausEnum {
    SUCCESS(0,"请求成功"),
    FALT(-1,"业务异常"),
    SYSTEMERROR(-2,"服务异常"),
    NOLOGIN(-3,"未登陆");

    private int code;
    private String context;

    public String getContext() {
        return this.context;
    }
    public int getCode() {
        return code;
    }
    private ResultStausEnum(int _code, String _context){
        this.code = _code;
        this.context = _context;
    }
}
