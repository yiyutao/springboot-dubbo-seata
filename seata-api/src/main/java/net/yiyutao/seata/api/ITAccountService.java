package net.yiyutao.seata.api;

import net.yiyutao.seata.common.base.BaseResult;
import net.yiyutao.seata.dto.AccountDTO;

/**
 * @author masterYI
 * @date 2019/4/12 17:42
 */
public interface ITAccountService {

    /**
     * 扣用户钱
     */
    BaseResult decreaseAccount(AccountDTO accountDTO);
}
