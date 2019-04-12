package net.yiyutao.seata.common.base;

import lombok.Data;
import net.yiyutao.seata.common.enums.ResultEnum;

import java.io.Serializable;

/**
 * @author masterYI
 * @date 2019/4/11 16:50
 */
@Data
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -2520719837958172526L;

    private int code;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 是否成功
     */
    private boolean success = false;

    /**
     * 查询数据总数
     */
    private Long total;

    /**
     * 当前分页页面
     */
    private int pageNum;

    /**
     * 当前分页每页数量
     */
    private int pageSize;

    public void setResultEnum(ResultEnum resultEnum) {
        code = resultEnum.code;
        msg = resultEnum.msg;
        success = code == ResultEnum.SUCCESS.code;
    }

    public void setData(T data) {
        this.data = data;
        setResultEnum(ResultEnum.SUCCESS);
    }

    public boolean isSuccess(){
        return success;
    }
}
