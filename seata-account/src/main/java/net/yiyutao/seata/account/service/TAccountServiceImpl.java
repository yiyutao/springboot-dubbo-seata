package net.yiyutao.seata.account.service;

import com.alibaba.fescar.core.context.RootContext;
import net.yiyutao.seata.account.mapper.TAccountMapper;
import net.yiyutao.seata.api.ITAccountService;
import net.yiyutao.seata.common.base.BaseResult;
import net.yiyutao.seata.common.enums.ResultEnum;
import net.yiyutao.seata.dto.AccountDTO;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author masterYI
 * @date 2019/4/12 17:49
 */
@Service(version = "1.0.0")
public class TAccountServiceImpl implements ITAccountService {

    @Autowired
    private TAccountMapper tAccountMapper;

    @Override
    public BaseResult decreaseAccount(AccountDTO accountDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        BaseResult baseResult = new BaseResult();
        int account = tAccountMapper.decreaseAccount(accountDTO.getUserId(), accountDTO.getAmount());
        if (account != 1) {
            baseResult.setResultEnum(ResultEnum.SYSTEM_ERROR);
            return baseResult;
        }
        baseResult.setResultEnum(ResultEnum.SUCCESS);
        return baseResult;
    }
}
