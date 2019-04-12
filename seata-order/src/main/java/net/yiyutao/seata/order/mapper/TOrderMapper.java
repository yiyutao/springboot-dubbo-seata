package net.yiyutao.seata.order.mapper;

import net.yiyutao.seata.common.base.BaseMapper;
import net.yiyutao.seata.order.entity.TOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author masterYI
 */
@Mapper
@Repository
public interface TOrderMapper extends BaseMapper<TOrder> {

    /**
     * 创建订单
     *
     * @Param: order 订单信息
     * @Return:
     */
    int createOrder(@Param("order") TOrder order);
}
