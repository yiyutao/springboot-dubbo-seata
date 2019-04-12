package net.yiyutao.seata.order.service;

import com.alibaba.fescar.core.context.RootContext;
import net.yiyutao.seata.api.ITAccountService;
import net.yiyutao.seata.api.ITOrderService;
import net.yiyutao.seata.common.base.BaseResult;
import net.yiyutao.seata.common.enums.ResultEnum;
import net.yiyutao.seata.dto.AccountDTO;
import net.yiyutao.seata.dto.OrderDTO;
import net.yiyutao.seata.order.entity.TOrder;
import net.yiyutao.seata.order.mapper.TOrderMapper;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * @author masterYI
 */
@Service(version = "1.0.0")
public class TOrderServiceImpl implements ITOrderService {

    @Reference(version = "1.0.0")
    private ITAccountService accountService;

    private final TOrderMapper orderMapper;

    @Autowired
    public TOrderServiceImpl(TOrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    /**
     * 创建订单
     *
     * @param orderDTO 订单对象
     * @return 订单对象
     */
    @Override
    public BaseResult<OrderDTO> createOrder(OrderDTO orderDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        BaseResult<OrderDTO> baseResult = new BaseResult<>();
        //扣减用户账户
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(orderDTO.getUserId());
        accountDTO.setAmount(orderDTO.getOrderAmount());
        BaseResult decreaseAccount = accountService.decreaseAccount(accountDTO);

        //生成订单号
        orderDTO.setOrderNo(UUID.randomUUID().toString().replace("-", ""));
        //生成订单
        TOrder tOrder = new TOrder();
        BeanUtils.copyProperties(orderDTO, tOrder);
        tOrder.setCount(orderDTO.getOrderCount());
        tOrder.setAmount(orderDTO.getOrderAmount());
        try {
            orderMapper.createOrder(tOrder);
        } catch (Exception e) {
            baseResult.setResultEnum(ResultEnum.SYSTEM_ERROR);
            return baseResult;
        }

        if (!decreaseAccount.isSuccess()) {
            baseResult.setResultEnum(ResultEnum.SYSTEM_ERROR);
            return baseResult;
        }

        baseResult.setResultEnum(ResultEnum.SUCCESS);
        return baseResult;
    }
}
