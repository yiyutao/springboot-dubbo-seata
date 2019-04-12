package net.yiyutao.seata.account.mapper;

import net.yiyutao.seata.common.base.BaseMapper;
import net.yiyutao.seata.account.entity.TAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author masterYI
 */
@Mapper
@Repository
public interface TAccountMapper extends BaseMapper<TAccount> {

    /**
     * 扣用户的金额
     *
     * @param userId 用户id
     * @param amount 扣除金额
     * @return 影响行数
     */
    int decreaseAccount(@Param("userId") String userId, @Param("amount") Integer amount);
}