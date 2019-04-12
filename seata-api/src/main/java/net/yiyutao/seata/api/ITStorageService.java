package net.yiyutao.seata.api;

import net.yiyutao.seata.common.base.BaseResult;
import net.yiyutao.seata.dto.CommodityDTO;

/**
 * 仓库服务
 *
 * @author heshouyou
 * @since 2019-01-13
 */
public interface ITStorageService {

    /**
     * 扣减库存
     */
    BaseResult decreaseStorage(CommodityDTO commodityDTO);
}
