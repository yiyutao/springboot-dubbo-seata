package net.yiyutao.seata.storage.service;

import com.alibaba.fescar.core.context.RootContext;
import net.yiyutao.seata.api.ITStorageService;
import net.yiyutao.seata.common.base.BaseResult;
import net.yiyutao.seata.common.enums.ResultEnum;
import net.yiyutao.seata.dto.CommodityDTO;
import net.yiyutao.seata.storage.mapper.TStorageMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author masterYI
 */
@Service(version = "1.0.0")
public class TStorageServiceImpl implements ITStorageService {

    @Autowired
    private TStorageMapper tStorageMapper;

    @Override
    public BaseResult decreaseStorage(CommodityDTO commodityDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        BaseResult baseResult = new BaseResult();
        int storage = tStorageMapper.decreaseStorage(commodityDTO.getCommodityCode(), commodityDTO.getCount());
        if (storage > 0) {
            baseResult.setResultEnum(ResultEnum.SUCCESS);
            return baseResult;
        }
        baseResult.setResultEnum(ResultEnum.SYSTEM_ERROR);
        return baseResult;
    }
}
