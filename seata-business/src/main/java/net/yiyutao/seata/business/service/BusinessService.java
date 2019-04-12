package net.yiyutao.seata.business.service;

import com.alibaba.fescar.core.context.RootContext;
import com.alibaba.fescar.spring.annotation.GlobalTransactional;
import net.yiyutao.seata.api.ITAccountService;
import net.yiyutao.seata.api.ITOrderService;
import net.yiyutao.seata.api.ITStorageService;
import net.yiyutao.seata.common.base.BaseResult;
import net.yiyutao.seata.dto.BusinessDTO;
import net.yiyutao.seata.dto.CommodityDTO;
import net.yiyutao.seata.dto.OrderDTO;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author masterYI
 * @date 2019/4/12 17:54
 */
@Service
public class BusinessService {

    @Reference(version = "1.0.0")
    private ITStorageService storageService;

    @Reference(version = "1.0.0")
    private ITOrderService orderService;

    private boolean flag;

    @GlobalTransactional(timeoutMills = 300000, name = "dubbo-gts-fescar-example")
    public BaseResult handleBusiness(BusinessDTO businessDTO) {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        //1、扣减库存
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityCode(businessDTO.getCommodityCode());
        commodityDTO.setCount(businessDTO.getCount());
        BaseResult decreaseStorage = storageService.decreaseStorage(commodityDTO);
        //2、创建订单
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(businessDTO.getUserId());
        orderDTO.setCommodityCode(businessDTO.getCommodityCode());
        orderDTO.setOrderCount(businessDTO.getCount());
        orderDTO.setOrderAmount(businessDTO.getAmount());
        BaseResult<OrderDTO> orderDTOBaseResult = orderService.createOrder(orderDTO);

        //打开注释测试事务发生异常后，全局回滚功能
        if (!flag) {
            throw new RuntimeException("测试抛异常后，分布式事务回滚！");
        }

        if (!orderDTOBaseResult.isSuccess() || !decreaseStorage.isSuccess()) {
            throw new RuntimeException("失败");
        }
        return orderDTOBaseResult;
    }
}
