package net.yiyutao.seata.api;

import net.yiyutao.seata.common.base.BaseResult;
import net.yiyutao.seata.dto.OrderDTO;

/**
 * <p>
 * 创建订单
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
public interface ITOrderService {

    /**
     * 创建订单
     */
    BaseResult<OrderDTO> createOrder(OrderDTO orderDTO);
}
