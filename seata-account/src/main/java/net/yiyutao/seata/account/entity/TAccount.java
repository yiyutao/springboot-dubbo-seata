package net.yiyutao.seata.account.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author masterYI
 */
@Data
public class TAccount implements Serializable {

    /**
     * 账号id
     */
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 用户金额
     */
    private Double amount;


}