package net.yiyutao.seata.storage.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 商品编码
     */
    private String commodityCode;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品库存
     */
    private Integer count;


}
