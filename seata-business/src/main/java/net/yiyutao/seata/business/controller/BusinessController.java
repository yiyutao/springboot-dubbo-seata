package net.yiyutao.seata.business.controller;


import lombok.extern.slf4j.Slf4j;
import net.yiyutao.seata.business.service.BusinessService;
import net.yiyutao.seata.common.base.BaseResult;
import net.yiyutao.seata.dto.BusinessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : masterYI
 */
@RestController
@RequestMapping("/business/dubbo")
@Slf4j
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    /**
     * 模拟用户购买商品下单业务逻辑流程
     *
     * @Param:
     * @Return:
     */
    @PostMapping("/buy")
    BaseResult handleBusiness(@RequestBody BusinessDTO businessDTO) {
        log.info("请求参数：{}", businessDTO.toString());
        return businessService.handleBusiness(businessDTO);
    }
}
