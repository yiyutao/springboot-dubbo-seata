package net.yiyutao.seata.common.enums;

/**
 * @author masterYI
 * @date 2019/3/5 11:04
 */
public enum ResultEnum {


    /**
     * 系统返回信息
     */
    SUCCESS(200, "success"),
    SYSTEM_ERROR(-100, "系统异常"),
    MISS_PARAM(-101, "缺少参数");
    public int code;
    public String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
