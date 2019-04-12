package net.yiyutao.seata.storage.mapper;

import net.yiyutao.seata.common.base.BaseMapper;
import net.yiyutao.seata.storage.entity.TStorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author masterYI
 */
@Mapper
@Repository
public interface TStorageMapper extends BaseMapper<TStorage> {

    /**
     * 扣减商品库存
     *
     * @param commodityCode 商品code
     * @param count         count扣减数量
     * @return 影响行数
     */
    int decreaseStorage(@Param("commodityCode") String commodityCode, @Param("count") Integer count);
}
