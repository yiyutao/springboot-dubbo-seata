package net.yiyutao.seata.storage.config;

import com.alibaba.fescar.spring.annotation.GlobalTransactionScanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author masterYI
 * 分布式事务fescar配置
 */
@Configuration
public class FescarConfig {


    @Bean
    public GlobalTransactionScanner globalTransactionScanner() {
        return new GlobalTransactionScanner("storage-gts-fescar-example", "my_test_tx_group");
    }
}
