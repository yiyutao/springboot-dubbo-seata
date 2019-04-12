package net.yiyutao.seata.order.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author masterYI
 */
@Data
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private Integer id;

    /**
     * 订单流水号
     */
    private String orderNo;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 商品编码
     */
    private String commodityCode;

    /**
     * 购买数量
     */
    private Integer count;

    /**
     * 金额
     */
    private Integer amount;


}
